package com.grailcloset.launcherui.UI.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grailcloset.launcherui.R;

public class SecondFragment extends Fragment {


    public TextView secondFragmentTextView;

    public SecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        secondFragmentTextView = (TextView) view.findViewById(R.id.secondFragmentTextView);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}


