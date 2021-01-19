package com.khairo.dotassignment.ui.main

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.khairo.bases.data.BaseActivity
import com.khairo.dotassignment.R
import com.khairo.dotassignment.data.models.repo.Repo
import com.khairo.dotassignment.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val navController: NavController by lazy { findNavController(R.id.main_nav_host) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        instance = this
    }

    fun Int.navigate(model: Repo) {
        navController.navigate(this, bundleOf("repo" to model))
    }

    companion object {
        lateinit var instance: MainActivity
    }
}
