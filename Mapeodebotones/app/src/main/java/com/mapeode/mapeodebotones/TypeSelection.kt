package com.mapeode.mapeodebotones

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class TypeSelection : Fragment() {
    lateinit var v : View
    lateinit var btnGoToEmulatorSelectionFromTypeSelection: Button
    lateinit var btnGoToGameMappingFromTypeSelection: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_type_selection,container,false)
        btnGoToEmulatorSelectionFromTypeSelection = v.findViewById(R.id.btnGoToEmulatorSelectionFromTypeSelection)
        btnGoToGameMappingFromTypeSelection = v.findViewById(R.id.btnGoToGameMappingFromTypeSelection)
        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToEmulatorSelectionFromTypeSelection.setOnClickListener {
            val action2 = TypeSelectionDirections.actionTypeSelectionToEmulatorSelection()
            v.findNavController().navigate(action2)
        }
        btnGoToGameMappingFromTypeSelection.setOnClickListener {
            val action1 = TypeSelectionDirections.actionTypeSelectionToGameSelection()
            v.findNavController().navigate(action1)
        }
    }
}