package net.kathir.kotlinbasicsandadvancedcorountines.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.page_adapter_main.*
import net.kathir.kotlinbasicsandadvancedcorountines.R
import net.kathir.kotlinbasicsandadvancedcorountines.adapter.CricketPagerAdapter
import net.kathir.kotlinbasicsandadvancedcorountines.model.CricketModel

class CricketMainActivity : AppCompatActivity()
{

    private var infoPagerAdapter: CricketPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.page_adapter_main)


        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.englandcri_name)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.newzelandcri_name)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.indiacri_name)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.auscri_name)))


        infoPagerAdapter =
            CricketPagerAdapter(
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



    private fun getInfoData(): List<CricketModel>
    {

        val infoList = arrayListOf<CricketModel>()

        infoList.add(
            CricketModel(getString(R.string.englandcri_name), getString(
                R.string.englandcri_url
            ),
                getString(R.string.englandcri_desc))
        )

        infoList.add(
            CricketModel(getString(R.string.newzelandcri_name), getString(
                R.string.newzelandcri_url
            ),
                getString(R.string.newzelandcri_desc))
        )

        infoList.add(
            CricketModel(getString(R.string.indiacri_name), getString(
                R.string.indiacri_url
            ),
                getString(R.string.indiacri_desc))
        )

        infoList.add(
            CricketModel(getString(R.string.auscri_name), getString(
                R.string.auscri_url
            ),
                getString(R.string.auscri_desc))
        )

        return infoList

    }
}