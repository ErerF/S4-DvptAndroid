import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.appliworld.pizzeria.PizzeriaMainActivity;
import com.appliworld.pizzeria.R;

public class Pres extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Affichage à partir du fichier XML
        addPreferencesFromResource(R.xml.prefs);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        ((PizzeriaMainActivity) getActivity()).applyPref();
    }

    // Lancement de l'écouteur
    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    // Arrêt de l'écouteur
    @Override
    public void onPause() {
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }
}
