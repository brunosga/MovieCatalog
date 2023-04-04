package com.example.moviecatalog.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (
    @SerializedName("id")
    val id : String?,

    @SerializedName("title")
    val name : String?,

    @SerializedName("poster_path")
    val image : String?,

    //@SerializedName("genre_ids")
 //   val certification : List<Int>?,

    @SerializedName("overview")
    val description : String?,

) : Parcelable{
            constructor() : this("", "", "", "")
}

