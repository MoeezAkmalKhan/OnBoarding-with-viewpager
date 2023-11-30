package com.moeez.onboardingscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.ktech.onboardingscreen.R
import com.ktech.onboardingscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var sliderList: ArrayList<OnBoardingModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        onBoardingItems()

    }

    private fun onBoardingItems() {
        sliderList = ArrayList()

        sliderList.add(
            OnBoardingModel(
                onBoardingImage = R.drawable.download,
                title = "Title 1",
                description = "Description 1"
            )
        )
        sliderList.add(
            OnBoardingModel(
                onBoardingImage = R.drawable.download,
                title = "Title 2",
                description = "Description 2"
            )
        )
        sliderList.add(
            OnBoardingModel(
                onBoardingImage = R.drawable.download,
                title = "Title 3",
                description = "Description 3"
            )
        )

        sliderAdapter = SliderAdapter(this, sliderList)
        binding?.viewPager?.adapter = sliderAdapter
        binding?.viewPager?.addOnPageChangeListener(viewListener)

        binding?.getStartedBtn?.setOnClickListener {
            val current: Int = getItem(+1)
            if (current < sliderList.size) {
                // move to next screen
                binding?.viewPager?.currentItem = current
            } else {

            }
        }
        binding?.viewPager?.adapter = sliderAdapter
    }

    private fun getItem(i: Int): Int {
        return (binding?.viewPager?.currentItem ?: 0) + i
    }

    private var viewListener: ViewPager.OnPageChangeListener =
        object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int, positionOffset: Float, positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding?.tVSlideOne?.setTextColor(resources.getColor(R.color.white))
                        binding?.tVSlideTwo?.setTextColor(resources.getColor(R.color.grey))
                        binding?.tVSlideThree?.setTextColor(resources.getColor(R.color.grey))

                        binding?.getStartedBtn?.text = "Next"

                    }
                    1 -> {
                        binding?.tVSlideTwo?.setTextColor(resources.getColor(R.color.white))
                        binding?.tVSlideThree?.setTextColor(resources.getColor(R.color.grey))
                        binding?.tVSlideOne?.setTextColor(resources.getColor(R.color.grey))

                        binding?.getStartedBtn?.text = "Next"
                    }
                    else -> {
                        binding?.tVSlideOne?.setTextColor(resources.getColor(R.color.grey))
                        binding?.tVSlideTwo?.setTextColor(resources.getColor(R.color.grey))
                        binding?.tVSlideThree?.setTextColor(resources.getColor(R.color.white))

                        binding?.getStartedBtn?.text = "Get Started"
                    }
                }
            }

            // below method is use to check scroll state.
            override fun onPageScrollStateChanged(state: Int) {}
        }


}