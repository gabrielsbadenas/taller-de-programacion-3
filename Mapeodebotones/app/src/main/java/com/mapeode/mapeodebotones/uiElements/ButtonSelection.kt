package com.mapeode.mapeodebotones.uiElements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.mapeode.mapeodebotones.uiElements.ButtonSelectionDirections
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Emulator

class ButtonSelection : Fragment() {

    lateinit var v : View
    lateinit var btnGoToButtonTableFromButtonSelection: Button
    lateinit var topText: TextView
    lateinit var bottomText: TextView
    lateinit var topInput: String
    lateinit var bottomInput: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_button_selection,container,false)
        btnGoToButtonTableFromButtonSelection = v.findViewById(R.id.btnGoToButtonTableFromButtonSelection)
        topText = v.findViewById(R.id.bsTopText)
        bottomText = v.findViewById(R.id.bsBottomText)
        topText.text = "emulated button"
        bottomText.text = "button in your controller"
        btnGoToButtonTableFromButtonSelection.text = "enter"
        topInput = "topInput"
        bottomInput = "bottomInput"
        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToButtonTableFromButtonSelection.setOnClickListener {
            val action2 = ButtonSelectionDirections.actionButtonSelectionToButtonTable(Emulator(topInput, bottomInput))
            v.findNavController().navigate(action2)
        }
    }
}