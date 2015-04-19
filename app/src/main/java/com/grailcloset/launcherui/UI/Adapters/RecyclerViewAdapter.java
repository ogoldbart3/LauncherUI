package com.grailcloset.launcherui.UI.Adapters;

import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grailcloset.launcherui.R;
import com.grailcloset.launcherui.UI.Cards.PowerCard;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardViewNative;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ListItemViewHolder> {

    private ArrayList<PowerCard> items;
    private SparseBooleanArray selectedItems;

    public RecyclerViewAdapter(ArrayList<PowerCard> modelData) {
        if (modelData == null) {
            throw new IllegalArgumentException("modelData must not be null");
        }
        items = modelData;
        selectedItems = new SparseBooleanArray();
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.recycler_view_card_row, viewGroup, false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListItemViewHolder viewHolder, int position) {

        if ( viewHolder.cardView.getCard() == null ) {
            viewHolder.cardView.setCard(items.get(position));
        } else {
            viewHolder.cardView.replaceCard(items.get(position));
        }

        viewHolder.itemView.setActivated(selectedItems.get(position, false));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public final static class ListItemViewHolder extends RecyclerView.ViewHolder {
        CardViewNative cardView;

        public ListItemViewHolder(View itemView) {
            super(itemView);
            cardView = (CardViewNative) itemView.findViewById(R.id.cardView);
        }
    }
}