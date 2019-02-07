package levandowski.app.arrentapp.ui.about

import android.os.Bundle
import levandowski.app.arrentapp.R
import levandowski.app.arrentapp.core.BaseActivity
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener
import com.synnapps.carouselview.ViewListener
import levandowski.app.arrentapp.model.Places


class AboutPlacesActivity :BaseActivity(){

    lateinit var titleAbout:TextView
    lateinit var localAbout:TextView
    lateinit var userAbout:TextView
    lateinit var ratingAbout:RatingBar
    lateinit var contractAbout:TextView
    lateinit var transportAbout:TextView
    lateinit var terrainAbout:TextView
    lateinit var waterAbout:TextView
    lateinit var descriptionAbout:TextView
    lateinit var amountAbout:TextView
    lateinit var valueAbout:TextView
    lateinit var minimumTimeAbout:TextView
    lateinit var availabilityAbout:TextView

    lateinit var image:ImageView

    lateinit var carouselView:CarouselView
    lateinit var carouselViewTitle: CarouselView


    var  sampleImages:IntArray = intArrayOf(R.drawable.canola_fields, R.drawable.canola_fields)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aboutplaces_activity)
        this.findViews()
        this.setValue(getBundle())
        this.setupCarouselAvaiable()
        this.setupCarouselTitle()
//        Toast.makeText(this, places.title,Toast.LENGTH_LONG).show()
    }

    fun findViews() {
        titleAbout = findViewById(R.id.text_title)
        localAbout = findViewById(R.id.text_local_about_place)
        userAbout = findViewById(R.id.text_user_about_place)
        ratingAbout = findViewById(R.id.rating_about_places)
        contractAbout = findViewById(R.id.text_contract_about_place)
        transportAbout = findViewById(R.id.text_transport_about_place)
        terrainAbout = findViewById(R.id.text_terrain_about_place)
        waterAbout = findViewById(R.id.text_water_about_place)
        descriptionAbout = findViewById(R.id.text_description_about_place)
        amountAbout = findViewById(R.id.text_quantity_htr_about_place)
        valueAbout = findViewById(R.id.text_value_htr_about_place)
        minimumTimeAbout = findViewById(R.id.text_timer_about_place)
        availabilityAbout = findViewById(R.id.text_avaiability_about_place)
    }

    fun getBundle():Places =  intent.getParcelableExtra<Places> ("FLAG")

    fun setValue(places: Places) {
        titleAbout.setText(places.title)
        localAbout.setText("Cuiaba, Mato Grosso")
        userAbout.setText(places.aboutUserContact)
//        ratingAbout.numStars = places.rankingReview?.toInt()!!
        contractAbout.setText(places.contract)
        transportAbout.setText(places.transport)
        terrainAbout.setText(places.terrainOption)
        waterAbout.setText(places.water)
        descriptionAbout.setText(places.about)
        amountAbout.setText(places.hectares)
        valueAbout.setText(places.valueHectare)
        minimumTimeAbout.setText(places.contractTime)
        availabilityAbout.setText(places.available)
    }

    fun setupCarouselAvaiable(){
        carouselView =  findViewById(R.id.carouselView)
        carouselView.setPageCount(sampleImages.size)

        carouselView.setViewListener(imageListener)
    }

    var imageListener = ViewListener{
        s ->
        val view = layoutInflater.inflate(R.layout.card_places,null)


        image = view.findViewById(R.id.image_places_card)

        image.setImageResource(sampleImages[s])

        carouselView.getLayoutParams().height = image.getDrawable().getIntrinsicHeight() +300

        //image.setImageDrawable(getDrawable(R.drawable.background_map))

         view
    }

    fun setupCarouselTitle() {
        carouselViewTitle = findViewById(R.id.carouselView_title_about)
        carouselViewTitle.pageCount = 2


        carouselViewTitle.setImageListener(imageListenerAbout)
    }

    var imageListenerAbout = ImageListener { position, imageView ->
        var  teste:IntArray = intArrayOf(R.drawable.canola_fields, R.drawable.canola_fields)
        imageView.setImageResource(teste.get(position))
        carouselViewTitle.getLayoutParams().height = imageView.getDrawable().getIntrinsicHeight() +300
    }

}