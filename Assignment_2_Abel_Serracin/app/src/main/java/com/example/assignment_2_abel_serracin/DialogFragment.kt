package com.example.assignment_2_abel_serracin

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class WelcomeDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireActivity())
            .setMessage("Welcome to my app")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .create()
    }
}
