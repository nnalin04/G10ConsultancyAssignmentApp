package com.example.g10consultancyassignmentapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.g10consultancyassignmentapp.data.model.Product
import com.example.g10consultancyassignmentapp.databinding.FragmentProductListBinding
import com.example.g10consultancyassignmentapp.ui.adapter.ProductAdapter

class ProductListFragment : Fragment() {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    private lateinit var data: ArrayList<Product>

    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycleView()
    }

    private fun setRecycleView() {
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(requireActivity().applicationContext)
        adapter = ProductAdapter(data)
        binding.productRecycleView.layoutManager = layoutManager
        binding.productRecycleView.adapter = adapter
    }
}