package com.example.assignment_2_abel_serracin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_2, container, false)

        val unitSpinner: Spinner = view.findViewById(R.id.unit_spinner)
        val inputEditText: EditText = view.findViewById(R.id.input_edittext)
        val convertButton: Button = view.findViewById(R.id.convert_button)
        val resultTextView: TextView = view.findViewById(R.id.result_textview)

        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.unit_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        unitSpinner.adapter = adapter

        convertButton.setOnClickListener {
            val input = inputEditText.text.toString().toDoubleOrNull()
            if (input != null) {
                val result = if (unitSpinner.selectedItem.toString() == "CM to Inches") {
                    input / 2.54
                } else {
                    input * 2.54
                }
                resultTextView.text = "Result: $result"
            } else {
                resultTextView.text = "Please enter a valid number"
            }
        }

        return view
    }
}
