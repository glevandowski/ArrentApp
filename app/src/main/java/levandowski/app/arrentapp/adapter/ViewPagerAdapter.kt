package levandowski.app.arrentapp.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class ViewPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

     var  mFragmentList:MutableList<Fragment> = arrayListOf()

     override fun getItem( position:Int):Fragment {
         return mFragmentList.get(position)
    }

   override fun getCount():Int {
        return mFragmentList.size
   }

    fun addFragment( fragment:Fragment) {
        mFragmentList.add(fragment)
    }

    fun removeFragment(  index:Int) {
        mFragmentList.removeAt(index)
        // do the same for the title
        notifyDataSetChanged();
    }
}