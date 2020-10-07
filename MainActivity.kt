package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var numberOfCoffie = 0
    private val coffiePrice = 2.00
    private var hasWhippedCream = false
    private var hasChoco = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun submitOrder(view: View): Unit {
        val whippedCream = findViewById<CheckBox>(R.id.has_whipped_cream)
        val choco = findViewById<CheckBox>(R.id.has_choco)

        when {
            choco.isChecked == true && whippedCream.isChecked == true -> {
                hasWhippedCream = whippedCream.isChecked
                hasChoco = choco.isChecked
                displayPrice(numberOfCoffie * coffiePrice + 2 * numberOfCoffie)
            }
            choco.isChecked == true || whippedCream.isChecked == true -> {
                hasWhippedCream = whippedCream.isChecked
                hasChoco = choco.isChecked
                displayPrice(numberOfCoffie * coffiePrice + numberOfCoffie)
            }
            else -> {
                hasWhippedCream = whippedCream.isChecked
                hasChoco = choco.isChecked
                displayPrice(numberOfCoffie * coffiePrice)
            }
        }
    }

    private fun displayPrice(cost: Double) {
        val newCost = findViewById<TextView>(R.id.price_text_view)
        val Name = findViewById<EditText>(R.id.name)
        val input = Name.text.toString()
        newCost.text =  "Name: $input" +
                        "\nTotal: $" + cost + "\nThank You!" +
                        "\nWith WhippedCream: $hasWhippedCream" +
                        "\nWith Chocolate: $hasChoco"
    }

    fun increment(view: View) {
        var quantity = findViewById<TextView>(R.id.quantity_text_view)
        quantity.text = "" + ++numberOfCoffie
    }

    fun decrement(view: View) {
        var quantity = findViewById<TextView>(R.id.quantity_text_view)
        if (numberOfCoffie > 0) {
            quantity.text = "" + --numberOfCoffie
        } else quantity.text = "" + numberOfCoffie
    }
}
