package com.taemin.recipe_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MyfoodActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private val contentModel = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val items = ArrayList<ContentsModel>()
        val itemKeyList = ArrayList<String>()

        auth = Firebase.auth

        val database = Firebase.database

        setContentView(R.layout.activity_myfood)


        val rvAdapter = RVAdapter2(baseContext, items,itemKeyList)

//
//        rvAdapter.itemClick = object : RVAdapter2.ItemClick {
//            override fun onClick(view : View, position: Int) {
//                val intent = Intent(baseContext,ViewActivity::class.java)
//                intent.putExtra("url", contentModel[position].url)
//                intent.putExtra("title", contentModel[position].title)
//                intent.putExtra("imageUrl", contentModel[position].imageUrl)
//
//                startActivity(intent)
//            }
//        }







        var cutuid = auth.currentUser?.uid.toString()

        val myfood = database.getReference("Myfood")

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (dataModel in dataSnapshot.children) {
                    Log.d("ContentListAcitivity", dataModel.toString())
                    Log.d("ContentListAcitivity", dataModel.key.toString())
                    val item = dataModel.getValue(ContentsModel::class.java)
                    items.add(item!!)
                    itemKeyList.add(dataModel.key.toString())
                }
                rvAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("ContentListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        myfood.child(cutuid).addValueEventListener(postListener)

        val recyclerView = findViewById<RecyclerView>(R.id.rv)

        recyclerView.adapter = rvAdapter

        recyclerView.layoutManager = GridLayoutManager(this,1)

//        myfood
//            .child(auth.currentUser?.uid.toString())
//            .addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    for (detaModel in snapshot.children) {
//                        Log.d("Datamodel",detaModel.toString())
//                        contentModel.add(detaModel.getValue(ContentsModel::class.java)!!)
//                    }
//                    rvAdapter.notifyDataSetChanged()
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//
//                }
//
//            })







        val del = findViewById<TextView>(R.id.del)
        del.setOnClickListener {
            myfood.child(cutuid).orderByChild("title").equalTo("떡볶이")
                .addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (childSnapshot in dataSnapshot.children) {
                            val clubkey = childSnapshot.key.toString()
                            Log.d("qweqw",clubkey)
                            // Add your code here to handle clubkey
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // Add your code here to handle errors, if necessary
                    }
                })

            myfood.child(cutuid).removeValue()
            startActivity(Intent(this,MyfoodActivity::class.java))
            finish()
        }

    }
}