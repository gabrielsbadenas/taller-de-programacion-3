package com.mapeode.mapeodebotones.uiElements

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mapeode.mapeodebotones.R
import com.mapeode.mapeodebotones.entities.Mapping

class MappingListAdapter(
        private var mappingList: MutableList<Mapping>,
        val onItemClick: (Int) -> Boolean
) : RecyclerView.Adapter<MappingListAdapter.MappingHolder>(){

    companion object {
        private val TAG = "MappingListAdapter"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MappingHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_mapping,parent,false)
        return (MappingHolder(view))
    }

    override fun onBindViewHolder(holder: MappingHolder, position: Int) {
        holder.setMapping(mappingList[position])
        holder.getCardLayout().setOnLongClickListener() {
            onItemClick(position)
        }
        holder.getButton().setOnClickListener {
            val action2 = MainMenuDirections.actionMainMenuToGenericMappingList(mappingList[position])
            holder.view.findNavController().navigate(action2)
        }
    }

    override fun getItemCount(): Int {
        return mappingList.size
    }
    class MappingHolder (v: View) : RecyclerView.ViewHolder(v){
        var view: View
        init {
            this.view = v
        }
        fun setMapping(map: Mapping) {
            val type: TextView = view.findViewById(R.id.item_type)
            type.text = map.type
            val typeName: TextView = view.findViewById(R.id.item_type_name)
            typeName.text = map.typeName
            val kind: TextView = view.findViewById(R.id.item_kind)
            kind.text = map.kind
            val kindName: TextView = view.findViewById(R.id.item_kind_name)
            kindName.text = map.kindName
            val controller: TextView = view.findViewById(R.id.item_controller)
            controller.text = map.controller
            val controllerName: TextView = view.findViewById(R.id.item_controller_name)
            controllerName.text = map.controllerName
        }
        fun getCardLayout (): CardView {
            return view.findViewById(R.id.card_package_item)
        }

        fun getButton (): Button {
            return view.findViewById(R.id.buttonItem)
        }
    }
}