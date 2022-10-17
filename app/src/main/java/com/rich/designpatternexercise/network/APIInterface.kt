package com.rich.designpatternexercise.network

import com.rich.designpatternexercise.model.CarResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIInterface {
    @GET("admin/car")
    fun getAllCars() : Call<List<CarResponseItem>>

    @GET("admin/car/{id}")
    fun getCarById(@Path("id") id : Int) : Call<CarResponseItem>
}