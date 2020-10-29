package com.mapeode.mapeodebotones.entities

import android.os.Parcel
import android.os.Parcelable

open class Mapping() : Parcelable {
    var type: String = "type:"
    var typeName: String = ""
    var kind: String = ""
    var kindName: String = ""
    var controller: String = "controller:"
    var controllerName: String = ""
    var buttons: ArrayList<GenericMapping> = ArrayList<GenericMapping>()

    constructor(parcel: Parcel) : this() {
        type = parcel.readString().toString()
        typeName = parcel.readString().toString()
        kind = parcel.readString().toString()
        kindName = parcel.readString().toString()
        controller = parcel.readString().toString()
        controllerName = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(typeName)
        parcel.writeString(kind)
        parcel.writeString(kindName)
        parcel.writeString(controller)
        parcel.writeString(controllerName)
    }

    override fun describeContents(): Int {
        return 0
    }

    open fun add(actionNameOrEmulatedButton: String, controllerButton: String, type: String, kind: String="controller:"){
        this.buttons.add(GenericMapping(actionNameOrEmulatedButton, controllerButton,type, kind))
    }

    companion object CREATOR : Parcelable.Creator<Mapping> {
        override fun createFromParcel(parcel: Parcel): Mapping {
            return Mapping(parcel)
        }

        override fun newArray(size: Int): Array<Mapping?> {
            return arrayOfNulls(size)
        }
    }

    open fun add(actionNameOrEmulatedButton: String, controllerButton: String) {}
}