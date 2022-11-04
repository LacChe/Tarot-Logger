package org.o7planning.phototests;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SpreadView extends AppCompatActivity {

    private static final int RESULT_CODE = 0;

    private TextView description;
    private int[] cards;
    private ImageView[] cardImages;
    private int currentImage = 0;

    private ImageView saveButton;
    private NumberPicker dateY;
    private NumberPicker dateM;
    private NumberPicker dateD;
    private EditText question;
    private TextView displayDate;
    private TextView displayQuestion;

    private String spreadID;
    private String ques;
    private String dateString;
    private String logString;
    private int layout;
    private int cardAmount;
    private int id;
    private String[][] keywords;

    private EditText journalView;
    private ImageView journalButton;

    private Intent keywordIntent;

    @SuppressLint({"ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
        setData();

        keywordIntent = new Intent(this, KeywordDisplay.class);

        journalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(journalView.getVisibility() == View.VISIBLE){
                    journalView.setVisibility(View.INVISIBLE);
                    for(int i = 0; i < cardAmount; i++){
                        cardImages[i].setVisibility(View.VISIBLE);
                    }
                }
                else if(journalView.getVisibility() == View.INVISIBLE){
                    journalView.setVisibility(View.VISIBLE);
                    for(int i = 0; i < cardAmount; i++){
                        cardImages[i].setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.GetDataManager().setData(id, displayDate.getText().toString(), displayQuestion.getText().toString(), spreadID, journalView.getText() + "", cards, keywords);

                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        MainActivity.GetDataManager().setData(id, displayDate.getText().toString(), displayQuestion.getText().toString(), spreadID, journalView.getText() + "", cards, keywords);
        finish();
    }

    private void getData(){
        if(getIntent().hasExtra("spreadID") &&
                getIntent().hasExtra("question") &&
                getIntent().hasExtra("date") &&
                getIntent().hasExtra("layout") &&
                getIntent().hasExtra("cards") &&
                getIntent().hasExtra("keywords") &&
                getIntent().hasExtra("log") &&
                getIntent().hasExtra("id")) {
            spreadID = getIntent().getStringExtra("spreadID");
            ques = getIntent().getStringExtra("question");
            dateString = getIntent().getStringExtra("date");
            layout = getIntent().getIntExtra("layout", 0);
            cards = getIntent().getIntArrayExtra("cards");
            cardAmount = cards.length;
            Bundle bundle = getIntent().getExtras();
            logString = getIntent().getStringExtra("log");
            id = getIntent().getIntExtra("id", 0);
            keywords = (String[][]) bundle.getSerializable("keywords");
        }
    }

    @SuppressLint({"ClickableViewAccessibility", "UseCompatLoadingForDrawables"})
    private void setData() {
        setContentView(layout);
        description = findViewById(R.id.spreadName);
        description.setText(StringManager.GetSpreadDisplayStringByID(spreadID));

        cardImages = new ImageView[cardAmount];

        displayDate = findViewById(R.id.displayDate);
        displayDate.setText(dateString);
        displayQuestion = findViewById(R.id.displayQuestion);
        displayQuestion.setText(ques);

        journalView = findViewById(R.id.editJournalEntry);
        journalButton = findViewById(R.id.journal);
        journalView.setVisibility(View.INVISIBLE);
        journalView.setText(logString);
        journalView.setHint(StringManager.GetHints()[1]);
        journalView.setHorizontallyScrolling(false);
        journalView.setMaxLines(Integer.MAX_VALUE);

        question = findViewById(R.id.editQuestion);
        question.setText(ques);

        dateY = findViewById(R.id.editDateY);
        dateM = findViewById(R.id.editDateM);
        dateD = findViewById(R.id.editDateD);

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
            cardImages[i].setImageDrawable(MainActivity.GetDrawableByCardID(cards[i]));
            int iFinal = i;
            cardImages[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    keywordIntent.putExtra("keywords", keywords[iFinal]);
                    keywordIntent.putExtra("cardID", cards[iFinal]);
                    keywordIntent.putExtra("position", iFinal);
                    startActivityForResult(keywordIntent, RESULT_CODE);
                }
            });
        }

        dateY.setVisibility(View.INVISIBLE);
        dateM.setVisibility(View.INVISIBLE);
        dateD.setVisibility(View.INVISIBLE);
        question.setVisibility(View.INVISIBLE);
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "ClickableViewAccessibility"})
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String[] retKeywords = data.getStringArrayExtra("retKeywords");
        int position = data.getIntExtra("position", 0);
        keywords[position] = retKeywords;

        int pFinal = position;
        cardImages[position].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keywordIntent.putExtra("keywords", keywords[pFinal]);
                keywordIntent.putExtra("cardID", cards[pFinal]);
                keywordIntent.putExtra("position", pFinal);
                startActivityForResult(keywordIntent, RESULT_CODE);
            }
        });

        keywords[position] = retKeywords;
    }

}