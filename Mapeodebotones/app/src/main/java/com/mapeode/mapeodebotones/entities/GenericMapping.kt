package com.mapeode.mapeodebotones.entities

class GenericMapping(actionNameOrEmulatedButton: String, controllerButton: String) {
    var actionNameOrEmulatedButton: String = ""
    var controllerButton: String = ""
    init{
        this.actionNameOrEmulatedButton=actionNameOrEmulatedButton
        this.controllerButton=controllerButton
    }
}