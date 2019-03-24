package com.kanykeinu.checkyourself.ui.subjectsList

import android.content.Context
import androidx.core.content.ContextCompat
import com.kanykeinu.checkyourself.R
import com.kanykeinu.checkyourself.data.local.SubjectModel
import com.kanykeinu.checkyourself.ui.base.BaseAdapter
import kotlinx.android.synthetic.main.item_rv_subjects.view.*

class SubjectAdapter(val context : Context) : BaseAdapter<SubjectModel>(R.layout.item_rv_subjects, null) {

    override fun onBindViewHolder(holder: BaseHolder, position: Int, item: SubjectModel) {
        holder.containerView.subject_img.background = ContextCompat.getDrawable(context, item.img)
        holder.containerView.subject_title.text = item.title
        holder.containerView.subject_question_count.text = item.questionsCount.toString() + " вопросов"
    }
}