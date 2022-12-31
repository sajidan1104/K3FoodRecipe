package co.id.uinsgd.kel3foodrecipe.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.azhar.resepmakanan.R
import com.azhar.resepmakanan.activities.DetailRecipeActivity
import com.azhar.resepmakanan.model.ModelFilter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class FavAdapter(private val context: Context, private val modelFilter: List<ModelFilter>):
RecyclerView.Adapter<FavAdapter.ViewHolder>() {

    interface onSelectData {
        fun onSelected(modelMain: ModelFilter)

        companion object
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_filter_food, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return modelFilter.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = modelFilter[position]
        Glide.with(context)
            .load(data.strMealThumb)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.imgThumb)
        holder.tvMeal.text = data.strMeal
        holder.cvFilterMeal.setOnClickListener {
            val intent = Intent(context, DetailRecipeActivity::class.java)
            intent.putExtra(DetailRecipeActivity.detailRecipe, modelFilter[position])
            context.startActivity(intent) }
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvMeal: TextView
        var cvFilterMeal: CardView
        var imgThumb: ImageView

        init {
            cvFilterMeal = itemView.findViewById(R.id.cvFilterMeal)
            tvMeal = itemView.findViewById(R.id.tvMeal)
            imgThumb = itemView.findViewById(R.id.imgThumb)
        }
    }
}

