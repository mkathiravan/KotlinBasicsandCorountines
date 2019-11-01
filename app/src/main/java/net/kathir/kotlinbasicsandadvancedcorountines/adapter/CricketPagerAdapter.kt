package net.kathir.kotlinbasicsandadvancedcorountines.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import net.kathir.kotlinbasicsandadvancedcorountines.fragment.CricketFragment
import net.kathir.kotlinbasicsandadvancedcorountines.model.CricketModel

class CricketPagerAdapter (private val cricketModelList: List<CricketModel>, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
{
    override fun getCount(): Int {
        return cricketModelList.size
    }

    override fun getItem(position: Int): Fragment {
        return CricketFragment.newInstance(cricketModelList[position])
    }

}