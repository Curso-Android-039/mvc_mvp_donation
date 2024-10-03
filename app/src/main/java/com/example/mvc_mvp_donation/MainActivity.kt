package com.example.mvc_mvp_donation

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.mvc_mvp_donation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var controller: Controller

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // inicializamos controller

        controller = Controller()


    }
    @SuppressLint("StringFormatInvalid")
    private  fun makeDonation(){
        val donation = controller.saveDonation(binding.tvDonation.text.toString())
        if(donation) {

            val totalDonation = controller.totalDonation()
            // recibo el total de las donaciones
            val total= getString(R.string.total_donaciones,totalDonation.toString())
            binding.tvTotal.text= total
            val toast = Toast.makeText(applicationContext, "Donación exitosa", Toast.LENGTH_LONG)
            toast.show()

        }
        else{

            val toast1 = Toast.makeText(
                applicationContext, "Donación Fallida",
                Toast.LENGTH_LONG)
            toast1.show()
        }


    }



}