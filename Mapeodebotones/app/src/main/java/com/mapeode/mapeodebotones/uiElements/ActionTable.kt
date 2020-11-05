package com.mapeode.mapeodebotones.uiElements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.mapeode.mapeodebotones.uiElements.ActionTableDirections
import com.mapeode.mapeodebotones.R

class ActionTable : Fragment() {

    lateinit var v : View
    lateinit var btnGoToActionSelectionFromActionTable: Button
    lateinit var btnGoToMainMenuFromActionTable: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_action_table,container,false)
        btnGoToActionSelectionFromActionTable = v.findViewById(R.id.btnGoToActionSelectionFromActionTable)
        btnGoToMainMenuFromActionTable = v.findViewById(R.id.btnGoToMainMenuFromActionTable)
        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToActionSelectionFromActionTable.setOnClickListener {
            val action2 = ActionTableDirections.actionActionTableToActionSelection()
            //val action2 = 0
            v.findNavController().navigate(action2)
        }
        btnGoToMainMenuFromActionTable.setOnClickListener {
            val mapping = ActionTableArgs.fromBundle(requireArguments()).game
            val action1 = ActionTableDirections.actionActionTableToMainMenu(mapping)
            v.findNavController().navigate(action1)
        }
    }
}