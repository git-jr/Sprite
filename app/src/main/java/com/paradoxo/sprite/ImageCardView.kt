package com.paradoxo.sprite

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.paradoxo.sprite.databinding.ImageCardViewBinding

class ImageCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var title: String? = null
    private var image: Drawable? = null

    private lateinit var binding: ImageCardViewBinding

    init {
        binding = ImageCardViewBinding.inflate(LayoutInflater.from(context), this, true)
        setLayout(attrs)
    }

    private fun setLayout(attrs: AttributeSet?) {
        attrs?.let { attributeSet ->

            val attributes = context.obtainStyledAttributes(
                attributeSet,
                R.styleable.ImageCardView
            )

            attributes.getResourceId(R.styleable.ImageCardView_titulo, 0).apply {
                if (this != 0) {
                    binding.title.text = context.getString(this)
                }
            }

            attributes.getResourceId(R.styleable.ImageCardView_imagem, 0).apply {
                if (this != 0) {
                    binding.imageView.setImageResource(this)
                }
            }

            attributes.getResourceId(R.styleable.ImageCardView_cor_titulo, 0).apply {
                if (this != 0) {
                    binding.title.setTextColor(context.getColor(this))
                }
            }

            attributes.recycle()
        }
    }


}
