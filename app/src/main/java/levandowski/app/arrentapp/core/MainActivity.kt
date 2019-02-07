package levandowski.app.arrentapp.core

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.view.MenuItem
import android.widget.Toast
import levandowski.app.arrentapp.*
import levandowski.app.arrentapp.adapter.ViewPagerAdapter
import levandowski.app.arrentapp.ui.chat.ChatFragment
import levandowski.app.arrentapp.ui.home.HomeFragment
import levandowski.app.arrentapp.ui.places.PlacesFragment
import levandowski.app.arrentapp.ui.profile.ProfileFragment

class MainActivity: BaseActivity(){

    //region PROPRIEDADES

    //FLAG
    var  IS_SEARCH:Boolean = false

    //BottomNavigation
    lateinit var bottomNavigationView:BottomNavigationView
    var prevMenuItem:MenuItem? = null

    //ViewPager
    lateinit var viewPager:ViewPager
    lateinit var viewPagerAdapter: ViewPagerAdapter

    //fragments
    lateinit var fragmentHome: HomeFragment
    lateinit var fragmentChat: ChatFragment
    lateinit var fragmentProfile: ProfileFragment
    //endregion

    //region LIFECYCLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        this.findViews()
        this.init()
    }

    override fun onResume() {
        super.onResume()
        this.eventsViewPager()
        this.setupViewPager(viewPager)
        this.isSearch()
    }

    /***
     * Resultado da atividade de pesquisa
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        try {
            super.onActivityResult(requestCode, resultCode, data)

            if (requestCode === 1 && resultCode === Activity.RESULT_OK) {
                val requiredValue = data?.getStringExtra("key")

                IS_SEARCH = true
            }
        } catch (ex: Exception) {
            Toast.makeText(this, "Erro ao consultar", Toast.LENGTH_SHORT).show()
        }
    }
    //endregion

    //region REFERENCES/INSTANCES
    /***
     * referencias
     */
    fun findViews(){
        bottomNavigationView = findViewById(R.id.navigation)
        viewPager = findViewById(R.id.viewpager)
    }

    /***
     * instances
     */
    fun init() {
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
    //endregion

    //region SETUP

    /***
     * Setup central ViewPager
     */
    fun setupViewPager(viewPager:ViewPager) {
        viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)

        fragmentHome = HomeFragment()
        fragmentChat = ChatFragment()
        fragmentProfile = ProfileFragment()

        viewPagerAdapter.addFragment(fragmentChat)
        viewPagerAdapter.addFragment(fragmentHome)
        viewPagerAdapter.addFragment(fragmentProfile)

        viewPager.setAdapter(viewPagerAdapter)
    }

    /***
     * Eventos - Controla os eventos que ocorrem no viewpager
     */
    fun eventsViewPager() {
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                managerMenuBottomNavigation(position)
                returnPosition(position)
            }
        })
    }

    /***
     * Gerencia o bottomnavigation para interagir corretamente com o viewpager
     */
    fun managerMenuBottomNavigation(position:Int){
        if (prevMenuItem != null)
            prevMenuItem?.setChecked(false)
        else
            bottomNavigationView.getMenu().getItem(0).setChecked(false)

        if(position != 3) {
            bottomNavigationView.getMenu().getItem(position).setChecked(true)
            prevMenuItem = bottomNavigationView.getMenu().getItem(position)
        }
    }
    //endregion

    //region VALIDATIONS

    /***
     * Setup viewpager - Recebeu uma solicitacao de pesquisa?
     */
    fun isSearch(){
        if(IS_SEARCH == true) {
            viewPagerAdapter.addFragment(PlacesFragment())
            viewPagerAdapter.notifyDataSetChanged()
            viewPager.setCurrentItem(3)
            IS_SEARCH = false
        } else {
            viewPager.offscreenPageLimit = 3
            viewPager.setCurrentItem(1)
        }
    }

    /**
     * Retorna a posicao inicial quando tenta acessar fragment de locais
     */
    fun returnPosition(position: Int) {
        if(position == 3 && bottomNavigationView.getMenu().getItem(2).isChecked){
            viewPager.setCurrentItem(2,true)
        }
    }
    //endregion

    //region MENU ACTION CONTROL BOTTOMNAVIGATION
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_message -> {
                viewPager.setCurrentItem(0,true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_explore -> {
                viewPager.setCurrentItem(1,true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                viewPager.setCurrentItem(2,true)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    //endregion

}