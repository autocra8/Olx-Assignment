package com.bitcodetech.olx

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class AddItems : AppCompatActivity(), View.OnClickListener {
    private lateinit var itemPrice: EditText
    private lateinit var itemDescription: EditText
    private lateinit var itemCity: EditText
    private lateinit var imgBullet: ImageView
    private lateinit var imgPolo: ImageView
    private lateinit var imgActiva: ImageView
    private lateinit var imgPrinter: ImageView
    private lateinit var imgRefrigerator: ImageView
    private lateinit var imgOven: ImageView
    private var selectedImage: Int=0
    private lateinit var btnSave: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_item_activity)


        initViews()
        initListener()

    }

    private fun initViews() {

        itemPrice = findViewById(R.id.itemPrice)
        itemDescription = findViewById(R.id.itemDescription)
        itemCity = findViewById(R.id.itemCity)
        imgBullet = findViewById(R.id.bullet)
        imgActiva = findViewById(R.id.activa)
        imgOven = findViewById(R.id.oven)
        imgPrinter = findViewById(R.id.printer)
        imgRefrigerator = findViewById(R.id.refrigerator)
        imgPolo = findViewById(R.id.polo)
        btnSave = findViewById(R.id.btnSave)

    }

    @SuppressLint("ResourceType")
    private fun initListener() {


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


        btnSave.setOnClickListener {
            val intent: Intent = Intent()

            intent.putExtra("P", itemPrice.text.toString())
            intent.putExtra("C", itemCity.text.toString())
            intent.putExtra("D", itemDescription.text.toString())
            intent.putExtra("S", selectedImage)
            Toast.makeText(this, intent.toString(), Toast.LENGTH_SHORT).show()

            setResult(1, intent)
            finish()
        }
    }

    override fun onClick(view: View?) {


    }

}