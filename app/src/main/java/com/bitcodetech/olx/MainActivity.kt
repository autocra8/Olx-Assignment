package com.bitcodetech.olx


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerPosts: RecyclerView
    private lateinit var postsAdapter : PostsAdapter
    private val posts =ArrayList<Posts>()
    private lateinit var city:String
    private lateinit var price:String
    private lateinit var description:String
    private  var selectedImage:Int=0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)



        recyclerPosts=findViewById(R.id.recyclerPosts)
        postsAdapter= PostsAdapter(posts)
        recyclerPosts.adapter=postsAdapter

        recyclerPosts.layoutManager=
            LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,
                false)

        initListener()


    }
    private fun initListener(){
        postsAdapter.onPostClickListener=MyOnPostClickListener()

    }
    private inner class MyOnPostClickListener:PostsAdapter.OnPostClickListener{
        override fun onPostClick(position: Int, post: Posts, view: View) {
            val intent=Intent(this@MainActivity,DetailActivity::class.java)
            intent.putExtra("C",posts[position].city)
            intent.putExtra("P",posts[position].price)
            intent.putExtra("D",posts[position].description)
            intent.putExtra("S",posts[position].selectedImage)
            intent.putExtra("I",position)
            startActivityForResult(intent,1)
Toast.makeText(this@MainActivity,"listener",Toast.LENGTH_SHORT).show()
        }
    }


    @SuppressLint("SuspiciousIndentation")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

if (resultCode==1) {
    city = data?.getStringExtra("C").toString()
    description = data?.getStringExtra("D").toString()
    price = data?.getStringExtra("P").toString()
    Toast.makeText(this,city,Toast.LENGTH_SHORT).show()
    selectedImage = data?.getIntExtra("S", R.id.polo)!!.toInt()

        posts.add(
        Posts(selectedImage, city, price, description)
    )
    postsAdapter.notifyDataSetChanged()
}
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

            val Intent=Intent(this,AddItems::class.java)
            startActivityForResult(Intent, 1)
            return super.onOptionsItemSelected(item)
    }

}