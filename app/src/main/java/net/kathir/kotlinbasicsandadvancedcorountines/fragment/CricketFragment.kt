package net.kathir.kotlinbasicsandadvancedcorountines.fragment

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.info_view.*
import kotlinx.coroutines.*
import net.kathir.kotlinbasicsandadvancedcorountines.R
import net.kathir.kotlinbasicsandadvancedcorountines.model.CricketModel
import net.kathir.kotlinbasicsandadvancedcorountines.utils.SnowFilter
import java.net.URL

class CricketFragment : Fragment()
{
    companion object
    {
        const val TUTORIAL_KEY = "INFO"
        fun newInstance(infoModel: CricketModel) : CricketFragment
        {
            val fragmentHome =
                CricketFragment()
            val args = Bundle()
            args.putParcelable(TUTORIAL_KEY, infoModel)
            fragmentHome.arguments = args
            return fragmentHome

        }
    }



    private val parentJob = Job()

    private val coroutineExceptionHandler : CoroutineExceptionHandler =

        CoroutineExceptionHandler { _, throwable ->

            coroutineScope.launch(Dispatchers.Main){
                errorMessage.visibility = View.VISIBLE
                errorMessage.text = getString(R.string.error_message)
            }

            GlobalScope.launch { println("Caught $throwable") }
        }


    private val coroutineScope = CoroutineScope(Dispatchers.Main + parentJob + coroutineExceptionHandler)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val cricketModel = arguments?.getParcelable<CricketModel>(TUTORIAL_KEY) as CricketModel
        val view = inflater.inflate(R.layout.info_view, container, false)
        view.findViewById<TextView>(R.id.tutorialName).text = cricketModel.name
        view.findViewById<TextView>(R.id.tutorialDesc).text = cricketModel.description
        Glide.with(activity).load(cricketModel.url).into(view.findViewById<ImageView>(R.id.snowFilterImage));
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tutorial = arguments?.getParcelable<CricketModel>(TUTORIAL_KEY) as CricketModel

        coroutineScope.launch (Dispatchers.Main) {

            val originalBitMap =  getOriginalBitmapAsync(tutorial)

            val snowFilterBitmap     =  loadSnowFilterAsync(originalBitMap)

            loadImage(snowFilterBitmap)
        }


    }


    private suspend fun getOriginalBitmapAsync(cricketModel: CricketModel) : Bitmap =
        withContext(Dispatchers.IO){
            URL(cricketModel.url).openStream().use {
                return@withContext BitmapFactory.decodeStream(it)
            }
        }


    private suspend fun loadSnowFilterAsync(originalBitmap: Bitmap) : Bitmap =
        withContext(Dispatchers.Default){
            SnowFilter.applySnowEffect(originalBitmap)
        }


    private fun loadImage(snowFilterBitmap : Bitmap)
    {
        progressBar.visibility = View.GONE
        snowFilterImage?.setImageBitmap(snowFilterBitmap)
    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()
    }
}