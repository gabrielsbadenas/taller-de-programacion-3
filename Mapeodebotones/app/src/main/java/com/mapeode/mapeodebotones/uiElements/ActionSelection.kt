package com.mapeode.mapeodebotones.uiElements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.mapeode.mapeodebotones.uiElements.ActionSelection
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Game

class ActionSelection : Fragment() {

    lateinit var v : View
    lateinit var btnGoToActionTableFromActionSelection: Button
    lateinit var topText: TextView
    lateinit var bottomText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_action_selection,container,false)
        btnGoToActionTableFromActionSelection = v.findViewById(R.id.btnGoToActionTableFromActionSelection)
        topText = v.findViewById(R.id.asTopText)
        bottomText = v.findViewById(R.id.asBottomText)
        topText.text = "What is the name of the action?"
        bottomText.text = "select the button of the action"
        btnGoToActionTableFromActionSelection.text = "enter"
        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToActionTableFromActionSelection.setOnClickListener {
            val action2 = ActionSelectionDirections.actionActionSelectionToActionTable(Game(topText.text as String, bottomText.text as String))
            v.findNavController().navigate(action2)
        }
    }
}