# Responsi-1-Praktikum-Pemrograman-Mobile
Nama: Fauzia Azahra Depriani<br>
NIM: H1D023117<br>
Shift Baru: Shift F<br>
Shift Asal: Shift D

 # Demo Aplikasi 576. RC Strasbourg Alsace
https://github.com/user-attachments/assets/f387c960-94d6-46fc-ac3f-48438364e6cf

Saat Activity atau Fragment dibuat, RecyclerView diinisialisasi dan adapter awalnya kosong. Aplikasi kemudian memanggil REST API menggunakan Retrofit yang mengirim request ke server dan menerima data JSON, seperti daftar pemain atau coach. JSON yang diterima otomatis diubah menjadi objek Kotlin sesuai data class, lalu dikirim ke main thread agar bisa diupdate di UI. Adapter RecyclerView kemudian diisi dengan data baru, menampilkan nama pemain, kebangsaan, tanggal lahir, dan posisi (yang juga menentukan warna CardView). RecyclerView menampilkan daftar pemain yang bisa discroll dan saat item diklik, BottomSheet PlayerDetailFragment muncul di atas layar untuk menampilkan detail pemain.
