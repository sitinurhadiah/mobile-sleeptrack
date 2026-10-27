
package com.example.sleeptrack

data class SleepSummary(
    val totalRecords: Int,
    val averageDurationMinutes: Int,
    val goodQualityCount: Int,
    val fairQualityCount: Int,
    val poorQualityCount: Int
)

fun calculateSleepSummary(
    records: List<SleepRecord>
): SleepSummary {
    val durations = records.mapNotNull { record ->
        calculateSleepDuration(record.sleepStart, record.wakeUp)
    }

    val averageDuration = if (durations.isNotEmpty()) {
        durations.average().toInt()
    } else {
        0
    }

    return SleepSummary(
        totalRecords = records.size,
        averageDurationMinutes = averageDuration,
        goodQualityCount = records.count { it.quality == "Baik" },
        fairQualityCount = records.count { it.quality == "Cukup" },
        poorQualityCount = records.count { it.quality == "Buruk" }
    )
}
