# SleepTrack — Requirements

## 1. Deskripsi Aplikasi

SleepTrack adalah aplikasi mobile sederhana untuk membantu pengguna mencatat kebiasaan tidur sehari-hari. Aplikasi ini menampilkan durasi tidur, kualitas tidur berdasarkan penilaian subjektif pengguna, serta ringkasan dari catatan yang telah disimpan.

Aplikasi dikembangkan sebagai proyek UTS Pemrograman Bergerak menggunakan Kotlin, Android Studio, Jetpack Compose, dan Material 3.

## 2. Tujuan Aplikasi

1. Membantu pengguna mencatat waktu tidur dan waktu bangun.
2. Menghitung durasi tidur berdasarkan waktu yang dimasukkan.
3. Membantu pengguna melihat riwayat dan kebiasaan tidur.
4. Menampilkan ringkasan sederhana berdasarkan catatan tidur.

## 3. Kebutuhan Fungsional

| ID | Kebutuhan |
|---|---|
| FR-01 | Pengguna dapat memasukkan tanggal tidur. |
| FR-02 | Pengguna dapat memasukkan waktu mulai tidur dan waktu bangun. |
| FR-03 | Pengguna dapat memilih kualitas tidur: Buruk, Cukup, atau Baik. |
| FR-04 | Pengguna dapat menentukan apakah menggunakan HP sebelum tidur. |
| FR-05 | Pengguna dapat menambahkan catatan opsional. |
| FR-06 | Sistem memvalidasi input sebelum menyimpan catatan. |
| FR-07 | Sistem menghitung durasi tidur, termasuk jika waktu tidur melewati tengah malam. |
| FR-08 | Pengguna dapat menyimpan catatan tidur yang valid. |
| FR-09 | Pengguna dapat mereset input pada formulir. |
| FR-10 | Sistem menampilkan catatan tidur dalam daftar riwayat. |
| FR-11 | Sistem menampilkan rata-rata durasi tidur dan jumlah catatan. |
| FR-12 | Sistem menampilkan ringkasan kualitas tidur berdasarkan catatan yang tersimpan. |
| FR-13 | Ringkasan diperbarui ketika catatan berhasil ditambahkan. |
| FR-14 | Sistem menampilkan pesan ketika belum ada catatan tidur. |
| FR-15 | Sistem menampilkan pesan edukasi umum mengenai kebiasaan tidur sehat. |

## 4. Kebutuhan Data

Setiap catatan tidur memiliki data berikut:

- Tanggal tidur
- Waktu mulai tidur
- Waktu bangun
- Kualitas tidur
- Penggunaan HP sebelum tidur
- Catatan tambahan (opsional)
- Durasi tidur hasil perhitungan

Data catatan direpresentasikan menggunakan Kotlin data class dengan properti dan tipe data yang sesuai.

## 5. Aturan Validasi

1. Tanggal, waktu mulai tidur, waktu bangun, kualitas tidur, dan pilihan penggunaan HP wajib diisi.
2. Catatan tambahan bersifat opsional.
3. Sistem menampilkan pesan kesalahan apabila input wajib belum lengkap atau tidak valid.
4. Waktu tidur dan waktu bangun harus menghasilkan durasi tidur yang masuk akal.
5. Perhitungan durasi harus memperhitungkan pergantian hari ketika pengguna tidur sebelum tengah malam dan bangun setelah tengah malam.
6. Catatan hanya ditambahkan apabila validasi berhasil.

## 6. Ringkasan dan Riwayat

Ringkasan aplikasi terdiri dari:

- Rata-rata durasi tidur dari catatan yang tersimpan.
- Jumlah catatan tidur.
- Ringkasan kualitas tidur berdasarkan data yang tersedia.

Setiap kartu riwayat menampilkan sekurang-kurangnya tanggal, durasi tidur, dan kualitas tidur.

Jika belum ada data, aplikasi menampilkan pesan kosong. Jika sudah ada data, aplikasi menampilkan daftar catatan tidur.

## 7. Kebutuhan Antarmuka

1. Aplikasi menggunakan Kotlin, Jetpack Compose, dan Material 3.
2. Aplikasi memiliki satu halaman utama yang dapat digulir secara vertikal.
3. Halaman utama memuat ringkasan, formulir pencatatan, riwayat, dan pesan edukasi.
4. Daftar riwayat menggunakan LazyColumn dan Card.
5. Formulir menyediakan tombol Simpan Catatan dan Reset Form.
6. Desain menggunakan tata letak sederhana, konsisten, dan mudah digunakan.
7. Tidak diperlukan halaman detail, halaman pengaturan, login, atau navigasi ke halaman lain.

## 8. Penyimpanan Data

Data disimpan sementara di memori aplikasi selama aplikasi berjalan. Proyek ini tidak memerlukan database atau backend.

## 9. Batasan Aplikasi

1. Aplikasi tidak mendiagnosis gangguan tidur.
2. Kualitas tidur merupakan penilaian subjektif pengguna.
3. Informasi yang ditampilkan bersifat pencatatan dan edukasi umum.
4. Data sementara tidak dijamin tetap tersedia setelah aplikasi ditutup atau proses aplikasi dihentikan.

## 10. Teknologi

- Bahasa pemrograman: Kotlin
- IDE: Android Studio
- UI toolkit: Jetpack Compose
- Desain komponen: Material 3
- Penyimpanan: In-memory sementara
- Kontrol daftar: LazyColumn
