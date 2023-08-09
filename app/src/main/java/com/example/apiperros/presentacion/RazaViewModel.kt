package com.example.apiperros.presentacion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiperros.data.Repositorio
import com.example.apiperros.data.local.RazaDataBase
import com.example.apiperros.data.remote.RazaPerritoRetrofit
import kotlinx.coroutines.launch

class RazaViewModel(application: Application) : AndroidViewModel(application) {

    private val repositorio: Repositorio

    init {
        val api = RazaPerritoRetrofit.getRetrofitRaza()
        val razaDataBase = RazaDataBase.getDataBase(application).getRazaDao()
        repositorio = Repositorio(api, razaDataBase)

    }
    fun getAllRazas() = viewModelScope.launch {
        repositorio.getRazas()
    }
}