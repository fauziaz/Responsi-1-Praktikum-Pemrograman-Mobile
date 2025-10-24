# Responsi-1-Praktikum-Pemrograman-Mobile
Nama: Fauzia Azahra Depriani<br>
NIM: H1D023117<br>
Shift Baru: Shift F<br>
Shift Asal: Shift D

 # Demo Aplikasi 576. RC Strasbourg Alsace
https://github.com/user-attachments/assets/f387c960-94d6-46fc-ac3f-48438364e6cf

Penjelasan Alur Data
- Inisialisasi UI: Saat Activity atau Fragment dibuat, RecyclerView diinisialisasi agar siap menampilkan data.
- Pemanggilan API: Aplikasi menggunakan Retrofit untuk memanggil REST API, mengirim HTTP request ke server, dan menerima respons berupa data JSON seperti daftar pemain atau coach.
- Parsing Data JSON: Retrofit otomatis mengubah JSON menjadi objek Kotlin/Java sesuai data class, misalnya JSON squad diubah menjadi list Player menggunakan val players = squad.map { Player(it.id, it.name, it.position, it.dateOfBirth, it.nationality) }.
- Update UI: Data yang sudah diparse dikirim ke main thread agar bisa diupdate di UI, contohnya menggunakan withContext(Dispatchers.Main) atau runOnUiThread().
- Update Adapter: RecyclerView adapter di-update dengan data baru sehingga memanggil onBindViewHolder untuk setiap item dan menampilkan data di ViewHolder.
- Penyajian di Layar: Setiap ViewHolder menampilkan nama pemain, kebangsaan, tanggal lahir, posisi, dan warna CardView sesuai posisi. list pemain bisa discroll dan saat item diklik, BottomSheet Fragment akan muncul menampilkan detail pemain,
