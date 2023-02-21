package com.example.fragmentpolicysample.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.fragmentpolicysample.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        insertNestedFragment()
    }

    // Embeds the child fragment dynamically
    private fun insertNestedFragment() {
        val childFragment: Fragment = ChildFragment()
        // parentFragmentManager
        // val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        requireActivity().supportFragmentManager.commit {
            replace(
                R.id.child_fragment_container,
                childFragment,
            )
        }

        parentFragment?.childFragmentManager?.commit {
            replace(
                R.id.child_fragment_container,
                childFragment,
            )
        }
    }
}

/**
 * Policy violation with PENALTY_DEATH in com.example.ChildFragment
 *
 *             androidx.fragment.app.strictmode.WrongNestedHierarchyViolation:
 *                         Attempting to nest fragment ChildFragment{4c02f88} (dc268e69-921a-408b-a219-463b4295ab6d id=0x7f080071)
 *                         within the view of parent fragment MainFragment{e0ab96c} (5714e376-2187-477c-9bac-7950a0ed4e88 id=0x7f08007d)
 *                         via container with ID 2131230833 without using parent's childFragmentManager
 *
 *             at androidx.fragment.app.strictmode.FragmentStrictMode.onWrongNestedHierarchy
 */
