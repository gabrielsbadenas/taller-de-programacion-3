package com.mapeode.mapeodebotones.uiElements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.mapeode.mapeodebotones.uiElements.MainMenuDirections
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Emulator
import com.mapeode.mapeodebotones.entities.Game
import com.mapeode.mapeodebotones.entities.GenericMapping
import com.mapeode.mapeodebotones.entities.Mapping

class MainMenu : Fragment() {
    lateinit var v : View
    lateinit var btnGoToTypeSelectionFromMainMenu: Button
    lateinit var recMapping : RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    var mappings : MutableList<Mapping> = ArrayList<Mapping>()
    private lateinit var mappingListAdapter: MappingListAdapter

    companion object {
        fun newInstance() = MainMenu()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_main_menu,container,false)
        btnGoToTypeSelectionFromMainMenu = v.findViewById(R.id.btnGoToTypeSelectionFromMainMenu)
        recMapping = v.findViewById(R.id.recyclerView)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        fillMappings()
        recMapping.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recMapping.layoutManager = linearLayoutManager
        mappingListAdapter = MappingListAdapter(mappings){ x ->
            onItemClick(x)
        }
        recMapping.adapter = mappingListAdapter
        btnGoToTypeSelectionFromMainMenu.setOnClickListener {
            val action2 = MainMenuDirections.actionMainMenuToTypeSelection()
            v.findNavController().navigate(action2)
        }
    }

    private fun onItemClick(position: Int): Boolean {
        Snackbar.make(v,position.toString(),Snackbar.LENGTH_SHORT).show()
        return true
    }

    private fun fillMappings(){
        val xd = Emulator("game boy","kolke")
        xd.buttons.add(GenericMapping("a","b","c","d"))
        mappings.add(xd)
        mappings.add(Emulator("nes","xbox one x"))
        mappings.add(Game("tetris","wiimote"))
        mappings.add(Game("soulcalibur 2","dualshock 4"))
    }

}