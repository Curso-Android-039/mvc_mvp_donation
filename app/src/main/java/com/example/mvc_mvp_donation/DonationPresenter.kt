package com.example.mvc_mvp_donation

class DonationPresenter(private val view : IViewPresenter) {


    //comunicar con el model la referencia a la clase model


    private  val model: DonationModel

    init{
        model = DonationModel()
    }


    //llamar la funcion dle model GUARDAR

    fun  saveDonation (donation :String ){

        if(model.saveDonation(donation)){

            view.displayConfirmationMessage()
            view.updateTotalDonation(model.getDonationAmount())
        }
        else {
            view.displayErrorMessage()
        }


    }


    fun totalDonation(){
        view.updateTotalDonation(model.getDonationAmount())
    }

    fun checkTotal(){
        view.displayColorAlert(model.chekAmount())
    }

}