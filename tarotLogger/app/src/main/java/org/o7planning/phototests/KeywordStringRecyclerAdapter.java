package org.o7planning.phototests;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class KeywordStringRecyclerAdapter extends RecyclerView.Adapter<KeywordStringRecyclerAdapter.MyViewHolder> {

    private Context context;

    public String[] keywords;

    private ViewGroup parentSave;
    private int viewTypeSave;

    public KeywordStringRecyclerAdapter(Context ct){
        context = ct;
    }

    private void update(int indexToRemove){
        String[] newKeywords = new String[keywords.length - 1];
        for(int i = 0; i < newKeywords.length; i++){
            if(i < indexToRemove) newKeywords[i] = keywords[i];
            else newKeywords[i] = keywords[i + 1];
        }
        keywords = newKeywords;

        onCreateViewHolder(parentSave, viewTypeSave);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        parentSave = parent;
        viewTypeSave = viewType;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_keyword_string, parent, false);
        return new MyViewHolder(view, this);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.keyword.setText(keywords[position]);

        holder.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(holder.deleteConfirm){
                    holder.deleteConfirm = false;
                    holder.delete.setImageDrawable(MainActivity.mContext.getResources().getDrawable(R.drawable.delete_disabled));
                }
            }
        });
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Log.d("aaaaaaaaaa   aaaaaaaaaa","" + holder.deleteConfirm);
                if(!holder.deleteConfirm){
                    Log.d("ddddddddddd","" + holder.deleteConfirm);
                    holder.deleteConfirm = true;
                    holder.delete.setImageDrawable(MainActivity.mContext.getResources().getDrawable(R.drawable.delete));
                } else {
                    Log.d("sssssssssss","" + holder.deleteConfirm);
                    update(position);
                    holder.adapter.removeItem(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return keywords.length;
    }

    public void removeItem(int position) {
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount());
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        KeywordStringRecyclerAdapter adapter;

        TextView select;
        TextView keyword;
        ImageView delete;

        boolean deleteConfirm = false;

        ConstraintLayout dateStringRowLayout;

        public MyViewHolder (@NonNull View itemView, KeywordStringRecyclerAdapter a) {
            super(itemView);
            adapter = a;
            select = itemView.findViewById(R.id.select);
            keyword = itemView.findViewById(R.id.keyword);
            delete = itemView.findViewById(R.id.delete);
            dateStringRowLayout = itemView.findViewById(R.id.dateStringRowLayout);
        }
    }
}