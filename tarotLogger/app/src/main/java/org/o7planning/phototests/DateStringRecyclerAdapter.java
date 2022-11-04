package org.o7planning.phototests;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class DateStringRecyclerAdapter extends RecyclerView.Adapter<DateStringRecyclerAdapter.MyViewHolder> {

    private Context context;

    private String[] dates;
    private String[] questions;
    private int[] icons;
    private int[] layouts;
    private int[][] cards;
    private String[][][] keywords;
    private String[] spreadIDs;
    private String[] logs;
    private int[] ids;

    private ViewGroup parentSave;
    private int viewTypeSave;

    public DateStringRecyclerAdapter(Context ct, String[] datesVal, String[] questionsVal, String[] descriptionsVal, int[] iconsVal, int[] layoutVal, int[][] cID, String[][][] keywordsVal, String[] logsVal, int[] id){
        context = ct;
        dates = datesVal;
        questions = questionsVal;

        spreadIDs = descriptionsVal;
        icons = iconsVal;
        layouts = layoutVal;
        cards = cID;
        keywords = keywordsVal;
        logs = logsVal;
        ids = id;
    }

    private void update(){
        dates = MainActivity.GetDataManager().getDates();
        questions = MainActivity.GetDataManager().getQuestions();

        spreadIDs = MainActivity.GetDataManager().getSpreadIDs();
        icons = MainActivity.GetDataManager().getIcons();
        layouts = MainActivity.GetDataManager().getLayouts();
        cards = MainActivity.GetDataManager().getCards();
        keywords = MainActivity.GetDataManager().getKeywords();
        logs = MainActivity.GetDataManager().getLogs();
        ids = MainActivity.GetDataManager().getIDs();

        onCreateViewHolder(parentSave, viewTypeSave);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        parentSave = parent;
        viewTypeSave = viewType;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_date_string, parent, false);
        return new MyViewHolder(view, this);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.date.setText(dates[position]);
        holder.question.setText(questions[position]);
        holder.image.setImageResource(MainActivity.GetDataManager().getIconsBySpreadID(spreadIDs[position]));

        holder.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(holder.deleteConfirm){
                    holder.deleteConfirm = false;
                    holder.delete.setImageDrawable(MainActivity.mContext.getResources().getDrawable(R.drawable.delete_disabled));
                } else {
                    Intent intent = new Intent(context, SpreadView.class);
                    intent.putExtra("spreadID", spreadIDs[position]);
                    intent.putExtra("question", questions[position]);
                    intent.putExtra("date", dates[position]);
                    intent.putExtra("layout", layouts[position]);
                    intent.putExtra("cards", cards[position]);
                    Bundle mBundle = new Bundle();
                    mBundle.putSerializable("keywords", keywords[position]);
                    intent.putExtras(mBundle);
                    intent.putExtra("log", logs[position]);
                    intent.putExtra("id", ids[position]);
                    context.startActivity(intent);
                }
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(!holder.deleteConfirm){
                    holder.deleteConfirm = true;
                    holder.delete.setImageDrawable(MainActivity.mContext.getResources().getDrawable(R.drawable.delete));
                } else {
                    MainActivity.GetDataManager().deleteByID(ids[position]);
                    update();
                    holder.adapter.removeItem(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return dates.length;
    }

    public void removeItem(int position) {
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        DateStringRecyclerAdapter adapter;

        TextView select;
        TextView date;
        TextView question;
        ImageView delete;
        ImageView image;

        boolean deleteConfirm = false;

        ConstraintLayout imageStringRowLayout;

        public MyViewHolder (@NonNull View itemView, DateStringRecyclerAdapter a) {
            super(itemView);
            adapter = a;
            select = itemView.findViewById(R.id.select);
            date = itemView.findViewById(R.id.date);
            question = itemView.findViewById(R.id.keyword);
            delete = itemView.findViewById(R.id.delete);
            image = itemView.findViewById(R.id.image);
            imageStringRowLayout = itemView.findViewById(R.id.dateStringRowLayout);
        }
    }
}