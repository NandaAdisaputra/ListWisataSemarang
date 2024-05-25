package com.nandaadisaputra.recyclerview.ui.activity

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
                R.drawable.lawangsewu,
                "Lawang Sewu",
                "Lawang Sewu adalah gedung bersejarah milik PT Kereta Api Indonesia (Persero) " +
                        "yang awalnya digunakan sebagai Kantor Pusat perusahaan kereta api swasta " +
                        "Nederlandsch-Indische Spoorweg Maatschappij (NISM). Gedung Lawang Sewu " +
                        "dibangun secara bertahap di atas lahan seluas 18.232 m2. Bangunan utama " +
                        "dimulai pada 27 Februari 1904 dan selesai pada Juli 1907. Sedangkan bangunan " +
                        "tambahan dibangun sekitar tahun 1916 dan selesai tahun 1918.",
            ),
            TouristAttraction(
                R.drawable.sampokong,
                "SAM POO KONG",
                "Kelenteng Gedung Kuno Sam Poo Kong yaitu bekas tempat persinggahan dan " +
                        "pendaratan pertama seorang Laksamana Tiongkok beragama Islam yang bernama " +
                        "Zheng He/Cheng Ho, yang juga dikenal dengan nama Sam Poo.",
            ),
            TouristAttraction(
                R.drawable.masjidagung,
                "Masjid Agung Jawa Tengah (MAJT)",
                "Masjid Agung Jawa Tengah adalah masjid yang terletak di Semarang, provinsi Jawa Tengah, " +
                        "Indonesia. Masjid ini mulai dibangun sejak tahun 2001 hingga selesai secara keseluruhan " +
                        "pada tahun 2006. Masjid ini berdiri di atas lahan 10 hektare.",
            ),
            TouristAttraction(
                R.drawable.tugumuda,
                "Tugu Muda Semarang",
                "Tugu Muda adalah sebuah monumen yang dibuat untuk mengenang jasa-jasa para pahlawan " +
                        "yang telah gugur dalam Pertempuran Lima Hari di Semarang. Monumen ini terletak di Jalan " +
                        "Nasional Rute 20 yang mengarah ke Solo.",
            ),
            TouristAttraction(
                R.drawable.candigedongsongo,
                "Candi Gedong Songo",
                "Candi Gedong Songo adalah nama sebuah kompleks bangunan candi peninggalan budaya Hindu " +
                        "yang terletak di desa Candi, Kecamatan Bandungan, Kabupaten Semarang, Jawa Tengah, " +
                        "Indonesia tepatnya di lereng Gunung Ungaran. Di kompleks candi ini terdapat sembilan " +
                        "buah candi.",
            ),
            TouristAttraction(
                R.drawable.curug,
                "Air Terjun Curug Lawe Benowo Kalisidi",
                "Candi Gedong Songo adalah nama sebuah kompleks bangunan candi peninggalan budaya Hindu " +
                        "yang terletak di desa Candi, Kecamatan Bandungan, Kabupaten Semarang, Jawa Tengah, " +
                        "Indonesia tepatnya di lereng Gunung Ungaran. Di kompleks candi ini terdapat sembilan " +
                        "buah candi.",
            ),
            TouristAttraction(
                R.drawable.goakreo,
                "Obyek Wisata Goa Kreo",
                "Gua Kreo adalah objek wisata yang terdapat di Kota Semarang. Gua Kreo merupakan Gua " +
                        "yang terbentuk oleh alam dan terletak di tengah-tengah Waduk Jatibarang, sebuah bendungan " +
                        "yang membendung Kali Kreo.",
            ),
            TouristAttraction(
                R.drawable.mawarcamp,
                "Mawar Camp Area",
                "Mawar Camp merupakan salah satu destinasi wisata terbaik untuk kamu yang ingin bermalam " +
                        "dengan suasana pemandangan di pegunungan. Terletak tak jauh dari lokasi Gunung Ungaran, " +
                        "camping ground ini dijadikan alternatif kamu yang ingin mendaki tapi tidak kuat fisik.",
            ),
            TouristAttraction(
                R.drawable.museumkereta,
                "Museum Kereta Api Ambarawa",
                "Museum Kereta Api Ambarawa adalah sebuah stasiun kereta api yang sudah dialihfungsikan " +
                        "menjadi sebuah museum serta merupakan museum perkeretaapian pertama di Indonesia. Museum " +
                        "ini memiliki koleksi kereta api yang pernah berjaya pada zamannya. Museum ini secara " +
                        "administratif berada di Desa Panjang, Ambarawa, Semarang.",
            ),
            TouristAttraction(
                R.drawable.saloka,
                "Saloka Theme Park",
                "Taman hiburan yang fantastis dengan banyak wahana bertema, konsesi, " +
                        "acara & air mancur",
            ),
            TouristAttraction(
                R.drawable.kampungpelangi,
                "Kampung Pelangi",
                "Desa yang terkenal dengan inisiatif pelestarian & lebih dari 200 rumah bergambar pelangi.",
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