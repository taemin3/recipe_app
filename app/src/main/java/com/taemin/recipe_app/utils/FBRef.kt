package com.taemin.recipe_app.utils

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FBRef {

    companion object {
        private val database = Firebase.database


        val myfood = database.getReference("Myfood")
    }

}