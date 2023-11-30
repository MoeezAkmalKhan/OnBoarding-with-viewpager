package com.moeez.onboardingscreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.ktech.onboardingscreen.R

class SliderAdapter(private val context: Context, private val sliderList: ArrayList<OnBoardingModel>)
    : PagerAdapter() {


    override fun getCount(): Int {
        // on below line we are returning
        // the size of slider list
        return sliderList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        // inside isViewFromobject method we are
        // returning our Relative layout object.
        return view === `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        // in this method we will initialize all our layout
        // items and inflate our layout file as well.
        val layoutInflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // below line is use to inflate the
        // layout file which we created.
        val view: View = layoutInflater.inflate(R.layout.slides_layout, container, false)

        // on below line we are initializing our image view,
        // heading text view and description text view with their ids.
        val sliderImage: ImageView = view.findViewById(R.id.slider_image)
        val sliderHeadingTV: TextView = view.findViewById(R.id.slider_heading)
        val sliderDescTV: TextView = view.findViewById(R.id.slider_desc)

        // on below line we are setting data to our text view
        // and image view on below line.
        val sliderData: OnBoardingModel = sliderList[position]
        sliderHeadingTV.text = sliderData.title
        sliderDescTV.text = sliderData.description
        sliderImage.setImageResource(sliderData.onBoardingImage)

        // on below line we are adding our view to container.
        container.addView(view)

        // on below line we are returning our view.
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // this is a destroy view method
        // which is use to remove a view.
        container.removeView(`object` as ConstraintLayout)
    }

}