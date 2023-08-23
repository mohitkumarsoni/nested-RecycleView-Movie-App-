package com.example.nestedmovierv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedmovierv.R;
import com.example.nestedmovierv.model.ChildModelClass;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.MyViewHolder> {

    List<ChildModelClass> childModelClasses;
    Context context;

    public ChildAdapter(List<ChildModelClass> childModelClasses, Context context) {
        this.childModelClasses = childModelClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_rv_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ChildModelClass child = childModelClasses.get(position);
        holder.imageView.setImageResource(child.getImage());
    }

    @Override
    public int getItemCount() {
        return childModelClasses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_child_item);
        }
    }
}
