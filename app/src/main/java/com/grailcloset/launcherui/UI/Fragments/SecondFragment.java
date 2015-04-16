package com.grailcloset.launcherui.UI.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.grailcloset.launcherui.Model.Datamart;
import com.grailcloset.launcherui.R;
import com.grailcloset.launcherui.UI.Cards.SimpleTextCard;

public class SecondFragment extends Fragment {

    public TextView secondFragmentTextView;
    public Button secondFragmentButton;

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
        secondFragmentButton = (Button) view.findViewById(R.id.secondFragmentButton);
        secondFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Datamart.getInstance().getCards().add(new SimpleTextCard( "from second fragment" ));
                Datamart.getInstance().getRecyclerView().getAdapter().notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}


