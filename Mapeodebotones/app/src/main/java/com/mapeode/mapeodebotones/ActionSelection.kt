package com.mapeode.mapeodebotones

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

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
        topText.text = "What is the name of the game?"
        bottomText.text = "which controller are you going to use?"
        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToActionTableFromActionSelection.setOnClickListener {
            val action2 = ActionSelectionDirections.actionActionSelectionToActionTable()
            v.findNavController().navigate(action2)
        }
    }
}