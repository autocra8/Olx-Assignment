package com.bitcodetech.olx

import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.TextView

class ConfirmationDialog (context: Context): Dialog (context){
    private var context:Context=context
    private lateinit var btnYes:Button
    private lateinit var btnNo:Button
    private lateinit var txtDialog: TextView


    init {

        setContentView(R.layout.dialog)
        initViews()
        initListener()

}


fun initViews(){
    txtDialog=findViewById(R.id.txtDialog)
    btnYes=findViewById(R.id.btnYes)
    btnNo=findViewById(R.id.btnNo)
}
 fun initListener() {

     btnNo.setOnClickListener {
         dismiss()

     }

     btnYes.setOnClickListener{

     }
 }
}