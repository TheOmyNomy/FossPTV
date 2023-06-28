package sh.nomy.fossptv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.preference.PreferenceManager
import com.google.android.material.navigation.NavigationView
import sh.nomy.fossptv.api.ptv.PtvClient

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

        val navigationHostFragment =
            supportFragmentManager.findFragmentById(R.id.navigation_host_fragment) as NavHostFragment

        val navigationController = navigationHostFragment.navController

        val navigationView: NavigationView = findViewById(R.id.drawer_layout)

        // Handle when an item in the hamburger menu is selected.
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.drawer_home -> {
                    navigationController.navigate(R.id.homeFragment)
                }

                R.id.drawer_search -> {
                    navigationController.navigate(R.id.searchFragment)
                }

                R.id.drawer_settings -> {
                    navigationController.navigate(R.id.settingsFragment)
                }

                R.id.drawer_about -> {
                    navigationController.navigate(R.id.aboutFragment)
                }
            }

            drawer.closeDrawer(GravityCompat.START)
            true
        }

        // Update the selected drawer item when the current fragment is changed by a
        // method other than the drawer itself (i.e. when the user navigates up / back).
        navigationController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {
                    navigationView.setCheckedItem(R.id.drawer_home)
                }

                R.id.searchFragment -> {
                    navigationView.setCheckedItem(R.id.drawer_search)
                }

                R.id.settingsFragment -> {
                    navigationView.setCheckedItem(R.id.drawer_settings)
                }

                R.id.aboutFragment -> {
                    navigationView.setCheckedItem(R.id.drawer_about)
                }
            }
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