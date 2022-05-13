package com.user.ingeweb.alcalist_mobile_wms_br.model

import com.google.gson.annotations.SerializedName

data class ResponseTask (
  @SerializedName("Status")
  var Status: Status,
  @SerializedName("Task")
  var Task: ArrayList<Task>,
  @SerializedName("Accompaniment")
  var Accompaniment : ArrayList<Accompaniment>
)