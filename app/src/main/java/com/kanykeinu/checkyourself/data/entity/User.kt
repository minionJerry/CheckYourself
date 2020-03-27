package com.kanykeinu.checkyourself.data.entity

import com.google.firebase.firestore.Exclude

data class User(
    var uid: String = "",
    val name: String = "",
    val email: String = "",
    @Exclude
    var isAuthenticated: Boolean = false,
    @Exclude
    var isNew: Boolean = false,
    @Exclude
    var isCreated: Boolean = false
)