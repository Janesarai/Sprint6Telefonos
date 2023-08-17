package com.example.sprint6telefonos.vistas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.sprint6telefonos.R
import com.example.sprint6telefonos.databinding.FragmentListaFonoBinding


class FragmentListaFono : Fragment() {
 lateinit var binding: FragmentListaFonoBinding
 private val fonoVM: FonoVM by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaFonoBinding.inflate(layoutInflater,container,false)
        fonoVM.getTodosFonos()
        initAdapter()

        return binding.root
    }

    private fun initAdapter() {
        val adapter = AdapterFono()
        binding.RVfono.adapter = adapter
        fonoVM.fonoLiveData().observe(viewLifecycleOwner){
            adapter.setData(it)
        }
    }


}