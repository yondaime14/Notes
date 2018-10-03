package com.carllewisapps.notes.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.carllewisapps.notes.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyViewHolder extends RecyclerView.ViewHolder{

    @BindView(R.id.note)
    TextView note;

    @BindView(R.id.dot)
    TextView dot;

    @BindView(R.id.timestamp)
    TextView timeStamp;

    public MyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


}
