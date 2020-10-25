package com.example.dagger2basic

import se.ansman.kotshi.JsonSerializable

@JsonSerializable
data class CourseView (
    var courses : List<FieldView>
)