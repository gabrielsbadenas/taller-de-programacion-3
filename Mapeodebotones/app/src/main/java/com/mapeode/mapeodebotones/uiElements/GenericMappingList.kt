

package com.mapeode.mapeodebotones.uiElements

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.google.android.material.snackbar.Snackbar
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.GenericMapping
import com.mapeode.mapeodebotones.entities.Mapping

class GenericMappingList : Fragment() {
    lateinit var v : View
    //lateinit var btnGoToTypeSelectionFromMainMenu: Button
    lateinit var recMapping : RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var buttons : MutableList<GenericMapping>//= ArrayList<GenericMapping>()
    private lateinit var genericMappingListAdapter: GenericMappingListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.generic_mapping_list,container,false)
        recMapping = v.findViewById(R.id.generic_recycler_view)
        return v
    }

    override fun onStart() {
        super.onStart()
        buttons = GenericMappingListArgs.fromBundle(requireArguments()).buttons.buttons
        //buttons = ArrayList()
        recMapping.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this.context)
        recMapping.layoutManager = linearLayoutManager
        genericMappingListAdapter = GenericMappingListAdapter(buttons){ x ->
            onItemClick(x)
        }
        recMapping.adapter = genericMappingListAdapter
    }

    private fun onItemClick(position: Int): Boolean {
        Snackbar.make(v,position.toString(), Snackbar.LENGTH_SHORT).show()
        return true
    }

    class GenericMappingListAdapter   (private var genericMappingList: MutableList<GenericMapping>,
        val onItemClick: (Int) -> Boolean
        ) : RecyclerView.Adapter<GenericMappingListAdapter.GenericMappingHolder>(){


        companion object {
            private val TAG = "GenericMappingListAdapter"
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericMappingListAdapter.GenericMappingHolder {
            val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_generic_mapping,parent,false)
            return (GenericMappingListAdapter.GenericMappingHolder(view))
        }

        override fun onBindViewHolder(holder: GenericMappingListAdapter.GenericMappingHolder, position: Int) {
            holder.setMapping(genericMappingList[position])
            holder.getCardLayout().setOnLongClickListener() {
                onItemClick(position)
            }
        }

        override fun getItemCount(): Int {
            return genericMappingList.size
        }
        class GenericMappingHolder  (v: View) : RecyclerView.ViewHolder(v){
            var view: View
            init {
                this.view = v
            }
            fun setMapping(map: GenericMapping) {
                val type: TextView = view.findViewById(R.id.item_type_generic)
                type.text = map.type
                val typeName: TextView = view.findViewById(R.id.item_type_name_generic)
                typeName.text = map.actionNameOrEmulatedButton
                val kind: TextView = view.findViewById(R.id.item_kind_generic)
                kind.text = map.kind
                val kindName: TextView = view.findViewById(R.id.item_kind_name_generic)
                kindName.text = map.controllerButton
            }
            fun getCardLayout (): CardView {
                return view.findViewById(R.id.card_package_item_generic)
            }
        }
        }
    }

