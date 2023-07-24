package com.taemin.recipe_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class chinaActivity : AppCompatActivity() {
    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_china)

        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6838655",
                "https://recipe1.ezmember.co.kr/cache/recipe/2015/11/25/1e26880e274893fb6df222bed4794bb51_m.jpg",
                "짜장면"
            )
        )
        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6897064",
                "https://recipe1.ezmember.co.kr/cache/recipe/2018/10/03/2d705ef0e765a316511fe42bac486cd31_s.jpg",
                "탕수육"
            )
        )
        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/2446471",
                "https://recipe1.ezmember.co.kr/cache/recipe/2015/06/08/f4f0a4739d7e3033277eda5b9e6caf96_s.jpg",
                "난자완스"
            )
        )
        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/2765742",
                "https://recipe1.ezmember.co.kr/cache/recipe/2015/04/10/8c0036a71a46e496e4572813bd1202c41_s.jpg",
                "마파두부"
            )
        )

        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6842005",
                "https://recipe1.ezmember.co.kr/cache/recipe/2016/01/23/b7ad001e4bab887facc421923ce868e61_s.jpg",
                "깐풍기"

            )
        )

        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6867023",
                "https://recipe1.ezmember.co.kr/cache/recipe/2017/03/17/5555cd2751c3676f5507f60b2a3d10141_s.jpg",
                "동파육"

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
