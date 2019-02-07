package levandowski.app.arrentapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import levandowski.app.arrentapp.ui.places.ItemClickListener
import levandowski.app.arrentapp.R
import levandowski.app.arrentapp.adapter.rows.PlaceHolder
import levandowski.app.arrentapp.model.Places

class PlacesAdapter( var mDataset: MutableList<Places>) : RecyclerView.Adapter<PlaceHolder>() {

    lateinit var mClickListener: ItemClickListener

    fun buildInterface(itemClickListener: ItemClickListener) {
        this.mClickListener = itemClickListener;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder =
            PlaceHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_places, parent, false))


    override fun getItemCount(): Int = mDataset.size


    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        //holder.imagePlaces
        holder.textTitle.setText(mDataset.get(position).title)
        holder.textValueHectare.setText(mDataset.get(position).valueHectare)
        holder.ratingBar.numStars = 3

        holder.itemView.setOnClickListener {
           onClickSetup(holder)
        }
    }

    private fun onClickSetup(holder: PlaceHolder) {
        if (mClickListener != null)
            mClickListener.onItemClick(holder.itemView, holder.adapterPosition)
    }

    fun getItem(id:Int) = mDataset.get(id)

}

