package com.motiky.appnavigation.ui

import androidx.lifecycle.ViewModel
import com.motiky.appnavigation.data.OrderUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.logging.SimpleFormatter

private const val PRICE_PER_CUPCAKE = 2.00
private const val PRICE_FOR_SAME_DAY_PICKUP = 3.00

class OrderViewModel: ViewModel() {

    private val _orderUiState = MutableStateFlow(OrderUiState(pickUpOptions = pickupOptions()))
    val orderUiState: StateFlow<OrderUiState> = _orderUiState.asStateFlow()

    fun setQuantity(numberCupcakes: Int) {
        _orderUiState.update { currState->
            currState.copy(
                quantity = numberCupcakes,
                price = calculatePrice(quantity = numberCupcakes)
            )
        }
    }

    fun setFlavor(desiredFlavor: String) {
        _orderUiState.update { currState->
            currState.copy(
                flavor = desiredFlavor
            )
        }
    }

    fun setDate(pickupDate: String) {
        _orderUiState.update { currState ->
            currState.copy(
                date = pickupDate,
                price = calculatePrice(pickupDate = pickupDate)
            )
        }
    }

    fun resetOrder() {
        _orderUiState.value = OrderUiState(pickUpOptions = pickupOptions())
    }

    private fun calculatePrice(
        quantity: Int = _orderUiState.value.quantity,
        pickupDate: String = _orderUiState.value.date
    ):String {
        var calculatedPrice = quantity * PRICE_PER_CUPCAKE

        if(pickupOptions()[0] == pickupDate) {
            calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
        }
        val formatedPrice = NumberFormat.getCurrencyInstance().format(calculatedPrice)
        return formatedPrice
    }

    private fun pickupOptions(): List<String>{
        val dateOptions = mutableListOf<String>()
        val formatter = SimpleDateFormat("E MMM d", Locale.getDefault())
        val calender = Calendar.getInstance()

        repeat(4) {
            dateOptions.add(formatter.format(calender.time))
            calender.add(Calendar.DATE, 1)
        }
        return dateOptions
    }
}