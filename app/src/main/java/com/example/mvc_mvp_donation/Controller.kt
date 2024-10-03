package com.example.mvc_mvp_donation

class Controller {

// comunica con el Model

    private val model  : DonationModel

    init {
        model = DonationModel()
    }

    // llamar la funcion model guardar

    fun saveDonation (amount:String):Boolean{
    return  model.saveDonation(amount)

    }



    // llamar la funcion model mostrar donaciones

    fun totalDonation():  Int{
        return  model.getDonationAmount()
    }
}