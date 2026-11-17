package com.ador.documentmanagement

import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private val blue = Color.rgb(21, 101, 192)
    private val dark = Color.rgb(30, 41, 59)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showDashboard()
    }

    private fun showDashboard() {

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.rgb(245, 247, 250))
            setPadding(20, 25, 20, 20)
        }

        val title = TextView(this).apply {
            text = "Document Management"
            textSize = 25f
            setTextColor(dark)
            gravity = Gravity.CENTER_VERTICAL
            setPadding(0, 15, 0, 20)
        }

        root.addView(title)

        val subtitle = TextView(this).apply {
            text = "ADOR Document Center"
            textSize = 15f
            setTextColor(Color.GRAY)
            setPadding(0, 0, 0, 25)
        }

        root.addView(subtitle)

        val features = listOf(
            "Word to PDF",
            "PDF Viewer",
            "PDF Merge",
            "PDF Split",
            "Document Scanner",
            "Document Create",
            "File Manager",
            "Share Document"
        )

        features.forEach { feature ->

            val button = Button(this).apply {
                text = feature
                textSize = 16f
                setTextColor(Color.WHITE)
                setBackgroundColor(blue)

                setOnClickListener {
                    Toast.makeText(
                        this@MainActivity,
                        "$feature - Coming Soon",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                58
            )

            params.setMargins(0, 0, 0, 12)

            root.addView(button, params)
        }

        val footer = TextView(this).apply {
            text = "Powered by ADOR"
            textSize = 13f
            gravity = Gravity.CENTER
            setTextColor(Color.GRAY)
            setPadding(0, 20, 0, 0)
        }

        root.addView(footer)

        val scrollView = ScrollView(this)
        scrollView.addView(root)

        setContentView(scrollView)
    }
}
