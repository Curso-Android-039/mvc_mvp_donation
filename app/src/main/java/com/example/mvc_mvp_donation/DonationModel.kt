package com.example.mvc_mvp_donation

class DonationModel {

    private var totalAmount: Int = 0



    init {
        this.totalAmount =0
    }

    // para guardar donaciones

    fun saveDonation( donation : String): Boolean {
        // convirtiendo de String a int
        val amount = donation.toIntOrNull()

        if( amount  != null  && amount >0){

            totalAmount += amount
        }
        return  false
    }


    fun getDonationAmount(): Int{
        return  totalAmount
    }





}