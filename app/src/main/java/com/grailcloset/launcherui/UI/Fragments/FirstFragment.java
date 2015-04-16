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

public class FirstFragment extends Fragment {

    public TextView firstFragmentTextView;
    public Button firstFragmentButton;

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

        firstFragmentButton = (Button) view.findViewById(R.id.firstFragmentButton);
        firstFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Datamart.getInstance().getCards().add(new SimpleTextCard( "from first fragment" ));
                Datamart.getInstance().getRecyclerView().getAdapter().notifyDataSetChanged();
            }
        });
    }
}


