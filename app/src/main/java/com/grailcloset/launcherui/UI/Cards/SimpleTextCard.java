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
public class SimpleTextCard extends Card {

    protected TextView mTitle;

    private String textString;

    public SimpleTextCard(String textString) {
        this(Datamart.getInstance().getCardListContext(), textString);
    }

    public SimpleTextCard(Context context, String textString) {
        this(context, R.layout.layout_simple_text_card, textString);
    }

    public SimpleTextCard(Context context, int innerLayout, String textString) {
        super(context, innerLayout);
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