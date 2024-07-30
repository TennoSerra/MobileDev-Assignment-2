package com.example.assignment_2_abel_serracin

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val infoTextView: TextView = findViewById(R.id.info_textview)
        infoTextView.text = "Use the menu on the top right to navigate"

        // Show the welcome dialog when the app opens
        val dialog = WelcomeDialogFragment()
        dialog.show(supportFragmentManager, "WelcomeDialog")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_show_fragment1 -> {
                // Show Fragment1
                val fragment = Fragment1()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit()
                true
            }
            R.id.action_show_fragment2 -> {
                // Show Fragment2
                val fragment = Fragment2()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit()
                true
            }
            R.id.action_show_dialog -> {
                // Show DialogFragment
                val dialog = WelcomeDialogFragment()
                dialog.show(supportFragmentManager, "WelcomeDialog")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
