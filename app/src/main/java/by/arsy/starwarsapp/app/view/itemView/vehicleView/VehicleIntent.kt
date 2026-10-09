package by.arsy.starwarsapp.app.view.itemView.vehicleView

sealed interface VehicleIntent {
    class GetPilots(val itemIdList: List<Int>) : VehicleIntent
    class GetFilms(val itemIdList: List<Int>) : VehicleIntent
}
