package com.mapeode.mapeodebotones.uiElements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.mapeode.mapeodebotones.uiElements.ButtonTableDirections
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Emulator

class ButtonTable : Fragment() {

    lateinit var v : View
    lateinit var btnGoToButtonSelectionFromButtonTable: Button
    lateinit var btnGoToMainMenuFromButtonTable: Button
    lateinit var id: Emulator
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_button_table,container,false)
        btnGoToButtonSelectionFromButtonTable = v.findViewById(R.id.btnGoToButtonSelectionFromButtonTable)
        btnGoToMainMenuFromButtonTable = v.findViewById(R.id.btnGoToGameMappingFromTypeSelection)
        id = ButtonTableArgs.fromBundle(requireArguments()).id!!
        return v
    }

    override fun onStart() {
        super.onStart()
        id = ButtonTableArgs.fromBundle(requireArguments()).id!!
        btnGoToButtonSelectionFromButtonTable.setOnClickListener {
            val action2 = ButtonTableDirections.actionButtonTableToButtonSelection(id)
            v.findNavController().navigate(action2)
        }
        btnGoToMainMenuFromButtonTable.setOnClickListener {
            val data = id.kindName+"-"+id.controllerName+"-"+java.util.UUID.randomUUID().toString()
            db.collection("mappings").document(data).set(id)
            val action1 = ButtonTableDirections.actionButtonTableToMainMenu()
            v.findNavController().navigate(action1)
        }
    }
}