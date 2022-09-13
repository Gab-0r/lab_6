package com.cubidevs.mobiedbapp2022.server.citiesRepository

import com.cubidevs.mobiedbapp2022.server.CitiesDB
import com.cubidevs.mobiedbapp2022.server.model.citiesList

class CitiesRepository {

    private val apiKey = "dvcgpiy7rT3Kf4cBxKXWID128PIvLAtC"

    suspend fun getCities() = CitiesDB.retrofit.getCities(apiKey)

}