package com.example.assignment_2_abel_serracin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.Calendar

class Fragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_1, container, false)

        val birthYearEditText: EditText = view.findViewById(R.id.birth_year_edittext)
        val calculateButton: Button = view.findViewById(R.id.calculate_button)
        val ageTextView: TextView = view.findViewById(R.id.age_textview)

        calculateButton.setOnClickListener {
            val birthYear = birthYearEditText.text.toString().toIntOrNull()
            if (birthYear != null) {
                val currentYear = Calendar.getInstance().get(Calendar.YEAR)
                val age = currentYear - birthYear
                ageTextView.text = "Your age is $age"
            } else {
                ageTextView.text = "Please enter a valid year"
            }
        }

        return view
    }
}
