package uz.gita.earmlkit.util.navigation

import androidx.navigation.NavController
import kotlinx.coroutines.flow.Flow

typealias  NavigationArgs = NavController.() -> Unit

interface NavigationHandler {
    val navigationBuffer: Flow<NavigationArgs>
}