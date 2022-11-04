package org.o7planning.phototests;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SingleStringRecyclerAdapter extends RecyclerView.Adapter<SingleStringRecyclerAdapter.MyViewHolder> {

    private String[] data1, data2;
    private Context context;

    public SingleStringRecyclerAdapter(Context ct, String[] s1){
        context = ct;
        data1 = s1;
        data2 = new String[]{};
    }

    public SingleStringRecyclerAdapter(Context ct, String[] s1, String[] s2){
        context = ct;
        data1 = s1;
        data2 = s2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_single_string, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.keyword.setText(data1[position]);
        if(data1.length == data2.length) {
            holder.percent.setText(data2[position]);
        }
        else holder.percent.setText("");
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView keyword;
        TextView percent;

        public MyViewHolder (@NonNull View itemView) {
            super(itemView);
            keyword = itemView.findViewById(R.id.keyword);
            percent = itemView.findViewById(R.id.percentage);
        }
    }
}