package com.baybaka.lievwp.android.config;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.baybaka.lievwp.android.MyApp;
import com.baybaka.lievwp.android.R;
import com.baybaka.lievwp.android.utils.SharedPreferenceController;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentTab2 extends Fragment{


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

    private EditText[] tab2EditFields;
    private SharedPreferenceController pref= SharedPreferenceController.getInstance();



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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab2, container, false);
        ButterKnife.bind(this, view);
        initArray();
        return view;
    }

    private void initArray() {
        tab2EditFields = new EditText[]{speedMin, speedMax, sizeMin, sizeMax, accelMin, accelMax, lifeMin, lifeMax};
    }

}
