package com.baybaka.lievwp.android.config;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.baybaka.lievwp.android.R;

/**
 * A placeholder fragment containing a simple view.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ConfigActivityFragment extends Fragment {

    public ConfigActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_config, container, false);

        TabHost tabs = (TabHost) view.findViewById(R.id.tabHost);

        tabs.setup();

        TabHost.TabSpec spec = tabs.newTabSpec("tag1");

        spec.setContent(R.id.tab1);
        spec.setIndicator("Particle setup");
        tabs.addTab(spec);

        spec = tabs.newTabSpec("tag2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Particle behaviour");
        tabs.addTab(spec);


        tabs.setCurrentTab(0);
        return view;
    }
}
