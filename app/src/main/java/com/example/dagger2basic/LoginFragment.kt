package com.example.dagger2basic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.dagger2basic.core.ui.safeNavigate
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_login, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        cb_student.setOnClickListener {
        }
        btn_login2.setOnClickListener {
//            if (homeViewModel.student.value == true) {
            safeNavigate(
                findNavController(),
                LoginFragmentDirections.actionLoginFragmentToFieldFragment()
            )
//            }
        }
    }


}