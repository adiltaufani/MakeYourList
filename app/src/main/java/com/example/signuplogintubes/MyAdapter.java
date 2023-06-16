package com.example.signuplogintubes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.core.Context;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;
    private List<DataClass> dataList;

//    public MyAdapter(Context context, List<DataClass> dataList) {
//        this.context = context;
//        this.dataList = dataList;
//    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.recNote.setText(datalist.get(position).getDataNoteList());
//        holder.recNoteTime.setText(datalist.get(position).getDataNoteTime());

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{
    TextView recNote,recNoteTime;
    CardView noteRecCard;

    public MyViewHolder(@NonNull View itemView){
        super(itemView);

        recNote = itemView.findViewById(R.id.recNote);
        recNoteTime = itemView.findViewById(R.id.recNoteTime);
        noteRecCard = itemView.findViewById(R.id.noteRecCard);



}

}