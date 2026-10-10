package by.arsy.starwarsapp.app.view.appStartView

sealed interface AppStartIntent {

    class DownloadItem(
        val id: Int,
        val type: AppStartViewModel.ItemType
    ) : AppStartIntent

    class DownloadPage(
        val page: Int,
        val type: AppStartViewModel.ItemType
    ) : AppStartIntent

    data object PopItemTypeBackStack : AppStartIntent
}