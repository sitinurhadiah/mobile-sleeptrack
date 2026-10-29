
# Test Cases — SleepTrack

## 1. Informasi Pengujian

- **Nama aplikasi:** SleepTrack
- **Studi kasus:** HT-04 — SleepTrack (Kebiasaan Tidur Sehat)
- **Platform:** Android
- **Teknologi:** Kotlin, Jetpack Compose, Material 3
- **Metode:** Pengujian manual (black-box)
- **Tanggal pengujian:** 29/10/2026
- **Penguji:** Xander dan Titis
- **Versi aplikasi:** Prototipe UTS — penyimpanan sementara

## 2. Tujuan Pengujian

Pengujian dilakukan untuk memastikan aplikasi SleepTrack dapat menerima dan memvalidasi input kebiasaan tidur, menghitung durasi tidur, menyimpan catatan sementara, menampilkan riwayat, serta memperbarui ringkasan secara benar tanpa menyebabkan aplikasi crash.

## 3. Daftar Test Case

### TC-01 — Aplikasi pertama kali dibuka

- **Langkah pengujian:**
    1. Jalankan aplikasi SleepTrack.
    2. Pastikan belum ada catatan yang disimpan.
    3. Periksa bagian ringkasan dan riwayat tidur.
- **Hasil yang diharapkan:** Aplikasi terbuka tanpa crash. Jumlah catatan dan rata-rata durasi menunjukkan nilai nol. Riwayat menampilkan empty state jika belum ada catatan.
- **Hasil aktual:** Aplikasi terbuka dan kondisi awal benar.
- **Status:** PASS

### TC-02 — Menyimpan catatan dengan input valid

- **Langkah pengujian:**
    1. Isi tanggal dengan tanggal yang valid.
    2. Masukkan waktu tidur 22:00.
    3. Masukkan waktu bangun 06:00.
    4. Pilih kualitas tidur Baik.
    5. Isi atau pilih status penggunaan gawai sesuai form.
    6. Tekan tombol simpan/tambah.
- **Hasil yang diharapkan:** Catatan berhasil disimpan sementara dan ditampilkan pada riwayat. Ringkasan berubah sesuai data yang ditambahkan.
- **Hasil aktual:** Data valid masuk ke riwayat dan ringkasan berubah.
- **Status:** PASS

### TC-03 — Input wajib kosong

- **Langkah pengujian:**
    1. Kosongkan tanggal atau input wajib lain yang tersedia.
    2. Isi input lainnya jika diperlukan.
    3. Tekan tombol simpan/tambah.
- **Hasil yang diharapkan:** Aplikasi menampilkan pesan kesalahan yang mudah dipahami. Catatan yang tidak valid tidak ditambahkan dan aplikasi tidak crash.
- **Hasil aktual:** Input wajib kosong ditolak dengan pesan yang jelas.
- **Status:** PASS

### TC-04 — Waktu tidur melewati tengah malam

- **Langkah pengujian:**
    1. Masukkan waktu tidur 22:00.
    2. Masukkan waktu bangun 06:00.
    3. Lengkapi input wajib dan simpan catatan.
    4. Periksa durasi atau rata-rata pada ringkasan.
- **Hasil yang diharapkan:** Durasi tidur dihitung sebagai 8 jam atau 480 menit. Jika hanya rata-rata yang ditampilkan, rata-rata untuk satu catatan ini adalah 8 jam.
- **Hasil aktual:** Waktu 22:00–06:00 dihitung menjadi 8 jam.
- **Status:** PASS

### TC-05 — Waktu tidur dan bangun sama

- **Langkah pengujian:**
    1. Masukkan waktu tidur 22:00.
    2. Masukkan waktu bangun 22:00.
    3. Lengkapi input wajib dan tekan tombol simpan/tambah.
- **Hasil yang diharapkan:** Durasi nol ditolak sesuai validasi aplikasi. Pesan kesalahan ditampilkan, jumlah catatan tidak bertambah, dan aplikasi tidak crash.
- **Hasil aktual:** Waktu tidur dan bangun sama ditolak.
- **Status:** PASS

### TC-06 — Format atau nilai waktu tidak valid

- **Langkah pengujian:**
    1. Coba masukkan waktu dengan format salah atau nilai di luar rentang jam dan menit jika antarmuka mengizinkannya.
    2. Tekan tombol simpan/tambah.
    3. Periksa respons aplikasi.
- **Hasil yang diharapkan:** Waktu tidak valid ditolak, pesan kesalahan ditampilkan, dan aplikasi tidak crash.
- **Hasil aktual:** Waktu tidak valid ditolak tanpa crash.
- **Status:** PASS

### TC-07 — Menambahkan beberapa catatan ke riwayat

- **Langkah pengujian:**
    1. Simpan catatan pertama dengan waktu tidur 22:00 dan bangun 06:00.
    2. Simpan catatan kedua dengan waktu tidur 23:00 dan bangun 05:00.
    3. Buka atau gulir ke bagian riwayat tidur.
- **Hasil yang diharapkan:** Kedua catatan tampil pada daftar riwayat. Setiap item menampilkan informasi tidur yang relevan dan daftar dapat digulir jika diperlukan.
- **Hasil aktual:** Dua catatan tampil di riwayat.
- **Status:** PASS

### TC-08 — Perhitungan ringkasan tidur

- **Langkah pengujian:**
    1. Simpan catatan pertama dengan waktu 22:00–06:00 dan kualitas Baik.
    2. Simpan catatan kedua dengan waktu 23:00–05:00 dan kualitas Cukup.
    3. Periksa jumlah catatan, rata-rata durasi, dan ringkasan kualitas.
- **Hasil yang diharapkan:**
    - Total catatan: 2.
    - Durasi catatan pertama: 8 jam.
    - Durasi catatan kedua: 6 jam.
    - Rata-rata durasi: 7 jam.
    - Kualitas Baik: 1.
    - Kualitas Cukup: 1.
    - Kualitas Buruk: 0.
- **Hasil aktual:** Jumlah, rata-rata, dan kualitas sesuai perhitungan.
- **Status:** PASS

### TC-09 — Tombol reset formulir

- **Langkah pengujian:**
    1. Isi beberapa kolom pada form.
    2. Tekan tombol reset jika tersedia.
    3. Periksa kondisi input setelah reset.
- **Hasil yang diharapkan:** Input form kembali ke kondisi awal. Catatan yang telah tersimpan tetap ada, kecuali terdapat tindakan hapus terpisah.
- **Hasil aktual:** Form kembali ke kondisi awal setelah reset.
- **Status:** PASS

### TC-10 — Aplikasi tetap berjalan setelah input tidak valid

- **Langkah pengujian:**
    1. Coba menyimpan input yang tidak valid.
    2. Periksa pesan validasi dan pastikan aplikasi tetap terbuka.
    3. Setelah itu, isi form dengan data yang valid dan coba simpan kembali.
- **Hasil yang diharapkan:** Aplikasi tidak crash. Input tidak valid ditolak, dan pengguna tetap dapat melanjutkan penggunaan aplikasi.
- **Hasil aktual:** Setelah input invalid, aplikasi tetap berjalan dan bisa digunakan kembali.
- **Status:** PASS

## 4. Rekapitulasi Hasil Pengujian

| Keterangan | Jumlah |
|---|-------:|
| Total test case |     10 |
| PASS |     10 |
| FAIL |      0 |
| Belum diuji |      0 |

## 5. Temuan dan Perbaikan

Pengujian telah dilakukan sesuai test case. Tidak ditemukan masalah yang menghambat pengujian.

## 6. Kesimpulan

Pengujian dilakukan untuk memeriksa validasi input, perhitungan durasi tidur, penyimpanan sementara, tampilan riwayat, dan pembaruan ringkasan SleepTrack.

Hasil akhir pengujian dan jumlah PASS/FAIL diisi berdasarkan pengujian langsung pada aplikasi. Data SleepTrack pada tahap UTS disimpan sementara selama aplikasi berjalan dan belum menggunakan Room Database.
