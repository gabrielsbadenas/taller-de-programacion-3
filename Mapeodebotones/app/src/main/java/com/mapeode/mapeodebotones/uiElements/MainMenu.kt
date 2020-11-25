package com.mapeode.mapeodebotones.uiElements

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Mapping
import kotlinx.android.synthetic.main.fragment_main_menu.*

class MainMenu : Fragment() {
    lateinit var v : View
    lateinit var recMapping : RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var mappings : MutableList<Mapping>
    private lateinit var mappingListAdapter: MappingListAdapter
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private lateinit var btnGoToTypeSelectionFromMainMenu: View
    lateinit var text: TextView

    companion object {
        fun newInstance() = MainMenu()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_main_menu, container, false)
        btnGoToTypeSelectionFromMainMenu = v.findViewById(R.id.btnGoToTypeSelectionFromMainMenu)
        text = v.findViewById(R.id.titleMM)
        text.text = "delete everything"
        recMapping = v.findViewById(R.id.recyclerViewMainMenu)
        recMapping.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recMapping.layoutManager = linearLayoutManager
        mappings = ArrayList<Mapping>()
        getMappings()
        return v
    }
/*
* funciones que tengo que agregar
* - borrar mappings
* - editar mappings
* - agregar botones
* - eliminar botones
* - agregar accion de main menu a action selection o button selection
* - cambiar nombre de mapping
* - conseguir el id de un mapping (poner la id como un parametro)*/
    
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun getMappings(){
        mappings = ArrayList<Mapping>()
        db.collection("mappings")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    mappings.add(document.toObject())
                }
                mappingListAdapter = MappingListAdapter(mappings)
                recMapping.adapter = mappingListAdapter
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }

    fun deleteAll(){
        db.collection("mappings").get().addOnSuccessListener { result ->
            for (document in result) {
                document.reference.delete()
            }
            getMappings()
        }
    }

    override fun onStart() {
        super.onStart()
        text.setOnClickListener {
            deleteAll()
        }
        btnGoToTypeSelectionFromMainMenu.setOnClickListener {
            val action2 = MainMenuDirections.actionMainMenuToTypeSelection()
            v.findNavController().navigate(action2)
        }
    }
}