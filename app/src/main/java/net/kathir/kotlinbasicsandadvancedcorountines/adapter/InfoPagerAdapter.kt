package net.kathir.kotlinbasicsandadvancedcorountines.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import net.kathir.kotlinbasicsandadvancedcorountines.fragment.InfoFragment
import net.kathir.kotlinbasicsandadvancedcorountines.model.InfoModel

class InfoPagerAdapter (private val infoModelList: List<InfoModel> , fm : FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
{

    override fun getCount(): Int {
        return infoModelList.size
    }

    override fun getItem(position: Int): Fragment {
        return InfoFragment.newInstance(infoModelList[position])
    }
}