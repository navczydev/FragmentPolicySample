package com.example.fragmentpolicysample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.strictmode.FragmentReuseViolation
import androidx.fragment.app.strictmode.FragmentStrictMode
import androidx.fragment.app.strictmode.Violation
import com.example.fragmentpolicysample.ui.main.MainFragment

class MainActivity : AppCompatActivity(), FragmentStrictMode.OnViolationListener {

    init {
        FragmentStrictMode.defaultPolicy = FragmentStrictMode.Policy.Builder()
            .penaltyDeath()
            .penaltyLog()
            .detectFragmentReuse()
            .detectWrongNestedHierarchy()
            .detectFragmentTagUsage()
            .detectSetUserVisibleHint()
            .detectWrongFragmentContainer()
            .detectRetainInstanceUsage()
            .detectTargetFragmentUsage()
            .penaltyListener(this)
            .allowViolation(
                MainFragment::class.java,
                FragmentReuseViolation::class.java,
            )
            .build()
        supportFragmentManager.strictModePolicy =
            FragmentStrictMode.Policy.Builder()
                .penaltyDeath()
                .penaltyLog()
                .detectFragmentReuse()
                .detectWrongNestedHierarchy()
                .detectFragmentTagUsage()
                .detectSetUserVisibleHint()
                .detectWrongFragmentContainer()
                .detectRetainInstanceUsage()
                .detectTargetFragmentUsage()
                .penaltyListener(this)
                .allowViolation(
                    MainFragment::class.java,
                    FragmentReuseViolation::class.java,
                )
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.container, MainFragment.newInstance())
            }
        }
    }

    override fun onViolation(violation: Violation) {
        Log.d(TAG, "onViolation: ${violation.cause}")
    }

    companion object {
        const val TAG = "MainActivity"
    }
}
