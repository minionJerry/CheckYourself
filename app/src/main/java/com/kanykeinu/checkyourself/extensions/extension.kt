package com.kanykeinu.checkyourself.extensions

import android.content.Context
import android.view.View
import com.kanykeinu.checkyourself.data.local.SubjectModel

interface ViewContainer {
    val containerView: View?
}

//fun Context.toSubjectModel(dataSnapshot: DataSnapshot){ //convert dataSnapshot to list of
//    val subjectsList = dataSnapshot.getValue<SubjectModel>(SubjectModel::class.java)
//
//}