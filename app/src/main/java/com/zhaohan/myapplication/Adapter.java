package com.zhaohan.myapplication;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Bean> list;

    public Adapter(List<Bean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Bean bean = list.get(position);
        holder.lay.setBackgroundColor(Color.parseColor(bean.getColor()));
        holder.tv.setText(bean.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout lay;
        TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lay = itemView.findViewById(R.id.item_background);
            tv = itemView.findViewById(R.id.item_textview);
        }
    }
}
