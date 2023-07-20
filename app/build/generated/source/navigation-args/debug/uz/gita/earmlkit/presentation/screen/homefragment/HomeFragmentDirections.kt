package uz.gita.earmlkit.presentation.screen.homefragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import uz.gita.earmlkit.R

public class HomeFragmentDirections private constructor() {
  public companion object {
    public fun actionHomeFragmentToScannerText(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_scannerText)

    public fun actionHomeFragmentToScanBarCodeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_scanBarCodeFragment)
  }
}
