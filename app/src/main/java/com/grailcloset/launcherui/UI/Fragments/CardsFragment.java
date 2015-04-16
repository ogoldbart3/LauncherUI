package com.grailcloset.launcherui.UI.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grailcloset.launcherui.Model.Datamart;
import com.grailcloset.launcherui.R;
import com.grailcloset.launcherui.UI.Adapters.RecyclerViewAdapter;
import com.grailcloset.launcherui.UI.Cards.SimpleTextCard;
import com.grailcloset.launcherui.UI.Listeners.SwipeDismissRecyclerViewTouchListener;

public class CardsFragment extends Fragment {

    RecyclerViewAdapter adapter;
    RecyclerView recyclerView;

    public CardsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cards, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Datamart.getInstance().setCardListContext(view.getContext());

        recyclerView = (RecyclerView) view.findViewById(R.id.myList);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        if ( Datamart.getInstance().getCards().size() == 0 ) {
            for (byte i = 0; i < 10; i++) {
                Datamart.getInstance().getCards().add(new SimpleTextCard( "helloooo " + i));
            }
        }

        adapter = new RecyclerViewAdapter(Datamart.getInstance().getCards());
        recyclerView.setAdapter(adapter);

        SwipeDismissRecyclerViewTouchListener touchListener =
                new SwipeDismissRecyclerViewTouchListener(
                        recyclerView,
                        new SwipeDismissRecyclerViewTouchListener.DismissCallbacks() {
                            @Override
                            public boolean canDismiss(int position) {
                                return true;
                            }

                            @Override
                            public void onDismiss(RecyclerView recyclerView, int[] reverseSortedPositions) {
                                for (int position : reverseSortedPositions) {
                                    Datamart.getInstance().getCards().remove(position);
                                }
                                // do not call notifyItemRemoved for every item, it will cause gaps on deleting items
                                adapter.notifyDataSetChanged();

                            }
                        });
        recyclerView.setOnTouchListener(touchListener);
        recyclerView.setOnScrollListener(touchListener.makeScrollListener());
    }
}

