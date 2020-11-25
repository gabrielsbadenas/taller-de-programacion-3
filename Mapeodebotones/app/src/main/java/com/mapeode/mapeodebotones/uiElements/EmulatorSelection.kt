package com.mapeode.mapeodebotones.uiElements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Emulator
import com.google.firebase.firestore.FirebaseFirestore

class EmulatorSelection : Fragment() {

    lateinit var v : View
    lateinit var btnGoToButtonTableFromEmulatorSelection: Button
    lateinit var emLeftText: TextView
    lateinit var emRightText: TextView
    lateinit var emLeftEditText: EditText
    lateinit var emRightEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_emulator_selection,container,false)
        btnGoToButtonTableFromEmulatorSelection = v.findViewById(R.id.btnGoToButtonTableFromEmulatorSelection)
        emLeftText = v.findViewById(R.id.emLeftText)
        emRightText = v.findViewById(R.id.emRightText)
        emLeftText.text = "which console are you going to emulate?"
        emRightText.text = "which controller are you going to use?"
        emLeftEditText = v.findViewById(R.id.emLeftEditText)
        emRightEditText = v.findViewById(R.id.emRightEditText)
        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToButtonTableFromEmulatorSelection.setOnClickListener {
            val emu = Emulator(emLeftEditText.text.toString(),emRightEditText.text.toString())
            val action2 = EmulatorSelectionDirections.actionEmulatorSelectionToButtonTable(emu)
            v.findNavController().navigate(action2)
        }
    }
}