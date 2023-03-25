package com.faiz.newyorktimesnewsapp


import com.faiz.newyorktimesnewsapp.base.BaseActivity
import com.faiz.newyorktimesnewsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainVM>() {
    override fun setBinding() = ActivityMainBinding.inflate(layoutInflater)
}