package com.example.cse438.studio3

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.cse438_rest_studio.Network.BreweryRepository
import com.example.cse438_rest_studio.data.Brewery


class BreweryViewModel(application: Application): AndroidViewModel(application) {

    //Done #8: Create a livedata object for tracking breweries
    public var breweryList: MutableLiveData<List<Brewery>> = MutableLiveData()

    //Done #9: Write functions to access the two brewery API calls from the repository
    fun getBreweriesByCity(city : String){
        BreweryRepository().getBreweriesByCity(breweryList, city)
    }

    fun getBreweriesByWord(term : String){
        BreweryRepository().getBreweriesByTerm(breweryList, term)
    }

}