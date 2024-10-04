package com.example.mvc_mvp_donation

import android.graphics.Color
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

class MainActivity : AppCompatActivity(),IViewPresenter{


    private lateinit var binding: ActivityMainBinding
    //parte 1
  //private lateinit var controller: Controller
    private lateinit var presenter: DonationPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // inicializamos controller parte 1

      //  controller = Controller() parte 1


        // parte 2 MVP
         presenter = DonationPresenter(this)
        binding.button.setOnClickListener{makeDonation()}


    }

    private  fun makeDonation(){
        // aca se guarda la donación
      presenter.saveDonation(binding.tvDonation.text.toString())
        // limpia el textView
        binding.tvDonation.setText("")
        presenter.totalDonation()
        presenter.checkTotal()


    }

    // esta Función actualiza el visor de las donaciones
    override fun updateTotalDonation(totalAmount: Int) {
       val total  = getString(R.string.total_donaciones, totalAmount.toString())
        binding.tvTotal.text = total
    }

    override fun displayConfirmationMessage() {
        val toast = Toast.makeText(applicationContext,"Donación Exitosa", Toast.LENGTH_LONG)
        toast.show()
    }

    override fun displayErrorMessage() {
        val toast1 = Toast.makeText(applicationContext,"Donación Fallida", Toast.LENGTH_LONG)
        toast1.show()
    }

    override fun displayColorAlert(color: String) {
        binding.textView2.setBackgroundColor(Color.parseColor(color))

    }


}