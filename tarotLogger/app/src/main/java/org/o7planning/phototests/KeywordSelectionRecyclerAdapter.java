package org.o7planning.phototests;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class KeywordSelectionRecyclerAdapter extends RecyclerView.Adapter<KeywordSelectionRecyclerAdapter.MyViewHolder> {

    private Context context;

    private int cardID;
    private String[] defaultKeywords;
    private String[] userKeywords;
    private String[] allKeywords;

    private String selectedKeyword = "";

    private TextView inputBox;

    public KeywordSelectionRecyclerAdapter(Context ct, int cID, TextView iBox){
        context = ct;
        cardID = cID;
        inputBox = iBox;

        defaultKeywords = MainActivity.GetDataManager().getDefaultKeywordsForCard(cID);
        userKeywords = MainActivity.GetDataManager().getUserKeywordsForCard(cID).string1;

        allKeywords = new String[defaultKeywords.length + userKeywords.length];
        for(int i = 0; i < allKeywords.length; i++){
            if (i < userKeywords.length) allKeywords[i] = userKeywords[i];
            else allKeywords[i] = defaultKeywords[i - userKeywords.length];
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_single_string, parent, false);
        return new MyViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.keyword.setText(allKeywords[position]);

        holder.singleStringRowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedKeyword = holder.keyword.getText() + "";
                inputBox.setText(selectedKeyword);;
            }
        });
    }

    @Override
    public int getItemCount() {
        return allKeywords.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        KeywordSelectionRecyclerAdapter adapter;

        TextView keyword;

        ConstraintLayout singleStringRowLayout;

        public MyViewHolder (@NonNull View itemView, KeywordSelectionRecyclerAdapter a) {
            super(itemView);
            adapter = a;
            keyword = itemView.findViewById(R.id.keyword);
            singleStringRowLayout = itemView.findViewById(R.id.singleStringRowLayout);
        }
    }
}