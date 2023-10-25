package com.example.myportfolioapp


import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.GravityCompat
import com.example.myportfolioapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding?.root
        setContentView(view)
        val scrollView = binding?.mainview


        //setting the result of class 10 inside the progressbar
        binding?.Progressbar1?.apply {
            progressMax = 100f
            setProgressWithAnimation(75f,1500)
            progressBarWidth = 5f
            val progressColor = ContextCompat.getColor(context, R.color.box)

            progressBarColor = progressColor
            roundBorder = true

        }

        //setting the result of class 12 inside a progress bar

        binding?.Progressbar2?.apply {
            progressMax = 100f
            setProgressWithAnimation(91f,1800)
            progressBarWidth = 5f
            val progressColor = ContextCompat.getColor(context, R.color.box)

            progressBarColor = progressColor
            roundBorder = true


        }




        binding!!.menuBar.setOnClickListener {
                view ->
            // Create a PopupMenu, specifying the anchor view and the menu resource.
            val popupMenu = PopupMenu(this, view)
            popupMenu.menuInflater.inflate(R.menu.menu_navigation, popupMenu.menu)

            // Set an item click listener for the popup menu.
            popupMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.nav_item1 -> {
                        scrollView?.smoothScrollTo(0, findViewById<View>(R.id.homePageSection).top)
                        true
                    }
                    R.id.nav_item2 -> {
                        scrollView?.smoothScrollTo(0, findViewById<View>(R.id.AboutMeSection).top)
                        true
                    }
                    R.id.nav_item3 -> {
                        scrollView?.smoothScrollTo(0, findViewById<View>(R.id.Skills).top)
                        true
                    }

                    R.id.nav_item4 -> {
                        scrollView?.smoothScrollTo(0, findViewById<View>(R.id.Projects).top)
                        true
                    }
                    R.id.nav_item6 -> {
                        scrollView?.smoothScrollTo(0, findViewById<View>(R.id.ContactDetails).top)
                        true
                    }
                    R.id.Resume -> {
                        scrollView?.smoothScrollTo(0, findViewById<View>(R.id.ContactDetails).top)
                        true
                    }

                    else -> false
                }
            }

            // Show the popup menu.
            popupMenu.show()// Opens the navigation drawer from the end (right side)
        }

        val textView = findViewById<TextView>(R.id.project1)
        textView.text = Html.fromHtml(getString(R.string.mathforfun), Html.FROM_HTML_MODE_LEGACY)

        val textView2 = findViewById<TextView>(R.id.project2)
        textView2.text = Html.fromHtml(getString(R.string.mathforfun), Html.FROM_HTML_MODE_LEGACY)

        //code for get in touch button

        binding?.getintouch?.setOnClickListener {
            openWhatsAppToContact()
        }

        binding?.linkedin?.setOnClickListener {
            openLinkedinToContact()
        }
        binding?.git?.setOnClickListener {
            opengithubLink()
        }
        binding?.mailmebtn?.setOnClickListener {
            opengmailLink()
        }
        binding?.whatsapp?.setOnClickListener {
            openWhatsAppToContact()
        }
    }

    private fun opengmailLink() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"

        // Add the recipient's email address
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("rudresh.patel0707@gmail.com"))


        // Use Intent.createChooser to let the user choose an email client
        startActivity(Intent.createChooser(intent, "Send Email"))

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            // Handle the case where no app can handle the intent (optional).
            // You can display a message or perform another action here.
            // For example, showing a toast message.
            Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show()
        }
    }

    private fun opengithubLink() {

        val url = "https://github.com/Rudresh07"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)

    }



    private fun openWhatsAppToContact() {

        // Replace with the recipient's phone number (including the country code)
        val phoneNumber = "+916307934948"
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber")

        startActivity(intent)

    }

    private fun openLinkedinToContact() {

        val linkedInAppProfileUrl = "linkedin://profile/rudresh-patel-559376224"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedInAppProfileUrl))

        // Check if the LinkedIn app is installed and can handle the intent
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            // If the LinkedIn app is not installed, you can provide an alternative action, like opening the LinkedIn website.
            val webProfileUrl = "https://www.linkedin.com/in/rudresh-patel-559376224/"
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(webProfileUrl))
            startActivity(webIntent)
        }





    }

}