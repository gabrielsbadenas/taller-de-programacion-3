package com.mapeode.mapeodebotones.entities

open class Emulator(kindName: String, controllerName: String): Mapping() {
    init {
        typeName = "emulator"
        kind = "console:"
        this.kindName = kindName
        this.controllerName = controllerName
    }
    override fun add(actionNameOrEmulatedButton: String, controllerButton: String){
        this.buttons.add(GenericMapping(actionNameOrEmulatedButton,controllerButton,"button:"))
    }
}