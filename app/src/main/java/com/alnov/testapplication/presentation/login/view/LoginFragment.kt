package com.alnov.testapplication.presentation.login.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.alnov.testapplication.presentation.login.viewmodel.LoginViewModel
import com.alnov.testapplication.presentation.main.view.MainActivity
import com.alnov.testapplication.presentation.utils.Constants.LoginFlow.HomePage
import com.alnov.testapplication.presentation.utils.ValidationHelper.assertEmail
import com.alnov.testapplication.presentation.utils.ValidationHelper.assertNotEmpty
import com.alnov.testapplication.presentation.utils.showSuccessSnackbar
import com.afollestad.vvalidator.form
import com.alnov.testapplication.R
import com.alnov.testapplication.databinding.FragmentLoginBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding
    private val viewModel by viewModel<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListener()
        setUpObserver()
    }

    private fun setUpListener() {
        binding?.let {
            with(it) {
                form {
                    inputLayout(textInputLayoutEmail) {
                        assertNotEmpty()
                        assertEmail()
                    }
                    inputLayout(textInputLayoutPassword) {
                        assertNotEmpty()
                    }
                    submitWith(R.id.button_login) {
                        if (it.success()) {
                            viewModel.onUserLogin(editTextEmail.text.toString())
                            navigateToWatchList()
                        }
                    }
                }
            }
        }
    }

    private fun setUpObserver() {
        viewModel.loginFlow.observe(viewLifecycleOwner) {
            when (it) {
                HomePage -> navigateToWatchList()
            }
        }
        viewModel.successSnackbar().observe(viewLifecycleOwner) { message ->
            val view = requireActivity().findViewById(android.R.id.content) as View
            view.showSuccessSnackbar(message)
        }
    }

    private fun navigateToWatchList() {
        val action =
            LoginFragmentDirections.actionLoginFragmentToWatchListFragment()
        if (findNavController().currentDestination?.id == R.id.loginFragment) {
            findNavController().navigate(action)
        }
    }

    override fun onAttach(context: Context) {
        (activity as MainActivity).hideBottomNavigation()
        (activity as MainActivity).hideMenu(true)
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        (activity as MainActivity).showBottomNavigation()
        (activity as MainActivity).hideMenu(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}