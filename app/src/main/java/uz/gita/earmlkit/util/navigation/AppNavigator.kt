package uz.gita.earmlkit.util.navigation

import androidx.navigation.NavDirections

typealias AppScreen = NavDirections

interface AppNavigator {

    suspend fun navigateTo(screen: AppScreen)
    suspend fun back()

}