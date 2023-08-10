package com.example.apiperros.presentacion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.apiperros.data.local.RazaDetalleEntity
import com.example.apiperros.databinding.FragmentDetalleBinding
import com.example.apiperros.databinding.ItemDetallePerroBinding

class AdapterDetalle : RecyclerView.Adapter<AdapterDetalle.DetallePerroViewHolder>() {

    lateinit var binding: ItemDetallePerroBinding
    private val listDetallePerro = mutableListOf<RazaDetalleEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetallePerroViewHolder {
        binding = ItemDetallePerroBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return DetallePerroViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listDetallePerro.size
    }

    override fun onBindViewHolder(holder: DetallePerroViewHolder, position: Int) {
        val perro = listDetallePerro[position]
        holder.bind(perro)
    }

    fun setDetalle(razaDetalleEntity: List<RazaDetalleEntity>){
        this.listDetallePerro.clear()
        this.listDetallePerro.addAll(razaDetalleEntity)
        notifyDataSetChanged()

    }

    class DetallePerroViewHolder(val perroVista: ItemDetallePerroBinding) :
        RecyclerView.ViewHolder(perroVista.root) {
        fun bind(razaDetalleEntity: RazaDetalleEntity) {
            perroVista.imageViewDetalle.load(razaDetalleEntity.url)
        }
    }
}