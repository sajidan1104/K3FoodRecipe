package com.azhar.resepmakanan.realm

import android.content.Context
import com.azhar.resepmakanan.model.ModelFilter
import io.realm.Realm

class RealmHelper(context: Context) {
    val realm:Realm

    init {
        Realm.init(context)
        realm = Realm.getDefaultInstance()
    }

    fun cekData(KeyResep: String?): Boolean {
        val listRecipes = realm.where(ModelFilter::class.java).equalTo("idMeal", KeyResep).findFirst()
        return listRecipes == null
    }

    fun showFavoriteRecipes(): ArrayList<ModelFilter> {
        val data = ArrayList<ModelFilter>()
        val modelRecipes = realm.where(ModelFilter::class.java).findAll()
        if (modelRecipes.size > 0) {
            for (i in modelRecipes.indices) {
                val listRecipes = ModelFilter()
                listRecipes.idMeal = modelRecipes[i]!!.idMeal
                listRecipes.strMeal = modelRecipes[i]!!.strMeal
                listRecipes.strMealThumb = modelRecipes[i]!!.strMealThumb
                data.add(listRecipes)
            }
        }
        return data
    }

    fun addFavoriteRecipes(KeyResep: String?, TitleResep: String?, Thumbnail: String?) {
        val listRecipes = ModelFilter()
        listRecipes.idMeal = KeyResep
        listRecipes.strMeal = TitleResep
        listRecipes.strMealThumb = Thumbnail
        realm.beginTransaction()
        realm.copyToRealm(listRecipes)
        realm.commitTransaction()
    }

    fun deleteFavoriteRecipes(KeyResep: String?) {
        realm.beginTransaction()
        val listRecipes = realm.where(ModelFilter::class.java).equalTo("idMeal", KeyResep).findAll()
        listRecipes.deleteAllFromRealm()
        realm.commitTransaction()
    }


}