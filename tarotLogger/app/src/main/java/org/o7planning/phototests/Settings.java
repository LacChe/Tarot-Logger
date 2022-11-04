package org.o7planning.phototests;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    TextView language;
    TextView clearData;
    TextView languageText;
    TextView clearDataText;
    TextView deleteBox;
    TextView languageIcon;
    TextView about;

    boolean clearCheck = false;

    @SuppressLint({"ClickableViewAccessibility", "UseCompatLoadingForDrawables"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        language = findViewById(R.id.language);
        clearData = findViewById(R.id.clearData);
        languageText = findViewById(R.id.languageText);
        clearDataText = findViewById(R.id.clearDataText);
        deleteBox = findViewById(R.id.deleteBox);
        languageIcon = findViewById(R.id.languageIcon);
        languageIcon.setText(StringManager.GetCurrentLanguage());
        about = findViewById(R.id.about);
        about.setText(StringManager.GetAboutStrings()[0]);
        about.setBackgroundResource(R.drawable.image_icon_border);

        languageText.setText(StringManager.GetSettingsPageStrings()[0]);
        clearDataText.setText(StringManager.GetSettingsPageStrings()[1]);

        language.setBackground(MainActivity.mContext.getResources().getDrawable(R.drawable.bar_icons));
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringManager.nextLanguage();
                languageText.setText(StringManager.GetSettingsPageStrings()[0]);
                clearDataText.setText(StringManager.GetSettingsPageStrings()[1]);
                about.setText(StringManager.GetAboutStrings()[0]);
                languageIcon.setText(StringManager.GetCurrentLanguage());
            }
        });

        clearData.setBackground(MainActivity.mContext.getResources().getDrawable(R.drawable.bar_delete_disabled));
        clearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clearCheck){
                    clearData.setBackground(MainActivity.mContext.getResources().getDrawable(R.drawable.bar_delete_disabled));
                    clearCheck = false;
                    Toast toast = Toast.makeText(getApplicationContext(),"Clear Data Canceled", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        deleteBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!clearCheck) {
                    clearData.setBackground(MainActivity.mContext.getResources().getDrawable(R.drawable.bar_delete));
                    clearCheck = true;
                    Toast toast = Toast.makeText(getApplicationContext(),"Confirm Clear Data", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    MainActivity.GetDataManager().clearData();
                    clearData.setBackground(MainActivity.mContext.getResources().getDrawable(R.drawable.bar_delete_disabled));
                    clearCheck = false;
                    Toast toast = Toast.makeText(getApplicationContext(),"Data Cleared", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }

}