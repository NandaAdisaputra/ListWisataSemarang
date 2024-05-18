package com.nandaadisaputra.recyclerview.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nandaadisaputra.recyclerview.R
import com.nandaadisaputra.recyclerview.adapter.TouristAttractionAdapter
import com.nandaadisaputra.recyclerview.databinding.ActivityMainBinding
import com.nandaadisaputra.recyclerview.model.TouristAttraction

// Kelas MainActivity merupakan kelas utama yang mengatur tampilan halaman utama aplikasi.
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // Metode onCreate dipanggil ketika aktivitas dibuat.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mengikat layout activity_main.xml menggunakan ViewBinding.
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Data pariwisata yang akan ditampilkan dalam RecyclerView.
        val touristAttraction = arrayOf(
            TouristAttraction(
                R.drawable.lawang_sewu,
                "Lawang Sewu",
                "Lawang Sewu adalah sebuah bangunan bersejarah yang terletak di Semarang, " +
                        "Jawa Tengah, Indonesia. Nama \"Lawang Sewu\" secara harfiah berarti \"seribu pintu\" " +
                        "dalam bahasa Jawa, merujuk pada banyaknya pintu dan jendela besar yang ada di " +
                        "bangunan ini.",
            ),
            // Data pariwisata lainnya di Semarang.
        )

        // Mengatur layout manager dan adapter untuk RecyclerView.
        binding.rvTouristAttraction.layoutManager = LinearLayoutManager(this)
        binding.rvTouristAttraction.adapter = TouristAttractionAdapter(touristAttraction) { item ->
            // Mengarahkan pengguna ke DetailActivity saat item RecyclerView diklik.
            val touristAttractionIntent = Intent(this, DetailActivity::class.java).apply {
                putExtra(DetailActivity.KEY_TITLE, item.title)
                putExtra(DetailActivity.KEY_DESCRIPTION, item.description)
                putExtra(DetailActivity.KEY_IMAGE, item.image)
            }
            startActivity(touristAttractionIntent)
        }
    }
}