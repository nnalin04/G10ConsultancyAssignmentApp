package com.example.g10consultancyassignmentapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.g10consultancyassignmentapp.R
import com.example.g10consultancyassignmentapp.data.Response
import com.example.g10consultancyassignmentapp.data.model.Product
import com.example.g10consultancyassignmentapp.databinding.FragmentProductListBinding
import com.example.g10consultancyassignmentapp.ui.RecyclerViewClickListener
import com.example.g10consultancyassignmentapp.ui.adapter.ProductAdapter
import com.example.g10consultancyassignmentapp.utils.Constants
import com.example.g10consultancyassignmentapp.viewmodel.ProductViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListFragment : Fragment(), RecyclerViewClickListener {

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    private lateinit var data: List<Product>

    private lateinit var adapter: ProductAdapter

    private val viewModel: ProductViewModel by viewModels()

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
        data = ArrayList<Product>()
        setRecycleView()
        viewModel.productList.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Response.Loading -> {

                }
                is Response.Success -> {
                    it.data?.let { data ->
                        this.data = data
                        adapter.updateView(this.data)
                    }
                }
                is Response.Error -> {

                }
            }
        })
    }

    private fun setRecycleView() {
        val layoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(requireActivity().applicationContext)
        adapter = ProductAdapter(data, this)
        binding.productRecycleView.layoutManager = layoutManager
        binding.productRecycleView.adapter = adapter
    }

    override fun onRecyclerViewItemClick(product: Product) {
        val bundle = Bundle()
        bundle.putString(Constants.PRODUCT, Gson().toJson(product))
        findNavController().navigate(
            R.id.action_productListFragment_to_productDetailFragment,
            bundle
        )
    }
}