package com.favwest.coroutinestoyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private val _currentNumber = MutableLiveData<Int>(0)
    val currentNumber: LiveData<Int>
        get() = _currentNumber
}