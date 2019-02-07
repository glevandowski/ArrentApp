package levandowski.app.arrentapp.adapter.rows

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import levandowski.app.arrentapp.R


class PlaceHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    var imagePlaces:ImageView
    var textTitle:TextView
    var textValueHectare:TextView
    var ratingBar:RatingBar

    init {
        imagePlaces = itemView.findViewById(R.id.image_places_card)
        textTitle =  itemView.findViewById(R.id.info_text);
        textValueHectare = itemView.findViewById(R.id.value_hectare_text)
        ratingBar = itemView.findViewById(R.id.ratingBar_places)
        }
}

