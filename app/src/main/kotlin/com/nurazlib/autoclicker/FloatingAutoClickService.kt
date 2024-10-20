package com.nurazlib.autoclicker

import android.accessibilityservice.AccessibilityService
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.floating_widget.view.*

class FloatingAutoClickService : AccessibilityService() {
    private lateinit var windowManager: WindowManager
    private lateinit var floatingView: View
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate() {
        super.onCreate()
        windowManager = getSystemService(WINDOW_SERVICE) as WindowManager

        val layoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        floatingView = layoutInflater.inflate(R.layout.floating_widget, null)

        val params = WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        )
        params.gravity = Gravity.TOP or Gravity.START
        params.x = 100
        params.y = 100

        val clickButton: Button = floatingView.findViewById(R.id.click_button)
        clickButton.setOnClickListener {
            performGlobalAction(GLOBAL_ACTION_HOME)
            Toast.makeText(this, "Clicked!", Toast.LENGTH_SHORT).show()
        }

        floatingView.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    params.x = event.rawX.toInt()
                    params.y = event.rawY.toInt()
                    windowManager.updateViewLayout(floatingView, params)
                    true
                }
                MotionEvent.ACTION_MOVE -> {
                    params.x = event.rawX.toInt()
                    params.y = event.rawY.toInt()
                    windowManager.updateViewLayout(floatingView, params)
                    true
                }
                else -> false
            }
        }

        windowManager.addView(floatingView, params)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (floatingView != null) {
            windowManager.removeView(floatingView)
        }
    }

    override fun onServiceConnected() {
        super.onServiceConnected()
    }

    override fun onAccessibilityEvent(event: android.view.accessibility.AccessibilityEvent?) {}

    override fun onInterrupt() {}
}
