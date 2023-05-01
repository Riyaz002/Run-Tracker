package com.riyaz.runtracker.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.riyaz.runtracker.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: MainRepository
): ViewModel() {

}