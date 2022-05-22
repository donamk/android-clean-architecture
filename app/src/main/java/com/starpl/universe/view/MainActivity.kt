package com.starpl.universe.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.starpl.universe.R
import com.starpl.universe.core.platform.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun fragment() = MainFragment()
}
