
package com.example.sleeptrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sleeptrack.ui.theme.SleepTrackTheme

private val PageBackground = Color(0xFFF5F7FB)
private val AccentColor = Color(0xFF536DFE)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            SleepTrackTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = PageBackground
                ) { innerPadding ->
                    SleepTrackHome(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SleepTrackHome(modifier: Modifier = Modifier) {
    var records by remember {
        mutableStateOf<List<SleepRecord>>(emptyList())
    }

    var savedMessage by remember {
        mutableStateOf("")
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Column {
            Text(
                text = "SleepTrack",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = AccentColor
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = "Kenali kebiasaan tidurmu, mulai hari ini.",
                color = Color.DarkGray,
                fontSize = 14.sp
            )
        }

        SectionTitle("Ringkasan Tidur")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SummaryCard(
                title = "Total Catatan",
                value = "0",
                modifier = Modifier.weight(1f)
            )
            SummaryCard(
                title = "Rata-rata Tidur",
                value = "0j 0m",
                modifier = Modifier.weight(1f)
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = "Kualitas Tidur",
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(8.dp))
                Text("Baik: 0  •  Cukup: 0  •  Buruk: 0")
            }
        }


        SectionTitle("Catat Tidurmu")

        SleepRecordForm(
            onSave = { record ->
                records = records + record
                savedMessage =
                    "Catatan berhasil disimpan. Total catatan sementara: ${records.size}"
            }
        )

        if (savedMessage.isNotBlank()) {
            Text(
                text = savedMessage,
                color = Color(0xFF287D46),
                fontWeight = FontWeight.Medium
            )
        }


        SectionTitle("Riwayat Tidur")

        SleepRecordHistory(records = records)

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFE8EAFE)
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = "Tips Tidur Sehat",
                    fontWeight = FontWeight.Bold,
                    color = AccentColor
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Usahakan jadwal tidur teratur dan kurangi " +
                            "penggunaan ponsel menjelang waktu tidur."
                )
            }
        }

        Text(
            text = "SleepTrack • Catatan kebiasaan tidur",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF20243A)
    )
}

@Composable
private fun SummaryCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = title,
                color = Color.Gray,
                fontSize = 13.sp
            )
            Text(
                text = value,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                color = AccentColor
            )
        }
    }
}
