package org.o7planning.phototests;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ImageStringRecyclerAdapter extends RecyclerView.Adapter<ImageStringRecyclerAdapter.MyViewHolder> {

    private Context context;

    private int[] icons;
    private int[] layouts;
    private int[] cardAmounts;
    private String[] spreadID;

    public ImageStringRecyclerAdapter(Context ct, String[] s1, int[] i, int[] l, int[] c){
        context = ct;
        spreadID = s1;
        icons = i;
        layouts = l;
        cardAmounts = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_image_string, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.icon.setImageResource(icons[position]);
        holder.description.setText(StringManager.GetSpreadDisplayStringByID(spreadID[position]));

        holder.imageStringRowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(context, SpreadCreation.class);
                intent.putExtra("spreadID", spreadID[position]);
                intent.putExtra("layout", layouts[position]);
                intent.putExtra("cardAmount", cardAmounts[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return spreadID.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView description;
        ImageView deleteIcon;

        ConstraintLayout imageStringRowLayout;

        public MyViewHolder (@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            description = itemView.findViewById(R.id.keyword);
            deleteIcon = itemView.findViewById(R.id.deleteIcon);
            deleteIcon.setVisibility(View.INVISIBLE);
            imageStringRowLayout = itemView.findViewById(R.id.dateStringRowLayout);
        }
    }
}