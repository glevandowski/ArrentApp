package levandowski.app.arrentapp.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import levandowski.app.arrentapp.R
import levandowski.app.arrentapp.ui.search.SearchActivity
import levandowski.app.arrentapp.core.BaseFragment

class HomeFragment: BaseFragment() {

    lateinit var search:SearchView
    val REQUEST_CODE = 1

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.home_fragment,container,false)
        search = view.findViewById(R.id.homeSearch)
        return view
    }

    override fun onResume() {
        super.onResume()
        search.setOnClickListener {
            activity?.startActivityForResult(Intent(context, SearchActivity()::class.java), REQUEST_CODE)
        }
    }

}
