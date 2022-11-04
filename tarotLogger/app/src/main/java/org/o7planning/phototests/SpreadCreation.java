package org.o7planning.phototests;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SpreadCreation extends AppCompatActivity {

    private static final int RESULT_CODE = 0;

    private TextView description;
    private ImageView[] cardImages;
    private ImageView saveButton;
    private NumberPicker dateY;
    private NumberPicker dateM;
    private NumberPicker dateD;
    private EditText question;
    private TextView displayDate;
    private TextView displayQuestion;
    private EditText journalView;
    private ImageView journalButton;

    private String spreadID;
    private int layout;
    private int cardAmount;
    private int[] cards;
    private int currentImage = 0;

    @SuppressLint({"ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
        setData();

        cardImages = new ImageView[cardAmount];
        cards = new int[cardAmount];

        dateY = findViewById(R.id.editDateY);
        dateM = findViewById(R.id.editDateM);
        dateD = findViewById(R.id.editDateD);

        dateY.setMaxValue(99);
        dateY.setMinValue(0);
        dateY.setDisplayedValues(MainActivity.YearStrings);
        dateY.setBackgroundResource(R.drawable.number_picker_icon_border);

        dateM.setMaxValue(11);
        dateM.setMinValue(0);
        dateM.setDisplayedValues(MainActivity.MonthStrings);
        dateM.setBackgroundResource(R.drawable.number_picker_icon_border);

        dateD.setMaxValue(30);
        dateD.setMinValue(0);
        dateD.setDisplayedValues(MainActivity.DayStrings);
        dateD.setBackgroundResource(R.drawable.number_picker_icon_border);

        question = findViewById(R.id.editQuestion);
        question.setHint(StringManager.GetHints()[0]);
        displayDate = findViewById(R.id.displayDate);
        displayQuestion = findViewById(R.id.displayQuestion);
        journalView = findViewById(R.id.editJournalEntry);
        journalButton = findViewById(R.id.journal);

        // set images to choose tarot card
        for(int i = 0; i < cardAmount; i++){
            switch (i){
                case 0: cardImages[0] = findViewById(R.id.card1); break;
                case 1: cardImages[1] = findViewById(R.id.card2); break;
                case 2: cardImages[2] = findViewById(R.id.card3); break;
                case 3: cardImages[3] = findViewById(R.id.card4); break;
                case 4: cardImages[4] = findViewById(R.id.card5); break;
                case 5: cardImages[5] = findViewById(R.id.card6); break;
                case 6: cardImages[6] = findViewById(R.id.card7); break;
                case 7: cardImages[7] = findViewById(R.id.card8); break;
                case 8: cardImages[8] = findViewById(R.id.card9); break;
                case 9: cardImages[9] = findViewById(R.id.card10); break;
                case 10: cardImages[10] = findViewById(R.id.card11); break;
                case 11: cardImages[11] = findViewById(R.id.card12); break;
                case 12: cardImages[12] = findViewById(R.id.card13); break;
                case 13: cardImages[13] = findViewById(R.id.card14); break;
                case 14: cardImages[14] = findViewById(R.id.card15); break;
                case 15: cardImages[15] = findViewById(R.id.card16); break;
                case 16: cardImages[16] = findViewById(R.id.card17); break;
                case 17: cardImages[17] = findViewById(R.id.card18); break;
                case 18: cardImages[18] = findViewById(R.id.card19); break;
                case 19: cardImages[19] = findViewById(R.id.card20); break;
                case 20: cardImages[20] = findViewById(R.id.card21); break;
            }
        }
        for(int i = 0; i < cardAmount; i++){
            cardImages[i].setImageDrawable(MainActivity.GetDrawableIconByCardID(22));
            cards[i] = 22;
            int iFinal = i;
            cardImages[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentImage = iFinal;
                    openSelectCardPage();
                }
            });
        }

        // can't edit journal or keywords in creation view
        journalView.setVisibility(View.INVISIBLE);
        journalButton.setVisibility(View.INVISIBLE);
        displayDate.setVisibility(View.INVISIBLE);
        displayQuestion.setVisibility(View.INVISIBLE);

        saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i = 0; i < cardAmount; i++){
                    if(cards[i] == 22 || question.getText().toString().equalsIgnoreCase("")){
                        Toast toast = Toast.makeText(getApplicationContext(),"Layout Incomplete",Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    }
                }

                // init default data
                String[][] emptyKeywords = new String[cards.length][0];
                String emptyJournal = "";

                MainActivity.GetDataManager().addNewData(dateY.getDisplayedValues()[dateY.getValue()] + " / " + dateM.getDisplayedValues()[dateM.getValue()] +  " / " + dateD.getDisplayedValues()[dateD.getValue()], question.getText().toString(), spreadID, emptyJournal, cards, emptyKeywords);

                Toast toast = Toast.makeText(getApplicationContext(),"Saved", Toast.LENGTH_SHORT);
                toast.show();

                finish();
            }
        });
    }

    private void openSelectCardPage() {
        Intent intent = new Intent(this, CardSelection.class);
        intent.putExtra("selectFor", "spreadCreation"); // set to return tarot card id
        startActivityForResult(intent, RESULT_CODE);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data.hasExtra("cardIDReturn")){
            int cardIDReturn = data.getIntExtra("cardIDReturn", 0);
            if(cardIDReturn == 22) return;
            cards[currentImage] = cardIDReturn;
            cardImages[currentImage].setImageDrawable(MainActivity.GetDrawableByCardID(cardIDReturn));
        }
    }

    private void getData(){
        if(getIntent().hasExtra("spreadID")) {
            spreadID = getIntent().getStringExtra("spreadID");
            layout = getIntent().getIntExtra("layout", 0);
            cardAmount = getIntent().getIntExtra("cardAmount", 0);
        }
    }

    private void setData(){
        setContentView(layout);
        description = findViewById(R.id.spreadName);
        description.setText(StringManager.GetSpreadDisplayStringByID(spreadID));
    }

}