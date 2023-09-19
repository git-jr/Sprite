package com.paradoxo.sprite

import android.animation.ValueAnimator
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.fragment.app.Fragment
import com.paradoxo.sprite.databinding.FragmentTab1Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TabFragment1.newInstance] factory method to
 * create an instance of this fragment.
 */
class TabFragment1 : Fragment() {

    private lateinit var binding: FragmentTab1Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentTab1Binding.inflate(layoutInflater)

        val imageCustomCardView = binding.imageCustomCardView

        imageCustomCardView.setOnClickListener {
            binding.imageCustomCardView.animateRoundCorner()
        }


        val containerCard = binding.containerCard
        containerCard.setOnClickListener {
            val currentHeight = binding.root.height / 2
            val currentPosition = imageCustomCardView.translationY
            val targetPosition = if (currentPosition == 0f) currentHeight.toFloat() else 0f

            val animator = ValueAnimator.ofFloat(currentPosition, targetPosition)
            animator.interpolator = AccelerateInterpolator()
            animator.duration = 500
            animator.addUpdateListener {
                imageCustomCardView.translationY = it.animatedValue as Float
            }

            animator.start()
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TabFragment1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}