package org.o7planning.phototests;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static Context mContext;

    private ImageView newSpread;
    private TextView oldSpread;
    private TextView docs;
    private ImageView settings;

    private ImageView card;

    private Intent selectNewSpread;
    private Intent selectOldSpread;
    private Intent docsPage;
    private Intent settingsPage;
    private Intent cardSelection;

    private static DataManager dataManager;

    public static String[] YearStrings;
    public static String[] MonthStrings;
    public static String[] DayStrings;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;

        setContentView(R.layout.activity_main);
        dataManager = new DataManager();

        initButtons();

        card = findViewById(R.id.card);

        int id = 22;
        do {
            id = (int)(Math.random()*78);
        } while (id == 22);
        card.setImageDrawable(GetDrawableByCardID(id));

        selectNewSpread = new Intent(this, SelectNewSpread.class);
        selectOldSpread = new Intent(this, SelectOldSpread.class);
        docsPage = new Intent(this, Docs.class);
        settingsPage = new Intent(this, Settings.class);
        cardSelection = new Intent(this, CardSelection.class);
        cardSelection.putExtra("selectFor", "display"); // set intent to display tarot card
    }

    public static DataManager GetDataManager() {
        if(dataManager == null) dataManager = new DataManager();
        return dataManager;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initButtons(){

        // temp init
        YearStrings = new String[100];
        MonthStrings = new String[12];
        DayStrings = new String[31];
        for(int i = 0; i < 100; i++){
            YearStrings[i] = (2000 + i) + "";
        }
        for(int i = 1; i <= 12; i++){
            if(i < 10) MonthStrings[i-1] = "0" + i;
            else MonthStrings[i-1] = "" + i;
        }
        for(int i = 1; i <= 31; i++){
            if(i < 10) DayStrings[i-1] = "0" + i;
            else DayStrings[i-1] = "" + i;
        }

        newSpread = findViewById(R.id.newSpread);
        newSpread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage("newSpread");
            }
        });
        oldSpread = findViewById(R.id.oldSpread);
        oldSpread.setText(StringManager.GetMainPageStrings()[0]);
        oldSpread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage("oldSpread");
            }
        });
        docs = findViewById(R.id.docs);
        docs.setText(StringManager.GetResourcePageStrings()[0]); // set to card text
        docs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage("cards");
            } // set to card page
        });
        settings = findViewById(R.id.settings);
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage("settings");
            }
        });
    }

    public void changePage(String page) {
        switch(page){
            case"newSpread":
                startActivity(selectNewSpread);
                break;
            case"oldSpread":
                startActivity(selectOldSpread);
                break;
            case"docs":
                startActivity(docsPage);
                break;
            case"cards":
                startActivity(cardSelection);
                break;
            case"settings":
                startActivity(settingsPage);
                break;
            default:
                break;
        }
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            mContext = this;

            initButtons();

            int id = 22;
            do {
                id = (int)(Math.random()*78);
            } while (id == 22);
            card.setImageDrawable(GetDrawableByCardID(id));
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public static Drawable GetDrawableIconByCardID(int cardID){
        switch(cardID) {
            case 0: return mContext.getResources().getDrawable(R.drawable.atu00_icon);
            case 1: return mContext.getResources().getDrawable(R.drawable.atu01_icon);
            case 2: return mContext.getResources().getDrawable(R.drawable.atu02_icon);
            case 3: return mContext.getResources().getDrawable(R.drawable.atu03_icon);
            case 4: return mContext.getResources().getDrawable(R.drawable.atu04_icon);
            case 5: return mContext.getResources().getDrawable(R.drawable.atu05_icon);
            case 6: return mContext.getResources().getDrawable(R.drawable.atu06_icon);
            case 7: return mContext.getResources().getDrawable(R.drawable.atu07_icon);
            case 8: return mContext.getResources().getDrawable(R.drawable.atu08_icon);
            case 9: return mContext.getResources().getDrawable(R.drawable.atu09_icon);
            case 10: return mContext.getResources().getDrawable(R.drawable.atu10_icon);
            case 11: return mContext.getResources().getDrawable(R.drawable.atu11_icon);
            case 12: return mContext.getResources().getDrawable(R.drawable.atu12_icon);
            case 13: return mContext.getResources().getDrawable(R.drawable.atu13_icon);
            case 14: return mContext.getResources().getDrawable(R.drawable.atu14_icon);
            case 15: return mContext.getResources().getDrawable(R.drawable.atu15_icon);
            case 16: return mContext.getResources().getDrawable(R.drawable.atu16_icon);
            case 17: return mContext.getResources().getDrawable(R.drawable.atu17_icon);
            case 18: return mContext.getResources().getDrawable(R.drawable.atu18_icon);
            case 19: return mContext.getResources().getDrawable(R.drawable.atu19_icon);
            case 20: return mContext.getResources().getDrawable(R.drawable.atu20_icon);
            case 21: return mContext.getResources().getDrawable(R.drawable.atu21_icon);
            case 22: return mContext.getResources().getDrawable(R.drawable.back_icon);
            case 23: return mContext.getResources().getDrawable(R.drawable.fire01_icon);
            case 24: return mContext.getResources().getDrawable(R.drawable.fire02_icon);
            case 25: return mContext.getResources().getDrawable(R.drawable.fire03_icon);
            case 26: return mContext.getResources().getDrawable(R.drawable.fire04_icon);
            case 27: return mContext.getResources().getDrawable(R.drawable.fire05_icon);
            case 28: return mContext.getResources().getDrawable(R.drawable.fire06_icon);
            case 29: return mContext.getResources().getDrawable(R.drawable.fire07_icon);
            case 30: return mContext.getResources().getDrawable(R.drawable.fire08_icon);
            case 31: return mContext.getResources().getDrawable(R.drawable.fire09_icon);
            case 32: return mContext.getResources().getDrawable(R.drawable.fire10_icon);
            case 33: return mContext.getResources().getDrawable(R.drawable.fire11_icon);
            case 34: return mContext.getResources().getDrawable(R.drawable.fire12_icon);
            case 35: return mContext.getResources().getDrawable(R.drawable.fire13_icon);
            case 36: return mContext.getResources().getDrawable(R.drawable.fire14_icon);
            case 37: return mContext.getResources().getDrawable(R.drawable.water01_icon);
            case 38: return mContext.getResources().getDrawable(R.drawable.water02_icon);
            case 39: return mContext.getResources().getDrawable(R.drawable.water03_icon);
            case 40: return mContext.getResources().getDrawable(R.drawable.water04_icon);
            case 41: return mContext.getResources().getDrawable(R.drawable.water05_icon);
            case 42: return mContext.getResources().getDrawable(R.drawable.water06_icon);
            case 43: return mContext.getResources().getDrawable(R.drawable.water07_icon);
            case 44: return mContext.getResources().getDrawable(R.drawable.water08_icon);
            case 45: return mContext.getResources().getDrawable(R.drawable.water09_icon);
            case 46: return mContext.getResources().getDrawable(R.drawable.water10_icon);
            case 47: return mContext.getResources().getDrawable(R.drawable.water11_icon);
            case 48: return mContext.getResources().getDrawable(R.drawable.water12_icon);
            case 49: return mContext.getResources().getDrawable(R.drawable.water13_icon);
            case 50: return mContext.getResources().getDrawable(R.drawable.water14_icon);
            case 51: return mContext.getResources().getDrawable(R.drawable.air01_icon);
            case 52: return mContext.getResources().getDrawable(R.drawable.air02_icon);
            case 53: return mContext.getResources().getDrawable(R.drawable.air03_icon);
            case 54: return mContext.getResources().getDrawable(R.drawable.air04_icon);
            case 55: return mContext.getResources().getDrawable(R.drawable.air05_icon);
            case 56: return mContext.getResources().getDrawable(R.drawable.air06_icon);
            case 57: return mContext.getResources().getDrawable(R.drawable.air07_icon);
            case 58: return mContext.getResources().getDrawable(R.drawable.air08_icon);
            case 59: return mContext.getResources().getDrawable(R.drawable.air09_icon);
            case 60: return mContext.getResources().getDrawable(R.drawable.air10_icon);
            case 61: return mContext.getResources().getDrawable(R.drawable.air11_icon);
            case 62: return mContext.getResources().getDrawable(R.drawable.air12_icon);
            case 63: return mContext.getResources().getDrawable(R.drawable.air13_icon);
            case 64: return mContext.getResources().getDrawable(R.drawable.air14_icon);
            case 65: return mContext.getResources().getDrawable(R.drawable.earth01_icon);
            case 66: return mContext.getResources().getDrawable(R.drawable.earth02_icon);
            case 67: return mContext.getResources().getDrawable(R.drawable.earth03_icon);
            case 68: return mContext.getResources().getDrawable(R.drawable.earth04_icon);
            case 69: return mContext.getResources().getDrawable(R.drawable.earth05_icon);
            case 70: return mContext.getResources().getDrawable(R.drawable.earth06_icon);
            case 71: return mContext.getResources().getDrawable(R.drawable.earth07_icon);
            case 72: return mContext.getResources().getDrawable(R.drawable.earth08_icon);
            case 73: return mContext.getResources().getDrawable(R.drawable.earth09_icon);
            case 74: return mContext.getResources().getDrawable(R.drawable.earth10_icon);
            case 75: return mContext.getResources().getDrawable(R.drawable.earth11_icon);
            case 76: return mContext.getResources().getDrawable(R.drawable.earth12_icon);
            case 77: return mContext.getResources().getDrawable(R.drawable.earth13_icon);
            case 78: return mContext.getResources().getDrawable(R.drawable.earth14_icon);
        }
        return null;
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public static Drawable GetDrawableByCardID(int cardID){
        switch(cardID) {
            case 0: return mContext.getResources().getDrawable(R.drawable.atu00);
            case 1: return mContext.getResources().getDrawable(R.drawable.atu01);
            case 2: return mContext.getResources().getDrawable(R.drawable.atu02);
            case 3: return mContext.getResources().getDrawable(R.drawable.atu03);
            case 4: return mContext.getResources().getDrawable(R.drawable.atu04);
            case 5: return mContext.getResources().getDrawable(R.drawable.atu05);
            case 6: return mContext.getResources().getDrawable(R.drawable.atu06);
            case 7: return mContext.getResources().getDrawable(R.drawable.atu07);
            case 8: return mContext.getResources().getDrawable(R.drawable.atu08);
            case 9: return mContext.getResources().getDrawable(R.drawable.atu09);
            case 10: return mContext.getResources().getDrawable(R.drawable.atu10);
            case 11: return mContext.getResources().getDrawable(R.drawable.atu11);
            case 12: return mContext.getResources().getDrawable(R.drawable.atu12);
            case 13: return mContext.getResources().getDrawable(R.drawable.atu13);
            case 14: return mContext.getResources().getDrawable(R.drawable.atu14);
            case 15: return mContext.getResources().getDrawable(R.drawable.atu15);
            case 16: return mContext.getResources().getDrawable(R.drawable.atu16);
            case 17: return mContext.getResources().getDrawable(R.drawable.atu17);
            case 18: return mContext.getResources().getDrawable(R.drawable.atu18);
            case 19: return mContext.getResources().getDrawable(R.drawable.atu19);
            case 20: return mContext.getResources().getDrawable(R.drawable.atu20);
            case 21: return mContext.getResources().getDrawable(R.drawable.atu21);
            case 22: return mContext.getResources().getDrawable(R.drawable.back);
            case 23: return mContext.getResources().getDrawable(R.drawable.fire01);
            case 24: return mContext.getResources().getDrawable(R.drawable.fire02);
            case 25: return mContext.getResources().getDrawable(R.drawable.fire03);
            case 26: return mContext.getResources().getDrawable(R.drawable.fire04);
            case 27: return mContext.getResources().getDrawable(R.drawable.fire05);
            case 28: return mContext.getResources().getDrawable(R.drawable.fire06);
            case 29: return mContext.getResources().getDrawable(R.drawable.fire07);
            case 30: return mContext.getResources().getDrawable(R.drawable.fire08);
            case 31: return mContext.getResources().getDrawable(R.drawable.fire09);
            case 32: return mContext.getResources().getDrawable(R.drawable.fire10);
            case 33: return mContext.getResources().getDrawable(R.drawable.fire11);
            case 34: return mContext.getResources().getDrawable(R.drawable.fire12);
            case 35: return mContext.getResources().getDrawable(R.drawable.fire13);
            case 36: return mContext.getResources().getDrawable(R.drawable.fire14);
            case 37: return mContext.getResources().getDrawable(R.drawable.water01);
            case 38: return mContext.getResources().getDrawable(R.drawable.water02);
            case 39: return mContext.getResources().getDrawable(R.drawable.water03);
            case 40: return mContext.getResources().getDrawable(R.drawable.water04);
            case 41: return mContext.getResources().getDrawable(R.drawable.water05);
            case 42: return mContext.getResources().getDrawable(R.drawable.water06);
            case 43: return mContext.getResources().getDrawable(R.drawable.water07);
            case 44: return mContext.getResources().getDrawable(R.drawable.water08);
            case 45: return mContext.getResources().getDrawable(R.drawable.water09);
            case 46: return mContext.getResources().getDrawable(R.drawable.water10);
            case 47: return mContext.getResources().getDrawable(R.drawable.water11);
            case 48: return mContext.getResources().getDrawable(R.drawable.water12);
            case 49: return mContext.getResources().getDrawable(R.drawable.water13);
            case 50: return mContext.getResources().getDrawable(R.drawable.water14);
            case 51: return mContext.getResources().getDrawable(R.drawable.air01);
            case 52: return mContext.getResources().getDrawable(R.drawable.air02);
            case 53: return mContext.getResources().getDrawable(R.drawable.air03);
            case 54: return mContext.getResources().getDrawable(R.drawable.air04);
            case 55: return mContext.getResources().getDrawable(R.drawable.air05);
            case 56: return mContext.getResources().getDrawable(R.drawable.air06);
            case 57: return mContext.getResources().getDrawable(R.drawable.air07);
            case 58: return mContext.getResources().getDrawable(R.drawable.air08);
            case 59: return mContext.getResources().getDrawable(R.drawable.air09);
            case 60: return mContext.getResources().getDrawable(R.drawable.air10);
            case 61: return mContext.getResources().getDrawable(R.drawable.air11);
            case 62: return mContext.getResources().getDrawable(R.drawable.air12);
            case 63: return mContext.getResources().getDrawable(R.drawable.air13);
            case 64: return mContext.getResources().getDrawable(R.drawable.air14);
            case 65: return mContext.getResources().getDrawable(R.drawable.earth01);
            case 66: return mContext.getResources().getDrawable(R.drawable.earth02);
            case 67: return mContext.getResources().getDrawable(R.drawable.earth03);
            case 68: return mContext.getResources().getDrawable(R.drawable.earth04);
            case 69: return mContext.getResources().getDrawable(R.drawable.earth05);
            case 70: return mContext.getResources().getDrawable(R.drawable.earth06);
            case 71: return mContext.getResources().getDrawable(R.drawable.earth07);
            case 72: return mContext.getResources().getDrawable(R.drawable.earth08);
            case 73: return mContext.getResources().getDrawable(R.drawable.earth09);
            case 74: return mContext.getResources().getDrawable(R.drawable.earth10);
            case 75: return mContext.getResources().getDrawable(R.drawable.earth11);
            case 76: return mContext.getResources().getDrawable(R.drawable.earth12);
            case 77: return mContext.getResources().getDrawable(R.drawable.earth13);
            case 78: return mContext.getResources().getDrawable(R.drawable.earth14);
        }
        return null;
    }

}