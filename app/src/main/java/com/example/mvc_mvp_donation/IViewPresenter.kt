package com.example.mvc_mvp_donation

interface IViewPresenter {


    fun updateTotalDonation ( totalAmount :Int)

    fun displayConfirmationMessage()

    fun displayErrorMessage()

    fun displayColorAlert (color: String)
}