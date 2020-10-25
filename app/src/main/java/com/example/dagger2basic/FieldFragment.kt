package com.example.dagger2basic

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import com.example.dagger2basic.core.util.autoCleared
import com.example.dagger2basic.databinding.FragmentFieldBinding
import com.example.notepad.features.home.ui.NoteListAdapter

import retrofit2.Retrofit
import javax.inject.Inject

class FieldFragment : Fragment() {

    lateinit var navController: NavController
    private var binding by autoCleared<FragmentFieldBinding>()

    private var adapter by autoCleared<NoteListAdapter>()

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity().application as CourceApp).courceComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_field, container, false)
        return binding.root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel.getCoursce()
        initView()
    }

    @SuppressLint("FragmentLiveDataObserve")
    fun initView() {

        /**
         * init adapter and get it to bind
         * */

        Toast.makeText(context, "im adapter", Toast.LENGTH_LONG).show()
        adapter = NoteListAdapter(context)
        binding.noteList.adapter = adapter

        /**
         * first init adapter for test or other things
         * */

//        adapter.submitList(mutableListOf(NoteItemInfoView("mozhgan"),NoteItemInfoView("milad")))

        /**
         * init adapter after change
         * */

        homeViewModel.noteListHome.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Result.Success -> {
                    val uiModel = it.data
                    adapter.submitList(uiModel.toMutableList())
                }
                is Result.Error -> {
//                        Log.i("findNavController", "$it")
                    Toast.makeText(context, "${it.message}", Toast.LENGTH_SHORT).show()
                }
                is Result.Loading -> {
                }
            }

        })

    }

}
