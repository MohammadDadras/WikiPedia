package com.example.wikipedia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragment.Explore_Fragment
import com.example.wikipedia.fragment.Photographer_Fragment
import com.example.wikipedia.fragment.Profile_Fragment
import com.example.wikipedia.fragment.Trend_Fragment
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.mainToolbar)


        val actionBarDrawerToggle = ActionBarDrawerToggle(

            this,
            binding.mainDrawerLayout,
            binding.mainToolbar,
            R.string.drawer_open,
            R.string.drawer_close
        )

        binding.mainDrawerLayout.addDrawerListener(actionBarDrawerToggle)

        actionBarDrawerToggle.syncState()
        binding.mainNavigationView.setNavigationItemSelectedListener {

            when (it.itemId) {


                R.id.writer_menu -> {

                    binding.mainDrawerLayout.closeDrawer(GravityCompat.START)

//                    val dialog = SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
//                    dialog.titleText = "Alert!"
//                    dialog.confirmText = "Confirm"
//                    dialog.cancelText = "Cancel"
//                    dialog.contentText = "Wanna be a Writer?"
//
//                    dialog.setCancelClickListener {
//
//                        dialog.dismiss()
//                    }

//                    dialog.setConfirmClickListener {
//
//                        dialog.dismiss()
//                        Toast.makeText(this,"You can be a writer",Toast.LENGTH_SHORT).show()
//                    }

                }

                R.id.translate_menu -> {

                    val intent = Intent(this, MainActivity3::class.java)
                    startActivity(intent)

                }

                R.id.photographer_menu -> {

                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.add(R.id.frame_main_container, Photographer_Fragment())
                    transaction.addToBackStack(null)
                    transaction.commit()

                    // check menu item =>
                    binding.mainNavigationView.menu.getItem(1).isChecked = true

                    // closedrawer =>
                    binding.mainDrawerLayout.closeDrawer(GravityCompat.START)

                }

                R.id.vidio_maker_menu -> {

                    Snackbar.make(binding.root, "You Can Create Vidio", Snackbar.LENGTH_LONG)
                        .setAction("Retry") {


                        }.setBackgroundTint(ContextCompat.getColor(this, R.color.blue))
                        .setActionTextColor(ContextCompat.getColor(this, R.color.blue)).show()

                }


                //.....................

                R.id.open_wikimedia_menu -> {


                    openWebsite("https://www.wikimedia.org/")
                }

                R.id.open_wikipedia_menu -> {


                    openWebsite("https://en.wikipedia.org/wiki/Wiki")
                }
            }

            true
        }

        firstRun()
        binding.mainNavigationBottom.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.explore_menu -> {

                    replaceFragment(Explore_Fragment())

                }

                R.id.trend_menu -> {

                    replaceFragment(Trend_Fragment())
                }

                R.id.profile_menu -> {

                    replaceFragment(Profile_Fragment())
                }
            }

            binding.mainNavigationView.menu.getItem(1).isChecked = false

            true
        }


        //for dont reload fragment with change bottom navigation
        binding.mainNavigationBottom.setOnItemReselectedListener { }



    }

   private fun replaceFragment(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.commit()


    }

    private fun firstRun() {
        replaceFragment(Explore_Fragment())

        binding.mainNavigationBottom.selectedItemId = R.id.explore_menu
    }

    override fun onBackPressed() {
        super.onBackPressed()

        //check menu item off =>

        binding.mainNavigationView.menu.getItem(1).isChecked = false


    }

    private fun openWebsite(url: String) {

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.exit_menu -> {

                onBackPressed()
            }

        }
        return true
    }
}

