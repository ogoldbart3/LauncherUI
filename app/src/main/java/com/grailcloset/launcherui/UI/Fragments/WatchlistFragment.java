package com.grailcloset.launcherui.UI.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grailcloset.launcherui.R;

public class WatchlistFragment extends Fragment {


    public TextView watchlistFragmentTextViewLoggedIn;

    public WatchlistFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_watchlist, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        watchlistFragmentTextViewLoggedIn = (TextView) view.findViewById(R.id.watchlistFragmentLoggedInText);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}


