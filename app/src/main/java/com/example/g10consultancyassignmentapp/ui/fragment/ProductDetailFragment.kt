package com.example.g10consultancyassignmentapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.g10consultancyassignmentapp.data.model.Product
import com.example.g10consultancyassignmentapp.databinding.FragmentProductDetailBinding
import com.example.g10consultancyassignmentapp.ui.adapter.ViewPagerRecyclerAdapter
import com.example.g10consultancyassignmentapp.utils.Constants
import com.google.gson.Gson


class ProductDetailFragment : Fragment() {

    private var _binding : FragmentProductDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var product: Product

    private lateinit var adapter: ViewPagerRecyclerAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jsonProduct = arguments?.getString(Constants.PRODUCT)
        if (jsonProduct != null) {
            product = Gson().fromJson<Product>(jsonProduct, Product::class.java)
            product.let {
                binding.brand.text = product.brand
                binding.model.text = product.title
                binding.discount.text = product.discountPercentage.toString() + " %"
                binding.price.text = product.price.toString() + " $"
                binding.description.text = product.description
                setImage(product.images)
            }
        }
    }

    private fun setImage(images: List<String>) {
        adapter = ViewPagerRecyclerAdapter(images, requireActivity().applicationContext)
        binding.pager.adapter = adapter
    }

}