package com.example.testjdsapp.fonts

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import com.example.testjdsapp.R
import com.facebook.react.common.assets.ReactFontManager

object CustomFontAssetManager {
    
    fun registerFonts(context: Context) {
        // Register RubikStorm font family from res/font
        // Try both approaches: XML font family and direct Typeface
        try {
            // Method 1: Register using XML font family resource
            ReactFontManager.getInstance().addCustomFont(context, "RubikStorm", R.font.rubik_storm)
            Log.d("CustomFontManager", "Successfully registered font via XML: RubikStorm")
        } catch (e: Exception) {
            Log.e("CustomFontManager", "Failed to register font via XML, trying Typeface", e)
            // Method 2: Fallback - load Typeface directly and register
            try {
                val typeface = ResourcesCompat.getFont(context, R.font.rubik_storm_regular)
                if (typeface != null) {
                    ReactFontManager.getInstance().addCustomFont("RubikStorm", typeface)
                    Log.d("CustomFontManager", "Successfully registered font via Typeface: RubikStorm")
                } else {
                    Log.e("CustomFontManager", "Failed to load Typeface from resource")
                }
            } catch (e2: Exception) {
                Log.e("CustomFontManager", "Failed to register font via Typeface", e2)
            }
        }
    }
}
