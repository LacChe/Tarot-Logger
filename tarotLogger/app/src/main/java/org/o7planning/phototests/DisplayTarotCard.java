package org.o7planning.phototests;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DisplayTarotCard extends AppCompatActivity {

    private  ImageView image;
    private  ImageView desc;
    private  ImageView attr;

    private  ImageView imageWindow;
    private  RecyclerView defaultKeywordsWindow;
    private  RecyclerView userKeywordsWindow;

    private String[] default_keywords;
    private String[] user_keywords;
    private String[] user_keywords_percentages;

    private int lastX = 0, lastY = 0;
    private int posX = 0, posY = 0;
    private int scale = 1000;
    private int scaleMin = 100, scaleMax = 0;

    private float viewW = 1;
    private float viewH = 1;

    private int lastPointerDist = 0;

    private int scaleDelta = 2;

    private int cardID;

    private boolean checkingDist = false;

    private boolean singleLockedIn = false, doubleLockedIn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardID = getIntent().getIntExtra("cardID", 0);

        setContentView(R.layout.activity_display_tarot_card);
    }

    private void initViews(){
        imageWindow = findViewById(R.id.imageWindow);

        defaultKeywordsWindow = findViewById(R.id.defaultKeywordsWindow);

        userKeywordsWindow = findViewById(R.id.userKeywordsWindow);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initButtons(){
        image = findViewById(R.id.image);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage("image");
            }
        });
        desc = findViewById(R.id.defaultKeywords);
        desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage("desc");
            }
        });
        attr = findViewById(R.id.userKeywords);
        attr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePage("attr");
            }
        });
    }

    private void changePage(String page){
        switch(page){
            case"image":
                imageWindow.setVisibility(View.VISIBLE);
                defaultKeywordsWindow.setVisibility(View.INVISIBLE);
                userKeywordsWindow.setVisibility(View.INVISIBLE);
                break;
            case"desc":
                imageWindow.setVisibility(View.INVISIBLE);
                defaultKeywordsWindow.setVisibility(View.VISIBLE);
                userKeywordsWindow.setVisibility(View.INVISIBLE);
                break;
            case"attr":
                imageWindow.setVisibility(View.INVISIBLE);
                defaultKeywordsWindow.setVisibility(View.INVISIBLE);
                userKeywordsWindow.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onWindowFocusChanged(boolean hasFocus){
        super.onWindowFocusChanged(hasFocus);

        initButtons();
        initViews();
        changePage("image");

        float x = imageWindow.getWidth();
        float y = imageWindow.getHeight();

        viewW = x;
        viewH = y;

        defaultKeywordsWindow = findViewById(R.id.defaultKeywordsWindow);
        default_keywords = getCurrentDefaultKeywords();
        SingleStringRecyclerAdapter myDefaultAdapter = new SingleStringRecyclerAdapter(this, default_keywords);
        defaultKeywordsWindow.setAdapter(myDefaultAdapter);
        defaultKeywordsWindow.setLayoutManager(new LinearLayoutManager(this));

        userKeywordsWindow = findViewById(R.id.userKeywordsWindow);
        user_keywords = getCurrentUserKeywords();
        user_keywords_percentages = getCurrentUserKeywordsPercentages();
        SingleStringRecyclerAdapter myUserAdapter = new SingleStringRecyclerAdapter(this, user_keywords, user_keywords_percentages);
        userKeywordsWindow.setAdapter(myUserAdapter);
        userKeywordsWindow.setLayoutManager(new LinearLayoutManager(this));

        Drawable drSun = getCurrentCard();
        Bitmap bitmap = ((BitmapDrawable) drSun).getBitmap();
        scaleMax = Math.min(bitmap.getWidth(), bitmap.getHeight());
        scale = scaleMax;
        Drawable d = new BitmapDrawable(getResources(), Bitmap.createBitmap(bitmap, 0, 0, Math.min(scale, bitmap.getWidth()), Math.min((int)(scale / viewW * viewH), bitmap.getHeight())));

        ImageView cardView = findViewById(R.id.imageWindow);
        cardView.setImageDrawable(d);
        cardView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int dist = 0;
                // scale
                if(event.getPointerCount() == 2){
                    doubleLockedIn = true;

                    int x1 = (int) event.getX(0);
                    int y1 = (int) event.getY(0);
                    int x2 = (int) event.getX(1);
                    int y2 = (int) event.getY(1);
                    dist = (int) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));

                    if (dist > lastPointerDist && checkingDist){
                        scale -= scaleDelta * (dist - lastPointerDist);
                        if(scale < scaleMin)
                            scale = scaleMin;
                        else{
                            posX += (scaleDelta * (dist - lastPointerDist)) / 2;
                            posY += (int)(((scaleDelta * (dist - lastPointerDist)) / 2) / viewW * viewH);
                        }
                    } else if (dist < lastPointerDist && checkingDist){
                        scale += scaleDelta * (lastPointerDist - dist);
                        if(scale > scaleMax)
                            scale = scaleMax;
                        else {
                            posX -= (scaleDelta * (lastPointerDist - dist)) / 2;
                            posY -= (int)(((scaleDelta * (lastPointerDist - dist)) / 2) / viewW * viewH);
                        }
                    }
                    lastPointerDist = dist;

                    @SuppressLint("UseCompatLoadingForDrawables") Drawable drSun = getCurrentCard();
                    Bitmap bitmap = ((BitmapDrawable) drSun).getBitmap();

                    if(posX + scale > bitmap.getWidth()) posX = bitmap.getWidth() - scale;
                    if(posY + (int)(scale / viewW * viewH) > bitmap.getHeight()) posY = bitmap.getHeight() - (int)(scale / viewW * viewH);
                    if(posX < 0) posX = 0;
                    if(posY < 0) posY = 0;

                    scale = Math.min(scale, bitmap.getWidth());

                    Drawable d = new BitmapDrawable(getResources(), Bitmap.createBitmap(bitmap, posX, posY, scale, (int)(scale / viewW * viewH)));

                    cardView.setImageDrawable(d);
                    checkingDist = true;

                }

                // translate
                if(!doubleLockedIn && event.getPointerCount() == 1){
                    singleLockedIn = true;

                    int clickX = (int) event.getX();
                    int clickY = (int) event.getY();

                    int eventAction = event.getAction();
                    switch (eventAction) {
                        case MotionEvent.ACTION_DOWN:
                            lastX = clickX;
                            lastY = clickY;
                            break;
                        case MotionEvent.ACTION_MOVE:
                            @SuppressLint("UseCompatLoadingForDrawables") Drawable drSun = getCurrentCard();
                            Bitmap bitmap = ((BitmapDrawable) drSun).getBitmap();

                            int newPosX = posX + (lastX - clickX);
                            int newPosY = posY + (lastY - clickY);

                            lastX = clickX;
                            lastY = clickY;

                            if(newPosX + scale > bitmap.getWidth()) newPosX = bitmap.getWidth() - scale;
                            if(newPosY + (int)(scale / viewW * viewH) > bitmap.getHeight()) newPosY = bitmap.getHeight() - (int)(scale / viewW * viewH);
                            if(newPosX < 0) newPosX = 0;
                            if(newPosY < 0) newPosY = 0;

                            posX = newPosX;
                            posY = newPosY;

                            scale = Math.min(scale, bitmap.getWidth());

                            Drawable d = new BitmapDrawable(getResources(), Bitmap.createBitmap(bitmap, posX, posY, scale, (int)(scale / viewW * viewH)));

                            cardView.setImageDrawable(d);
                            break;
                    }
                }

                // unlock gestures on cancel
                if(event.getAction() == MotionEvent.ACTION_UP){
                    singleLockedIn = false;
                    doubleLockedIn = false;
                }
                if(event.getAction() == MotionEvent.ACTION_UP || event.getPointerCount() < 2){
                    checkingDist = false;
                }

                return true;
            }
        });
    }

    private Drawable getCurrentCard(){
        return CardSelection.SELECTED_TAROT_CARD;
    }

    private String[] getCurrentDefaultKeywords(){
        return CardSelection.SELECTED_DEFAULT_KEYWORDS;
    }

    private String[] getCurrentUserKeywords(){
        String[] ret = MainActivity.GetDataManager().getUserKeywordsForCard(cardID).string1;
        return ret;
    }

    private String[] getCurrentUserKeywordsPercentages(){
        String[] ret = MainActivity.GetDataManager().getUserKeywordsForCard(cardID).string2;
        return ret;
    }

}