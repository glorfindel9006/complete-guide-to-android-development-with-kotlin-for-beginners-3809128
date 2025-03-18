package com.example.two.trees

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModel: ViewModel() {

    val TAG = "MainViewModel"

    init {
        Log.i(TAG, "initialize")
    }

    fun generateNewImageId(): Int {
        return when(Random.nextInt(4)) {
            0 -> R.drawable.delicate_olive_oil
            1 -> R.drawable.lemon_olive_oil
            2 -> R.drawable.chili_olive_oil
            3 -> R.drawable.basil_olive_oil
            else -> R.drawable.logo
        }
    }
}