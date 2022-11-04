package org.o7planning.phototests;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class CardSelection extends AppCompatActivity {

    private String selectFor = "spreadCreation"; // display, spreadCreation

    public static Drawable SELECTED_TAROT_CARD = null;
    public static String[] SELECTED_DEFAULT_KEYWORDS = {};

    private String currentType = "spirit";

    public ImageView fire01;
    public ImageView fire02;
    public ImageView fire03;
    public ImageView fire04;
    public ImageView fire05;
    public ImageView fire06;
    public ImageView fire07;
    public ImageView fire08;
    public ImageView fire09;
    public ImageView fire10;
    public ImageView fire11;
    public ImageView fire12;
    public ImageView fire13;
    public ImageView fire14;

    public ImageView water01;
    public ImageView water02;
    public ImageView water03;
    public ImageView water04;
    public ImageView water05;
    public ImageView water06;
    public ImageView water07;
    public ImageView water08;
    public ImageView water09;
    public ImageView water10;
    public ImageView water11;
    public ImageView water12;
    public ImageView water13;
    public ImageView water14;

    public ImageView air01;
    public ImageView air02;
    public ImageView air03;
    public ImageView air04;
    public ImageView air05;
    public ImageView air06;
    public ImageView air07;
    public ImageView air08;
    public ImageView air09;
    public ImageView air10;
    public ImageView air11;
    public ImageView air12;
    public ImageView air13;
    public ImageView air14;

    public ImageView earth01;
    public ImageView earth02;
    public ImageView earth03;
    public ImageView earth04;
    public ImageView earth05;
    public ImageView earth06;
    public ImageView earth07;
    public ImageView earth08;
    public ImageView earth09;
    public ImageView earth10;
    public ImageView earth11;
    public ImageView earth12;
    public ImageView earth13;
    public ImageView earth14;

    public ImageView atu00;
    public ImageView atu01;
    public ImageView atu02;
    public ImageView atu03;
    public ImageView atu04;
    public ImageView atu05;
    public ImageView atu06;
    public ImageView atu07;
    public ImageView atu08;
    public ImageView atu09;
    public ImageView atu10;
    public ImageView atu11;
    public ImageView atu12;
    public ImageView atu13;
    public ImageView atu14;
    public ImageView atu15;
    public ImageView atu16;
    public ImageView atu17;
    public ImageView atu18;
    public ImageView atu19;
    public ImageView atu20;
    public ImageView atu21;
    public ImageView back;
    public ImageView spirit;
    public ImageView fire;
    public ImageView water;
    public ImageView air;
    public ImageView earth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_card_selection);
        getData();
        initButtons();

    }

    private void getData(){
        if(getIntent().hasExtra("selectFor")) {
            selectFor = getIntent().getStringExtra("selectFor");
        }
    }

    public void displayTarot(Drawable d, String[] s, int cardID) {
        if(selectFor.equalsIgnoreCase("display")) {
            Intent intent = new Intent(this, DisplayTarotCard.class);
            intent.putExtra("cardID", cardID);
            SELECTED_TAROT_CARD = d;
            SELECTED_DEFAULT_KEYWORDS = s;
            startActivity(intent);
        }
        if(selectFor.equalsIgnoreCase("spreadCreation")){
            Intent intentWithResult = new Intent();
            intentWithResult.putExtra("cardIDReturn", cardID);
            setResult(1, intentWithResult);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        if(selectFor.equalsIgnoreCase("display")) {
            super.onBackPressed();
        }
        if(selectFor.equalsIgnoreCase("spreadCreation")){
            Intent intentWithResult = new Intent();
            intentWithResult.putExtra("cardIDReturn", 22);
            setResult(1, intentWithResult);
            finish();
        }
    }

    public void changeType(String type) {
        // toggle all off
        atu00.setVisibility(View.INVISIBLE);
        atu01.setVisibility(View.INVISIBLE);
        atu02.setVisibility(View.INVISIBLE);
        atu03.setVisibility(View.INVISIBLE);
        atu04.setVisibility(View.INVISIBLE);
        atu05.setVisibility(View.INVISIBLE);
        atu06.setVisibility(View.INVISIBLE);
        atu07.setVisibility(View.INVISIBLE);
        atu08.setVisibility(View.INVISIBLE);
        atu09.setVisibility(View.INVISIBLE);
        atu10.setVisibility(View.INVISIBLE);
        atu11.setVisibility(View.INVISIBLE);
        atu12.setVisibility(View.INVISIBLE);
        atu13.setVisibility(View.INVISIBLE);
        atu14.setVisibility(View.INVISIBLE);
        atu15.setVisibility(View.INVISIBLE);
        atu16.setVisibility(View.INVISIBLE);
        atu17.setVisibility(View.INVISIBLE);
        atu18.setVisibility(View.INVISIBLE);
        atu19.setVisibility(View.INVISIBLE);
        atu20.setVisibility(View.INVISIBLE);
        atu21.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);

        fire01.setVisibility(View.INVISIBLE);
        fire02.setVisibility(View.INVISIBLE);
        fire03.setVisibility(View.INVISIBLE);
        fire04.setVisibility(View.INVISIBLE);
        fire05.setVisibility(View.INVISIBLE);
        fire06.setVisibility(View.INVISIBLE);
        fire07.setVisibility(View.INVISIBLE);
        fire08.setVisibility(View.INVISIBLE);
        fire09.setVisibility(View.INVISIBLE);
        fire10.setVisibility(View.INVISIBLE);
        fire11.setVisibility(View.INVISIBLE);
        fire12.setVisibility(View.INVISIBLE);
        fire13.setVisibility(View.INVISIBLE);
        fire14.setVisibility(View.INVISIBLE);

        water01.setVisibility(View.INVISIBLE);
        water02.setVisibility(View.INVISIBLE);
        water03.setVisibility(View.INVISIBLE);
        water04.setVisibility(View.INVISIBLE);
        water05.setVisibility(View.INVISIBLE);
        water06.setVisibility(View.INVISIBLE);
        water07.setVisibility(View.INVISIBLE);
        water08.setVisibility(View.INVISIBLE);
        water09.setVisibility(View.INVISIBLE);
        water10.setVisibility(View.INVISIBLE);
        water11.setVisibility(View.INVISIBLE);
        water12.setVisibility(View.INVISIBLE);
        water13.setVisibility(View.INVISIBLE);
        water14.setVisibility(View.INVISIBLE);

        air01.setVisibility(View.INVISIBLE);
        air02.setVisibility(View.INVISIBLE);
        air03.setVisibility(View.INVISIBLE);
        air04.setVisibility(View.INVISIBLE);
        air05.setVisibility(View.INVISIBLE);
        air06.setVisibility(View.INVISIBLE);
        air07.setVisibility(View.INVISIBLE);
        air08.setVisibility(View.INVISIBLE);
        air09.setVisibility(View.INVISIBLE);
        air10.setVisibility(View.INVISIBLE);
        air11.setVisibility(View.INVISIBLE);
        air12.setVisibility(View.INVISIBLE);
        air13.setVisibility(View.INVISIBLE);
        air14.setVisibility(View.INVISIBLE);

        earth01.setVisibility(View.INVISIBLE);
        earth02.setVisibility(View.INVISIBLE);
        earth03.setVisibility(View.INVISIBLE);
        earth04.setVisibility(View.INVISIBLE);
        earth05.setVisibility(View.INVISIBLE);
        earth06.setVisibility(View.INVISIBLE);
        earth07.setVisibility(View.INVISIBLE);
        earth08.setVisibility(View.INVISIBLE);
        earth09.setVisibility(View.INVISIBLE);
        earth10.setVisibility(View.INVISIBLE);
        earth11.setVisibility(View.INVISIBLE);
        earth12.setVisibility(View.INVISIBLE);
        earth13.setVisibility(View.INVISIBLE);
        earth14.setVisibility(View.INVISIBLE);

        // turn on needed
        switch(type) {
            case "spirit":
                atu00.setVisibility(View.VISIBLE);
                atu01.setVisibility(View.VISIBLE);
                atu02.setVisibility(View.VISIBLE);
                atu03.setVisibility(View.VISIBLE);
                atu04.setVisibility(View.VISIBLE);
                atu05.setVisibility(View.VISIBLE);
                atu06.setVisibility(View.VISIBLE);
                atu07.setVisibility(View.VISIBLE);
                atu08.setVisibility(View.VISIBLE);
                atu09.setVisibility(View.VISIBLE);
                atu10.setVisibility(View.VISIBLE);
                atu11.setVisibility(View.VISIBLE);
                atu12.setVisibility(View.VISIBLE);
                atu13.setVisibility(View.VISIBLE);
                atu14.setVisibility(View.VISIBLE);
                atu15.setVisibility(View.VISIBLE);
                atu16.setVisibility(View.VISIBLE);
                atu17.setVisibility(View.VISIBLE);
                atu18.setVisibility(View.VISIBLE);
                atu19.setVisibility(View.VISIBLE);
                atu20.setVisibility(View.VISIBLE);
                atu21.setVisibility(View.VISIBLE);
                back.setVisibility(View.VISIBLE);
                break;
            case "fire":
                fire01.setVisibility(View.VISIBLE);
                fire02.setVisibility(View.VISIBLE);
                fire03.setVisibility(View.VISIBLE);
                fire04.setVisibility(View.VISIBLE);
                fire05.setVisibility(View.VISIBLE);
                fire06.setVisibility(View.VISIBLE);
                fire07.setVisibility(View.VISIBLE);
                fire08.setVisibility(View.VISIBLE);
                fire09.setVisibility(View.VISIBLE);
                fire10.setVisibility(View.VISIBLE);
                fire11.setVisibility(View.VISIBLE);
                fire12.setVisibility(View.VISIBLE);
                fire13.setVisibility(View.VISIBLE);
                fire14.setVisibility(View.VISIBLE);
                break;
            case "water":
                water01.setVisibility(View.VISIBLE);
                water02.setVisibility(View.VISIBLE);
                water03.setVisibility(View.VISIBLE);
                water04.setVisibility(View.VISIBLE);
                water05.setVisibility(View.VISIBLE);
                water06.setVisibility(View.VISIBLE);
                water07.setVisibility(View.VISIBLE);
                water08.setVisibility(View.VISIBLE);
                water09.setVisibility(View.VISIBLE);
                water10.setVisibility(View.VISIBLE);
                water11.setVisibility(View.VISIBLE);
                water12.setVisibility(View.VISIBLE);
                water13.setVisibility(View.VISIBLE);
                water14.setVisibility(View.VISIBLE);
                break;
            case "air":
                air01.setVisibility(View.VISIBLE);
                air02.setVisibility(View.VISIBLE);
                air03.setVisibility(View.VISIBLE);
                air04.setVisibility(View.VISIBLE);
                air05.setVisibility(View.VISIBLE);
                air06.setVisibility(View.VISIBLE);
                air07.setVisibility(View.VISIBLE);
                air08.setVisibility(View.VISIBLE);
                air09.setVisibility(View.VISIBLE);
                air10.setVisibility(View.VISIBLE);
                air11.setVisibility(View.VISIBLE);
                air12.setVisibility(View.VISIBLE);
                air13.setVisibility(View.VISIBLE);
                air14.setVisibility(View.VISIBLE);
                break;
            case "earth":
                earth01.setVisibility(View.VISIBLE);
                earth02.setVisibility(View.VISIBLE);
                earth03.setVisibility(View.VISIBLE);
                earth04.setVisibility(View.VISIBLE);
                earth05.setVisibility(View.VISIBLE);
                earth06.setVisibility(View.VISIBLE);
                earth07.setVisibility(View.VISIBLE);
                earth08.setVisibility(View.VISIBLE);
                earth09.setVisibility(View.VISIBLE);
                earth10.setVisibility(View.VISIBLE);
                earth11.setVisibility(View.VISIBLE);
                earth12.setVisibility(View.VISIBLE);
                earth13.setVisibility(View.VISIBLE);
                earth14.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    @SuppressLint({"ClickableViewAccessibility", "UseCompatLoadingForDrawables"})
    public void initButtons() {
        // set category selection
        spirit = findViewById(R.id.spirit);
        spirit.setImageDrawable(getResources().getDrawable(R.drawable.spirit));
        spirit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeType(currentType = "spirit");
            }
        });
        fire = findViewById(R.id.fire);
        fire.setImageDrawable(getResources().getDrawable(R.drawable.fire));
        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeType(currentType = "fire");
            }
        });
        water = findViewById(R.id.water);
        water.setImageDrawable(getResources().getDrawable(R.drawable.water));
        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeType(currentType = "water");
            }
        });
        air = findViewById(R.id.air);
        air.setImageDrawable(getResources().getDrawable(R.drawable.air));
        air.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeType(currentType = "air");
            }
        });
        earth = findViewById(R.id.earth);
        earth.setImageDrawable(getResources().getDrawable(R.drawable.earth));
        earth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeType(currentType = "earth");
            }
        });

        // init major arcana
        atu00 = findViewById(R.id.atu00);
        atu00.setImageDrawable(MainActivity.GetDrawableIconByCardID(0));
        atu00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(0), StringManager.GetDefaultKeywordsByCardID(0),0);
            }
        });
        atu01 = findViewById(R.id.atu01);
        atu01.setImageDrawable(MainActivity.GetDrawableIconByCardID(1));
        atu01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(1), StringManager.GetDefaultKeywordsByCardID(1),1);
            }
        });
        atu02 = findViewById(R.id.atu02);
        atu02.setImageDrawable(MainActivity.GetDrawableIconByCardID(2));
        atu02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(2), StringManager.GetDefaultKeywordsByCardID(2),2);
            }
        });
        atu03 = findViewById(R.id.atu03);
        atu03.setImageDrawable(MainActivity.GetDrawableIconByCardID(3));
        atu03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(3), StringManager.GetDefaultKeywordsByCardID(3),3);
            }
        });
        atu04 = findViewById(R.id.atu04);
        atu04.setImageDrawable(MainActivity.GetDrawableIconByCardID(4));
        atu04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(4), StringManager.GetDefaultKeywordsByCardID(4),4);
            }
        });
        atu05 = findViewById(R.id.atu05);
        atu05.setImageDrawable(MainActivity.GetDrawableIconByCardID(5));
        atu05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(5), StringManager.GetDefaultKeywordsByCardID(5),5);
            }
        });
        atu06 = findViewById(R.id.atu06);
        atu06.setImageDrawable(MainActivity.GetDrawableIconByCardID(6));
        atu06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(6), StringManager.GetDefaultKeywordsByCardID(6),6);
            }
        });
        atu07 = findViewById(R.id.atu07);
        atu07.setImageDrawable(MainActivity.GetDrawableIconByCardID(7));
        atu07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(7), StringManager.GetDefaultKeywordsByCardID(7),7);
            }
        });
        atu08 = findViewById(R.id.atu08);
        atu08.setImageDrawable(MainActivity.GetDrawableIconByCardID(8));
        atu08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(8), StringManager.GetDefaultKeywordsByCardID(8),8);
            }
        });
        atu09 = findViewById(R.id.atu09);
        atu09.setImageDrawable(MainActivity.GetDrawableIconByCardID(9));
        atu09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(9), StringManager.GetDefaultKeywordsByCardID(9),9);
            }
        });
        atu10 = findViewById(R.id.atu10);
        atu10.setImageDrawable(MainActivity.GetDrawableIconByCardID(10));
        atu10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(10), StringManager.GetDefaultKeywordsByCardID(10),10);
            }
        });
        atu11 = findViewById(R.id.atu11);
        atu11.setImageDrawable(MainActivity.GetDrawableIconByCardID(11));
        atu11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(11), StringManager.GetDefaultKeywordsByCardID(11),11);
            }
        });
        atu12 = findViewById(R.id.atu12);
        atu12.setImageDrawable(MainActivity.GetDrawableIconByCardID(12));
        atu12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(12), StringManager.GetDefaultKeywordsByCardID(12),12);
            }
        });
        atu13 = findViewById(R.id.atu13);
        atu13.setImageDrawable(MainActivity.GetDrawableIconByCardID(13));
        atu13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(13), StringManager.GetDefaultKeywordsByCardID(13),13);
            }
        });
        atu14 = findViewById(R.id.atu14);
        atu14.setImageDrawable(MainActivity.GetDrawableIconByCardID(14));
        atu14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(14), StringManager.GetDefaultKeywordsByCardID(14),14);
            }
        });
        atu15 = findViewById(R.id.atu15);
        atu15.setImageDrawable(MainActivity.GetDrawableIconByCardID(15));
        atu15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(15), StringManager.GetDefaultKeywordsByCardID(15),15);
            }
        });
        atu16 = findViewById(R.id.atu16);
        atu16.setImageDrawable(MainActivity.GetDrawableIconByCardID(16));
        atu16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(16), StringManager.GetDefaultKeywordsByCardID(16),16);
            }
        });
        atu17 = findViewById(R.id.atu17);
        atu17.setImageDrawable(MainActivity.GetDrawableIconByCardID(17));
        atu17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(17), StringManager.GetDefaultKeywordsByCardID(17),17);
            }
        });
        atu18 = findViewById(R.id.atu18);
        atu18.setImageDrawable(MainActivity.GetDrawableIconByCardID(18));
        atu18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(18), StringManager.GetDefaultKeywordsByCardID(18),18);
            }
        });
        atu19 = findViewById(R.id.atu19);
        atu19.setImageDrawable(MainActivity.GetDrawableIconByCardID(19));
        atu19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(19), StringManager.GetDefaultKeywordsByCardID(19),19);
            }
        });
        atu20 = findViewById(R.id.atu20);
        atu20.setImageDrawable(MainActivity.GetDrawableIconByCardID(20));
        atu20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(20), StringManager.GetDefaultKeywordsByCardID(20),20);
            }
        });
        atu21 = findViewById(R.id.atu21);
        atu21.setImageDrawable(MainActivity.GetDrawableIconByCardID(21));
        atu21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(21), StringManager.GetDefaultKeywordsByCardID(21),21);
            }
        });
        back = findViewById(R.id.back);
        back.setImageDrawable(MainActivity.GetDrawableIconByCardID(22));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(22), StringManager.GetDefaultKeywordsByCardID(22),22);
            }
        });
        fire01 = findViewById(R.id.fire01);
        fire01.setImageDrawable(MainActivity.GetDrawableIconByCardID(23));
        fire01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(23), StringManager.GetDefaultKeywordsByCardID(23), 23);
            }
        });
        fire02 = findViewById(R.id.fire02);
        fire02.setImageDrawable(MainActivity.GetDrawableIconByCardID(24));
        fire02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(24), StringManager.GetDefaultKeywordsByCardID(24), 24);
            }
        });
        fire03 = findViewById(R.id.fire03);
        fire03.setImageDrawable(MainActivity.GetDrawableIconByCardID(25));
        fire03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(25), StringManager.GetDefaultKeywordsByCardID(25), 25);
            }
        });
        fire04 = findViewById(R.id.fire04);
        fire04.setImageDrawable(MainActivity.GetDrawableIconByCardID(26));
        fire04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(26), StringManager.GetDefaultKeywordsByCardID(26), 26);
            }
        });
        fire05 = findViewById(R.id.fire05);
        fire05.setImageDrawable(MainActivity.GetDrawableIconByCardID(27));
        fire05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(27), StringManager.GetDefaultKeywordsByCardID(27), 27);
            }
        });
        fire06 = findViewById(R.id.fire06);
        fire06.setImageDrawable(MainActivity.GetDrawableIconByCardID(28));
        fire06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(28), StringManager.GetDefaultKeywordsByCardID(28), 28);
            }
        });
        fire07 = findViewById(R.id.fire07);
        fire07.setImageDrawable(MainActivity.GetDrawableIconByCardID(29));
        fire07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(29), StringManager.GetDefaultKeywordsByCardID(29), 29);
            }
        });
        fire08 = findViewById(R.id.fire08);
        fire08.setImageDrawable(MainActivity.GetDrawableIconByCardID(30));
        fire08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(30), StringManager.GetDefaultKeywordsByCardID(30), 30);
            }
        });
        fire09 = findViewById(R.id.fire09);
        fire09.setImageDrawable(MainActivity.GetDrawableIconByCardID(31));
        fire09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(31), StringManager.GetDefaultKeywordsByCardID(31), 31);
            }
        });
        fire10 = findViewById(R.id.fire10);
        fire10.setImageDrawable(MainActivity.GetDrawableIconByCardID(32));
        fire10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(32), StringManager.GetDefaultKeywordsByCardID(32), 32);
            }
        });
        fire11 = findViewById(R.id.fire11);
        fire11.setImageDrawable(MainActivity.GetDrawableIconByCardID(33));
        fire11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(33), StringManager.GetDefaultKeywordsByCardID(33), 33);
            }
        });
        fire12 = findViewById(R.id.fire12);
        fire12.setImageDrawable(MainActivity.GetDrawableIconByCardID(34));
        fire12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(34), StringManager.GetDefaultKeywordsByCardID(34), 34);
            }
        });
        fire13 = findViewById(R.id.fire13);
        fire13.setImageDrawable(MainActivity.GetDrawableIconByCardID(35));
        fire13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(35), StringManager.GetDefaultKeywordsByCardID(35), 35);
            }
        });
        fire14 = findViewById(R.id.fire14);
        fire14.setImageDrawable(MainActivity.GetDrawableIconByCardID(36));
        fire14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(36), StringManager.GetDefaultKeywordsByCardID(36), 36);
            }
        });
        water01 = findViewById(R.id.water01);
        water01.setImageDrawable(MainActivity.GetDrawableIconByCardID(37));
        water01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(37), StringManager.GetDefaultKeywordsByCardID(37), 37);
            }
        });
        water02 = findViewById(R.id.water02);
        water02.setImageDrawable(MainActivity.GetDrawableIconByCardID(38));
        water02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(38), StringManager.GetDefaultKeywordsByCardID(38), 38);
            }
        });
        water03 = findViewById(R.id.water03);
        water03.setImageDrawable(MainActivity.GetDrawableIconByCardID(39));
        water03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(39), StringManager.GetDefaultKeywordsByCardID(39), 39);
            }
        });
        water04 = findViewById(R.id.water04);
        water04.setImageDrawable(MainActivity.GetDrawableIconByCardID(40));
        water04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(40), StringManager.GetDefaultKeywordsByCardID(40), 40);
            }
        });
        water05 = findViewById(R.id.water05);
        water05.setImageDrawable(MainActivity.GetDrawableIconByCardID(41));
        water05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(41), StringManager.GetDefaultKeywordsByCardID(41), 41);
            }
        });
        water06 = findViewById(R.id.water06);
        water06.setImageDrawable(MainActivity.GetDrawableIconByCardID(42));
        water06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(42), StringManager.GetDefaultKeywordsByCardID(42), 42);
            }
        });
        water07 = findViewById(R.id.water07);
        water07.setImageDrawable(MainActivity.GetDrawableIconByCardID(43));
        water07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(43), StringManager.GetDefaultKeywordsByCardID(43), 43);
            }
        });
        water08 = findViewById(R.id.water08);
        water08.setImageDrawable(MainActivity.GetDrawableIconByCardID(44));
        water08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(44), StringManager.GetDefaultKeywordsByCardID(44), 44);
            }
        });
        water09 = findViewById(R.id.water09);
        water09.setImageDrawable(MainActivity.GetDrawableIconByCardID(45));
        water09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(45), StringManager.GetDefaultKeywordsByCardID(45), 45);
            }
        });
        water10 = findViewById(R.id.water10);
        water10.setImageDrawable(MainActivity.GetDrawableIconByCardID(46));
        water10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(46), StringManager.GetDefaultKeywordsByCardID(46), 46);
            }
        });
        water11 = findViewById(R.id.water11);
        water11.setImageDrawable(MainActivity.GetDrawableIconByCardID(47));
        water11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(47), StringManager.GetDefaultKeywordsByCardID(47), 47);
            }
        });
        water12 = findViewById(R.id.water12);
        water12.setImageDrawable(MainActivity.GetDrawableIconByCardID(48));
        water12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(48), StringManager.GetDefaultKeywordsByCardID(48), 48);
            }
        });
        water13 = findViewById(R.id.water13);
        water13.setImageDrawable(MainActivity.GetDrawableIconByCardID(49));
        water13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(49), StringManager.GetDefaultKeywordsByCardID(49), 49);
            }
        });
        water14 = findViewById(R.id.water14);
        water14.setImageDrawable(MainActivity.GetDrawableIconByCardID(50));
        water14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(50), StringManager.GetDefaultKeywordsByCardID(50), 50);
            }
        });
        air01 = findViewById(R.id.air01);
        air01.setImageDrawable(MainActivity.GetDrawableIconByCardID(51));
        air01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(51), StringManager.GetDefaultKeywordsByCardID(51), 51);
            }
        });
        air02 = findViewById(R.id.air02);
        air02.setImageDrawable(MainActivity.GetDrawableIconByCardID(52));
        air02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(52), StringManager.GetDefaultKeywordsByCardID(52), 52);
            }
        });
        air03 = findViewById(R.id.air03);
        air03.setImageDrawable(MainActivity.GetDrawableIconByCardID(53));
        air03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(53), StringManager.GetDefaultKeywordsByCardID(53), 53);
            }
        });
        air04 = findViewById(R.id.air04);
        air04.setImageDrawable(MainActivity.GetDrawableIconByCardID(54));
        air04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(54), StringManager.GetDefaultKeywordsByCardID(54), 54);
            }
        });
        air05 = findViewById(R.id.air05);
        air05.setImageDrawable(MainActivity.GetDrawableIconByCardID(55));
        air05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(55), StringManager.GetDefaultKeywordsByCardID(55), 55);
            }
        });
        air06 = findViewById(R.id.air06);
        air06.setImageDrawable(MainActivity.GetDrawableIconByCardID(56));
        air06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(56), StringManager.GetDefaultKeywordsByCardID(56), 56);
            }
        });
        air07 = findViewById(R.id.air07);
        air07.setImageDrawable(MainActivity.GetDrawableIconByCardID(57));
        air07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(57), StringManager.GetDefaultKeywordsByCardID(57), 57);
            }
        });
        air08 = findViewById(R.id.air08);
        air08.setImageDrawable(MainActivity.GetDrawableIconByCardID(58));
        air08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(58), StringManager.GetDefaultKeywordsByCardID(58), 58);
            }
        });
        air09 = findViewById(R.id.air09);
        air09.setImageDrawable(MainActivity.GetDrawableIconByCardID(59));
        air09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(59), StringManager.GetDefaultKeywordsByCardID(59), 59);
            }
        });
        air10 = findViewById(R.id.air10);
        air10.setImageDrawable(MainActivity.GetDrawableIconByCardID(60));
        air10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(60), StringManager.GetDefaultKeywordsByCardID(60), 60);
            }
        });
        air11 = findViewById(R.id.air11);
        air11.setImageDrawable(MainActivity.GetDrawableIconByCardID(61));
        air11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(61), StringManager.GetDefaultKeywordsByCardID(61), 61);
            }
        });
        air12 = findViewById(R.id.air12);
        air12.setImageDrawable(MainActivity.GetDrawableIconByCardID(62));
        air12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(62), StringManager.GetDefaultKeywordsByCardID(62), 62);
            }
        });
        air13 = findViewById(R.id.air13);
        air13.setImageDrawable(MainActivity.GetDrawableIconByCardID(63));
        air13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(63), StringManager.GetDefaultKeywordsByCardID(63), 63);
            }
        });
        air14 = findViewById(R.id.air14);
        air14.setImageDrawable(MainActivity.GetDrawableIconByCardID(64));
        air14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(64), StringManager.GetDefaultKeywordsByCardID(64), 64);
            }
        });
        earth01 = findViewById(R.id.earth01);
        earth01.setImageDrawable(MainActivity.GetDrawableIconByCardID(65));
        earth01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(65), StringManager.GetDefaultKeywordsByCardID(65), 65);
            }
        });
        earth02 = findViewById(R.id.earth02);
        earth02.setImageDrawable(MainActivity.GetDrawableIconByCardID(66));
        earth02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(66), StringManager.GetDefaultKeywordsByCardID(66), 66);
            }
        });
        earth03 = findViewById(R.id.earth03);
        earth03.setImageDrawable(MainActivity.GetDrawableIconByCardID(67));
        earth03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(67), StringManager.GetDefaultKeywordsByCardID(67), 67);
            }
        });
        earth04 = findViewById(R.id.earth04);
        earth04.setImageDrawable(MainActivity.GetDrawableIconByCardID(68));
        earth04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(68), StringManager.GetDefaultKeywordsByCardID(68), 68);
            }
        });
        earth05 = findViewById(R.id.earth05);
        earth05.setImageDrawable(MainActivity.GetDrawableIconByCardID(69));
        earth05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(69), StringManager.GetDefaultKeywordsByCardID(69), 69);
            }
        });
        earth06 = findViewById(R.id.earth06);
        earth06.setImageDrawable(MainActivity.GetDrawableIconByCardID(70));
        earth06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(70), StringManager.GetDefaultKeywordsByCardID(70), 70);
            }
        });
        earth07 = findViewById(R.id.earth07);
        earth07.setImageDrawable(MainActivity.GetDrawableIconByCardID(71));
        earth07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(71), StringManager.GetDefaultKeywordsByCardID(71), 71);
            }
        });
        earth08 = findViewById(R.id.earth08);
        earth08.setImageDrawable(MainActivity.GetDrawableIconByCardID(72));
        earth08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(72), StringManager.GetDefaultKeywordsByCardID(72), 72);
            }
        });
        earth09 = findViewById(R.id.earth09);
        earth09.setImageDrawable(MainActivity.GetDrawableIconByCardID(73));
        earth09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(73), StringManager.GetDefaultKeywordsByCardID(73), 73);
            }
        });
        earth10 = findViewById(R.id.earth10);
        earth10.setImageDrawable(MainActivity.GetDrawableIconByCardID(74));
        earth10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(74), StringManager.GetDefaultKeywordsByCardID(74), 74);
            }
        });
        earth11 = findViewById(R.id.earth11);
        earth11.setImageDrawable(MainActivity.GetDrawableIconByCardID(75));
        earth11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(75), StringManager.GetDefaultKeywordsByCardID(75), 75);
            }
        });
        earth12 = findViewById(R.id.earth12);
        earth12.setImageDrawable(MainActivity.GetDrawableIconByCardID(76));
        earth12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(76), StringManager.GetDefaultKeywordsByCardID(76), 76);
            }
        });
        earth13 = findViewById(R.id.earth13);
        earth13.setImageDrawable(MainActivity.GetDrawableIconByCardID(77));
        earth13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(77), StringManager.GetDefaultKeywordsByCardID(77), 77);
            }
        });
        earth14 = findViewById(R.id.earth14);
        earth14.setImageDrawable(MainActivity.GetDrawableIconByCardID(78));
        earth14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayTarot(MainActivity.GetDrawableByCardID(78), StringManager.GetDefaultKeywordsByCardID(78), 78);
            }
        });
        changeType(currentType);
    }

}