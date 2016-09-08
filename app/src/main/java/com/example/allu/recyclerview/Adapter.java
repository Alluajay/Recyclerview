package com.example.allu.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by allu on 5/20/16.
 */
public class Adapter extends RecyclerView.Adapter<list> {

    Context Activity_context;
    Recycler_onclick_interface Onclick_interface;
    public Adapter(Context context,Recycler_onclick_interface recycler_onclick_interface){
        this.Activity_context=context;
        this.Onclick_interface=recycler_onclick_interface;
    }

    @Override
    public list onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(Activity_context).inflate(R.layout.recycler_single_layout,parent,false);
        list ls=new list(v);
        return ls;
    }

    @Override
    public void onBindViewHolder(list holder, final int position) {
        //binds each list item
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Onclick_interface.Onclicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}


class list extends RecyclerView.ViewHolder {
    //class containing single listview layout items
    public TextView textView;
    public list(View itemView) {
        super(itemView);
        textView=(TextView)itemView.findViewById(R.id.Recycler_textview);
    }
}
