package com.mapeode.mapeodebotones

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

class EmulatorSelection : Fragment() {

    lateinit var v : View
    lateinit var btnGoToButtonTableFromEmulatorSelection: Button
    lateinit var topText: TextView
    lateinit var bottomText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_emulator_selection,container,false)
        btnGoToButtonTableFromEmulatorSelection = v.findViewById(R.id.btnGoToButtonTableFromEmulatorSelection)
        topText = v.findViewById(R.id.emTopText)
        bottomText = v.findViewById(R.id.emBottomText)
        topText.text = "which console are you going to emulate?"
        bottomText.text = "which controller are you going to use?"
        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToButtonTableFromEmulatorSelection.setOnClickListener {
            val action2 = EmulatorSelectionDirections.actionEmulatorSelectionToButtonTable()
            v.findNavController().navigate(action2)
        }
    }
}