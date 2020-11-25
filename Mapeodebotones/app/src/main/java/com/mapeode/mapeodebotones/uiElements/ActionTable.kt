package com.mapeode.mapeodebotones.uiElements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.mapeode.mapeodebotones.uiElements.ActionTableDirections
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Game

class ActionTable : Fragment() {

    lateinit var v : View
    lateinit var btnGoToActionSelectionFromActionTable: Button
    lateinit var btnGoToMainMenuFromActionTable: Button
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()
    lateinit var id: Game

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_action_table,container,false)
        btnGoToActionSelectionFromActionTable = v.findViewById(R.id.btnGoToActionSelectionFromActionTable)
        btnGoToMainMenuFromActionTable = v.findViewById(R.id.btnGoToMainMenuFromActionTable)
        id = ActionTableArgs.fromBundle(requireArguments()).game!!
        return v
    }

    override fun onStart() {
        super.onStart()
        id = ActionTableArgs.fromBundle(requireArguments()).game!!
        btnGoToActionSelectionFromActionTable.setOnClickListener {
            val action2 = ActionTableDirections.actionActionTableToActionSelection(id)
            v.findNavController().navigate(action2)
        }
        btnGoToMainMenuFromActionTable.setOnClickListener {
            val data = id.kindName+"-"+id.controllerName+"-"+java.util.UUID.randomUUID().toString()
            db.collection("mappings").document(data).set(id)
            val action1 = ActionTableDirections.actionActionTableToMainMenu()
            v.findNavController().navigate(action1)
        }
    }
}