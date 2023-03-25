package com.faiz.newyorktimesnewsapp.presentation.details


import com.faiz.newyorktimesnewsapp.util.NavigationCommand
import com.faiz.newyorktimesnewsapp.BR
import com.faiz.newyorktimesnewsapp.base.BaseFragment
import com.faiz.newyorktimesnewsapp.databinding.FragmentNewsDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailsFragment :
    BaseFragment<FragmentNewsDetailsBinding, NewsDetailsVM>() {
    override val viewModelBindingVariable: Int
        get() = BR.viewModel

    override fun setBinding() = FragmentNewsDetailsBinding.inflate(layoutInflater)

    override fun listeners() {
        super.listeners()
        binding.toolbar.setNavigationOnClickListener {
            viewModel.navigationCommands.value = NavigationCommand.Back
        }
    }
}