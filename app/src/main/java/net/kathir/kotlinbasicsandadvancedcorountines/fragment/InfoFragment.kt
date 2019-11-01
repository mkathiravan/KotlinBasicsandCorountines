package net.kathir.kotlinbasicsandadvancedcorountines.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import net.kathir.kotlinbasicsandadvancedcorountines.R
import net.kathir.kotlinbasicsandadvancedcorountines.model.InfoModel

class InfoFragment : Fragment()
{

    companion object
    {
        const val TUTORIAL_KEY = "INFO"

        fun newInstance(infoModel: InfoModel) : InfoFragment
        {
            val fragmentHome = InfoFragment()
            val args = Bundle()
            args.putParcelable(TUTORIAL_KEY, infoModel)
            fragmentHome.arguments = args
            return fragmentHome

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val infoModel = arguments?.getParcelable<InfoModel>(TUTORIAL_KEY) as InfoModel
        val view = inflater.inflate(R.layout.info_view, container, false)
        view.findViewById<TextView>(R.id.tutorialName).text = infoModel.name
        view.findViewById<TextView>(R.id.tutorialDesc).text = infoModel.description
        Glide.with(activity).load(infoModel.url).into(view.findViewById<ImageView>(R.id.snowFilterImage));
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tutorial = arguments?.getParcelable<InfoModel>(TUTORIAL_KEY) as InfoModel
    }



}