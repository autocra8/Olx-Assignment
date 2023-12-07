package com.bitcodetech.olx

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditActivity:AppCompatActivity() {

    private lateinit var edtCity:EditText
    private lateinit var edtPrice:EditText
    private lateinit var edtDescription:EditText
    private lateinit var city:String
    private lateinit var description:String
    private lateinit var price:String
    private lateinit var imgBullet: ImageView
    private lateinit var imgPolo: ImageView
    private lateinit var imgActiva: ImageView
    private lateinit var imgPrinter: ImageView
    private lateinit var imgRefrigerator: ImageView
    private lateinit var imgOven: ImageView
    private  var selectedImage:Int=0
    private lateinit var btnSave:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_activity)

        initViews()
        initListener()


        city=intent.getStringExtra("C").toString()
        description=intent.getStringExtra("D").toString()
        price=intent.getStringExtra("P").toString()

        edtPrice.setText(price)
        edtCity.setText(city)
        edtDescription.setText(description)
    }
    @SuppressLint("ResourceType")
    private fun initListener() {
     btnSave.setOnClickListener{

     val intent=Intent(this@EditActivity,MainActivity::class.java)

     intent.putExtra("C",edtCity.text.toString())
     intent.putExtra("P",edtPrice.text.toString())
     intent.putExtra("D",edtDescription.text.toString())
     intent.putExtra("S",selectedImage)

     setResult(1, intent)
     finish()

 }
        imgBullet.setOnClickListener {
            Toast.makeText(this, "Bullet", Toast.LENGTH_SHORT).show()
            selectedImage = R.drawable.bullet
            imgBullet.setBackgroundColor(Color.parseColor("#008000"))
        }


        imgPolo.setOnClickListener {
            Toast.makeText(this, "Polo", Toast.LENGTH_SHORT).show()
            selectedImage = R.drawable.polo
            imgPolo.setBackgroundColor(Color.parseColor("#008000"))
            imgBullet.setBackgroundColor(Color.parseColor("#000000"))
        }


        imgOven.setOnClickListener {
            Toast.makeText(this, "Oven", Toast.LENGTH_SHORT).show()
            selectedImage = R.drawable.oven
            imgOven.setBackgroundColor(Color.parseColor("#008000"))
        }


        imgActiva.setOnClickListener {
            Toast.makeText(this, "Activa", Toast.LENGTH_SHORT).show()
            selectedImage = R.drawable.activa
            imgActiva.setBackgroundColor(Color.parseColor("#008000"))
        }


        imgPrinter.setOnClickListener {
            Toast.makeText(this, "Printer", Toast.LENGTH_SHORT).show()
            selectedImage = R.drawable.printer
            imgPrinter.setBackgroundColor(Color.parseColor("#008000"))
        }


        imgRefrigerator.setOnClickListener {
            Toast.makeText(this, "Refrigerator", Toast.LENGTH_SHORT).show()
            selectedImage = R.drawable.refrigerator
            imgRefrigerator.setBackgroundColor(Color.parseColor("#008000"))
        }
    }



        fun initViews() {
            btnSave=findViewById(R.id.btnSave)
            imgBullet = findViewById(R.id.imgBullet)
            imgActiva = findViewById(R.id.imgActiva)
            imgOven = findViewById(R.id.imgOven)
            imgPrinter = findViewById(R.id.imgPrinter)
            imgRefrigerator = findViewById(R.id.imgRefrigerator)
            imgPolo = findViewById(R.id.imgPolo)
            edtPrice = findViewById(R.id.itemPrice)
            edtDescription = findViewById(R.id.itemDescription)
            edtCity = findViewById(R.id.itemCity)
        }
    }
