package com.example.sprint6telefonos.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.sprint6telefonos.R
import com.example.sprint6telefonos.databinding.FragmentDetalleFonoBinding


private const val ARG_PARAM1 = "id"


class FragmentDetalleFono : Fragment() {
    lateinit var binding: FragmentDetalleFonoBinding
    private val fonoVM: FonoVM by activityViewModels()
    private var fonoId: Int=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            fonoId= it.getInt("id")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleFonoBinding.inflate(layoutInflater,container,false)
        fonoVM.getDetallesFono(fonoId)
        initAdapter()

        return binding.root
    }

    private fun initAdapter() {

        fonoVM.detalleLiveData(fonoId).observe(viewLifecycleOwner) { fonoDetail ->
            if (fonoDetail != null) {
                binding.txNombreDetalle.text = fonoDetail.nombre
                binding.txPrecioDetalle.text = fonoDetail.precio.toString()
                binding.txDescripcion.text = fonoDetail.fonoDescripcion
                binding.txPrecioFinal.text = fonoDetail.precioFinal.toString()
                binding.imgDetalleFono.load(fonoDetail.imagen)
                if (!fonoDetail.credito) {
                    binding.txCredito.text = "Pago solo en efectivo"
                } else {
                    binding.txCredito.text = "Se acepta tarjeta de credito"
                }
            }
        }

    }
    }