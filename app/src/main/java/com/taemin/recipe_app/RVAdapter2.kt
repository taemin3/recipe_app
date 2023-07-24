package com.taemin.recipe_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.taemin.recipe_app.utils.FBAuth
import com.taemin.recipe_app.utils.FBRef
import android.app.Activity




class RVAdapter2(val context : Context, val List : MutableList<ContentsModel>, val keyList : ArrayList<String>) : RecyclerView.Adapter<RVAdapter2.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter2.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item2,parent,false)

        return ViewHolder(v)
    }

//    interface ItemClick{
//        fun onClick(view : View, position: Int)
//    }
//
//    var itemClick : ItemClick? = null



    override fun onBindViewHolder(holder: RVAdapter2.ViewHolder, position: Int) {
//        if (itemClick != null) {
//            holder?.itemView.setOnClickListener{ v->
//                itemClick!!.onClick(v, position)
//            }
//        }

        holder.bindItems(List[position],keyList[position])
    }

    override fun getItemCount(): Int {
        return List.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(item : ContentsModel,key : String) {

            itemView.setOnClickListener{
                val intent = Intent(context, ViewActivity::class.java)
                intent.putExtra("url",item.url)
                itemView.context.startActivity(intent)
            }

            val rv_img = itemView.findViewById<ImageView>(R.id.rvImageArea)
            val rv_text = itemView.findViewById<TextView>(R.id.rvTextArea)
            val delBtn = itemView.findViewById<Button>(R.id.delBtn)

            delBtn.setOnClickListener {
                FBRef.myfood
                    .child(FBAuth.getUid())
                    .child(key)
                    .removeValue()


            }



            rv_text.text = item.title
            Glide.with(context)
                .load(item.imageUrl)
                .into(rv_img)
        }
    }

}