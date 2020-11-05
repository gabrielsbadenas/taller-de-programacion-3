package com.mapeode.mapeodebotones.uiElements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.mapeode.mapeodebotones.uiElements.ButtonTableDirections
import com.mapeode.mapeodebotones.R

class ButtonTable : Fragment() {

    lateinit var v : View
    lateinit var btnGoToButtonSelectionFromButtonTable: Button
    lateinit var btnGoToMainMenuFromButtonTable: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_button_table,container,false)
        btnGoToButtonSelectionFromButtonTable = v.findViewById(R.id.btnGoToButtonSelectionFromButtonTable)
        btnGoToMainMenuFromButtonTable = v.findViewById(R.id.btnGoToGameMappingFromTypeSelection)
        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToButtonSelectionFromButtonTable.setOnClickListener {
            val action2 = ButtonTableDirections.actionButtonTableToButtonSelection()
            //val action2 = 0
            v.findNavController().navigate(action2)
        }
        btnGoToMainMenuFromButtonTable.setOnClickListener {
            val mapping = ButtonTableArgs.fromBundle(requireArguments()).emulator
            val action1 = ButtonTableDirections.actionButtonTableToMainMenu(mapping)
            v.findNavController().navigate(action1)
        }
    }
}