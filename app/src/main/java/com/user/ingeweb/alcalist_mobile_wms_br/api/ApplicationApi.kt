package com.user.ingeweb.alcalist_mobile_wms_br.api

import androidx.lifecycle.LiveData
import com.user.ingeweb.alcalist_mobile_wms_br.model.ResponseTask
import com.user.ingeweb.alcalist_mobile_wms_br.model.Task
import com.user.ingeweb.alcalist_mobile_wms_br.model.UserRequest
import retrofit2.http.*

interface  ApplicationApi {
    @POST("TaskManger")
    fun task(@Body user: UserRequest): LiveData<ApiResponse<ResponseTask>>

     /*@GET("lookupteam.php")
    fun teamsById(@Query("id") idTeam: Long): LiveData<ApiResponse<Teams>>

    @GET("eventslast.php")
    fun teamEvents(@Query("id") idTeam: Long): LiveData<ApiResponse<List<Events>>>*/
}