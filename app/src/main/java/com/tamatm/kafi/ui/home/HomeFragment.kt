package com.tamatm.kafi.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.tamatm.kafi.databinding.FragmentHomeBinding
import android.view.Gravity
import android.graphics.Color
import androidx.cardview.widget.CardView
import android.graphics.drawable.GradientDrawable

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        // Customize each CardView
        customizeCardView(binding.cardView1, binding.textView1, "Box 1: Bottom Shadow", true)
        customizeCardViewWithGradients(binding.cardView2, binding.textView2, "Box 2: Inner Shadow / Gradient Background")
        customizeCardView(binding.cardView3, binding.textView3, "Box 3: Top Shadow", true, isTopShadow = true)

        return root
    }

    private fun customizeCardView(cardView: CardView, textView: TextView, text: String, hasShadow: Boolean, isTopShadow: Boolean = false) {
        // Set up the TextView
        textView.apply {
            this.text = text
            gravity = Gravity.CENTER
            setTextColor(Color.BLACK) // Ensure text is visible
        }

        // Customize the CardView
        cardView.apply {
            if (hasShadow) {
                setCardBackgroundColor(Color.WHITE)
                cardElevation = 20f // Increased elevation for more pronounced shadow
                translationY = if (isTopShadow) 3f else -3f // Shifts the shadow up or down slightly
            } else {
                setCardBackgroundColor(Color.TRANSPARENT)
                cardElevation = 0f
            }
        }
    }

    private fun customizeCardViewWithGradients(cardView: CardView, textView: TextView, text: String) {
        // Set up the TextView
        textView.apply {
            this.text = text
            gravity = Gravity.CENTER
            setTextColor(Color.BLACK)
        }

        // Create top gradient drawable
        val topGradient = GradientDrawable(
            GradientDrawable.Orientation.TOP_BOTTOM,
            intArrayOf(
                Color.argb(25, 0, 0, 0),  // Black with 10% opacity
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )

        // Create bottom gradient drawable (inverted)
        val bottomGradient = GradientDrawable(
            GradientDrawable.Orientation.BOTTOM_TOP,
            intArrayOf(
                Color.argb(25, 0, 0, 0),  // Black with 10% opacity
                Color.TRANSPARENT,
                Color.TRANSPARENT
            )
        )

        // Apply gradients to the gradient views
        binding.topGradientView.background = topGradient
        binding.bottomGradientView.background = bottomGradient

        // Customize the CardView
        cardView.apply {
            setCardBackgroundColor(Color.TRANSPARENT)
            cardElevation = 0f
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}