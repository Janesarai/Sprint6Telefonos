package com.example.sprint6telefonos.vistas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sprint6telefonos.R
import com.example.sprint6telefonos.data.local.FonoEntity
import com.example.sprint6telefonos.databinding.ItemFonoBinding

class AdapterFono: RecyclerView.Adapter <AdapterFono.ItemFonoViewHolder>() {
    lateinit var binding: ItemFonoBinding
    private val listaItemFono = mutableListOf<FonoEntity>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterFono.ItemFonoViewHolder {

        binding = ItemFonoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemFonoViewHolder(binding)

    }


    override fun onBindViewHolder(holder: AdapterFono.ItemFonoViewHolder, position: Int) {
        val fono = listaItemFono[position]
        holder.bind(fono)
    }

    override fun getItemCount(): Int {
        return listaItemFono.size
    }

    fun setData(fono: List<FonoEntity>){
        this.listaItemFono.clear()
        this.listaItemFono.addAll(fono)
        notifyDataSetChanged()
    }
    class ItemFonoViewHolder(val fonoVista: ItemFonoBinding): RecyclerView.ViewHolder(fonoVista.root) {
        fun bind(fono: FonoEntity){
            fonoVista.txNombreFono.text = fono.nombre
            fonoVista.txPrecio.text = fono.precio.toString()
            fonoVista.imgFono.load(fono.imagen)
            fonoVista.CVfono.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("id", fono.id)
                Navigation.findNavController(fonoVista.root).navigate(R.id.action_fragmentListaFono_to_fragmentDetalleFono, bundle)
            }
        }
    }
}