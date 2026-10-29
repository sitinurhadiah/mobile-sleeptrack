
package com.example.sleeptrack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SleepRecordHistory(records: List<SleepRecord>) {
    if (records.isEmpty()) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Belum ada catatan tidur",
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = "Catatan yang kamu simpan akan muncul di sini.",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 420.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(records) { index, record ->
                SleepRecordCard(
                    record = record,
                    number = index + 1
                )
            }
        }
    }
}

@Composable
private fun SleepRecordCard(
    record: SleepRecord,
    number: Int
) {
    val duration = calculateSleepDuration(
        sleepStart = record.sleepStart,
        wakeUp = record.wakeUp
    )

    val durationText = if (duration != null) {
        "${duration / 60} jam ${duration % 60} menit"
    } else {
        "Durasi tidak tersedia"
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Catatan #$number",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF536DFE)
            )

            Text(
                text = "Tanggal: ${record.date}"
            )

            Text(
                text = "Tidur: ${record.sleepStart}  •  Bangun: ${record.wakeUp}"
            )

            Text(
                text = "Durasi: $durationText",
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "Kualitas tidur: ${record.quality}"
            )

            Text(
                text = "Menggunakan ponsel sebelum tidur: " +
                        if (record.phoneUsage) "Ya" else "Tidak"
            )

            if (record.note.isNotBlank()) {
                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "Catatan: ${record.note}"
                )
            }
        }
    }
}
