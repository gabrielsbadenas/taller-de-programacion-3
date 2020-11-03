package com.mapeode.mapeodebotones.uiElements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.mapeode.mapeodebotones.uiElements.GameSelectionDirections
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Game

class GameSelection : Fragment() {

    lateinit var v : View
    lateinit var btnGoToActionTableFromGameSelection: Button
    lateinit var topText: TextView
    lateinit var bottomText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_game_selection,container,false)
        btnGoToActionTableFromGameSelection = v.findViewById(R.id.btnGoToActionTableFromGameSelection)
        topText = v.findViewById(R.id.gsTopText)
        bottomText = v.findViewById(R.id.gsBottomText)
        topText.text = "What is the name of the game?"
        bottomText.text = "which controller are you going to use?"
        btnGoToActionTableFromGameSelection.text = "next"
        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToActionTableFromGameSelection.setOnClickListener {
            val action2 = GameSelectionDirections.actionGameSelectionToActionTable(Game(topText.text as String, bottomText.text as String))
            v.findNavController().navigate(action2)
        }
    }
}