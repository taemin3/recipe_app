package com.taemin.recipe_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class koreaActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentsModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_korea)

        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6894096",
                "https://recipe1.ezmember.co.kr/cache/recipe/2018/08/13/3233d427883d15239f297aeeaf1775531_m.jpg",
                "떡볶이"
            )
        )
        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6863296",
                "https://recipe1.ezmember.co.kr/cache/recipe/2016/12/30/df939769792632a48a0eba8bc895e8601_m.jpg",
                "불고기"
            )
        )
        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/3686217",
                "https://recipe1.ezmember.co.kr/cache/recipe/2015/08/25/d1754942db6cebf74146eff6225e620d1_m.jpg",
                "김치찌개"
            )
        )
        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6928209",
                "https://recipe1.ezmember.co.kr/cache/recipe/2020/03/10/95e02532aa0e83a5bf7fd822692b8a771_m.jpg",
                "닭갈비"
            )
        )
        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6859263",
                "https://recipe1.ezmember.co.kr/cache/recipe/2016/10/27/462f2e2c70a260e044c4450bc18e6f651_m.jpg",
                "된장찌개"
            )
        )
        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6877358",
                "https://recipe1.ezmember.co.kr/cache/recipe/2017/10/01/4c42e9f62070c3816da33eda42eb7d4f1_m.jpg",
                "잔치국수"
            )
        )
        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6831083",
                "https://recipe1.ezmember.co.kr/cache/recipe/2015/08/03/3b049aac7f0ce3b34b4f9890f400305c1_m.jpg",
                "파전"
            )
        )
        items.add(
            ContentsModel(
                "https://m.10000recipe.com/recipe/6872350",
                "https://recipe1.ezmember.co.kr/cache/recipe/2017/07/06/c807784ab41809f624a6a4a7466cd5bd1_m.jpg",
                "계란찜"
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