package com.faiz.newyorktimesnewsapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.faiz.newyorktimesnewsapp.R
import com.faiz.newyorktimesnewsapp.util.LoadingDialog
import com.faiz.newyorktimesnewsapp.util.NavigationCommand
import com.faiz.newyorktimesnewsapp.util.showSnackBar
import com.faiz.newyorktimesnewsapp.util.toast
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

abstract class BaseFragment<T : ViewDataBinding, V : ViewModel> :
    Fragment() {

    private var _binding: T? = null
    protected val binding get() = _binding!!
    abstract val viewModelBindingVariable: Int

    @Inject
    lateinit var viewModel: V

    private var loadingDialog: LoadingDialog? = null

    private val shareVM: ShareViewModel by activityViewModels()
    open lateinit var sharedViewModel: ShareViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (viewModel as BaseViewModel).shareViewModel = shareVM
        sharedViewModel = shareVM
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = this.setBinding()
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        binding.setVariable(viewModelBindingVariable, viewModel)
        binding.executePendingBindings()
        listeners()
        observers()
        observe()
    }

    private fun observe() {
        (viewModel as BaseViewModel).navigationCommands.observe(
            viewLifecycleOwner,
            Observer {
                when (it) {
                    is NavigationCommand.To -> findNavController().navigate(it.directions)
                    is NavigationCommand.Back -> findNavController().popBackStack()
                }
            }
        )

        (viewModel as BaseViewModel).observeLoading.observe(
            viewLifecycleOwner,
            Observer {
                when {
                    it.showLoading -> {
                        showLoadingWidget()
                    }
                    it.isSuccess -> {
                        hideLoadingWidget()
                    }
                    it.message != "" -> {
                        hideLoadingWidget()
                        requireContext().toast(it.message)
                        showSnackBar(requireActivity(), getString(R.string.snack_bar_msg))
                    }
                    else -> {
                        hideLoadingWidget()
                    }
                }
            }
        )
    }

    abstract fun setBinding(): T
    protected open fun initViews() {}
    protected open fun observers() {}
    protected open fun listeners() {}


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showLoadingWidget() {
        loadingDialog = LoadingDialog(requireContext())
    }

    private fun hideLoadingWidget() {
        loadingDialog?.dismiss()
    }
}