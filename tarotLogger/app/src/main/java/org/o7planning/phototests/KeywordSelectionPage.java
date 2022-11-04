package org.o7planning.phototests;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class KeywordSelectionPage extends AppCompatActivity {

    private RecyclerView keywordSelectionDisplay;
    private TextView inputBox;
    private ImageView saveNewKeyword;

    private int cardID;

    private KeywordSelectionRecyclerAdapter myAdapter;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_keyword_selection_page);

        keywordSelectionDisplay = findViewById(R.id.oldKeywords);
        inputBox = findViewById(R.id.addNewKeyword);
        inputBox.setHint(StringManager.GetHints()[2]);
        saveNewKeyword = findViewById(R.id.save);

        cardID = getIntent().getIntExtra("cardID", 0);

        myAdapter = new KeywordSelectionRecyclerAdapter(this, cardID, inputBox);
        keywordSelectionDisplay.setAdapter(myAdapter);
        keywordSelectionDisplay.setLayoutManager(new LinearLayoutManager(this));

        saveNewKeyword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(inputBox.getText() != "") {
                    Intent intentWithResult = new Intent();
                    intentWithResult.putExtra("retKeyword", inputBox.getText() + "");
                    setResult(1, intentWithResult);
                    finish();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(inputBox.getText() != "") {
            Intent intentWithResult = new Intent();
            intentWithResult.putExtra("retKeyword", inputBox.getText() + "");
            setResult(1, intentWithResult);
            finish();
        }
    }

}