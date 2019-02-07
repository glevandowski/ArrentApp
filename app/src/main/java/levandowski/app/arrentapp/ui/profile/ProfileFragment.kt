package levandowski.app.arrentapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import levandowski.app.arrentapp.R
import levandowski.app.arrentapp.core.BaseFragment

class ProfileFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.profile_fragment,container,false)

        return view
    }
}