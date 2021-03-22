package com.example.shareanalysiscalculator.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel : ViewModel() {

    private val cs1LiveData = MutableLiveData<Float>()
    private val ps1LiveData = MutableLiveData<Float>()
    private val vLiveData = MutableLiveData<Float>()
    private val clLiveData = MutableLiveData<Float>()

    fun cs1Changed(cs: Float) {
        cs1LiveData.value = cs
    }

    fun getCs1LiveData(): LiveData<Float> {
        return cs1LiveData
    }

    fun ps1Changed(ps: Float) {
        ps1LiveData.value = ps
    }

    fun getPs1LiveData(): LiveData<Float> {
        return ps1LiveData
    }

    fun vChanged(v: Float) {
        vLiveData.value = v
    }

    fun getVLiveData(): LiveData<Float> {
        return vLiveData
    }

    fun clChanged(cl: Float) {
        clLiveData.value = cl
    }

    fun getClLiveData(): LiveData<Float> {
        return clLiveData
    }
}