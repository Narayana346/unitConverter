package com.example.firstapp

//noinspection SuspiciousImport
import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.firstapp.R.*

class UnitConverter : AppCompatActivity() {
    private lateinit var spinner: Spinner
    private lateinit var spinnerFrom: Spinner
    private lateinit var spinnerTo: Spinner
    private lateinit var editTextFrom: EditText
    private lateinit var editTextTo: EditText
    private lateinit var spinnerAddItem: Spinner
    private lateinit var showItem: TextView
    private lateinit var buttonConvert: Button
    private lateinit var ButtonAddItem: Button
    private var unitOptions = arrayOf("Length", "Weight", "Volume")
    private var lengthUnitOptions = arrayOf("Meter", "Foot", "Centimeter")
    private var weightUnitOptions = arrayOf("Kilogram", "Pound", "Grams")
    private var volumeUnitOptions = arrayOf("Liters", "Gallon", "Milliliters")

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_unit_converter)

        // Initialize views
        spinner = findViewById(id.spinner)
        spinnerFrom = findViewById(id.spinnerFrom)
        spinnerTo = findViewById(id.spinnerTo)
        editTextFrom = findViewById(id.editTextFrom)
        editTextTo = findViewById(id.editTextTo)
        buttonConvert = findViewById(id.buttonConvert)
        ButtonAddItem = findViewById(id.AddButton)
        showItem = findViewById(id.AddItemText)
        spinnerAddItem = findViewById(id.spinnerShow)
        showItem.isVisible = false
        spinnerAddItem.isVisible = false

        // Populate spinners with unit options
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, unitOptions)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                // Update data for spinner2 based on the selected item in spinner1
                updateSpinnerData()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }


        }

            // Set click listener for the "Convert" button
        buttonConvert.setOnClickListener {
            if(spinnerAddItem.isVisible){
                addItemConvert()
            }else{
                convertUnits()
            }
        }
        ButtonAddItem.setOnClickListener {
            if (!showItem.isVisible) {
                showItem.isVisible = true
                spinnerAddItem.isVisible = true
                editTextTo.setHint("Enter unit")
                ButtonAddItem.text = "Remove Item"

            } else {
                showItem.isVisible = false
                spinnerAddItem.isVisible = false
                editTextTo.setHint("Conversion unit")
                ButtonAddItem.text = "Add Item"
            }

        }
    }

    private fun updateSpinnerData() {
        // Logic to update spinnerData based on the selection in spinner
        when (spinner.selectedItem.toString()) {
            "Length" -> {
                val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, lengthUnitOptions)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinnerFrom.adapter = adapter
                spinnerTo.adapter = adapter
                spinnerAddItem.adapter = adapter
            }

            "Weight" -> {
                val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, weightUnitOptions)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinnerFrom.adapter = adapter
                spinnerTo.adapter = adapter
                spinnerAddItem.adapter = adapter
            }

            "Volume" -> {
                val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, volumeUnitOptions)
                adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
                spinnerFrom.adapter = adapter
                spinnerTo.adapter = adapter
                spinnerAddItem.adapter = adapter
            }
        }

    }


    private fun convertUnits() {
        // Get selected units and values
        val unitFrom = spinnerFrom.selectedItem.toString()
        val unitTo = spinnerTo.selectedItem.toString()
        val valueFrom = editTextFrom.text.toString().toDoubleOrNull()

        // Perform the conversion
        val units = UnitConvert()
        val convertedValue =units.convert(unitFrom, unitTo, valueFrom)
        // Display the result
        editTextTo.setText(convertedValue.toString())
        //add item conversion


    }
    fun addItemConvert(){
        val unitConvert = UnitConvert()
        val addItem = spinnerAddItem.selectedItem.toString()
        val unitFrom = spinnerFrom.selectedItem.toString()
        val unitTo = spinnerTo.selectedItem.toString()
        val valueFrom = editTextFrom.text.toString().toDoubleOrNull()
        val valueTo = editTextTo.text.toString().toDoubleOrNull()
        val add = unitConvert.convert(unitFrom,addItem,valueFrom)+unitConvert.convert(unitTo,addItem,valueTo)
        showItem.setText(add.toString())
    }


}

