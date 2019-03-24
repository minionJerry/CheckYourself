package com.kanykeinu.checkyourself.ui.subjectsList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.kanykeinu.checkyourself.R
import com.kanykeinu.checkyourself.data.SubjectModel

class SubjectListViewModel : ViewModel() {
    val subjectList = MutableLiveData<List<SubjectModel>>()

    init {
        loadSubjects()
    }

    private fun loadSubjects(){
        val subjects = arrayListOf<SubjectModel>(
                SubjectModel(R.drawable.math, "Математика", 14),
                SubjectModel(R.drawable.russ, "Русский язык", 20),
                SubjectModel(R.drawable.physics, "Физика", 30))
        subjectList.value = subjects
    }
}
