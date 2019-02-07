package levandowski.app.arrentapp.model

import android.os.Parcel
import android.os.Parcelable
import android.widget.ImageView

class Places() : Parcelable {

    var title: String? = null
    var aboutUserContact: String? = null
    var imageUserContact: ImageView? = null
    var rankingReview: String? = null
    var imagePlaces: ImageView? = null
    var contract: String? = null
    var terrainOption: String? = null
    var transport: String? = null
    var water: String? = null
    var about: String? = null
    var hectares: String? = null
    var valueHectare: String? = null
    var contractTime: String? = null
    var available: String? = null

    constructor(parcel: Parcel) : this() {
        title = parcel.readString()
        aboutUserContact = parcel.readString()
        rankingReview = parcel.readString()
        contract = parcel.readString()
        terrainOption = parcel.readString()
        transport = parcel.readString()
        water = parcel.readString()
        about = parcel.readString()
        hectares = parcel.readString()
        valueHectare = parcel.readString()
        contractTime = parcel.readString()
        available = parcel.readString()
    }


    constructor (title:String, aboutUserContact: String, imageUserContact: ImageView? = null, rankingReview: String,
                 imagePlaces: ImageView? = null, contract: String, terrainOption: String, transport: String,
                 water: String, about: String, hectares: String, valueHectare: String, contractTime: String,
                 available: String): this () {
        this.title = title
        this.aboutUserContact = aboutUserContact
        this.imageUserContact = imageUserContact
        this.rankingReview = rankingReview
        this.imagePlaces = imagePlaces
        this.contract = contract
        this.terrainOption = terrainOption
        this.transport = transport
        this.water = water
        this.about = about
        this.hectares = hectares
        this.valueHectare = valueHectare
        this.contractTime = contractTime
        this.available = available
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(aboutUserContact)
        parcel.writeString(rankingReview)
        parcel.writeString(contract)
        parcel.writeString(terrainOption)
        parcel.writeString(transport)
        parcel.writeString(water)
        parcel.writeString(about)
        parcel.writeString(hectares)
        parcel.writeString(valueHectare)
        parcel.writeString(contractTime)
        parcel.writeString(available)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Places> {
        override fun createFromParcel(parcel: Parcel): Places {
            return Places(parcel)
        }

        override fun newArray(size: Int): Array<Places?> {
            return arrayOfNulls(size)
        }
    }
}