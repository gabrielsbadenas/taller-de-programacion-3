package com.mapeode.mapeodebotones.entities

open class Mapping {
    var type: String = "type:"
    var typeName: String = ""
    var kind: String = ""
    var kindName: String = ""
    var controller: String = "controller:"
    var controllerName: String = ""
    var buttons: ArrayList<GenericMapping> = ArrayList<GenericMapping>()
}