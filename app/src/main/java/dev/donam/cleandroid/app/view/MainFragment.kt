package dev.donam.cleandroid.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import dev.donam.cleandroid.app.R
import dev.donam.cleandroid.app.core.extension.failure
import dev.donam.cleandroid.app.core.extension.observe
import dev.donam.cleandroid.app.core.platform.BaseFragment
import dev.donam.cleandroid.app.databinding.FragmentMainBinding
import dev.donam.cleandroid.presentation.model.AirQualityView
import dev.donam.cleandroid.presentation.viewmodel.AirQualityViewModel

@AndroidEntryPoint
class MainFragment : BaseFragment() {
    private lateinit var binding: FragmentMainBinding

    override fun layoutId(): Int = R.layout.fragment_main

    private val viewModel: AirQualityViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, layoutId(), container, false)

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.loadAirQualities("37.50", "127.02", "059dd92d-23ef-4c5d-a442-e32079c782a6")

        with(viewModel) {
            observe(airQuality, ::renderAirQuality)
            failure(exception, ::handleFailure)
        }
    }

    private fun renderAirQuality(airQuality: AirQualityView?) {
        airQuality?.let {
            with(airQuality) {
                binding.txtAddress.text = "${address.country} ${address.state} ${address.city}"
                binding.txtAqi.text = pollution.aqius.toString()
                binding.txtMain.text = pollution.mainus
                binding.txtTemp.text = weather.tp.toString()
                binding.txtHumid.text = weather.hu.toString()
                binding.txtWind.text = weather.ws.toString()
            }
        }
    }

    private fun handleFailure(exception: Exception?): Nothing = TODO()
//        when (exception) {
//            is NetworkConnection -> renderFailure(R.string.failure_network_connection)
//            is ServerError -> renderFailure(R.string.failure_server_error)
//            is ListNotAvailable -> renderFailure(R.string.failure_movies_list_unavailable)
//            else -> renderFailure(R.string.failure_server_error)
//        }
}