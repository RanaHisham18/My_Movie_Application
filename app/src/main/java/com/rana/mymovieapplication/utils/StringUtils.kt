package com.rana.mymovieapplication.utils

inline fun < reified T : Any > String.desrialize() : T{
return com.squareup.moshi.Moshi.Builder().build()
    .adapter<T>(T::class.java).fromJson(this)!!
}

inline fun <reified T: Any> T.serialize() :String{
    return com.squareup.moshi.Moshi.Builder().build()
        .adapter<String>(T::class.java).toJson(this.toString())
}


