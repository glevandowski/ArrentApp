package levandowski.app.arrentapp.ui.search

import android.app.Activity
import android.os.Bundle
import android.widget.RelativeLayout
import levandowski.app.arrentapp.R
import levandowski.app.arrentapp.core.BaseActivity


class SearchActivity: BaseActivity() {

    lateinit var relativeLayout: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_activity)

        relativeLayout = findViewById(R.id.relative_recents_search)

        relativeLayout.setOnClickListener {
            val intent = intent
            intent.putExtra("key", "Essa tela foi fechada")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}