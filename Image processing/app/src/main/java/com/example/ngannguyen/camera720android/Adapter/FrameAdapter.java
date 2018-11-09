package com.example.ngannguyen.camera720android.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ngannguyen.camera720android.R;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.*;

public class FrameAdapter extends RecyclerView.Adapter<FrameAdapter.FrameViewHolder> {

    Context context;
    List<Integer> frameList;
    FrameAdapterListener listener;
    int row_selected = -1;

    public FrameAdapter(Context context, FrameAdapterListener listener){
        this.context = context;
        this.frameList = getFrameList();
        this.listener = listener;
    }
    @NonNull
    @Override
    public FrameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(context).inflate(R.layout.frame_item,parent,false);

        return new FrameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FrameViewHolder holder, int position) {
        if(row_selected == position)
            holder.img_check.setVisibility(View.VISIBLE);
        else
            holder.img_check.setVisibility(View.INVISIBLE);
        holder.img_frame.setImageResource(frameList.get(position));
    }

    @Override
    public int getItemCount() {
        return frameList.size();
    }

    public List<Integer> getFrameList() {
        List<Integer> result = new ArrayList<>();
        result.add(R.drawable.frames1);
        result.add(R.drawable.frames2);
        result.add(R.drawable.frames3);

        result.add(R.drawable.frames5);
       // result.add(R.drawable.frames6);
        result.add(R.drawable.frames7);
        result.add(R.drawable.frames8);
        //result.add(R.drawable.frames9);
        return result;
    }

    public class FrameViewHolder extends RecyclerView.ViewHolder {
        ImageView img_check, img_frame;
        public FrameViewHolder(View itemView){
            super(itemView);
            img_check = (ImageView) itemView.findViewById(R.id.img_check);
            img_frame = (ImageView) itemView.findViewById(R.id.img_frame);

            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onFrameSelected(frameList.get(getAdapterPosition()));
                    row_selected = getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
        }
    }

    public interface FrameAdapterListener {
        void onFrameSelected(int frame);
    }
}
