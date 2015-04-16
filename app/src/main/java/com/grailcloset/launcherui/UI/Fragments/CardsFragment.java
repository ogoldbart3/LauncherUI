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

        Datamart.getInstance().setRecyclerView( (RecyclerView) view.findViewById(R.id.myList) );
        Datamart.getInstance().getRecyclerView().setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        Datamart.getInstance().getRecyclerView().setLayoutManager(llm);

        if ( Datamart.getInstance().getCards().size() == 0 ) {
            Datamart.getInstance().getCards().add(new SimpleTextCard( "Example first card.  Swipe right to remove." ));
        }

        Datamart.getInstance().getRecyclerView().setAdapter( new RecyclerViewAdapter(Datamart.getInstance().getCards()) );

        SwipeDismissRecyclerViewTouchListener touchListener =
                new SwipeDismissRecyclerViewTouchListener(
                        Datamart.getInstance().getRecyclerView(),
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
                                Datamart.getInstance().getRecyclerView().getAdapter().notifyDataSetChanged();
                            }
                        });
        Datamart.getInstance().getRecyclerView().setOnTouchListener(touchListener);
        Datamart.getInstance().getRecyclerView().setOnScrollListener(touchListener.makeScrollListener());
    }
}


