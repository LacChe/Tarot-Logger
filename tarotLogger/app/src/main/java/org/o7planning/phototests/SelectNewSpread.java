package org.o7planning.phototests;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SelectNewSpread extends AppCompatActivity {

    private RecyclerView selectSpreadWindow;

    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_new_spread);
        selectSpreadWindow = findViewById(R.id.spreadSelection);

        // add custom spreads
        ImageStringRecyclerAdapter myAdapter = new ImageStringRecyclerAdapter(this, StringManager.GetDefaultSpreadIDs(), DataManager.icons, DataManager.layouts, DataManager.cardAmounts);
        selectSpreadWindow.setAdapter(myAdapter);
        selectSpreadWindow.setLayoutManager(new LinearLayoutManager(this));

        title = findViewById(R.id.title);
        title.setText(StringManager.GetTitles()[0]);
    }

}