package com.taemin.recipe_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class westernActivity : AppCompatActivity() {
    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_western)

        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6901938",
                "https://recipe1.ezmember.co.kr/cache/recipe/2018/12/14/2e5a56658f3abe62fa741b2958e3354e1_s.jpg",
                "크림파스타"
            )
        )
        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6895534",
                "https://recipe1.ezmember.co.kr/cache/recipe/2018/09/09/9308e339ab6033260f1e18b6945ca7bf1_s.jpg",
                "피자"
            )
        )
        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6951957",
                "https://recipe1.ezmember.co.kr/cache/recipe/2019/10/17/b04528673e70c3118e4e72dc6b4f47c11_s.jpg",
                "스테이크"
            )
        )
        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6874085",
                "https://recipe1.ezmember.co.kr/cache/recipe/2017/08/04/8488f4c68d54e3e094d77dc5eb7553f21_s.jpg",
                "감자스프"
            )
        )







        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext, items)
        recyclerView.adapter = rvAdapter

        rvAdapter.itemClick = object : RVAdapter.ItemClick {
            override fun onClick(view : View, position: Int) {
                val intent = Intent(baseContext,ViewActivity::class.java)
                intent.putExtra("url", items[position].url)
                intent.putExtra("title", items[position].title)
                intent.putExtra("imageUrl", items[position].imageUrl)

                startActivity(intent)
            }
        }

        recyclerView.layoutManager = GridLayoutManager(this,1)


    }
}