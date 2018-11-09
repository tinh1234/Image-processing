package com.example.ngannguyen.camera720android.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ngannguyen.camera720android.R;

import java.util.ArrayList;
import java.util.List;

public class ColorAdapter extends RecyclerView.Adapter<ColorAdapter.ColorViewholder> {
    Context context;
    List<Integer> colorList;
    ColorAdapterListener listener;

    public ColorAdapter(Context context, ColorAdapterListener listener){
        this.context = context;
        this.colorList = genColorList();
        this.listener = listener;
    }

    @NonNull
    @Override
    public ColorViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.color_item,parent,false);
        return new ColorViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewholder holder, int position) {
        holder.color_section.setCardBackgroundColor(colorList.get(position));
    }

    @Override
    public int getItemCount() {
        return colorList.size();
    }

    public class ColorViewholder extends RecyclerView.ViewHolder {
        public CardView color_section;
        public ColorViewholder(@NonNull View itemView) {
            super(itemView);
            color_section = (CardView) itemView.findViewById(R.id.color_section);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onColorSelected(colorList.get(getAdapterPosition()));
                }
            });
        }
    }

    private List<Integer> genColorList() {
        List<Integer> colorList = new ArrayList<>();

        //add màu

        colorList.add(Color.parseColor("#131722"));
        colorList.add(Color.parseColor("#FF2F2F"));
        colorList.add(Color.parseColor("#FF6D8A"));
        colorList.add(Color.parseColor("#FF6A6A"));
        colorList.add(Color.parseColor("#8C001A"));
        colorList.add(Color.parseColor("#2701D5"));
        colorList.add(Color.parseColor("#4F545C"));
        colorList.add(Color.parseColor("#00FDD1"));
        colorList.add(Color.parseColor("#FF0074"));
        colorList.add(Color.parseColor("#FFDB99"));
        colorList.add(Color.parseColor("#E0E3BC"));
        colorList.add(Color.parseColor("#FFD62A"));
        colorList.add(Color.parseColor("#936B08"));
        colorList.add(Color.parseColor("#000000"));


        return colorList;
    }
    public interface ColorAdapterListener{
        void onColorSelected(int color);
    }
}
