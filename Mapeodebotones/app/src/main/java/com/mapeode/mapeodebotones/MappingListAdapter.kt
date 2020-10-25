package com.mapeode.mapeodebotones

import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MappingListAdapter(
        private var mappingList: MutableList<Mapping>,
        val onItemClick: (Int) -> Boolean
) : RecyclerView.Adapter<MappingListAdapter.MappingHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MappingHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MappingHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
    class MappingHolder (v: View) : RecyclerView.ViewHolder(v){
        private var view: View
        init {
            this.view = v
        }
        fun getCardLayout (): CardView {
            return view.findViewById(R.id.card_package_item)
        }
        /*
        fun getButton (): Button {
            return view.findViewById(R.id.btn_item)
        }
        */
    }
}