package com.example.applist.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.applist.R
import com.example.applist.databinding.ResultScanFragmentBinding
import com.example.applist.model.AppData
import com.example.applist.view.adapters.ActionListener
import com.example.applist.view.adapters.AppsListAdapter


class ResultScanFragment : Fragment(R.layout.result_scan_fragment) {

    private lateinit var binding: ResultScanFragmentBinding
    private lateinit var adapter: AppsListAdapter
    private val args: ResultScanFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ResultScanFragmentBinding.bind(view)


        adapter = AppsListAdapter(object : ActionListener {
            override fun onAppDetails(app: AppData) {
                onAppDetailsClick(app)
            }
        })
        adapter.apps= args.apps.toList()
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.appList.layoutManager = layoutManager
        binding.appList.adapter = adapter
    }

    private fun onAppDetailsClick(app:AppData) {
        val direction = ResultScanFragmentDirections.actionResultScanFragmentToDetailsFragment(app)
        findNavController().navigate(direction)
    }
}