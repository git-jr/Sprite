package com.paradoxo.sprite.home.fragments

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.paradoxo.sprite.databinding.FragmentTab1Binding
import kotlinx.coroutines.launch

class TabFragment1 : Fragment() {

    private lateinit var binding: FragmentTab1Binding

    private lateinit var viewModel: TabFragment1ViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentTab1Binding.inflate(layoutInflater)
        val imageCustomCardView = binding.imageCustomCardView
        val containerCard = binding.containerCard

        viewModel = ViewModelProvider(this)[TabFragment1ViewModel::class.java]
        val state = viewModel.uiState
        lifecycleScope.launch {
            state.collect {

            }
        }

        imageCustomCardView.setOnClickListener {
            binding.imageCustomCardView.animateRoundCorner()
        }


        containerCard.setOnClickListener {
            viewModel.setHeightScreen(binding.root.height)
            val currentPosition = imageCustomCardView.translationY
            val targetPosition =
                if (currentPosition == 0f) state.value.heighScreen.toFloat() else 0f

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
        fun newInstance() = TabFragment1()
    }
}
