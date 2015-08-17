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

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FragmentTab1 extends Fragment{


    @Bind(R.id.value)
    EditText value;

    private SharedPreferenceController pref = SharedPreferenceController.getInstance();

    @OnClick(R.id.apply)
    public void saveTab1() {
        Float f = getValueFromEditText(value);
        if (f != null) {
            pref.setQuantity((f.intValue()));
            MyApp.setUpdated(true);
        }
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
        View view = inflater.inflate(R.layout.tab1, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
