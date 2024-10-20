package com.nurazlib.autoclicker.databinding

import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class ActivityMainBinding {
    lateinit var root: ConstraintLayout
    lateinit var startFloatingButton: Button
    lateinit var stopFloatingButton: Button

    companion object {
        fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): ActivityMainBinding {
            // Inflate the layout and return the binding
            val binding: ActivityMainBinding = DataBindingUtil.inflate(inflater, R.layout.activity_main, container, attachToRoot)
            return binding
        }
    }
}
