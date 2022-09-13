package com.cubidevs.mobiedbapp2022.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cubidevs.mobiedbapp2022.server.citiesRepository.CitiesRepository
import com.cubidevs.mobiedbapp2022.server.model.citiesList
import com.cubidevs.mobiedbapp2022.server.model.citiesListItem
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val citiesRepository = CitiesRepository()

    private val _citiesLoaded : MutableLiveData<ArrayList<citiesListItem>> = MutableLiveData()
    val citiesLoaded: LiveData<ArrayList<citiesListItem>> = _citiesLoaded

    fun getCities() {
        viewModelScope.launch {
            val CitiesList: citiesList = citiesRepository.getCities()
            _citiesLoaded.postValue(CitiesList as ArrayList<citiesListItem>)
        }
    }
}