package com.rich.designpatternexercise.presenter

import com.rich.designpatternexercise.model.CarResponseItem
import com.rich.designpatternexercise.network.APIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CarPresenter(val listCarView : ListCarView) {
    fun getAllCars(){
        val client = APIClient.getService()
        client.getAllCars().enqueue(object : Callback<List<CarResponseItem>>{
            override fun onResponse(
                call: Call<List<CarResponseItem>>,
                response: Response<List<CarResponseItem>>
            ) {
                if(response.isSuccessful){
                    val data = response.body()
                    if(data != null){
                        listCarView.onSucces("Success", data)
                    }else{
                        listCarView.onFailure("Data is null")
                    }
                }
            }

            override fun onFailure(call: Call<List<CarResponseItem>>, t: Throwable) {
                listCarView.onFailure("Failed to get data")
            }

        })
    }

    fun getCarById(id : Int){
        val client = APIClient.getService()
        client.getCarById(id).enqueue(object : Callback<CarResponseItem>{
            override fun onResponse(
                call: Call<CarResponseItem>,
                response: Response<CarResponseItem>
            ) {
                if(response.isSuccessful){
                    val data = response.body()
                    if(data != null){
                        listCarView.onSucces("Success", listOf(data))
                    }else{
                        listCarView.onFailure("Data is null")
                    }
                }
            }

            override fun onFailure(call: Call<CarResponseItem>, t: Throwable) {
                listCarView.onFailure("Failed to get data")
            }

        })
    }
}