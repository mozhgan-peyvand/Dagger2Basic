package com.example.dagger2basic

import android.icu.text.CaseMap
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dagger2basic.UserRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    /**
     * use live data in normal way with first init
     */

     var noteListHome = MutableLiveData<Result<List<FieldView>>>()
//    var contentListHome = MutableLiveData<Result<List<ContentView>>>()


//    var student =  MutableLiveData<Boolean>(false)
    private var listFieldView = MutableLiveData<CourseView>()

    /**
     * first init recycler view that extended by list Adapter
     *  without save data in dataBase with retrofit
     *  this fun is for add item to listAdapter with plus
     *  for delete item used minus
     */
    fun getCoursce(){
        noteListHome = userRepository.users()
    }

//    fun getContent(){
//        contentListHome = userRepository.content()
//    }


//    fun addNoteItem(title: String) {
//        noteItemInfoView = NoteItemInfoView(title)
//        _noteListHome.value = _noteListHome.value?.plus(noteItemInfoView)
//    }
}