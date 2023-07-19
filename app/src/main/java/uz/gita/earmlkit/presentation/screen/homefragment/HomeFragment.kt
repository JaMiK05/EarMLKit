package uz.gita.earmlkit.presentation.screen.homefragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import uz.gita.earmlkit.R
import uz.gita.earmlkit.databinding.HomeFragmentBinding
import uz.gita.earmlkit.util.navigation.AppNavigator
import javax.inject.Inject

/**
 *   Created by Jamik on 7/19/2023 ot 4:23 PM
 **/
@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.home_fragment) {

    @Inject
    lateinit var navigator: AppNavigator

    private val myPermissionRequest =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {}

    private fun requestPermission(): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    requireContext(), Manifest.permission.CAMERA
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                myPermissionRequest.launch(arrayOf(Manifest.permission.CAMERA))
                return false
            }
        }
        return true
    }

    private val binding by viewBinding(HomeFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestPermission()
        binding.apply {
            scantextrecognition.setOnClickListener {
                if (!requestPermission()) return@setOnClickListener
                lifecycleScope.launch {
                    navigator.navigateTo(HomeFragmentDirections.actionHomeFragmentToScannerText())
                }
            }

        }
    }
}