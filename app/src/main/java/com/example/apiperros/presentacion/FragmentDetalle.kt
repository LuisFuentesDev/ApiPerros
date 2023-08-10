package com.example.apiperros.presentacion

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.apiperros.R
import com.example.apiperros.databinding.FragmentDetalleBinding
import com.example.apiperros.databinding.FragmentListadoRazasBinding

private const val ARG_PARAM1 = "id"

class FragmentDetalle : Fragment() {
    lateinit var binding: FragmentDetalleBinding
    private val razaViewModel: RazaViewModel by activityViewModels()
    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(layoutInflater, container, false)
        initAdapter()
        razaViewModel.getDetallePerroVM(param1.toString())
        return binding.root
    }

    private fun initAdapter() {
        val adapter = AdapterDetalle()
        binding.recyclerViewDetalle.adapter = adapter
        razaViewModel.detalleLiveData(param1.toString()).observe(viewLifecycleOwner){
        adapter.setDetalle(it)
        }
    }


}