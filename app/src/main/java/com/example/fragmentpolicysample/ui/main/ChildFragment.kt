package com.example.fragmentpolicysample.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentpolicysample.R

// Child fragment that will be dynamically embedded in the parent
class ChildFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Need to define the child fragment layout
        return inflater.inflate(R.layout.fragment_child, container, false)
    }
}
