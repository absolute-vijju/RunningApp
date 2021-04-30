package com.developer.vijay.runningapp.ui.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.developer.vijay.runningapp.R
import com.developer.vijay.runningapp.databinding.FragmentSettingsBinding
import com.developer.vijay.runningapp.other.Constants
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private lateinit var mBinding: FragmentSettingsBinding

    @Inject
    lateinit var sharedPref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSettingsBinding.inflate(inflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadFieldsFromSharedPref()
    }

    private fun loadFieldsFromSharedPref() {
        val name = sharedPref.getString(Constants.KEY_NAME, "")
        val weight = sharedPref.getFloat(Constants.KEY_WEIGHT, 80f)

        mBinding.etName.setText(name)
        mBinding.etWeight.setText(weight.toString())

        mBinding.btnApplyChanges.setOnClickListener {
            val success = applyChangesToSharedPref()
            if (success)
                Snackbar.make(mBinding.root, "Saved changes", Snackbar.LENGTH_LONG).show()
            else
                Snackbar.make(mBinding.root, "Please enter all the fields", Snackbar.LENGTH_LONG)
                    .show()
        }

    }

    private fun applyChangesToSharedPref(): Boolean {
        val name = mBinding.etName.text.toString()
        val weight = mBinding.etWeight.text.toString()

        if (name.isEmpty() || weight.isEmpty()) {
            return false
        }

        sharedPref.edit()
            .putString(Constants.KEY_NAME, name)
            .putFloat(Constants.KEY_WEIGHT, weight.toFloat())
            .apply()

        val toolbarText = "Let's go, $name!"
        requireActivity().findViewById<TextView>(R.id.tvToolbarTitle).text = toolbarText
        return true
    }
}