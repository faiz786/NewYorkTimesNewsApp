package com.faiz.newyorktimesnewsapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding, V : ViewModel> :
    AppCompatActivity() {


    protected lateinit var binding: T

    @Inject
    lateinit var viewModel: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = this.setBinding()
        setContentView(binding.root)
        initViews()
        observers()
        listeners()

    }


    abstract fun setBinding(): T
    protected open fun initViews() {}
    protected open fun observers() {}
    protected open fun listeners() {}


}