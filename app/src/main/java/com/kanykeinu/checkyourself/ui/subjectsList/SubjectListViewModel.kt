package com.kanykeinu.checkyourself.ui.subjectsList

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.kanykeinu.checkyourself.R
import com.kanykeinu.checkyourself.data.local.SubjectModel

class SubjectListViewModel() : ViewModel() {
    val subjectsWithQuestions = MutableLiveData<List<SubjectModel>>()
    val error = MutableLiveData<String>()

//    init {
//        FirebaseApp.initializeApp(context.applicationContext)
//    }
//
//
//    fun loadSubjects(): LiveData<List<SubjectModel>> {
////        val subjects = arrayListOf<SubjectModel>(
////                SubjectModel(R.drawable.math, "Математика", 14),
////                SubjectModel(R.drawable.russ, "Русский язык", 20),
////                SubjectModel(R.drawable.physics, "Физика", 30))
////        subjectList.value = subjects
//        if (subjectsWithQuestions.value == null) {
//
//            FirebaseDatabase.getInstance()
//                    .getReference("subjects")
//                    .addListenerForSingleValueEvent(object : ValueEventListener {
//                        override fun onCancelled(p0: DatabaseError) {
//                            error.value = p0.message
//                        }
//
//                        override fun onDataChange(p0: DataSnapshot) {
//                            if (p0.exists()) {
////                                toSubjectModel
////                                subjectsWithQuestions.postValue(p0)
//                            }
//                        }
//                    })
//        }
//        return subjectsWithQuestions
//    }

}
