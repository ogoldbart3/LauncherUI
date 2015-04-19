package com.grailcloset.launcherui.UI.Cards;

import android.content.Context;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by Oliver on 4/19/2015.
 */
public class PowerCard extends Card {

    private boolean canSwipe;

//    public PowerCard(Context context, boolean swipeable) {
//        super(context);
//        this.swipeable = swipeable;
//    }

    public PowerCard(Context context, int innerLayout, boolean canSwipe) {
        super(context, innerLayout);
        this.canSwipe = canSwipe;
    }

    public boolean getCanSwipe() {
        return canSwipe;
    }

    public void setCanSwipe(boolean canSwipe) {
        this.canSwipe = canSwipe;
    }
}
