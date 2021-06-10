package com.parveendala.productscanner.ui.discover

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.parveendala.productscanner.R

private const val PRODUCT_ID = "AIR71826TUI"

class DiscoverFragment : Fragment() {

    private lateinit var discoverViewModel: DiscoverViewModel
    private lateinit var tvName: AppCompatTextView
    private lateinit var tvBrandName: AppCompatTextView
    private lateinit var tvRating: AppCompatTextView
    private lateinit var tvRatingCounts: AppCompatTextView
    private lateinit var tvOfferedPrice: AppCompatTextView
    private lateinit var tvActualPrice: AppCompatTextView
    private lateinit var tvOfferText: AppCompatTextView
    private lateinit var tvDescription: AppCompatTextView
    private lateinit var btnWishList: AppCompatImageView
    private lateinit var ivProductImage: AppCompatImageView
    private lateinit var tvColorSelector: MaterialAutoCompleteTextView
    private lateinit var tvSizeSelector: MaterialAutoCompleteTextView
    private lateinit var specificationContainer: LinearLayout

    private var wishListStatus = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        discoverViewModel = ViewModelProvider(this).get(DiscoverViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_discover, container, false)
        tvName = view.findViewById(R.id.tvProductName)
        tvBrandName = view.findViewById(R.id.tvBrandName)
        tvRating = view.findViewById(R.id.tvRating)
        tvOfferedPrice = view.findViewById(R.id.tvOfferedPrice)
        tvActualPrice = view.findViewById(R.id.tvActualPrice)
        tvOfferText = view.findViewById(R.id.tvOfferText)
        tvDescription = view.findViewById(R.id.tvDescription)
        btnWishList = view.findViewById(R.id.btnWishlist)
        ivProductImage = view.findViewById(R.id.ivProductImage)
        tvColorSelector = view.findViewById(R.id.tvColorSelector)
        tvSizeSelector = view.findViewById(R.id.tvSizeSelector)
        specificationContainer = view.findViewById(R.id.specificationContainer)
        btnWishList.setOnClickListener {
            btnWishList.setImageResource(if (wishListStatus) R.drawable.ic_wishlist_border_24 else R.drawable.ic_wishlist_24)
            wishListStatus = wishListStatus.not()
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        discoverViewModel.getProduct(PRODUCT_ID)?.let { product ->
            with(product) {
                tvName.text = name
                tvBrandName.text = brandName
                tvRating.text = "$rating Ratings"
                tvOfferedPrice.text = offeredPrice
                tvActualPrice.apply {
                    text = actualPrice
                    paintFlags = Paint.STRIKE_THRU_TEXT_FLAG;
                }
                tvOfferText.text = "($offerText)"
                tvDescription.text = description
                ivProductImage.setImageResource(image)
                colors.takeIf { it.isNotEmpty() }?.let { setColorView(it) }
                sizes.takeIf { it.isNotEmpty() }?.let { setSizeView(it) }
                specifications.takeIf { it.isNotEmpty() }?.forEach {
                    val specificationView = LayoutInflater.from(context).inflate(R.layout.layout_specification_list_item, null, false)
                    specificationView.findViewById<AppCompatTextView>(R.id.tvTitle).text = "${it.title}:"
                    specificationView.findViewById<AppCompatTextView>(R.id.tvValue).text = it.value
                    specificationContainer.addView(specificationView)
                }
            }
        }
    }

    private fun setColorView(colorList: List<String>) {
        tvColorSelector.apply {
            setText(colorList.first(), false)
            setAdapter(ArrayAdapter(tvColorSelector.context, R.layout.layout_color_selector_item, colorList))
            setOnClickListener { showDropDown() }
        }
    }

    private fun setSizeView(sizeList: List<String>) {
        tvSizeSelector.apply {
            setText(sizeList.first(), false)
            setAdapter(ArrayAdapter<String>(tvSizeSelector.context, R.layout.layout_color_selector_item, sizeList))
            setOnClickListener { showDropDown() }
        }
    }
}