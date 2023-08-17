package com.example.sprint6telefonos.vistas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sprint6telefonos.data.local.FonoDetalleEntity
import com.example.sprint6telefonos.databinding.ItemDetalleBinding

class AdapterDetalle: RecyclerView.Adapter<AdapterDetalle.ItemDetalleFonoViewHolder>() {
    lateinit var binding: ItemDetalleBinding
    private val listDetalle= mutableListOf<FonoDetalleEntity>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterDetalle.ItemDetalleFonoViewHolder {

        binding= ItemDetalleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemDetalleFonoViewHolder(binding)
    }


    override fun onBindViewHolder(holder: AdapterDetalle.ItemDetalleFonoViewHolder, position: Int) {
        val fonoDetail = listDetalle[position]
        holder.bind(fonoDetail)
    }

    override fun getItemCount(): Int {
        return listDetalle.size
    }
    fun setDataDetalle(fonoDetail: List<FonoDetalleEntity>) {
        this.listDetalle.clear()
        this.listDetalle.addAll(fonoDetail)
        notifyDataSetChanged()
    }
        class ItemDetalleFonoViewHolder(val fonoVista: ItemDetalleBinding) :
            RecyclerView.ViewHolder(fonoVista.root) {
            fun bind(fonoDetail: FonoDetalleEntity) {
                fonoVista.txDescripcion.text = fonoDetail.fonoDescripcion
                fonoVista.txCredito.text = fonoDetail.credito.toString()
                fonoVista.txPrecioFinal.text = fonoDetail.precioFinal.toString()
            }
        }
    }

