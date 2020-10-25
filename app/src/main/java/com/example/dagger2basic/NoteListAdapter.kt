package com.example.notepad.features.home.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.navigation.findNavController
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableList
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import com.example.dagger2basic.FieldView
import com.example.dagger2basic.R
import com.example.dagger2basic.databinding.ItemNoteListBinding
import com.example.notepad.core.util.binding.DataBoundListAdapter
import com.squareup.picasso.Picasso


/**
* use listAdapter that its deferent with recycler with becase it
 * dont ust of notifyDataSetChanged() after adapter and it
 * use of are itemTheSame and areContentTheSame for it
 * best source to displain recycler view in world! https://www.testchamber.nl/test-automation/testing-recyclerviews-with-espresso/
* */

class NoteListAdapter (private val context: Context?):
    DataBoundListAdapter<FieldView, ItemNoteListBinding>(
        diffCallback = object : DiffUtil.ItemCallback<FieldView>() {
            override fun areItemsTheSame(
                oldItem: FieldView,
                newItem: FieldView
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: FieldView,
                newItem: FieldView
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }
    ) {
//    private val context: Context

    override fun createBinding(parent: ViewGroup): ItemNoteListBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_note_list,
            parent,
            false
        )
    }

    override fun bind(binding: ItemNoteListBinding, item: FieldView, position: Int) {
        Picasso.get().load(item.Image).into(binding.courseimg);

        binding.apply {

            noteItem = item
            btn2.setOnClickListener {

            }
            root.setOnClickListener {

            }

        }
    }

    private var noteItemInfoView: MutableList<FieldView>? = null

    /**
     * can dont override it
    * */

    override fun submitList(list: MutableList<FieldView>?) {
        noteItemInfoView = list
        super.submitList(list)
    }

}