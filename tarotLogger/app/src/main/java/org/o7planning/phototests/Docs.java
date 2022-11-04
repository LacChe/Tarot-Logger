package org.o7planning.phototests;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Docs extends AppCompatActivity {

    private TextView cards;
    private TextView spreads;
    private TextView other1;
    private TextView other2;

    private Intent cardSelection;
    // private Intent spreadDisplay;
    // private Intent other1;
    // private Intent other2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docs);

        initButtons();

        cardSelection = new Intent(this, CardSelection.class);
        cardSelection.putExtra("selectFor", "display"); // set intent to display tarot card
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initButtons(){
        cards = findViewById(R.id.cards);
        cards.setText(StringManager.GetResourcePageStrings()[0]);
        cards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage("cards");
            }
        });
        spreads = findViewById(R.id.spreads);
        spreads.setText(StringManager.GetResourcePageStrings()[1]);
        spreads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage("spreads");
            }
        });
        other1 = findViewById(R.id.other1);
        other1.setText(StringManager.GetResourcePageStrings()[2]);
        other1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage("other1");
            }
        });
        other2 = findViewById(R.id.other2);
        other2.setText(StringManager.GetResourcePageStrings()[3]);
        other2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage("other2");
            }
        });
    }

    public void changePage(String page) {
        switch(page){
            case"cards":
                startActivity(cardSelection);
                break;
            case"spreads":
                break;
            case"other1":
                break;
            case"other2":
                break;
            default:
                break;
        }
    }

}