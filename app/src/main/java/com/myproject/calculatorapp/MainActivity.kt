package com.myproject.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isNewOp = true
    var oldNumber = ""
    var op = "+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun numberEvent(view: View) {

        if (isNewOp){
            editText.setText("")
        }
        isNewOp = false

        var btn_Click = editText.text.toString()
        val btn_Select = view as Button

        when(btn_Select.id){

            btn_One.id -> {btn_Click += "1"}
            btn_Two.id -> {btn_Click += "2"}
            btn_Three.id -> {btn_Click += "3"}
            btn_Four.id -> {btn_Click += "4"}
            btn_Five.id -> {btn_Click += "5"}
            btn_Six.id -> {btn_Click += "6"}
            btn_Seven.id -> {btn_Click += "7"}
            btn_Eight.id -> {btn_Click += "8"}
            btn_Nine.id -> {btn_Click += "9"}
            btn_Zero.id -> {btn_Click += "0"}
            btn_Point.id -> {btn_Click += "."}
            btn_PlusMinus.id ->{btn_Click = "-${btn_Click}"}
        }
        editText.setText(btn_Click)
    }

    fun operatorEvent(view: View) {

        isNewOp = true
        oldNumber = editText.text.toString()
        var btn_Select = view as Button

        when(btn_Select.id){

            btn_Multiply.id -> {op = "*"}
            btn_Plus.id -> {op = "+"}
            btn_Divide.id -> {op = "/"}
            btn_Minus.id -> {op = "-"}
        }
    }

    fun equalEvent(view: View) {

    var newNumber = editText.text.toString()
    var result = 0.0
    when(op){
        "+" -> {result = oldNumber.toDouble() + newNumber.toDouble()}
        "-" -> {result = oldNumber.toDouble() - newNumber.toDouble()}
        "/" -> {result = oldNumber.toDouble() / newNumber.toDouble()}
        "*" -> {result = oldNumber.toDouble() * newNumber.toDouble()}
    }
        editText.setText(result.toString())

    }

    fun acEvent(view: View) {

        editText.setText("0")
        isNewOp = true
    }

    fun percentEvent(view: View) {

        var num = editText.text.toString().toDouble()/100
        editText.setText(num.toString())
        isNewOp = true

    }
}