package co.id.uinsgd.kel3foodrecipe.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import co.id.uinsgd.kel3foodrecipe.R
import co.id.uinsgd.kel3foodrecipe.adapter.FavAdapter
import co.id.uinsgd.kel3foodrecipe.model.ModelFilter
import co.id.uinsgd.kel3foodrecipe.realm.RealmHelper
import kotlinx.android.synthetic.main.activity_filter_food.*
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.ArrayList

class MainActivity2 : AppCompatActivity(){
    var modelFilter: MutableList<ModelFilter> = ArrayList()
    var helper:RealmHelper? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        helper = RealmHelper(this)

        toolbar2.setTitle(null)
        setSupportActionBar(toolbar2)

        rvFav.setLayoutManager(LinearLayoutManager(this))
        rvFav.setAdapter(FavAdapter(this, modelFilter))
        rvFav.setHasFixedSize(true)


        getFavorite()
    }

//    override fun onSelected(modelMain: ModelFilter) {
//        val intent = Intent(this@MainActivity2, DetailRecipeActivity::class.java)
//        intent.putExtra("detailRecipe", modelMain)
//        startActivity(intent)
//    }

    private fun getFavorite() {
        modelFilter = helper!!.showFavoriteRecipes()
        if (modelFilter.size == 0) {
            rvFav.visibility = View.GONE
        } else {
            rvFav.visibility = View.VISIBLE
            rvFav.adapter = FavAdapter(this, modelFilter)
        }
    }
    public override fun onResume() {
        super.onResume()
        getFavorite()
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}