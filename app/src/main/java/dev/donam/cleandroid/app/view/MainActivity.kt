package dev.donam.cleandroid.app.view

import android.content.Context
import android.content.Intent
import dev.donam.cleandroid.app.core.platform.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    companion object {
        fun callingIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    override fun fragment() = MainFragment()
}
