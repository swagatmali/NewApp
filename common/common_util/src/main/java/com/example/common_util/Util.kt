package com.example.common_util

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import java.time.LocalDate
import kotlin.time.Duration

class Util {
    companion object {
        @RequiresApi(Build.VERSION_CODES.O)
        fun calculateHRs(publishedAt: String): String {
            val parse = Instant.parse(publishedAt)
            val now = Clock.System.now()
            val durationSinceThen: Duration = now - parse
            return durationSinceThen.inWholeHours.toString()
        }
    }
}