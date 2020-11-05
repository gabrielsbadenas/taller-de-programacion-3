package com.mapeode.mapeodebotones.uiElements

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import com.mapeode.mapeodebotones.uiElements.EmulatorSelectionDirections
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Emulator
import android.widget.ArrayAdapter

class EmulatorSelection : Fragment() {

    lateinit var v : View
    lateinit var btnGoToButtonTableFromEmulatorSelection: Button
    lateinit var topText: TextView
    lateinit var bottomText: TextView
    lateinit var topSpinner: Spinner
    lateinit var bottomSpinner: Spinner
    lateinit var console: String
    lateinit var controller: String

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

        topSpinner = v.findViewById(R.id.emTopSpinner)
        bottomSpinner = v.findViewById(R.id.emBottomSpinner)
        val consoles = arrayOf("nes","game boy")
        val controllers = arrayOf("dualshock 4","xbox controller")
        topSpinner.adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_item, consoles)
        topSpinner.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                console = "nothing"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                console = consoles[p2]
            }
        }
        bottomSpinner.adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_item, controllers)
        bottomSpinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                controller = "nothing"
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                controller = controllers[p2]
            }
        }

        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToButtonTableFromEmulatorSelection.setOnClickListener {
            val action2 = EmulatorSelectionDirections.actionEmulatorSelectionToButtonTable(Emulator(console, controller))
            v.findNavController().navigate(action2)
        }
    }
}