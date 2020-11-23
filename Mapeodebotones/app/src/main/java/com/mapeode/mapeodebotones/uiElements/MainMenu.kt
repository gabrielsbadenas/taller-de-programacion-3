package com.mapeode.mapeodebotones.uiElements

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Game
import com.mapeode.mapeodebotones.entities.Mapping
import com.mapeode.mapeodebotones.entities.Name

class MainMenu : Fragment() {
    lateinit var v : View
    lateinit var btnGoToTypeSelectionFromMainMenu: Button
    lateinit var recMapping : RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var mappings : MutableList<Mapping>
    private lateinit var mappingListAdapter: MappingListAdapter
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()

    companion object {
        fun newInstance() = MainMenu()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_main_menu, container, false)
        btnGoToTypeSelectionFromMainMenu = v.findViewById(R.id.btnGoToTypeSelectionFromMainMenu)
        recMapping = v.findViewById(R.id.recyclerView)
        recMapping.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        recMapping.layoutManager = linearLayoutManager
        mappings = ArrayList<Mapping>()
        todos("mappings", mappings)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    fun unoSolo(path: String) {
        db.collection("mappings").document(path)
                .get()
                .addOnSuccessListener { document ->
                    if (document != null){
                        mappings.add(document.toObject(Mapping::class.java)!!)
                    }else{
                        Log.d(TAG,"no such document")
                    }
                }
    }

    fun todos(path: String, array: MutableList<Mapping>){
        db.collection(path)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    array.add(document.toObject())
                }
                mappingListAdapter = MappingListAdapter(mappings)
                recMapping.adapter = mappingListAdapter
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
    }

    fun addGame(name: String, controller: String){
        db.collection("mappings").add(Game(name,controller))
    }

    override fun onStart() {
        super.onStart()

        btnGoToTypeSelectionFromMainMenu.setOnClickListener {
            val action2 = MainMenuDirections.actionMainMenuToTypeSelection()
            v.findNavController().navigate(action2)
        }
    }
}