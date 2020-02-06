package com.example.cse438_rest_studio.Network

import androidx.lifecycle.MutableLiveData
import com.example.cse438_rest_studio.data.Brewery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class BreweryRepository {
    val service = ApiClient.makeRetrofitService()

    //Done #6: Create a function that launches a coroutine for searching by city
    fun getBreweriesByCity(responseBody : MutableLiveData<List<Brewery>>, city : String){
        CoroutineScope(Dispatchers.IO).launch{
            val response = service.getBreweriesByCity(city)

            withContext(Dispatchers.Main){
                try{
                    if(response.isSuccessful){
                        responseBody.value = response.body()
                    }
                } catch(e: HttpException){
                    println("Http exception")
                }
            }

        }
    }

    //Done #7: Create a function that launches a coroutine for searching by a generic term
    fun getBreweriesByTerm(responseBody : MutableLiveData<List<Brewery>>, term : String){
        CoroutineScope(Dispatchers.IO).launch{
            val response = service.getBreweriesByTerm(term)

            withContext(Dispatchers.Main){
                try{
                    if(response.isSuccessful){
                        responseBody.value = response.body()
                    }
                } catch(e: HttpException){
                    println("Http exception")
                }
            }

        }
    }
}