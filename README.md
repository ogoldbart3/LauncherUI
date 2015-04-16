# LauncherUI
Simple Android App UI based on Material Design, Cards, and the Google Play Launcher

Using code from:
krossovochkin's Android Swipe-to-Dismiss RecyclerView Sample Code
https://github.com/krossovochkin/Android-SwipeToDismiss-RecyclerView

gabrielemariotti's cardslib
https://github.com/gabrielemariotti/cardslib

Add new cards:

//Get the app's overarching data storage system, the Datamart.getInstance()
//Take the arrayList of Cards with .getCards()
//and add a new Card to the list
Datamart.getInstance().getCards().add(new SimpleTextCard( "from second fragment" ));

//Then notify the CardFragment's recyclerview that the dataset has changed
Datamart.getInstance().getRecyclerView().getAdapter().notifyDataSetChanged();



To create custom cards, extend Card and use CustomCard or SimpleTextCard as a template:

public class CustomCard extends Card {

    //Instances of all card UI elements
    protected TextView mTitle;

    //Instances of all card Data elements
    private String textString;

    //Use this constructor, it collects the correct Context from anywhere in the application
    public CustomCard(String textString) {
        this(Datamart.getInstance().getCardListContext(), textString);
    }

    public CustomCard(Context context, String textString) {
        this(context, R.layout.layout_custom_card, textString);
    }

    //Base-level constructor, make sure to assign your data instances in here
    public CustomCard(Context context, int innerLayout, String textString) {
        super(context, innerLayout);
        this.textString = textString;
    }

    //This method will actually set all your UI elements to involve your Data, aka setting onclicklisteners, images, text
    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {

        mTitle = (TextView) parent.findViewById(R.id.custom_card_text_view);
        mTitle.setText(textString);

    }
}
