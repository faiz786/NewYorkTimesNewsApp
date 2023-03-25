package com.faiz.newyorktimesnewsapp.presentation.news

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.faiz.newyorktimesnewsapp.base.BaseFragment
import com.faiz.newyorktimesnewsapp.databinding.FragmentNewsBinding
import com.faiz.newyorktimesnewsapp.domain.model.NewsModel
import com.faiz.newyorktimesnewsapp.presentation.adapter.NewsAdapter
import com.faiz.newyorktimesnewsapp.util.NavigationCommand
import com.faiz.newyorktimesnewsapp.BR
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : BaseFragment<FragmentNewsBinding, NewsVM>(),
    NewsAdapter.OnItemClickListener {
    override val viewModelBindingVariable: Int
        get() = BR.viewModel

    override fun setBinding() = FragmentNewsBinding.inflate(layoutInflater)

    private val adapter = NewsAdapter(this)

    override fun initViews() {
        super.initViews()

        binding.rvNews.let {
            it.adapter = adapter
            it.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    override fun onItemClick(item: NewsModel) {
        viewModel.shareViewModel.news = item
        viewModel.navigationCommands.value = NavigationCommand.To(
            NewsFragmentDirections.actionNewsFragmentToDetailsNewsFragment()
        )
    }

    override fun observers() {
        super.observers()
        viewModel.observeNews.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }
}