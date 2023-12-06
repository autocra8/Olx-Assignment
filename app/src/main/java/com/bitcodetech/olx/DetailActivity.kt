package com.bitcodetech.olx

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class DetailActivity:AppCompatActivity() {
    private lateinit var  image:ImageView
    private lateinit var textCity:TextView
    private lateinit var textDescription:TextView
    private lateinit var textPrice:TextView
    private lateinit var city:String
    private lateinit var description:String
    private lateinit var price:String
    private var detailsImage :Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.post_details)

        initViews()
        initIntent()

    }
   private fun initViews(){
        image=findViewById(R.id.img)
        textDescription=findViewById(R.id.textDescription)
        textCity=findViewById(R.id.textCity)
        textPrice=findViewById(R.id.textPrice)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.deleteItem->{

            }
            R.id.editItem->{
                val intent=Intent(this@DetailActivity,EditActivity::class.java)
                intent.putExtra("C",city)
                intent.putExtra("P",price)
                intent.putExtra("D",description)
                intent.putExtra("S",detailsImage)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
   private fun initIntent(){
        city=intent.getStringExtra("C").toString()
        description=intent.getStringExtra("D").toString()
        price=intent.getStringExtra("P").toString()
        detailsImage=intent.getIntExtra("S",R.drawable.polo)
        textCity.setText(city)
        textDescription.setText(description)
        textPrice.setText(price)
        image.setImageResource(detailsImage)
    }
}