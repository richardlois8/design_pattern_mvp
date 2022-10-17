package com.rich.designpatternexercise.presenter

import com.rich.designpatternexercise.model.CarResponseItem

interface ListCarView {
    fun onSucces(message : String, data : List<CarResponseItem>)
    fun onFailure(message : String)
}