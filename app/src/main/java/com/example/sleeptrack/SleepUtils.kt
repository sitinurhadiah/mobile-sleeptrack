
package com.example.sleeptrack

fun calculateSleepDuration(
    sleepStart: String,
    wakeUp: String
): Int? {
    val startParts = sleepStart.split(":")
    val wakeParts = wakeUp.split(":")

    if (startParts.size != 2 || wakeParts.size != 2) {
        return null
    }

    val startHour = startParts[0].toIntOrNull() ?: return null
    val startMinute = startParts[1].toIntOrNull() ?: return null
    val wakeHour = wakeParts[0].toIntOrNull() ?: return null
    val wakeMinute = wakeParts[1].toIntOrNull() ?: return null

    if (
        startHour !in 0..23 ||
        wakeHour !in 0..23 ||
        startMinute !in 0..59 ||
        wakeMinute !in 0..59
    ) {
        return null
    }

    val startTotal = startHour * 60 + startMinute
    val wakeTotal = wakeHour * 60 + wakeMinute

    if (wakeTotal == startTotal) return null

    val duration = if (wakeTotal > startTotal) {
        wakeTotal - startTotal
    } else {
        wakeTotal + 24 * 60 - startTotal
    }

    return duration
}

fun validateSleepRecord(
    date: String,
    sleepStart: String,
    wakeUp: String,
    quality: String
): String? {
    if (date.isBlank()) return "Tanggal harus diisi."

    if (calculateSleepDuration(sleepStart, wakeUp) == null) {
        return "Waktu tidur atau bangun tidak valid."
    }

    if (quality !in listOf("Buruk", "Cukup", "Baik")) {
        return "Pilih kualitas tidur yang tersedia."
    }

    return null
}
