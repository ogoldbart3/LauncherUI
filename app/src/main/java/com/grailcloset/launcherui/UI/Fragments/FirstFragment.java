package com.grailcloset.launcherui.UI.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grailcloset.launcherui.R;

public class FirstFragment extends Fragment {


    public TextView firstFragmentTextView;

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firstFragmentTextView = (TextView) view.findViewById(R.id.firstFragmentTextView);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}


