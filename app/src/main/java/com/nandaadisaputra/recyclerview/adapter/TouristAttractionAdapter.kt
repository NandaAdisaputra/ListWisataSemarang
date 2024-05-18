package com.nandaadisaputra.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nandaadisaputra.recyclerview.databinding.ItemTouristAttractionsBinding
import com.nandaadisaputra.recyclerview.model.TouristAttraction


// Kelas TouristAttractionAdapter adalah adapter yang digunakan untuk menghubungkan data objek pariwisata ke dalam RecyclerView.
class TouristAttractionAdapter(
    private val items: Array<TouristAttraction>, // List objek pariwisata yang akan ditampilkan.
    private val onSelect: (TouristAttraction) -> Unit // Listener yang dipanggil ketika salah satu item dipilih.
) :
    RecyclerView.Adapter<TouristAttractionAdapter.ViewHolder>() {

    // Inner class ViewHolder yang bertanggung jawab untuk menginisialisasi tampilan setiap item dalam RecyclerView.
    inner class ViewHolder(private val binding: ItemTouristAttractionsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Fungsi bind digunakan untuk mengikat data objek pariwisata ke dalam tampilan setiap item.
        fun bind(item: TouristAttraction) {
            binding.apply {
                // Menetapkan gambar, judul, dan menambahkan listener klik untuk setiap item.
                imageTouristAttraction.setImageResource(item.image)
                tvTitle.text = item.title
                root.setOnClickListener { onSelect(item) }
            }
        }
    }

    // Metode onCreateViewHolder digunakan untuk membuat ViewHolder baru ketika RecyclerView memerlukannya.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Membuat instance dari ViewHolder menggunakan layout binding untuk tampilan item pariwisata.
        val binding = ItemTouristAttractionsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    // Metode onBindViewHolder digunakan untuk mengikat data objek pariwisata ke dalam ViewHolder.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    // Metode getItemCount digunakan untuk mendapatkan jumlah total item dalam RecyclerView.
    override fun getItemCount(): Int {
        return items.size
    }
}
