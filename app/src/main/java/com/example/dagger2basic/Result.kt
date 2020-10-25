package com.example.dagger2basic

import androidx.annotation.Keep

/**
 * A generic class that holds a value with its loading status.
 * @param <T>
 */
sealed class Result<out T> {

    @Keep
    data class Loading<out T>(val data: T) : Result<T>()

    @Keep
    data class Success<out T>(val data: T) : Result<T>()


    @Keep
    data class Error<out T>(val message: String, val data: T? = null) : Result<T>()

    override fun toString(): String {
        return when (this) {
            is Loading<*> -> "Loading[data=$data]"
            is Success<*> -> "Success[data=$data]"
            is Error<*> -> "Error[exception=$message, data=$data]"
        }
    }
}