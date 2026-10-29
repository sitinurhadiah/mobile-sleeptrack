
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp
                )

                FormPlaceholder("Tanggal", "Pilih tanggal")
                Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    FormPlaceholder(
                        "Mulai tidur",
                        "22:00",
                        Modifier.weight(1f)
                    )
                    FormPlaceholder(
                        "Waktu bangun",
                        "06:00",
                        Modifier.weight(1f)
                    )
                }

                Text(
                    text = "Kualitas tidur",
                    fontWeight = FontWeight.Medium
                )
                Text("Buruk  •  Cukup  •  Baik")

                Text(
                    text = "Menggunakan HP sebelum tidur?",
                    fontWeight = FontWeight.Medium
                )
                Text("Ya / Tidak")

                FormPlaceholder(
                    "Catatan tambahan",
                    "Ceritakan bagaimana tidurmu..."
                )

                Button(
                    onClick = {},
                    enabled = false,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Simpan Catatan")
                }

                Text(
                    text = "Form akan diaktifkan pada tahap integrasi.",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }

        SectionTitle("Riwayat Tidur")

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

@Composable
private fun FormPlaceholder(
    label: String,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Text(
            text = label,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            color = Color(0xFFF5F6FA),
            border = androidx.compose.foundation.BorderStroke(
                1.dp,
                Color(0xFFE0E3EC)
            )
        ) {
            Text(
                text = placeholder,
                modifier = Modifier.padding(12.dp),
                color = Color.Gray,
                fontSize = 14.sp
            )
        }
    }
}
