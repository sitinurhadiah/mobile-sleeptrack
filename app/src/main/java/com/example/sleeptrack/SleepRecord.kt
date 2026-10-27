package com.example.sleeptrack

data class SleepRecord(
    val date: String,
    val sleepStart: String,
    val wakeUp: String,
    val quality: String,
    val phoneUsage: Boolean,
    val note: String
)