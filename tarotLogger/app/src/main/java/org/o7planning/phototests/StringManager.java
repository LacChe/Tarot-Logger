package org.o7planning.phototests;

import android.annotation.SuppressLint;
import android.util.Log;

public class StringManager {

    private static int currentLanguage = 0;

    private final static String[] languages = new String[] {
            "EN",
            "中文",
    };

    public static String GetCurrentLanguage(){
        return languages[currentLanguage];
    }

    public static void nextLanguage(){
        currentLanguage++;
        if(currentLanguage >= languages.length) currentLanguage = 0;
    }

    public static String GetSpreadDisplayStringByID(String id){
        for(int i = 0; i < MainActivity.mContext.getResources().getStringArray(R.array.en_default_spread_names).length; i++){
            if(id.equalsIgnoreCase(MainActivity.mContext.getResources().getStringArray(R.array.en_default_spread_names)[i])){
                switch(currentLanguage) {
                    case 0:
                        return MainActivity.mContext.getResources().getStringArray(R.array.en_default_spread_names)[i];
                    case 1:
                        return MainActivity.mContext.getResources().getStringArray(R.array.cn_default_spread_names)[i];
                }
            }
        }
        return null;
    }

    public static String[] GetMainPageStrings(){
        switch(currentLanguage) {
            case 0:
                return MainActivity.mContext.getResources().getStringArray(R.array.en_main_page_icons);
            case 1:
                return MainActivity.mContext.getResources().getStringArray(R.array.cn_main_page_icons);
        }
        return null;
    }

    public static String[] GetAboutStrings(){
        switch(currentLanguage) {
            case 0:
                return MainActivity.mContext.getResources().getStringArray(R.array.en_about);
            case 1:
                return MainActivity.mContext.getResources().getStringArray(R.array.cn_about);
        }
        return null;
    }

    public static String[] GetResourcePageStrings(){
        switch(currentLanguage) {
            case 0:
                return MainActivity.mContext.getResources().getStringArray(R.array.en_resource_page_icons);
            case 1:
                return MainActivity.mContext.getResources().getStringArray(R.array.cn_resource_page_icons);
        }
        return null;
    }

    public static String[] GetSettingsPageStrings(){
        switch(currentLanguage) {
            case 0:
                return MainActivity.mContext.getResources().getStringArray(R.array.en_settings_page_icons);
            case 1:
                return MainActivity.mContext.getResources().getStringArray(R.array.cn_settings_page_icons);
        }
        return null;
    }

    public static String[] GetTitles(){
        switch(currentLanguage) {
            case 0:
                return MainActivity.mContext.getResources().getStringArray(R.array.en_spread_selection_titles);
            case 1:
                return MainActivity.mContext.getResources().getStringArray(R.array.cn_spread_selection_titles);
        }
        return null;
    }

    public static String[] GetHints(){
        switch(currentLanguage) {
            case 0:
                return MainActivity.mContext.getResources().getStringArray(R.array.en_hints);
            case 1:
                return MainActivity.mContext.getResources().getStringArray(R.array.cn_hints);
        }
        return null;
    }

    public static String[] GetDefaultSpreadIDs(){
        return MainActivity.mContext.getResources().getStringArray(R.array.en_default_spread_names);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    public static String[] GetDefaultKeywordsByCardID(int cardID){
        switch(currentLanguage) {
            case 0:
                switch(cardID) {
                    case 0: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu00_default_keywords);
                    case 1: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu01_default_keywords);
                    case 2: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu02_default_keywords);
                    case 3: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu03_default_keywords);
                    case 4: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu04_default_keywords);
                    case 5: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu05_default_keywords);
                    case 6: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu06_default_keywords);
                    case 7: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu07_default_keywords);
                    case 8: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu08_default_keywords);
                    case 9: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu09_default_keywords);
                    case 10: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu10_default_keywords);
                    case 11: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu11_default_keywords);
                    case 12: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu12_default_keywords);
                    case 13: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu13_default_keywords);
                    case 14: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu14_default_keywords);
                    case 15: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu15_default_keywords);
                    case 16: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu16_default_keywords);
                    case 17: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu17_default_keywords);
                    case 18: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu18_default_keywords);
                    case 19: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu19_default_keywords);
                    case 20: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu20_default_keywords);
                    case 21: return MainActivity.mContext.getResources().getStringArray(R.array.en_atu21_default_keywords);
                    case 22: return new String[]{};
                    case 23: return MainActivity.mContext.getResources().getStringArray(R.array.en_fire01_default_keywords);
                    case 24: return MainActivity.mContext.getResources().getStringArray(R.array.en_fire02_default_keywords);
                    case 25: return MainActivity.mContext.getResources().getStringArray(R.array.en_fire03_default_keywords);
                    case 26: return MainActivity.mContext.getResources().getStringArray(R.array.en_fire04_default_keywords);
                    case 27: return MainActivity.mContext.getResources().getStringArray(R.array.en_fire05_default_keywords);
                    case 28: return MainActivity.mContext.getResources().getStringArray(R.array.en_fire06_default_keywords);
                    case 29: return MainActivity.mContext.getResources().getStringArray(R.array.en_fire07_default_keywords);
                    case 30: return MainActivity.mContext.getResources().getStringArray(R.array.en_fire08_default_keywords);
                    case 31: return MainActivity.mContext.getResources().getStringArray(R.array.en_fire09_default_keywords);
                    case 32: return MainActivity.mContext.getResources().getStringArray(R.array.en_fire10_default_keywords);
                    case 33: return MainActivity.mContext.getResources().getStringArray(R.array.en_fire11_default_keywords);
                    case 34: return MainActivity.mContext.getResources().getStringArray(R.array.en_fire12_default_keywords);
                    case 35: return MainActivity.mContext.getResources().getStringArray(R.array.en_fire13_default_keywords);
                    case 36: return MainActivity.mContext.getResources().getStringArray(R.array.en_fire14_default_keywords);
                    case 37: return MainActivity.mContext.getResources().getStringArray(R.array.en_water01_default_keywords);
                    case 38: return MainActivity.mContext.getResources().getStringArray(R.array.en_water02_default_keywords);
                    case 39: return MainActivity.mContext.getResources().getStringArray(R.array.en_water03_default_keywords);
                    case 40: return MainActivity.mContext.getResources().getStringArray(R.array.en_water04_default_keywords);
                    case 41: return MainActivity.mContext.getResources().getStringArray(R.array.en_water05_default_keywords);
                    case 42: return MainActivity.mContext.getResources().getStringArray(R.array.en_water06_default_keywords);
                    case 43: return MainActivity.mContext.getResources().getStringArray(R.array.en_water07_default_keywords);
                    case 44: return MainActivity.mContext.getResources().getStringArray(R.array.en_water08_default_keywords);
                    case 45: return MainActivity.mContext.getResources().getStringArray(R.array.en_water09_default_keywords);
                    case 46: return MainActivity.mContext.getResources().getStringArray(R.array.en_water10_default_keywords);
                    case 47: return MainActivity.mContext.getResources().getStringArray(R.array.en_water11_default_keywords);
                    case 48: return MainActivity.mContext.getResources().getStringArray(R.array.en_water12_default_keywords);
                    case 49: return MainActivity.mContext.getResources().getStringArray(R.array.en_water13_default_keywords);
                    case 50: return MainActivity.mContext.getResources().getStringArray(R.array.en_water14_default_keywords);
                    case 51: return MainActivity.mContext.getResources().getStringArray(R.array.en_air01_default_keywords);
                    case 52: return MainActivity.mContext.getResources().getStringArray(R.array.en_air02_default_keywords);
                    case 53: return MainActivity.mContext.getResources().getStringArray(R.array.en_air03_default_keywords);
                    case 54: return MainActivity.mContext.getResources().getStringArray(R.array.en_air04_default_keywords);
                    case 55: return MainActivity.mContext.getResources().getStringArray(R.array.en_air05_default_keywords);
                    case 56: return MainActivity.mContext.getResources().getStringArray(R.array.en_air06_default_keywords);
                    case 57: return MainActivity.mContext.getResources().getStringArray(R.array.en_air07_default_keywords);
                    case 58: return MainActivity.mContext.getResources().getStringArray(R.array.en_air08_default_keywords);
                    case 59: return MainActivity.mContext.getResources().getStringArray(R.array.en_air09_default_keywords);
                    case 60: return MainActivity.mContext.getResources().getStringArray(R.array.en_air10_default_keywords);
                    case 61: return MainActivity.mContext.getResources().getStringArray(R.array.en_air11_default_keywords);
                    case 62: return MainActivity.mContext.getResources().getStringArray(R.array.en_air12_default_keywords);
                    case 63: return MainActivity.mContext.getResources().getStringArray(R.array.en_air13_default_keywords);
                    case 64: return MainActivity.mContext.getResources().getStringArray(R.array.en_air14_default_keywords);
                    case 65: return MainActivity.mContext.getResources().getStringArray(R.array.en_earth01_default_keywords);
                    case 66: return MainActivity.mContext.getResources().getStringArray(R.array.en_earth02_default_keywords);
                    case 67: return MainActivity.mContext.getResources().getStringArray(R.array.en_earth03_default_keywords);
                    case 68: return MainActivity.mContext.getResources().getStringArray(R.array.en_earth04_default_keywords);
                    case 69: return MainActivity.mContext.getResources().getStringArray(R.array.en_earth05_default_keywords);
                    case 70: return MainActivity.mContext.getResources().getStringArray(R.array.en_earth06_default_keywords);
                    case 71: return MainActivity.mContext.getResources().getStringArray(R.array.en_earth07_default_keywords);
                    case 72: return MainActivity.mContext.getResources().getStringArray(R.array.en_earth08_default_keywords);
                    case 73: return MainActivity.mContext.getResources().getStringArray(R.array.en_earth09_default_keywords);
                    case 74: return MainActivity.mContext.getResources().getStringArray(R.array.en_earth10_default_keywords);
                    case 75: return MainActivity.mContext.getResources().getStringArray(R.array.en_earth11_default_keywords);
                    case 76: return MainActivity.mContext.getResources().getStringArray(R.array.en_earth12_default_keywords);
                    case 77: return MainActivity.mContext.getResources().getStringArray(R.array.en_earth13_default_keywords);
                    case 78: return MainActivity.mContext.getResources().getStringArray(R.array.en_earth14_default_keywords);
                }
            case 1:
                switch(cardID) {
                    case 0: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu00_default_keywords);
                    case 1: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu01_default_keywords);
                    case 2: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu02_default_keywords);
                    case 3: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu03_default_keywords);
                    case 4: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu04_default_keywords);
                    case 5: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu05_default_keywords);
                    case 6: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu06_default_keywords);
                    case 7: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu07_default_keywords);
                    case 8: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu08_default_keywords);
                    case 9: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu09_default_keywords);
                    case 10: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu10_default_keywords);
                    case 11: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu11_default_keywords);
                    case 12: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu12_default_keywords);
                    case 13: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu13_default_keywords);
                    case 14: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu14_default_keywords);
                    case 15: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu15_default_keywords);
                    case 16: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu16_default_keywords);
                    case 17: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu17_default_keywords);
                    case 18: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu18_default_keywords);
                    case 19: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu19_default_keywords);
                    case 20: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu20_default_keywords);
                    case 21: return MainActivity.mContext.getResources().getStringArray(R.array.cn_atu21_default_keywords);
                    case 22: return new String[]{};
                    case 23: return MainActivity.mContext.getResources().getStringArray(R.array.cn_fire01_default_keywords);
                    case 24: return MainActivity.mContext.getResources().getStringArray(R.array.cn_fire02_default_keywords);
                    case 25: return MainActivity.mContext.getResources().getStringArray(R.array.cn_fire03_default_keywords);
                    case 26: return MainActivity.mContext.getResources().getStringArray(R.array.cn_fire04_default_keywords);
                    case 27: return MainActivity.mContext.getResources().getStringArray(R.array.cn_fire05_default_keywords);
                    case 28: return MainActivity.mContext.getResources().getStringArray(R.array.cn_fire06_default_keywords);
                    case 29: return MainActivity.mContext.getResources().getStringArray(R.array.cn_fire07_default_keywords);
                    case 30: return MainActivity.mContext.getResources().getStringArray(R.array.cn_fire08_default_keywords);
                    case 31: return MainActivity.mContext.getResources().getStringArray(R.array.cn_fire09_default_keywords);
                    case 32: return MainActivity.mContext.getResources().getStringArray(R.array.cn_fire10_default_keywords);
                    case 33: return MainActivity.mContext.getResources().getStringArray(R.array.cn_fire11_default_keywords);
                    case 34: return MainActivity.mContext.getResources().getStringArray(R.array.cn_fire12_default_keywords);
                    case 35: return MainActivity.mContext.getResources().getStringArray(R.array.cn_fire13_default_keywords);
                    case 36: return MainActivity.mContext.getResources().getStringArray(R.array.cn_fire14_default_keywords);
                    case 37: return MainActivity.mContext.getResources().getStringArray(R.array.cn_water01_default_keywords);
                    case 38: return MainActivity.mContext.getResources().getStringArray(R.array.cn_water02_default_keywords);
                    case 39: return MainActivity.mContext.getResources().getStringArray(R.array.cn_water03_default_keywords);
                    case 40: return MainActivity.mContext.getResources().getStringArray(R.array.cn_water04_default_keywords);
                    case 41: return MainActivity.mContext.getResources().getStringArray(R.array.cn_water05_default_keywords);
                    case 42: return MainActivity.mContext.getResources().getStringArray(R.array.cn_water06_default_keywords);
                    case 43: return MainActivity.mContext.getResources().getStringArray(R.array.cn_water07_default_keywords);
                    case 44: return MainActivity.mContext.getResources().getStringArray(R.array.cn_water08_default_keywords);
                    case 45: return MainActivity.mContext.getResources().getStringArray(R.array.cn_water09_default_keywords);
                    case 46: return MainActivity.mContext.getResources().getStringArray(R.array.cn_water10_default_keywords);
                    case 47: return MainActivity.mContext.getResources().getStringArray(R.array.cn_water11_default_keywords);
                    case 48: return MainActivity.mContext.getResources().getStringArray(R.array.cn_water12_default_keywords);
                    case 49: return MainActivity.mContext.getResources().getStringArray(R.array.cn_water13_default_keywords);
                    case 50: return MainActivity.mContext.getResources().getStringArray(R.array.cn_water14_default_keywords);
                    case 51: return MainActivity.mContext.getResources().getStringArray(R.array.cn_air01_default_keywords);
                    case 52: return MainActivity.mContext.getResources().getStringArray(R.array.cn_air02_default_keywords);
                    case 53: return MainActivity.mContext.getResources().getStringArray(R.array.cn_air03_default_keywords);
                    case 54: return MainActivity.mContext.getResources().getStringArray(R.array.cn_air04_default_keywords);
                    case 55: return MainActivity.mContext.getResources().getStringArray(R.array.cn_air05_default_keywords);
                    case 56: return MainActivity.mContext.getResources().getStringArray(R.array.cn_air06_default_keywords);
                    case 57: return MainActivity.mContext.getResources().getStringArray(R.array.cn_air07_default_keywords);
                    case 58: return MainActivity.mContext.getResources().getStringArray(R.array.cn_air08_default_keywords);
                    case 59: return MainActivity.mContext.getResources().getStringArray(R.array.cn_air09_default_keywords);
                    case 60: return MainActivity.mContext.getResources().getStringArray(R.array.cn_air10_default_keywords);
                    case 61: return MainActivity.mContext.getResources().getStringArray(R.array.cn_air11_default_keywords);
                    case 62: return MainActivity.mContext.getResources().getStringArray(R.array.cn_air12_default_keywords);
                    case 63: return MainActivity.mContext.getResources().getStringArray(R.array.cn_air13_default_keywords);
                    case 64: return MainActivity.mContext.getResources().getStringArray(R.array.cn_air14_default_keywords);
                    case 65: return MainActivity.mContext.getResources().getStringArray(R.array.cn_earth01_default_keywords);
                    case 66: return MainActivity.mContext.getResources().getStringArray(R.array.cn_earth02_default_keywords);
                    case 67: return MainActivity.mContext.getResources().getStringArray(R.array.cn_earth03_default_keywords);
                    case 68: return MainActivity.mContext.getResources().getStringArray(R.array.cn_earth04_default_keywords);
                    case 69: return MainActivity.mContext.getResources().getStringArray(R.array.cn_earth05_default_keywords);
                    case 70: return MainActivity.mContext.getResources().getStringArray(R.array.cn_earth06_default_keywords);
                    case 71: return MainActivity.mContext.getResources().getStringArray(R.array.cn_earth07_default_keywords);
                    case 72: return MainActivity.mContext.getResources().getStringArray(R.array.cn_earth08_default_keywords);
                    case 73: return MainActivity.mContext.getResources().getStringArray(R.array.cn_earth09_default_keywords);
                    case 74: return MainActivity.mContext.getResources().getStringArray(R.array.cn_earth10_default_keywords);
                    case 75: return MainActivity.mContext.getResources().getStringArray(R.array.cn_earth11_default_keywords);
                    case 76: return MainActivity.mContext.getResources().getStringArray(R.array.cn_earth12_default_keywords);
                    case 77: return MainActivity.mContext.getResources().getStringArray(R.array.cn_earth13_default_keywords);
                    case 78: return MainActivity.mContext.getResources().getStringArray(R.array.cn_earth14_default_keywords);
                }
        }
        return null;
    }

}