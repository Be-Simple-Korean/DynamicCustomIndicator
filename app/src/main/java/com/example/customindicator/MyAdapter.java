package com.example.customindicator;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private int num;
    private ArrayList<Data> dar;
    int curPos = 0;
    private ViewHolder h;
    ArrayList<ImageView> iar = new ArrayList<>();

    public MyAdapter(int num, ArrayList<Data> dar) {
        this.num = num;
        this.dar = dar;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        h = new ViewHolder(v);
        return h;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.iv.setImageResource(dar.get(position).getIv_d());
    }

    @Override
    public int getItemCount() {
        return num;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView iv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            iar.add(iv);
            if (iar.size() == num) {
                srcoll(0);
            }
        }
    }



    public void srcoll(int n) {
        if(curPos!=n){
            iar.get(curPos).setImageResource(R.drawable.unsel);
            iar.get(n).setImageResource(R.drawable.sel);
            iar.get(curPos).getLayoutParams().width=55;
            iar.get(curPos).requestLayout();
            iar.get(n).getLayoutParams().width=100;
            iar.get(n).requestLayout();
        }else{
            iar.get(n).setImageResource(R.drawable.sel);
            iar.get(n).getLayoutParams().width = 100;
            iar.get(n).requestLayout();
        }
        curPos = n;
    }
}
