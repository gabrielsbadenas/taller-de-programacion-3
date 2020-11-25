package com.mapeode.mapeodebotones.uiElements

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.mapeode.mapeodebotones.uiElements.ButtonSelectionDirections
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Emulator
import com.mapeode.mapeodebotones.entities.Game
import com.mapeode.mapeodebotones.entities.GenericMapping
import com.mapeode.mapeodebotones.entities.Mapping

class ButtonSelection : Fragment() {

    lateinit var v: View
    lateinit var btnGoToButtonTableFromButtonSelection: Button
    lateinit var topText: TextView
    lateinit var bottomText: TextView
    lateinit var emu: Emulator
    lateinit var topEditText: EditText
    lateinit var bottomEditText: EditText

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_button_selection, container, false)
        btnGoToButtonTableFromButtonSelection = v.findViewById(R.id.btnGoToButtonTableFromButtonSelection)

        topText = v.findViewById(R.id.bsTopText)
        topText.text = "emulated button"

        bottomText = v.findViewById(R.id.bsBottomText)
        bottomText.text = "button in your controller"

        topEditText = v.findViewById(R.id.bsTopEditText)
        bottomEditText = v.findViewById(R.id.bsBottomEditText)

        btnGoToButtonTableFromButtonSelection.text = "enter"
        emu = ButtonTableArgs.fromBundle(requireArguments()).id!!

        return v
    }

    override fun onStart() {
        super.onStart()
        emu = ButtonSelectionArgs.fromBundle(requireArguments()).id!!
        btnGoToButtonTableFromButtonSelection.setOnClickListener {
            emu.add(topEditText.text.toString(),bottomEditText.text.toString())
            val action2 = ButtonSelectionDirections.actionButtonSelectionToButtonTable(emu)
            v.findNavController().navigate(action2)
        }
    }

}