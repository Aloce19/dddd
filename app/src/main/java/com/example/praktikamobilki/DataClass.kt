package com.example.smarthouse

class DataClass
{
    @kotlinx.serialization.Serializable
    data class RoomsUsers (
        var id: Int = 0,
        val idRoom: Int = 0,
        val idUser: String = "",
        val name: String = "") 

    @kotlinx.serialization.Serializable
    data class AllRooms (val id: Int = 0,
                         val name: String = "")
    @kotlinx.serialization.Serializable
    data class AllDevices(val id: Int = 0,
                          val name: String = "")
    @kotlinx.serialization.Serializable
    data class Users (val id: String = "",
                      var name: String = "",
                      var address: String = "")
    @kotlinx.serialization.Serializable
    data class DevicesUsers(val idDevice: Int = 0,
                            val idRoomUser: Int = 0,
                            val value: Boolean = false,
                            val brightness: Int = 0,
                            val power: Int = 0,
                            val degrees: Int = 0,
                            val name: String = "",
                            val Identyname: String = "")
}