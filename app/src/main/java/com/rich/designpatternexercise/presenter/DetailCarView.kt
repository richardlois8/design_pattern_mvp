package com.rich.designpatternexercise.presenter

import com.rich.designpatternexercise.model.CarResponseItem

interface DetailCarView {
    fun onSucces(message : String, data : CarResponseItem)
    fun onFailure(message : String)
}