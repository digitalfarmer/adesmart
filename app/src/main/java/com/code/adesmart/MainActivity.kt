package com.code.adesmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvProducts: RecyclerView
    private var list: ArrayList<Product> = arrayListOf()
    private var title: String = "Product List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvProducts=findViewById(R.id.rv_products)
        rvProducts.setHasFixedSize(true)

        list.addAll(ProductsData.listData)
        showRecyclerList()



    }

    private fun showRecyclerList() {
        rvProducts.layoutManager = LinearLayoutManager(this)
        val listProductAdapter = ListProductAdapter(list)
        rvProducts.adapter = listProductAdapter

        listProductAdapter.setOnItemClickCallback(object : ListProductAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Product) {
                showSelectedProduct(data)
            }
        })
    }

//    item click
    private fun showSelectedProduct(product: Product) {

        val detailIntent = Intent(this@MainActivity, ActivityDetail::class.java)
        detailIntent.putExtra(ActivityDetail.EXTRA_IMAGE, product.photo)
        detailIntent.putExtra(ActivityDetail.EXTRA_NAME, product.name)
        detailIntent.putExtra(ActivityDetail.EXTRA_DESCRIPTION, product.description)
        startActivity(detailIntent)

//        Toast.makeText(this, "Kamu memilih " + product.name, Toast.LENGTH_SHORT).show()
    }


    //    block menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            setMode(item.itemId)
            return super.onOptionsItemSelected(item)
        }
        private fun setMode(selectedMode: Int) {


            when (selectedMode) {

                R.id.action_about -> {

                    val aboutIntent = Intent(this@MainActivity, AboutUsActivity::class.java)
                    startActivity(aboutIntent)
                }
            }
            setActionBarTitle(title)

        }

//    change title
    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}