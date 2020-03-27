package com.kanykeinu.checkyourself.ui.subjectsList

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.kanykeinu.checkyourself.R
import com.kanykeinu.checkyourself.data.local.SubjectModel

class SubjectListViewModel : ViewModel() {
    val subjectsWithQuestions = MutableLiveData<List<SubjectModel>>()
    val error = MutableLiveData<String>()

    fun loadSubjects(): LiveData<List<SubjectModel>> {
//        val subjects = arrayListOf<SubjectModel>(
//                SubjectModel(R.drawable.math, "Математика", 14),
//                SubjectModel(R.drawable.russ, "Русский язык", 20),
//                SubjectModel(R.drawable.physics, "Физика", 30))
//        subjectsWithQuestions.value = subjects as List<SubjectModel>?

        return subjectsWithQuestions
    }

}
