package com.mapeode.mapeodebotones.entities

class Game(kindName: String, controllerName: String): Mapping() {
    init {
        typeName = "game"
        kind = "game:"
        this.kindName = kindName
        this.controllerName = controllerName
    }
}