package org.o7planning.phototests;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class KeywordDisplay extends AppCompatActivity {

    private static final int RESULT_CODE = 0;

    private RecyclerView keywordDisplay;
    private ImageView addKeyword;
    private ImageView saveButton;
    private TextView title;

    private String[] keywords;
    private int position;

    private int cardID;

    private KeywordStringRecyclerAdapter myAdapter = new KeywordStringRecyclerAdapter(this);

    private Intent keywordSelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_card_keyword_display);
        keywordDisplay = findViewById(R.id.cardKeywordDisplay);
        addKeyword = findViewById(R.id.addKeyword);
        saveButton = findViewById(R.id.save);
        title = findViewById(R.id.title);
        title.setText(StringManager.GetTitles()[2]);

        position = getIntent().getIntExtra("position", 0);
        cardID = getIntent().getIntExtra("cardID", 0);
        keywords = getIntent().getStringArrayExtra("keywords");

        // temp remove empty
        // keywords = removeEmpty(keywords);

        myAdapter.keywords = keywords;
        keywordDisplay.setAdapter(myAdapter);
        keywordDisplay.setLayoutManager(new LinearLayoutManager(this));

        keywordSelection = new Intent(this, KeywordSelectionPage.class);

        addKeyword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                keywordSelection.putExtra("cardID", cardID);
                startActivityForResult(keywordSelection, RESULT_CODE);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                keywords = myAdapter.keywords;
                Intent intentWithResult = new Intent();
                intentWithResult.putExtra("retKeywords", keywords);
                intentWithResult.putExtra("position", position);
                setResult(1, intentWithResult);
                finish();
            }
        });
    }

    private String[] removeEmpty(String[] keys) {
        String[] ret;

        int amount = 0;
        for(int i = 0; i < keys.length; i++) {
            if(keys[i] == " ") amount++;
        }

        ret = new String[keys.length - amount];

        int offset = 0;
        for(int i = 0; i < keys.length; i++) {
            if(keys[i] == " ") {
                offset++;
            }
            else ret[i - offset] = keys[i];
        }

        ret = new String[keys.length - amount];

        for(int i = 0; i < ret.length; i++) {
            Log.d("asdfafsdfdfssfe",ret[i]);
        }

        return ret;
    }

    @Override
    public void onBackPressed() {
        keywords = myAdapter.keywords;
        Intent intentWithResult = new Intent();
        intentWithResult.putExtra("retKeywords", keywords);
        intentWithResult.putExtra("position", position);
        setResult(1, intentWithResult);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        keywords = myAdapter.keywords;
        String newWord = data.getStringExtra("retKeyword");
        if(newWord == null || newWord.equals("")) {
            Log.d("error ",  "newWord null");
            return;
        }
        for(int i = 0; i < keywords.length; i++){
            if(newWord.equals(keywords[i])) return;
        }
        // get index to put
        int index = keywords.length;
        for(int i = 0; i < keywords.length; i++){
            if(newWord.compareTo(keywords[i]) == -1) {
                index = i;
                break;
            }
        }
        // add word
        String[] temp = new String[keywords.length + 1];
        temp[index] = newWord;
        for(int i = 0; i < keywords.length; i++){
            if(i < index) temp[i] = keywords[i];
            else temp[i + 1] = keywords[i];
        }
        keywords = temp;

        keywordDisplay = findViewById(R.id.cardKeywordDisplay);
        myAdapter = new KeywordStringRecyclerAdapter(this);
        myAdapter.keywords = keywords;
        keywordDisplay.setAdapter(myAdapter);
        keywordDisplay.setLayoutManager(new LinearLayoutManager(this));
    }

}