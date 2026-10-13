package by.arsy.starwarsapp.ui.screen.appStartScreen

sealed interface AppStartIntent {

    class DownloadItem(
        val id: Int,
        val type: AppStartViewModel.ItemType
    ) : AppStartIntent

    object DownloadNextPage : AppStartIntent

    class OpenPage(
        val type: AppStartViewModel.ItemType
    ) : AppStartIntent

    object PopItemTypeBackStack : AppStartIntent
}