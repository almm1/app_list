package com.example.applist.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.applist.R
import com.example.applist.databinding.ScanFragmentBinding
import com.example.applist.model.DataService
import com.example.applist.utils.ScanViewModelFactory
import com.example.applist.vievModels.ScanViewModel


class ScanFragment : Fragment(R.layout.scan_fragment) {
    private lateinit var binding: ScanFragmentBinding

    private val viewModel: ScanViewModel by viewModels { ScanViewModelFactory(DataService(), activity!!.application) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = ScanFragmentBinding.bind(view)
        binding.scanButton.setOnClickListener { onScanButtonPressed() }

    }
    private fun onScanButtonPressed(){
        val apps = viewModel.loadData()
        val direction = ScanFragmentDirections.actionScanFragmentToResultScanFragment(apps)
        findNavController().navigate(direction)
    }
}


