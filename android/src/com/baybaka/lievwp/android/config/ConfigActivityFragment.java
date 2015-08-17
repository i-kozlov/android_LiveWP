package com.baybaka.lievwp.android.config;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TabHost;

import com.baybaka.lievwp.android.MyApp;
import com.baybaka.lievwp.android.R;
import com.baybaka.lievwp.android.utils.SharedPreferenceController;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class ConfigActivityFragment extends Fragment {

    @Bind(R.id.value)
    EditText value;

    @Bind(R.id.speed_min)
    EditText speedMin;

    @Bind(R.id.speed_max)
    EditText speedMax;

    @Bind(R.id.size_min)
    EditText sizeMin;

    @Bind(R.id.size_max)
    EditText sizeMax;

    @Bind(R.id.acceleration_min)
    EditText accelMin;

    @Bind(R.id.acceleration_max)
    EditText accelMax;

    @Bind(R.id.lifetime_min)
    EditText lifeMin;

    @Bind(R.id.lifetime_max)
    EditText lifeMax;

    private EditText[] tab2EditFields = new EditText[]{speedMin, speedMax, sizeMin, sizeMax, accelMin, accelMax, lifeMin, lifeMax};
    private SharedPreferenceController pref;

    @OnClick(R.id.apply)
    public void saveTab1() {
        Float f = getValueFromEditText(value);
        if (f != null) {
            pref.setQuantity((f.intValue()));
            MyApp.setUpdated(true);
        }
    }

    @OnClick(R.id.apply2)
    public void saveTab2() {
        List<Float> fieldValues = new ArrayList<>(tab2EditFields.length);
        for (EditText e : tab2EditFields) {
            fieldValues.add(getValueFromEditText(e));
        }
        pref.updateTab2(fieldValues);
        MyApp.setUpdated(true);
    }

    private Float getValueFromEditText(EditText input) {
        Float result = null;
        try {
            result = Float.parseFloat(input.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ConfigActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        pref = SharedPreferenceController.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_config, container, false);
        ButterKnife.bind(this, view);

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
