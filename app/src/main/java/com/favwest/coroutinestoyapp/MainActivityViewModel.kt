package com.favwest.coroutinestoyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class MainActivityViewModel : ViewModel() {
    private var _currentNumber = MutableLiveData<Int>(0)
    val currentNumber: LiveData<Int>
        get() = _currentNumber

    suspend fun countUpSlowly() {
        for (number in 0..100) {
            delay(10L)
            _currentNumber.value = number + 1
        }
    }
}