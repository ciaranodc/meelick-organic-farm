package com.meelickorganicfarm.app.utils

import android.text.format.DateFormat
import java.util.Date

fun getDate(): String {
    return "${DateFormat.format("dd-MMM-yyyy", Date().time)}"
}