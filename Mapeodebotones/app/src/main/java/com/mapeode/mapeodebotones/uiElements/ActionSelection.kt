package com.mapeode.mapeodebotones.uiElements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Game

class ActionSelection : Fragment() {

    lateinit var v : View
    lateinit var btnGoToActionTableFromActionSelection: Button
    lateinit var rightText: TextView
    lateinit var leftText: TextView
    lateinit var asLeftEditText: EditText
    lateinit var asRightEditText: EditText
    lateinit var game: Game

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_action_selection,container,false)
        btnGoToActionTableFromActionSelection = v.findViewById(R.id.btnGoToActionTableFromActionSelection)
        rightText = v.findViewById(R.id.asRightText)
        leftText = v.findViewById(R.id.asLeftText)
        asLeftEditText = v.findViewById(R.id.asLeftEditText)
        asRightEditText = v.findViewById(R.id.asRightEditText)
        rightText.text = "What is the name of the action?"
        leftText.text = "select the button of the action"
        btnGoToActionTableFromActionSelection.text = "enter"
        game = ActionSelectionArgs.fromBundle(requireArguments()).game!!
        return v
    }

    override fun onStart() {
        super.onStart()
        game = ActionSelectionArgs.fromBundle(requireArguments()).game!!
        btnGoToActionTableFromActionSelection.setOnClickListener {
            game.add(asRightEditText.text.toString(),asLeftEditText.text.toString())
            val action2 = ActionSelectionDirections.actionActionSelectionToActionTable(game)
            v.findNavController().navigate(action2)
        }
    }
}