package com.rich.designpatternexercise.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.rich.designpatternexercise.databinding.ActivityDetailCarBinding
import com.rich.designpatternexercise.model.CarResponseItem
import com.rich.designpatternexercise.presenter.CarPresenter
import com.rich.designpatternexercise.presenter.ListCarView

class DetailCarActivity : AppCompatActivity(),ListCarView {
    private lateinit var presenter : CarPresenter
    private lateinit var binding: ActivityDetailCarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = CarPresenter(this)
        presenter.getCarById(intent.getIntExtra("id",0))
    }

    override fun onSucces(message: String, data: List<CarResponseItem>) {
        binding.car = data[0]
        Glide.with(this).load(data[0].image).into(binding.imgCar)
    }

    override fun onFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}