package sh.nomy.fossptv.fragments

import android.os.Bundle
import android.widget.Toast
import androidx.preference.EditTextPreference
import androidx.preference.PreferenceFragmentCompat
import sh.nomy.fossptv.R
import sh.nomy.fossptv.api.ptv.PtvClient

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)

        val fossPtvApiInstanceUrlPreference =
            findPreference<EditTextPreference>("fossptv_api_instance_url")

        fossPtvApiInstanceUrlPreference?.summary = fossPtvApiInstanceUrlPreference?.text

        fossPtvApiInstanceUrlPreference?.setOnPreferenceChangeListener { preference, newValue ->
            val url = newValue as? String

            if (!url.isNullOrEmpty() && url.endsWith('/')) {
                PtvClient.updateBaseUrl(url)
                preference.summary = url

                true
            } else {
                val context = requireContext()

                Toast.makeText(context, context.getString(R.string.invalid_url), Toast.LENGTH_SHORT)
                    .show()

                false
            }
        }
    }
}