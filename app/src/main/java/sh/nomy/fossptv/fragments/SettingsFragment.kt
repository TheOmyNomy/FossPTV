package sh.nomy.fossptv.fragments

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import sh.nomy.fossptv.R

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
    }
}