package com.grailcloset.launcherui.Model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by Oliver on 4/14/2015.
 */
public class Datamart {

    static Datamart instance;

    private Context cardListContext;
    private RecyclerView recyclerView;

    private ArrayList<Card> cards;

    public Datamart() {
        cards = new ArrayList<>();
    }

    public static Datamart getInstance() {
        if (instance == null) {
            if (instance == null || !(instance instanceof Datamart)) {
                instance = new Datamart();
            }
        }
        return instance;
    }

    public Context getCardListContext() {
        return cardListContext;
    }

    public void setCardListContext(Context cardListContext) {
        this.cardListContext = cardListContext;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
