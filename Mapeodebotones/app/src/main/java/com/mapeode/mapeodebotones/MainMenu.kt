package com.mapeode.mapeodebotones

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class MainMenu : Fragment() {
    lateinit var v : View
    lateinit var btnGoToTypeSelectionFromMainMenu: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_main_menu,container,false)
        btnGoToTypeSelectionFromMainMenu = v.findViewById(R.id.btnGoToTypeSelectionFromMainMenu)
        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToTypeSelectionFromMainMenu.setOnClickListener {
            val action2 = MainMenuDirections.actionMainMenuToTypeSelection()
            v.findNavController().navigate(action2)
        }
    }

}