package uz.gita.earmlkit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*
import uz.gita.earmlkit.util.navigation.NavigationHandler
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigationHandler: NavigationHandler


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val host = supportFragmentManager.findFragmentById(R.id.fragmentcontainer) as NavHostFragment
        val navController = host.navController
        navigationHandler
            .navigationBuffer
            .onEach {
                it(navController)
            }
            .launchIn(lifecycleScope)
    }

}