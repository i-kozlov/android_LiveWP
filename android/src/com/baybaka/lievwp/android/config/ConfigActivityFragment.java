package com.baybaka.lievwp.android.config;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baybaka.lievwp.android.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ConfigActivityFragment extends Fragment {

    public ConfigActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_config, container, false);
    }
}
