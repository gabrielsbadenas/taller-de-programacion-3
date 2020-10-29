package com.mapeode.mapeodebotones.entities

class GenericMapping(actionNameOrEmulatedButton: String, controllerButton: String,type: String="action/button:", kind: String="controller:") {
    var actionNameOrEmulatedButton: String = ""
    var controllerButton: String = ""
    var type: String="action/button:"
    var kind: String="controller:"
    init{
        this.actionNameOrEmulatedButton=actionNameOrEmulatedButton
        this.controllerButton=controllerButton
        this.type=type
        this.kind=kind
    }
}