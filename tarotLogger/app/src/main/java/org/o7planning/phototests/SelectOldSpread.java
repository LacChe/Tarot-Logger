package org.o7planning.phototests;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SelectOldSpread extends AppCompatActivity {

    private  RecyclerView selectSpreadWindow;
    DateStringRecyclerAdapter myAdapter;

    private String[] dates;
    private String[] questions;

    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_old_spread);
        selectSpreadWindow = findViewById(R.id.spreadSelection);

        questions = MainActivity.GetDataManager().getQuestions();
        dates = MainActivity.GetDataManager().getDates();

        myAdapter = new DateStringRecyclerAdapter//
            (this, dates, questions, MainActivity.GetDataManager().getSpreadIDs(), //
                    MainActivity.GetDataManager().getIcons(), MainActivity.GetDataManager().getLayouts(), //
                    MainActivity.GetDataManager().getCards(), MainActivity.GetDataManager().getKeywords(), //
                    MainActivity.GetDataManager().getLogs(), MainActivity.GetDataManager().getIDs());
        selectSpreadWindow.setAdapter(myAdapter);
        selectSpreadWindow.setLayoutManager(new LinearLayoutManager(this));

        title = findViewById(R.id.title);
        title.setText(StringManager.GetTitles()[1]);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        questions = MainActivity.GetDataManager().getQuestions();
        dates = MainActivity.GetDataManager().getDates();

        myAdapter = new DateStringRecyclerAdapter//
                (this, dates, questions, MainActivity.GetDataManager().getSpreadIDs(), //
                        MainActivity.GetDataManager().getIcons(), MainActivity.GetDataManager().getLayouts(), //
                        MainActivity.GetDataManager().getCards(), MainActivity.GetDataManager().getKeywords(), //
                        MainActivity.GetDataManager().getLogs(), MainActivity.GetDataManager().getIDs());
        selectSpreadWindow.setAdapter(myAdapter);
        selectSpreadWindow.setLayoutManager(new LinearLayoutManager(this));

        title = findViewById(R.id.title);
        title.setText(StringManager.GetTitles()[1]);
    }

}