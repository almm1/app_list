package com.example.applist.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.applist.R
import com.example.applist.databinding.DetailsFragmentBinding
import com.example.applist.vievModels.DetailsViewModel

class DetailsFragment : Fragment(R.layout.details_fragment) {

    private lateinit var binding: DetailsFragmentBinding
    private val args: DetailsFragmentArgs by navArgs()
    private val viewModel = DetailsViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DetailsFragmentBinding.bind(view)

        binding.backButton.setOnClickListener { onBackButtonPressed() }
        viewModel.setApp(args.app)

        binding.logoApp.setImageDrawable(args.app.logo)
        binding.nameApp.text=viewModel.name
        binding.sizeApp.text=viewModel.size
        binding.sdkVersion.text=viewModel.sdkVersion
        binding.intallDate.text=viewModel.installDate
    }

    private fun onBackButtonPressed() {
        findNavController().popBackStack()
    }
}