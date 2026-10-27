package com.example.sleeptrack

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class SleepUtilsTest {

    @Test
    fun sleepDurationAcrossMidnight() {
        assertEquals(480, calculateSleepDuration("22:00", "06:00"))
    }

    @Test
    fun sleepDurationSameDay() {
        assertEquals(120, calculateSleepDuration("21:00", "23:00"))
    }

    @Test
    fun sleepDurationWithMinutes() {
        assertEquals(450, calculateSleepDuration("23:30", "07:00"))
    }

    @Test
    fun sameSleepAndWakeTimeIsInvalid() {
        assertNull(calculateSleepDuration("22:00", "22:00"))
    }

    @Test
    fun invalidTimeIsRejected() {
        assertNull(calculateSleepDuration("25:00", "06:00"))
    }

    @Test
    fun blankDateIsRejected() {
        assertEquals(
            "Tanggal harus diisi.",
            validateSleepRecord("", "22:00", "06:00", "Baik")
        )
    }

    @Test
    fun invalidQualityIsRejected() {
        assertEquals(
            "Pilih kualitas tidur yang tersedia.",
            validateSleepRecord("2026-10-27", "22:00", "06:00", "Bagus")
        )
    }

    @Test
    fun validRecordPassesValidation() {
        assertNull(
            validateSleepRecord("2026-10-27", "22:00", "06:00", "Baik")
        )
    }

    @Test
    fun emptySummaryHasZeroValues() {
        val summary = calculateSleepSummary(emptyList())

        assertEquals(0, summary.totalRecords)
        assertEquals(0, summary.averageDurationMinutes)
        assertEquals(0, summary.goodQualityCount)
        assertEquals(0, summary.fairQualityCount)
        assertEquals(0, summary.poorQualityCount)
    }

    @Test
    fun summaryCountsRecordsAndQuality() {
        val records = listOf(
            SleepRecord("2026-10-25", "22:00", "06:00", "Baik", false, ""),
            SleepRecord("2026-10-26", "23:00", "05:00", "Cukup", true, ""),
            SleepRecord("2026-10-27", "22:00", "05:00", "Baik", false, "")
        )

        val summary = calculateSleepSummary(records)

        assertEquals(3, summary.totalRecords)
        assertEquals(420, summary.averageDurationMinutes)
        assertEquals(2, summary.goodQualityCount)
        assertEquals(1, summary.fairQualityCount)
        assertEquals(0, summary.poorQualityCount)
    }
}
