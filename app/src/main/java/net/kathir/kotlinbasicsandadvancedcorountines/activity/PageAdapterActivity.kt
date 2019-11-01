package net.kathir.kotlinbasicsandadvancedcorountines.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.page_adapter_main.*
import net.kathir.kotlinbasicsandadvancedcorountines.R
import net.kathir.kotlinbasicsandadvancedcorountines.adapter.InfoPagerAdapter
import net.kathir.kotlinbasicsandadvancedcorountines.model.InfoModel

class PageAdapterActivity : AppCompatActivity()
{
    private var infoPagerAdapter: InfoPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_adapter_main)


        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.france_name)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.croatia_name)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.belgium_name)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.england_name)))


        infoPagerAdapter = InfoPagerAdapter(
            getInfoData(),
            supportFragmentManager
        )

        viewPager.adapter = infoPagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })


    }



    private fun getInfoData(): List<InfoModel>
    {

        val infoList = arrayListOf<InfoModel>()

        infoList.add(
            InfoModel(getString(R.string.france_name), getString(
                R.string.france_url
            ),
            getString(R.string.france_desc))
        )

        infoList.add(InfoModel(getString(R.string.croatia_name), getString(
            R.string.croatia_url
        ),
            getString(R.string.croatia_desc)))

        infoList.add(InfoModel(getString(R.string.belgium_name), getString(
            R.string.belgium_url
        ),
            getString(R.string.belgium_desc)))

        infoList.add(InfoModel(getString(R.string.england_name), getString(
            R.string.england_url
        ),
            getString(R.string.engladn_desc)))

        return infoList

    }
}