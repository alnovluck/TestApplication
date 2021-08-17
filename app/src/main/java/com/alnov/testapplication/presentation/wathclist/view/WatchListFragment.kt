package com.alnov.testapplication.presentation.wathclist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import com.alnov.testapplication.databinding.FragmentWatchListBinding
import com.alnov.testapplication.domain.common.Result
import com.alnov.testapplication.domain.common.SimpleResult
import com.alnov.testapplication.domain.model.CryptoModel
import com.alnov.testapplication.presentation.utils.*
import com.alnov.testapplication.presentation.wathclist.adapter.WatchListAdapter
import com.alnov.testapplication.presentation.wathclist.viewmodel.WatchListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WatchListFragment : Fragment() {

    private var _binding: FragmentWatchListBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<WatchListViewModel>()
    private lateinit var adapter: WatchListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWatchListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpView()
        setUpObserver()
        setUpListener()
        viewModel.getData()
    }

    private fun setUpView() {
        with(binding) {
            recyclerViewCryptoData.addItemDecoration(
                DividerItemDecoration(
                    context,
                    DividerItemDecoration.VERTICAL
                )
            )
            adapter = WatchListAdapter {
                viewModel.fetchNextPage()
                progressBarLoadMore.showSlideUp()
            }
            recyclerViewCryptoData.adapter = adapter
        }
    }

    private fun setUpObserver() {
        viewModel.cryptoData.observe(viewLifecycleOwner, ::handleCryptoResult)
    }

    private fun handleCryptoResult(result: SimpleResult<List<CryptoModel>>) {
        result.handleResult(
            { data ->
                stopShimmer()
                viewModel.cryptoList.addAll(data)
//                viewModel.updateDataLocal(data)
                adapter.submitList(viewModel.cryptoList)
                onFinishLoadData()
                viewModel.onUpdatePageNumber()
                binding.recyclerViewCryptoData.setVisible()
            }, {
                stopShimmer()
                onFinishLoadData()
            }, {
                stopShimmer()
                showErrorSnackbar(it.errorMessage)
                onFinishLoadData()
            }
        ) { state ->
            when (state) {
                Result.State.Loading -> {
                    onLoadData()
                }
            }
        }
    }

    private fun onFinishLoadData() {
        binding.progressBarLoadMore.hideSlideDown()
        binding.pullToRefresh.isRefreshing = false
        binding.textViewErrorMessage.showIf { viewModel.cryptoList.isNullOrEmpty() }
    }

    private fun onLoadData() {
        startShimmer()
        binding.textViewErrorMessage.setGone()
        binding.recyclerViewCryptoData.setGone()
    }

    private fun stopShimmer() {
        binding.shimmerLoading.stopShimmer()
        binding.shimmerLoading.setGone()
    }

    private fun startShimmer() {
        binding.shimmerLoading.setVisible()
        binding.shimmerLoading.startShimmer()
    }

    private fun setUpListener() {
        binding.pullToRefresh.setOnRefreshListener {
            binding.textViewErrorMessage.setGone()
            binding.recyclerViewCryptoData.setGone()
            startShimmer()
            adapter.submitList(null)
            viewModel.refreshData()
        }
    }

    private fun showErrorSnackbar(message: String) {
        val view = requireActivity().findViewById(android.R.id.content) as View
        view.showErrorSnackbar(message)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}