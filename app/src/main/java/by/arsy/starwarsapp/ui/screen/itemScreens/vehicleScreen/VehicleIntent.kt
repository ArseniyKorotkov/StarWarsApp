package by.arsy.starwarsapp.ui.screen.itemScreens.vehicleScreen

sealed interface VehicleIntent {
    class GetPilots(val itemIdList: List<Int>) : VehicleIntent
    class GetFilms(val itemIdList: List<Int>) : VehicleIntent
}
