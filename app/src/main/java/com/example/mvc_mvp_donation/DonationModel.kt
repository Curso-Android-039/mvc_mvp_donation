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
            // aca faltaba el tru
            return true
        }
        return  false
    }


    fun getDonationAmount(): Int{
        return  totalAmount
    }


    // mvp

    fun chekAmount(): String{

        if(totalAmount >= 200 && totalAmount<=500){

            return "#F31A1A"
        }
        if(totalAmount >= 500 && totalAmount<=1000){

            return "#FFB33"
        }

        return "#58FF11"

    }




}