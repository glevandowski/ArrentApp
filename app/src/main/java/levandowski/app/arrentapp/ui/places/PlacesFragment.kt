package levandowski.app.arrentapp.ui.places

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import levandowski.app.arrentapp.R
import levandowski.app.arrentapp.adapter.PlacesAdapter
import levandowski.app.arrentapp.core.BaseFragment
import levandowski.app.arrentapp.model.Places
import levandowski.app.arrentapp.ui.about.AboutPlacesActivity

class PlacesFragment: BaseFragment(), ItemClickListener {

    lateinit var mAdapter:PlacesAdapter
    lateinit var mRecyclerView:RecyclerView
    lateinit var localizacoes:MutableList<Places>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.places_fragment,container,false)
        this.findViews(view)
        this.insertPlaces()
        this.setupRecyclerViewLayout()

        return view
    }

    override fun onResume() {
        super.onResume()
        setupAdapter()
    }

    fun insertPlaces() {
        localizacoes = ArrayList<Places>()

        localizacoes.add(Places(
                "Fazenda um cuiabá 120 hectares para plantio",
                "Antônio",
                null,
                "3",
                null,
                "Contrato flexível",
                "Terreno plano",
                "Transporte público",
                "Água encanada",
                "Terra disponível para plantio e pecuária, água encanada e poço artesiano. Conta também com galpão para...",
                "120",
                "R$ 100,00",
                "3 anos",
                "Pecuária e plantio"))

        localizacoes.add(Places(
                "teste123",
                "teste123",
                null,
                "teste",
                null,
                "teste",
                "teste",
                "teste",
                "teste",
                "teste",
                "teste",
                "teste",
                "teste",
                "teste"))

    }

    fun findViews(view: View){
        mRecyclerView = view.findViewById(R.id.recycler_view);
    }

   fun setupAdapter() {
        mAdapter = PlacesAdapter(localizacoes);
        mAdapter.buildInterface(this)
        mRecyclerView.setAdapter(mAdapter)
    }

    fun setupRecyclerViewLayout() {
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.setLayoutManager(GridLayoutManager(activity, 2))
    }

    override fun onItemClick(view: View, position: Int) {
      //  Toast.makeText(context,"Title: "+mAdapter.mDataset.get(position).title+"You clicked number " + mAdapter.getItem(position) + ", which is at cell position " + position, Toast.LENGTH_LONG).show()
        val intent = Intent(activity, AboutPlacesActivity::class.java)

        intent.putExtra("FLAG",  mAdapter.getItem(position))
        startActivity(intent)
    }

}