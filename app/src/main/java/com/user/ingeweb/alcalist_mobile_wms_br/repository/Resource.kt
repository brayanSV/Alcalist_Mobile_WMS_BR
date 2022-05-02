package com.user.ingeweb.alcalist_mobile_wms_br.repository

import com.user.ingeweb.alcalist_mobile_wms_br.repository.Status

data class Resource<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun<T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun<T> error(data: T?, message: String): Resource<T> {
            return Resource(Status.ERROR, data, message)
        }

        fun<T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}