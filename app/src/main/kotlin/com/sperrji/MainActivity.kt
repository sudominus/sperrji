package com.sperrji

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (SperrjiAccessibilityService.tryLockScreen()) {
            finish()
            return
        }
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.open_accessibility_button).setOnClickListener {
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        }
    }

    override fun onResume() {
        super.onResume()
        if (SperrjiAccessibilityService.tryLockScreen()) {
            finish()
        }
    }
}
