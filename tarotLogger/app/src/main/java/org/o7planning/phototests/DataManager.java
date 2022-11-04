package org.o7planning.phototests;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
reversals
save transfer
 */

public class DataManager {

    private static final String saveFilePath = "save.txt";

    public static int[] icons = new int[] {
            R.drawable.single_card_icon,
            R.drawable.two_card_spread_icon,
            R.drawable.three_card_icon,
            R.drawable.four_card_spread_icon,
            R.drawable.grid_icon,
            R.drawable.four_directions_icon,
            R.drawable.square_icon,
            R.drawable.pentagram_spread_icon,
            R.drawable.relationship_icon,
            R.drawable.directional_icon,
            R.drawable.simple_yes_no_icon,
            R.drawable.choice_icon,
            R.drawable.horseshoe_icon,
            R.drawable.seven_horseshoe_icon,
            R.drawable.chakra_icon,
            R.drawable.events_icon,
            R.drawable.timing_icon,
            R.drawable.celtic_cross_icon,
            R.drawable.world_tree_icon,
            R.drawable.tree_of_life_icon,
            R.drawable.resources_icon,
            R.drawable.overview_icon,
            R.drawable.manifestation_causation_icon,
            R.drawable.solution_icon,
            R.drawable.astrology_icon,
            R.drawable.year_icon,
            R.drawable.fate_pattern_icon,
            R.drawable.story_icon,
            R.drawable.three_card_pyramid_icon,
            R.drawable.six_card_pyramid_icon,
            R.drawable.tetraktys_icon,
            R.drawable.romany_icon,
    };

    public static int[] layouts = new int[] {
            R.layout.spread_single_card_spread,
            R.layout.spread_two_card_spread_spread,
            R.layout.spread_three_card_spread_spread,
            R.layout.spread_four_card_spread_spread,
            R.layout.spread_four_card_grid_spread,
            R.layout.spread_four_directions_spread,
            R.layout.spread_five_card_square_spread,
            R.layout.spread_pentagram_spread_spread,
            R.layout.spread_relationship_spread,
            R.layout.spread_directional_spread,
            R.layout.spread_simple_yes_no_spread,
            R.layout.spread_choice_spread,
            R.layout.spread_horseshoe_spread,
            R.layout.spread_seven_card_horseshoe_spread,
            R.layout.spread_chakra_spread,
            R.layout.spread_event_spread,
            R.layout.spread_timing_spread,
            R.layout.spread_celtic_cross_spread,
            R.layout.spread_world_tree_spread,
            R.layout.spread_tree_of_life_spread,
            R.layout.spread_resources_spread,
            R.layout.spread_overview_spread,
            R.layout.spread_manifestation_causation_spread,
            R.layout.spread_solution_spread,
            R.layout.spread_astrology_spread,
            R.layout.spread_year_spread,
            R.layout.spread_fate_pattern_spread,
            R.layout.spread_story_spread,
            R.layout.spread_three_card_pyramid_spread,
            R.layout.spread_six_card_pyramid_spread,
            R.layout.spread_tetraktys_spread,
            R.layout.spread_romany_spread,
    };

    public static int[] cardAmounts = new int[] {
            1,
            2,
            3,
            4,
            4,
            5,
            5,
            6,
            7,
            6,
            6,
            6,
            5,
            7,
            7,
            6,
            8,
            10,
            10,
            10,
            11,
            13,
            10,
            10,
            12,
            12,
            10,
            15,
            3,
            6,
            10,
            21,
    };

    private String[] saveData;
    private int dataLength = 0;
    private int maxID = 0;

    // data format:
    // date_question_ID_spreadName_log_spreadCardCount_cardID#cardKeywordCount#keyword&keyword&keyword_cardID#cardKeywordCount#keyword&keyword&keyword

    public DataManager() {
        readFromFile(MainActivity.mContext);
    }

    public String[] getDates(){
        String dates[] = new String[dataLength];

        for(int i = 0; i < dataLength; i++){
            dates[i] = saveData[i].split("_")[0];
        }

        return dates;
    }

    public String[] getQuestions(){
        String questions[] = new String[dataLength];

        for(int i = 0; i < dataLength; i++){
            questions[i] = saveData[i].split("_")[1];
        }

        return questions;
    }

    public String[] getSpreadIDs(){
        String questions[] = new String[dataLength];

        for(int i = 0; i < dataLength; i++){
            questions[i] = saveData[i].split("_")[3];
        }

        return questions;
    }

    public int[] getLayouts(){
        String[] defaultSpreadNamesEn = MainActivity.mContext.getResources().getStringArray(R.array.en_default_spread_names);
        String[] names = getSpreadIDs();
        int[] ret = new int[names.length];

        for(int i = 0; i < names.length; i++){
            for(int j = 0; j < defaultSpreadNamesEn.length; j++){
                if(names[i].equalsIgnoreCase(defaultSpreadNamesEn[j])) ret[i] = layouts[j];
            }
        }
        return ret;
    }

    public int[] getIcons(){
        String[] defaultSpreadNamesEn = MainActivity.mContext.getResources().getStringArray(R.array.en_default_spread_names);
        String[] names = getSpreadIDs();
        int[] ret = new int[names.length];

        for(int i = 0; i < names.length; i++){
            for(int j = 0; j < defaultSpreadNamesEn.length; j++){
                if(names[i].equalsIgnoreCase(defaultSpreadNamesEn[j])) ret[i] = icons[j];
            }
        }
        return ret;
    }

    public int getIconsBySpreadID(String name){
        String[] defaultSpreadNamesEn = MainActivity.mContext.getResources().getStringArray(R.array.en_default_spread_names);
        int icon = icons[0];

        for(int i = 0; i < defaultSpreadNamesEn.length; i++){
            if(name.equalsIgnoreCase(defaultSpreadNamesEn[i])) icon = icons[i];
        }
        return icon;
    }

    public String[] getLogs(){
        String questions[] = new String[dataLength];

        for(int i = 0; i < dataLength; i++){
            questions[i] = saveData[i].split("_")[4];
        }

        return questions;
    }

    public int[] getIDs(){
        int questions[] = new int[dataLength];

        for(int i = 0; i < dataLength; i++){
            questions[i] = Integer.parseInt(saveData[i].split("_")[2]);
        }

        return questions;
    }

    public int[][] getCards(){
        int cards[][] = new int[dataLength][];

        for(int i = 0; i < dataLength; i++){
            cards[i] = new int[Integer.parseInt(saveData[i].split("_")[5])];
            for(int j = 0; j < cards[i].length; j++){
                cards[i][j] = Integer.parseInt((saveData[i].split("_")[6+j]).split("#")[0]);
            }
        }

        return cards;
    }

    public String[][][] getKeywords(){
        String keywords[][][] = new String[dataLength][][];

        for(int i = 0; i < dataLength; i++){
            keywords[i] = new String[Integer.parseInt(saveData[i].split("_")[5])][];
            for(int j = 0; j < keywords[i].length; j++){
                keywords[i][j] = new String[Integer.parseInt((saveData[i].split("_")[6+j]).split("#")[1])];
                for(int k = 0; k < keywords[i][j].length; k++){
                    keywords[i][j][k] = ((saveData[i].split("_")[6+j]).split("#")[2]).split("&")[k];
                }
            }
        }

        return keywords;
    }

    public StringArrayTuple getUserKeywordsForCard(int id) {
        int[][] cardRaw = getCards();
        String[][][] keywordsRaw = getKeywords();

        // combine
        String[] combinedKeywords = new String[]{};
        for(int i = 0; i < cardRaw.length; i++){
            for(int j = 0; j < cardRaw[i].length; j++){
                if(cardRaw[i][j] == id){
                    String[] temp = new String[keywordsRaw[i][j].length + combinedKeywords.length];
                    for(int t = 0; t < temp.length; t++) {
                        if(t < combinedKeywords.length ) temp[t] = combinedKeywords[t];
                        else temp[t] = keywordsRaw[i][j][t - combinedKeywords.length];
                    }
                    combinedKeywords = temp;
                }
            }
        }

        // order
        for(int i = 0; i < combinedKeywords.length - 1; i++){
            for (int j = i + 1; j < combinedKeywords.length; j++){
                if(combinedKeywords[i].compareTo(combinedKeywords[j]) > 0){
                    String temp = combinedKeywords[i];
                    combinedKeywords[i] = combinedKeywords[j];
                    combinedKeywords[j] = temp;
                }
            }
        }

        // remove dupes
        boolean[] dupe = new boolean[combinedKeywords.length];

        if(dupe.length > 0){
            dupe[0] = false;
        }
        for(int i = 0; i < combinedKeywords.length - 1; i++) {
            if(combinedKeywords[i].compareTo(combinedKeywords[i + 1]) == 0) dupe[i + 1] = true;
            else {
                dupe[i + 1] = false;
            }
        }

        int amount = 0;
        for(int i = 0; i < dupe.length; i++) {
            if(!dupe[i]) amount++;
        }

        String[] combinedKeywordsNoDupes = new String[amount];
        int tempIndex = 0;
        for(int i = 0; i < combinedKeywords.length; i++){
            if(!dupe[i]){
                combinedKeywordsNoDupes[tempIndex] = combinedKeywords[i];
                tempIndex++;
            }
        }

        // get percentage
        int[] frequency = new int[combinedKeywordsNoDupes.length];
        for(int i = 0; i < frequency.length; i++){
            frequency[i] = 0;
        }
        for(int i = 0; i < frequency.length; i++){
            for(int j = 0; j < combinedKeywords.length; j++){
                if(combinedKeywordsNoDupes[i].equalsIgnoreCase(combinedKeywords[j])) frequency[i]++;
            }
        }
        String[] percentage = new String[combinedKeywordsNoDupes.length];
        for(int i = 0; i < percentage.length; i++){
            int percent = (int)(((double)frequency[i] / (double)combinedKeywords.length) * 100.0);
            if(percent < 10) percentage[i] = "  " + percent + "%";
            else if(percent < 100) percentage[i] = " " + percent + "%";
            else percentage[i] = percent + "%";
        }

        return new StringArrayTuple(combinedKeywordsNoDupes, percentage);
    }

    public String[] getDefaultKeywordsForCard(int id) {
        return StringManager.GetDefaultKeywordsByCardID(id);
    }

    public void setData(int id, String d, String q, String s, String l, int[] cIDs, String[][] cKeywords){
        String saveString = formatToString(id, d, q, s, l, cIDs, cKeywords);

        setSaveData(id, saveString);

        saveCurrentData();
    }

    public void addNewData(String d, String q, String s, String l, int[] cIDs, String[][] cKeywords){
        String saveString = formatToString(d, q, s, l, cIDs, cKeywords);

        addToSaveData(saveString);

        saveCurrentData();
    }

    private void setSaveData(int id, String s){
        // get index
        int index = -1;
        for(int i = 0; i < saveData.length; i++){
            if(Integer.parseInt(saveData[i].split("_")[2]) == id) {
                index = i;
                break;
            }
        }
        if(index == -1){
            Toast toast = Toast.makeText(MainActivity.mContext,"No ID to save to",Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        saveData[index] = s;

        Toast toast = Toast.makeText(MainActivity.mContext,"Saved",Toast.LENGTH_SHORT);
        toast.show();
    }

    private void addToSaveData(String s){
        String[] newSaveData = new String[saveData.length + 1];

        // get index
        int index = saveData.length;
        for(int i = 0; i < saveData.length; i++){
            if(s.compareTo(saveData[i]) == -1) {
                index = i;
                break;
            }
        }

        // add to new array
        newSaveData[index] = s;
        for(int i = 0; i < saveData.length; i++){
            if(i < index) newSaveData[i] = saveData[i];
            else newSaveData[i + 1] = saveData[i];
        }

        // update
        saveData = newSaveData;
        dataLength = saveData.length;
    }

    public void deleteByID(int id){
        String[] newSaveData = new String[saveData.length - 1];

        // get index
        int index = saveData.length;
        for(int i = 0; i < saveData.length; i++){
            if(Integer.parseInt(saveData[i].split("_")[2]) == id) {
                index = i;
                break;
            }
        }

        // remove
        for(int i = 0; i < newSaveData.length; i++){
            if(i < index) newSaveData[i] = saveData[i];
            else newSaveData[i] = saveData[i + 1];
        }

        // update
        saveData = newSaveData;
        dataLength = saveData.length;

        saveCurrentData();
    }

    private String formatToString(String d, String q, String s, String l, int[] cIDs, String[][] cKeywords){
        int id = maxID + 1;
        maxID++;

        StringBuilder saveStringBuilder = new StringBuilder();
        saveStringBuilder.append(d); // date
        saveStringBuilder.append("_");
        saveStringBuilder.append(q); // question
        saveStringBuilder.append("_");
        saveStringBuilder.append(id); // ID
        saveStringBuilder.append("_");
        saveStringBuilder.append(s); // spreadName
        saveStringBuilder.append("_");
        saveStringBuilder.append(l); // journal
        saveStringBuilder.append("_");
        saveStringBuilder.append(cIDs.length); // spreadCardCount
        saveStringBuilder.append("_");

        for(int i = 0; i < cIDs.length; i++){
            saveStringBuilder.append(cIDs[i]); // cardID
            saveStringBuilder.append("#");
            saveStringBuilder.append(cKeywords[i].length); // cardKeywordCount
            saveStringBuilder.append("#");

            for(int j = 0; j < cKeywords[i].length; j++) {
                saveStringBuilder.append(cKeywords[i][j]); // keyword
                if (j != cKeywords[i].length - 1) saveStringBuilder.append("&");
            }

            if (i != cIDs.length - 1) saveStringBuilder.append("_");
        }

        return saveStringBuilder.toString();
    }

    private String formatToString(int id, String d, String q, String s, String l, int[] cIDs, String[][] cKeywords){

        StringBuilder saveStringBuilder = new StringBuilder();
        saveStringBuilder.append(d); // date
        saveStringBuilder.append("_");
        saveStringBuilder.append(q); // question
        saveStringBuilder.append("_");
        saveStringBuilder.append(id); // ID
        saveStringBuilder.append("_");
        saveStringBuilder.append(s); // spreadName
        saveStringBuilder.append("_");
        saveStringBuilder.append(l); // journal
        saveStringBuilder.append("_");
        saveStringBuilder.append(cIDs.length); // spreadCardCount
        saveStringBuilder.append("_");

        for(int i = 0; i < cIDs.length; i++){
            saveStringBuilder.append(cIDs[i]); // cardID
            saveStringBuilder.append("#");
            saveStringBuilder.append(cKeywords[i].length); // cardKeywordCount
            saveStringBuilder.append("#");

            for(int j = 0; j < cKeywords[i].length; j++) {
                saveStringBuilder.append(cKeywords[i][j]); // keyword
                if (j != cKeywords[i].length - 1) saveStringBuilder.append("&");
            }

            if (i != cIDs.length - 1) saveStringBuilder.append("_");
        }

        return saveStringBuilder.toString();
    }

    private void saveCurrentData(){
        writeToFile(maxID, saveData, MainActivity.mContext);
    }

    private void writeToFile(int mID, String[] data, Context context) {
        String saveText;

        int saveDataLength = data.length;
        saveText = "";
        for(int i = 0; i < saveDataLength; i++){
            saveText = saveText + data[i] + "\n";
        }

        try {
            if(context == null) context = MainActivity.mContext;
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(saveFilePath, Context.MODE_PRIVATE));
            outputStreamWriter.write(mID + "\n");
            outputStreamWriter.write(saveDataLength + "\n");
            outputStreamWriter.write(saveText);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private void readFromFile(Context context) {

        try {
            if(context == null) context = MainActivity.mContext;
            InputStream inputStream = context.openFileInput(saveFilePath);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";

                if((receiveString = bufferedReader.readLine()) != null) {
                    maxID = Integer.parseInt(receiveString);
                }
                if((receiveString = bufferedReader.readLine()) != null) {
                    dataLength = Integer.parseInt(receiveString);
                }
                saveData = new String[dataLength];
                for(int i = 0; i < dataLength; i++) {
                    if((receiveString = bufferedReader.readLine()) != null) {
                        saveData[i] = receiveString;
                    }
                }

                inputStream.close();
            }
        }
        catch (FileNotFoundException e) {
            saveData = new String[]{};
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
    }

    public void clearData(){
        writeToFile(0, new String[]{}, MainActivity.mContext);
    }

}