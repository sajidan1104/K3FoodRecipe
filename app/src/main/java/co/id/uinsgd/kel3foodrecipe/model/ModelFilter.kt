package co.id.uinsgd.kel3foodrecipe.model

import io.realm.RealmModel
import io.realm.RealmObject
import java.io.Serializable


open class ModelFilter : Serializable, RealmObject() {

    var idMeal: String? = null

    @JvmField
    var strMeal: String? = null

    @JvmField
    var strMealThumb: String? = null

}