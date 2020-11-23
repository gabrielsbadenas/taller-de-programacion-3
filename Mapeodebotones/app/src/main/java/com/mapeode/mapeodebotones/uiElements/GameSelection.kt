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
import com.google.firebase.firestore.FirebaseFirestore
import com.mapeode.mapeodebotones.uiElements.GameSelectionDirections
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Emulator
import com.mapeode.mapeodebotones.entities.Game
import com.mapeode.mapeodebotones.entities.Name

class GameSelection : Fragment() {

    lateinit var v : View
    lateinit var btnGoToActionTableFromGameSelection: Button
    lateinit var topText: TextView
    lateinit var bottomText: TextView
    lateinit var spinner: Spinner
    lateinit var editText: EditText
    lateinit var controller: String
    var db: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_game_selection,container,false)
        btnGoToActionTableFromGameSelection = v.findViewById(R.id.btnGoToActionTableFromGameSelection)
        btnGoToActionTableFromGameSelection.text = "next"

        topText = v.findViewById(R.id.gsTopText)
        topText.text = "What is the name of the game?"

        bottomText = v.findViewById(R.id.gsBottomText)
        bottomText.text = "which controller are you going to use?"

        editText = v.findViewById(R.id.gsEditText)

        spinner = v.findViewById(R.id.gsSpinner)
        todos()

        return v
    }

    override fun onStart() {
        super.onStart()
        btnGoToActionTableFromGameSelection.setOnClickListener {
            //addGame(editText.text.toString(),controller)
            val data = editText.text.toString()+"-"+controller+"-"+java
                    .util.UUID.randomUUID().toString()
            db.collection("mappings").document(data)
                    .set(Game(editText.text.toString(),controller))
            val action2 = GameSelectionDirections.actionGameSelectionToActionTable()
            v.findNavController().navigate(action2)
        }
    }

    fun todos(){
        var arrayList: MutableList<String> = ArrayList<String>()
        db.collection("controllers")
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
                            controller = "nothing"
                        }

                        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long){
                            controller = array[p2]
                        }

                    }

                }
                .addOnFailureListener { exception ->
                    Log.w(ContentValues.TAG, "Error getting documents.", exception)
                }
    }
}