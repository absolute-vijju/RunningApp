package com.developer.vijay.runningapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.developer.vijay.runningapp.R
import com.developer.vijay.runningapp.databinding.ActivityMainBinding
import com.developer.vijay.runningapp.db.RunDAO
import com.developer.vijay.runningapp.other.Constants
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.rootView)

        navigateToTrackingFragmentIfNeeded(intent)

        setSupportActionBar(mBinding.toolbar)

        mBinding.bottomNavigationView.setupWithNavController(findNavController(R.id.navHostFragment))
        mBinding.bottomNavigationView.setOnNavigationItemReselectedListener {
            // No operation
        }

        findNavController(R.id.navHostFragment).addOnDestinationChangedListener { controller, destination, arguments ->

            when (destination.id) {
                R.id.settingsFragment, R.id.runFragment, R.id.statisticsFragment -> {
                    mBinding.bottomNavigationView.visibility = View.VISIBLE
                }
                else -> mBinding.bottomNavigationView.visibility = View.GONE

            }
        }
    }

    private fun navigateToTrackingFragmentIfNeeded(intent: Intent?) {
        findNavController(R.id.navHostFragment)
        if (intent?.action == Constants.ACTION_SHOW_TRACKING_FRAGMENT) {
            findNavController(R.id.navHostFragment).navigate(R.id.action_global_trackingFragment)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigateToTrackingFragmentIfNeeded(intent)
    }

}