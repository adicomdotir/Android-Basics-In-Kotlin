package ir.adicom.app.androidbasicsinkotlin.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ir.adicom.app.androidbasicsinkotlin.databinding.GridViewItemBinding
import ir.adicom.app.androidbasicsinkotlin.network.MarsPhoto

class PhotoGridAdapter : ListAdapter<MarsPhoto,
        PhotoGridAdapter.MarsPhotoViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoGridAdapter.MarsPhotoViewHolder {
        return MarsPhotoViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: PhotoGridAdapter.MarsPhotoViewHolder, position: Int) {
        val marsPhoto = getItem(position)
        holder.bind(marsPhoto)
    }

    class MarsPhotoViewHolder(private var binding: GridViewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(MarsPhoto: MarsPhoto) {
            binding.photo = MarsPhoto
            binding.executePendingBindings()
        }
    }
}

object DiffCallback : DiffUtil.ItemCallback<MarsPhoto>() {
    override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
        return oldItem.imgSrcUrl == newItem.imgSrcUrl
    }
}
