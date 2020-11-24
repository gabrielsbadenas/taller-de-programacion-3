package com.mapeode.mapeodebotones.uiElements

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Emulator
import android.widget.ArrayAdapter
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.mapeode.mapeodebotones.entities.Name

class EmulatorSelection : Fragment() {

    lateinit var v : View
    lateinit var btnGoToButtonTableFromEmulatorSelection: Button
    lateinit var topText: TextView
    lateinit var bottomText: TextView
    lateinit var topSpinner: Spinner
    lateinit var bottomSpinner: Spinner
    lateinit var console: String
    lateinit var controller: String
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()

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

        todos("consoles",topSpinner)
        todos("controllers",bottomSpinner)

        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToButtonTableFromEmulatorSelection.setOnClickListener {
            val data = console+"-"+controller+"-"+java.util.UUID.randomUUID().toString()
            val emu = Emulator(console,controller)
            //emu.add("a","x")
            db.collection("mappings").document(data).set(emu)
            // tengo que crear un nuevo fragment para crear controllers y consoles
            val action2 = EmulatorSelectionDirections.actionEmulatorSelectionToButtonTable(data)
            v.findNavController().navigate(action2)
        }
    }

    fun todos(path: String, spinner: Spinner){
        var arrayList: MutableList<String> = ArrayList<String>()
        db.collection(path)
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        arrayList.add(document.toObject(Name::class.java).name)
                    }

                    val array: Array<String> = arrayList.toTypedArray()
                    spinner.adapter = ArrayAdapter(activity as Context, android.R.layout.simple_spinner_item, array)

                    spinner.onItemSelectedListener = object :
                        AdapterView.OnItemSelectedListener {
                        override fun onNothingSelected(p0: AdapterView<*>?) {
                            if(path == "consoles"){
                                console = "nothing"
                            }else if(path == "controllers"){
                                controller = "nothing"
                            }
                        }

                        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long){
                            if(path == "consoles"){
                                console = array[p2]
                            }else if(path == "controllers"){
                                controller = array[p2]
                            }
                        }

                    }

                }
                .addOnFailureListener { exception ->
                    Log.w(ContentValues.TAG, "Error getting documents.", exception)
                }
    }
}