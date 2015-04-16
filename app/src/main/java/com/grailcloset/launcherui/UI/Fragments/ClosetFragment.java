package com.grailcloset.launcherui.UI.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grailcloset.launcherui.R;

public class ClosetFragment extends Fragment {


    public TextView closetFragmentTextViewLoggedIn;

    public ClosetFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_closet, container, false);

//        Datamart.getInstance().setContext( () );

        rootView.setTag("page2");
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        closetFragmentTextViewLoggedIn = (TextView) view.findViewById(R.id.closetFragmentLoggedInText);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}


