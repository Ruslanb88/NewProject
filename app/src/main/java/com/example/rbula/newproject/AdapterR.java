package com.example.rbula.newproject;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterR extends RecyclerView.Adapter<AdapterR.RcViewHolder> {

    private List<WorkerObject.Worker> mDataset;

    public static class RcViewHolder extends RecyclerView.ViewHolder {
        public TextView mTexView;

        public RcViewHolder(View itemView) {
            super(itemView);

            mTexView = (TextView) itemView.findViewById(R.id.ID_Text);
//            WW = (TextView) itemView.findViewById(R.id.ID_WW);
        }
    }
    public AdapterR(List<WorkerObject.Worker> dataset) {
        mDataset = dataset;
    }

    @Override
    public AdapterR.RcViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_rc, parent, false);

        RcViewHolder vh = new RcViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(AdapterR.RcViewHolder holder, int position) {
        WorkerObject.Worker worker = mDataset.get(position);

        holder.mTexView.setText(worker.worker);
//        holder.WW.setText(String.valueOf(position));
    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}


