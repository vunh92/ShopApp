package com.vunh.shop_app.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vunh.shop_app.R
import com.vunh.shop_app.databinding.FragmentDashboardBinding
import com.vunh.shop_app.presentation.MainActivity
import com.vunh.shop_app.presentation.login.LoginActivity

class DashboardFragment : Fragment() {

private var _binding: FragmentDashboardBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

    private fun signOut(){
        (activity as MainActivity).signOut()
    }

    override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)

    _binding = FragmentDashboardBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val textView: TextView = binding.textDashboard
    dashboardViewModel.text.observe(viewLifecycleOwner) {
      textView.text = it
    }

    binding.toolbar.inflateMenu(R.menu.menu_main)
        binding.toolbar.setOnMenuItemClickListener {
        when (it.itemId) {
            R.id.action_sign_out -> {
                // Navigate to settings screen
                signOut()
                true
            }
            else -> false
        }
    }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}