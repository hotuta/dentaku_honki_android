package com.yokmama.learn10.chapter04.lesson16.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.yokmama.learn10.chapter04.lesson16.R;

/**
 * Created by yokmama on 15/02/19.
 */
public class ToggleButtonFragment extends Fragment {
    ToggleButton mToggleButton;
    TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_toggle_button, container, false);

        mTextView = (TextView) rootView.findViewById(R.id.textView);
        mToggleButton = (ToggleButton) rootView.findViewById(R.id.toggleButton1);
        mToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(getActivity(), "onCheckedChanged:" + isChecked, Toast.LENGTH_SHORT).show();
                updateText();
            }
        });

        updateText();

        return rootView;
    }


    private void updateText() {
        mTextView.setText("Toggle is " + mToggleButton.isChecked());
    }
}
