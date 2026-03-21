package com.sperrji

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity

/**
 * Invisible activity used by the home screen widget (and can be launched explicitly) to lock.
 */
class LockActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!SperrjiAccessibilityService.tryLockScreen()) {
            Toast.makeText(this, R.string.toast_enable_accessibility, Toast.LENGTH_SHORT).show()
        }
        finish()
    }
}
