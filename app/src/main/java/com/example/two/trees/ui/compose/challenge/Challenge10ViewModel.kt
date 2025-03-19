package com.example.two.trees.ui.compose.challenge

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.lang.Thread.State

private const val PRICE_PER_CAN_OF_OLIVES = 5

class Challenge10ViewModel : ViewModel() {

    private val _quantity = MutableStateFlow(0)
    // TODO: create public variable
    val quantity:StateFlow<Int> = _quantity

    private val _totalAmount = MutableStateFlow(0)
    // TODO: create public variable
    val totalAmount:StateFlow<Int> = _totalAmount

    fun increaseQuantity() {
        // TODO: implement this method
        _quantity.value++
    }

    fun decreaseQuantity() {
        // TODO: implement this method
        if (_quantity.value > 0) _quantity.value--
    }

    fun checkout() {
        _totalAmount.value = _quantity.value * PRICE_PER_CAN_OF_OLIVES
    }

}
