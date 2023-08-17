package com.example.sprint6telefonos.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.sprint6telefonos.R
import com.example.sprint6telefonos.databinding.FragmentDetalleFonoBinding


private const val ARG_PARAM1 = "param1"


class FragmentDetalleFono : Fragment() {
    lateinit var binding: FragmentDetalleFonoBinding
    private val fonoVM: FonoVM by activityViewModels()
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
        binding = FragmentDetalleFonoBinding.inflate(layoutInflater,container,false)
        initAdapter()

        return binding.root
    }

    private fun initAdapter() {
        val adapter = AdapterDetalle()
        binding.RVdetalle.adapter = adapter

    }


}