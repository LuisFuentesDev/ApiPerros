package com.example.apiperros.presentacion

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apiperros.data.local.RazaEntity
import com.example.apiperros.databinding.FragmentListadoRazasBinding
import com.example.apiperros.databinding.ItemRazasBinding

class AdapterRazas : RecyclerView.Adapter<AdapterRazas.ItemRazasViewHolder>() {

    lateinit var binding: ItemRazasBinding
    private val listItemRazas = mutableListOf<RazaEntity>()

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): AdapterRazas.ItemRazasViewHolder {
       binding = ItemRazasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemRazasViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItemRazas.size
    }

    override fun onBindViewHolder(holder: AdapterRazas.ItemRazasViewHolder, position: Int) {
        val raza = listItemRazas[position]
        holder.bind(raza)
    }

    fun setData(razas:List<RazaEntity>){
        this.listItemRazas.clear()
        this.listItemRazas.addAll(razas)
        notifyDataSetChanged()
    }

    class ItemRazasViewHolder(val razasVista:ItemRazasBinding):RecyclerView.ViewHolder(razasVista.root) {
        fun bind(raza:RazaEntity){
        razasVista.txtRaza.text = raza.raza
        }
    }
}