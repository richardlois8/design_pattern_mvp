package com.rich.designpatternexercise

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rich.designpatternexercise.databinding.ActivityMainBinding
import com.rich.designpatternexercise.model.CarResponseItem
import com.rich.designpatternexercise.presenter.CarPresenter
import com.rich.designpatternexercise.presenter.ListCarView
import com.rich.designpatternexercise.view.AddEditActivity
import com.rich.designpatternexercise.view.CarAdapter
import com.rich.designpatternexercise.view.DetailCarActivity

class MainActivity : AppCompatActivity(), ListCarView {
    private lateinit var presenter : CarPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = CarPresenter(this)
        presenter.getAllCars()
        isLoading(true)
    }

    override fun onSucces(message: String, data: List<CarResponseItem>) {
        val adapter = CarAdapter(data)
        binding.rvCar.layoutManager = LinearLayoutManager(this)
        binding.rvCar.adapter = adapter
        adapter.onClick = {
            val intent = Intent(this, AddEditActivity::class.java)
            intent.putExtra("id", it.id)
            startActivity(intent)
        }
        isLoading(false)
    }

    override fun onFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun isLoading(state : Boolean){
        if(state){
            binding.progressBar.visibility = View.VISIBLE
        }else{
            binding.progressBar.visibility = View.GONE
        }
    }
}