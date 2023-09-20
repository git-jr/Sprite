package com.paradoxo.sprite.home.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.paradoxo.sprite.R
import com.paradoxo.sprite.databinding.FragmentTab2Binding
import com.paradoxo.sprite.home.CardScreenImageView
import com.paradoxo.sprite.home.ComposeMainActivity

class TabFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTab2Binding.inflate(inflater, container, false)

        binding.textViewTitle.setOnClickListener {
            startActivity(Intent(context, ComposeMainActivity::class.java))
        }

        val view = binding.root

        binding.composeView.apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {

                var changeCorner by remember {
                    mutableStateOf(true)
                }

                CardScreenImageView(
                    image = R.drawable.luffy,
                    text = "Fragmento 2",
                    textColor = R.color.white,
                    changeCorner = changeCorner,
                    onChangeCorner = {
                        changeCorner = !changeCorner
                    }
                )
            }
        }

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = TabFragment2()

    }
}
