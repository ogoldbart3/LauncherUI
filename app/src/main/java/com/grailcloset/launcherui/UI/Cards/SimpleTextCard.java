package com.grailcloset.launcherui.UI.Cards;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grailcloset.launcherui.Model.Datamart;
import com.grailcloset.launcherui.R;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by Oliver on 4/14/2015.
 */
public class SimpleTextCard extends PowerCard {

    protected TextView mTitle;

    private String textString;

    public SimpleTextCard(String textString) {
        this(Datamart.getInstance().getCardListContext(), textString, true);
    }

    public SimpleTextCard(String textString, boolean canSwipe) {
        this(Datamart.getInstance().getCardListContext(), textString, canSwipe);
    }

    public SimpleTextCard(Context context, String textString, boolean canSwipe) {
        this(context, R.layout.layout_simple_text_card, textString, canSwipe);
    }

    public SimpleTextCard(Context context, int innerLayout, String textString, boolean canSwipe) {
        super(context, innerLayout, canSwipe);
        this.textString = textString;
        init();
    }


    private void init(){

    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        mTitle = (TextView) parent.findViewById(R.id.simpleTextCardTextView);
        mTitle.setText(textString);

    }
}