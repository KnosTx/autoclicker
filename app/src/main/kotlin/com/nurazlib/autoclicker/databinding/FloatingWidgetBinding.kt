package com.nurazlib.autoclicker.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil

class FloatingWidgetBinding {
    lateinit var root: ConstraintLayout
    lateinit var clickButton: Button

    companion object {
        fun inflate(inflater: LayoutInflater, container: ViewGroup?, attachToRoot: Boolean): FloatingWidgetBinding {
            // Inflate the layout and return the binding
            val binding: FloatingWidgetBinding = DataBindingUtil.inflate(inflater, R.layout.floating_widget, container, attachToRoot)
            return binding
        }
    }
}
