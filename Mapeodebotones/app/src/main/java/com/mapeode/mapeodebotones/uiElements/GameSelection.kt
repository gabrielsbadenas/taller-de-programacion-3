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
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Game
import com.mapeode.mapeodebotones.entities.Name

class GameSelection : Fragment() {

    lateinit var v : View
    lateinit var btnGoToActionTableFromGameSelection: Button
    lateinit var topText: TextView
    lateinit var bottomText: TextView
    lateinit var topEditText: EditText
    lateinit var bottomEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_game_selection,container,false)
        btnGoToActionTableFromGameSelection = v.findViewById(R.id.btnGoToActionTableFromGameSelection)
        btnGoToActionTableFromGameSelection.text = "next"

        topText = v.findViewById(R.id.gsTopText)
        topText.text = "What is the name of the game?"

        bottomText = v.findViewById(R.id.gsBottomText)
        bottomText.text = "which controller are you going to use?"

        topEditText = v.findViewById(R.id.gsTopEditText)
        bottomEditText = v.findViewById(R.id.gsBottomEditText)

        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToActionTableFromGameSelection.setOnClickListener {
            val action2 = GameSelectionDirections.actionGameSelectionToActionTable(Game(topEditText.text.toString(),bottomEditText.text.toString()))
            v.findNavController().navigate(action2)
        }
    }

}