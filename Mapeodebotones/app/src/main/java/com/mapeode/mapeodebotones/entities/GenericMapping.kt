package com.mapeode.mapeodebotones.entities

class GenericMapping(actionNameOrEmulatedButton: String, controllerButton: String,type: String, kind: String) {
    var actionNameOrEmulatedButton: String = ""
    var controllerButton: String = ""
    var type: String=""
    var kind: String=""
    init{
        this.actionNameOrEmulatedButton=actionNameOrEmulatedButton
        this.controllerButton=controllerButton
        this.type=type
        this.kind=kind
    }
}