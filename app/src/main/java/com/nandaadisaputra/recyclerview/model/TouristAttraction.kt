package com.nandaadisaputra.recyclerview.model

// Data class TouristAttraction merepresentasikan objek pariwisata yang akan ditampilkan dalam aplikasi.
data class TouristAttraction(
    val image: Int, // Menyimpan ID gambar yang akan digunakan untuk menampilkan gambar pariwisata.
    val title: String, // Menyimpan judul atau nama dari objek pariwisata.
    val description: String // Menyimpan deskripsi atau informasi tambahan tentang objek pariwisata.
)