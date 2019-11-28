package com.kanykeinu.checkyourself.data.local

import androidx.annotation.LayoutRes

data class QuestionModel(
        val img: String,
        val question: String,
        val answers: List<Map<String, String>>,
        val correctAnswer : String) {
}
