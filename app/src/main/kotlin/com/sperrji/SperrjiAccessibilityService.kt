package com.sperrji

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class SperrjiAccessibilityService : AccessibilityService() {

    override fun onServiceConnected() {
        super.onServiceConnected()
        instance = this
    }

    override fun onDestroy() {
        instance = null
        super.onDestroy()
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Intentionally empty: lock is triggered on demand from the launcher or widget.
    }

    override fun onInterrupt() {
        // No continuous operation to interrupt.
    }

    companion object {
        @Volatile
        private var instance: SperrjiAccessibilityService? = null

        fun tryLockScreen(): Boolean {
            val service = instance ?: return false
            return service.performGlobalAction(GLOBAL_ACTION_LOCK_SCREEN)
        }
    }
}
