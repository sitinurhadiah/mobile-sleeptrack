
package com.example.sleeptrack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun SleepRecordForm(
    onSave: (SleepRecord) -> Unit
) {
    var date by remember { mutableStateOf("") }
    var sleepStart by remember { mutableStateOf("22:00") }
    var wakeUp by remember { mutableStateOf("06:00") }
    var quality by remember { mutableStateOf("") }
    var phoneUsage by remember { mutableStateOf(false) }
    var note by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Isi informasi tidurmu",
                fontWeight = FontWeight.SemiBold
            )

            OutlinedTextField(
                value = date,
                onValueChange = {
                    date = it
                    errorMessage = ""
                },
                label = { Text("Tanggal (YYYY-MM-DD)") },
                placeholder = { Text("2026-10-29") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            OutlinedTextField(
                value = sleepStart,
                onValueChange = {
                    sleepStart = it
                    errorMessage = ""
                },
                label = { Text("Mulai tidur (HH:mm)") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Ascii
                )
            )

            OutlinedTextField(
                value = wakeUp,
                onValueChange = {
                    wakeUp = it
                    errorMessage = ""
                },
                label = { Text("Waktu bangun (HH:mm)") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Ascii
                )
            )

            Text(
                text = "Kualitas tidur",
                fontWeight = FontWeight.Medium
            )

            Column {
                listOf("Buruk", "Cukup", "Baik").forEach { option ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = quality == option,
                            onClick = {
                                quality = option
                                errorMessage = ""
                            }
                        )
                        Text(option)
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Menggunakan HP sebelum tidur?",
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = if (phoneUsage) "Ya" else "Tidak",
                        color = Color.Gray
                    )
                }

                Switch(
                    checked = phoneUsage,
                    onCheckedChange = { phoneUsage = it }
                )
            }

            OutlinedTextField(
                value = note,
                onValueChange = { note = it },
                label = { Text("Catatan tambahan (opsional)") },
                placeholder = {
                    Text("Ceritakan bagaimana tidurmu...")
                },
                modifier = Modifier.fillMaxWidth(),
                minLines = 2
            )

            if (errorMessage.isNotBlank()) {
                Text(
                    text = errorMessage,
                    color = Color(0xFFB3261E)
                )
            }

            Button(
                onClick = {
                    val validationError = validateSleepRecord(
                        date = date,
                        sleepStart = sleepStart,
                        wakeUp = wakeUp,
                        quality = quality
                    )

                    if (validationError != null) {
                        errorMessage = validationError
                    } else {
                        val record = SleepRecord(
                            date = date.trim(),
                            sleepStart = sleepStart,
                            wakeUp = wakeUp,
                            quality = quality,
                            phoneUsage = phoneUsage,
                            note = note.trim()
                        )

                        onSave(record)
                        errorMessage = ""
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Simpan Catatan")
            }

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFF5F6FA),
                shape = RoundedCornerShape(10.dp)
            ) {
                TextButton(
                    onClick = {
                        date = ""
                        sleepStart = "22:00"
                        wakeUp = "06:00"
                        quality = ""
                        phoneUsage = false
                        note = ""
                        errorMessage = ""
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Reset Form")
                }
            }
        }
    }
}
