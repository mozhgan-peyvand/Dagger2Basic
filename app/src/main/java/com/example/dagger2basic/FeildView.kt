package com.example.dagger2basic

import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class FieldView (
    var Image:String = "",
    var teacher:String = "",
    var name:String = "",
    var id :Int = 0
)