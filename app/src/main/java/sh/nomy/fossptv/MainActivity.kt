package sh.nomy.fossptv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.preference.PreferenceManager
import com.google.android.material.navigation.NavigationView
import sh.nomy.fossptv.api.ptv.PtvClient
import sh.nomy.fossptv.fragments.AboutFragment
import sh.nomy.fossptv.fragments.HomeFragment
import sh.nomy.fossptv.fragments.SearchFragment
import sh.nomy.fossptv.fragments.SettingsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        val fossPtvApiInstanceUrl = sharedPreferences.getString(
            "fossptv_api_instance_url", getString(R.string.fossptv_api_instance_url_default)
        )!!

        PtvClient.updateBaseUrl(fossPtvApiInstanceUrl)

        // Use our own toolbar so we can customise it.
        val appBar: Toolbar = findViewById(R.id.app_bar)
        setSupportActionBar(appBar)

        drawer = findViewById(R.id.main_drawer_layout)

        // Add a drawer toggle (i.e. the hamburger menu) to the toolbar.
        val drawerToggle = ActionBarDrawerToggle(
            this, drawer, appBar, R.string.open_navigation_drawer, R.string.close_navigation_drawer
        )

        drawer.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        val navigationView: NavigationView = findViewById(R.id.drawer_layout)

        // Handle when an item in the hamburger menu is selected.
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.drawer_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, HomeFragment()).commit()
                }

                R.id.drawer_search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, SearchFragment()).commit()
                }

                R.id.drawer_settings -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, SettingsFragment()).commit()
                }

                R.id.drawer_about -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, AboutFragment()).commit()
                }
            }

            drawer.closeDrawer(GravityCompat.START)
            true
        }

        // Open the home fragment on launch.
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()

            navigationView.setCheckedItem(R.id.drawer_home)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
            return
        }

        super.onBackPressed()
    }
}