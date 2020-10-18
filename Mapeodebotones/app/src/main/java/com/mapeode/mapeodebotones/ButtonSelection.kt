package com.mapeode.mapeodebotones

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

class ButtonSelection : Fragment() {

    lateinit var v : View
    lateinit var btnGoToButtonTableFromButtonSelection: Button
    lateinit var topText: TextView
    lateinit var bottomText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_button_selection,container,false)
        btnGoToButtonTableFromButtonSelection = v.findViewById(R.id.btnGoToButtonTableFromButtonSelection)
        topText = v.findViewById(R.id.bsTopText)
        bottomText = v.findViewById(R.id.bsBottomText)
        topText.text = "which console are you going to emulate?"
        bottomText.text = "which controller are you going to use?"
        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToButtonTableFromButtonSelection.setOnClickListener {
            val action2 = ButtonSelectionDirections.actionButtonSelectionToButtonTable()
            v.findNavController().navigate(action2)
        }
    }
}