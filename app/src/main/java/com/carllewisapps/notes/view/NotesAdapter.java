package com.carllewisapps.notes.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.carllewisapps.notes.R;
import com.carllewisapps.notes.network.model.Note;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {


    private Context mContext;
    private List<Note> noteList;

    public NotesAdapter(Context context, List<Note> noteList){
        this.mContext = context;
        this.noteList = noteList;
    }


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



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Note note = noteList.get(position);
        holder.note.setText(note.getNote());

        //Display dot from HTML character code
        holder.dot.setText(Html.fromHtml("&#8226;"));

        //changing dot to random color
        holder.dot.setTextColor(getRandomMaterialColor("400"));

    }

    private int getRandomMaterialColor(String typeColour) {

        int returnColor = Color.GRAY;
        int arrayId = mContext.getResources().getIdentifier("mdcolor_" + typeColour, "array", mContext.getPackageName());

        if (arrayId != 0) {

            TypedArray colors = mContext.getResources().obtainTypedArray(arrayId);
            int index = (int) (Math.random() * colors.length());
            returnColor = colors.getColor(index, Color.GRAY);
            colors.recycle();
        }

        return returnColor;
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    /*
    Formats Date Stamp to MM DD format
     */

    private String formateDate(String dateStr) {


        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = simpleDateFormat.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
            return fmtOut.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }



}
