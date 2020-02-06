package com.example.cse438_rest_studio.Network

import com.example.cse438_rest_studio.data.Brewery
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//interface to denote different calls with arguements
interface BreweryInterface {

    //Done #4: Create a function signature for accessing breweries by city
    @GET("breweries")
    suspend fun getBreweriesByCity(@Query("by_city") by_city : String): Response<List<Brewery>>

    //Done #5: Create a function signature that provides a search term for breweries
    @GET("breweries")
    suspend fun getBreweriesByTerm(@Query("by_name") by_name : String): Response<List<Brewery>>

}