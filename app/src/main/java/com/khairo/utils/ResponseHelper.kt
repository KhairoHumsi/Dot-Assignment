package com.khairo.utils

import com.khairo.dotassignment.R
import retrofit2.Response
import javax.inject.Inject

class ResponseHelper<T: Any> @Inject constructor() {
    fun checkResponse(response: Response<T>, result: (Int?, Any?) -> Unit) {
        response.apply {
            if (isSuccessful && code() == 200) result(null, body())
            else if (code() == 500) result(R.string.toast_server_error, null)
            else result(R.string.toast_something_error, null)

        }
    }
}
