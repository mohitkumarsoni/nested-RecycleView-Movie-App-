package com.example.nestedmovierv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nestedmovierv.R;
import com.example.nestedmovierv.model.ParentModelClass;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentAdapter.MyViewHolder> {

    List<ParentModelClass> parentModelClasses;
    Context context;

    public ParentAdapter(List<ParentModelClass> parentModelClasses, Context context) {
        this.parentModelClasses = parentModelClasses;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.parent_rv_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ParentModelClass parent = parentModelClasses.get(position);
        holder.tv_parentTitle.setText(parent.getTitle());

        ChildAdapter childAdapter;
        childAdapter = new ChildAdapter(parent.getChildModelClassList(), context);
        holder.rv_child.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false));
        holder.rv_child.setAdapter(childAdapter);
        childAdapter.notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return parentModelClasses.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_parentTitle;
        RecyclerView rv_child;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_parentTitle = itemView.findViewById(R.id.tv_parent_title);
            rv_child = itemView.findViewById(R.id.rv_child);
        }
    }
}
