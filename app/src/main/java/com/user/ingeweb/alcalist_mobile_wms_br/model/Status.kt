package com.user.ingeweb.alcalist_mobile_wms_br.model

import com.google.gson.annotations.SerializedName


data class Status (
  @SerializedName("Code")
  var Code: String,
  @SerializedName("Message")
  var Message: String
)