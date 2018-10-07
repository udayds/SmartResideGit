package com.smartresidesolutions.smartreside;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ComplaintsAdapter extends RecyclerView.Adapter<ComplaintsAdapter.MyViewHolder>{


    ArrayList<Complaint> complaintList;
    private static ItemClickListner itemListner;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView complaintTitle,fromDate,status,cid;

        public MyViewHolder(View v) {
            super(v);
            complaintTitle =(TextView)(v.findViewById(R.id.complaintCard).findViewById(R.id.complaintTitle));
            fromDate =(TextView)(v.findViewById(R.id.complaintCard).findViewById(R.id.fromDateTv));
            status =(TextView)(v.findViewById(R.id.complaintCard).findViewById(R.id.statusTv));
            cid=(TextView)(v.findViewById(R.id.complaintCard).findViewById(R.id.cidTv));
            v.setOnClickListener(cardClickListner);
        }

        private View.OnClickListener cardClickListner = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListner.onClick(v);
            }
        };
    }

    public ComplaintsAdapter(ArrayList complaints,ItemClickListner listner) {
        complaintList = complaints;
        itemListner=listner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = (View) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.complaint_card_layout, viewGroup, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Complaint complaint=complaintList.get(i);
        myViewHolder.complaintTitle.setText(complaint.getComplaintTitle());
        myViewHolder.fromDate.setText(complaint.getDate());
        myViewHolder.status.setText(complaint.getStatus());
        myViewHolder.cid.setText(complaint.getComplaintId());

    }

    @Override
    public int getItemCount() {
        return complaintList.size();
    }

    public interface ItemClickListner {
        // TODO: Update argument type and name
        void onClick(View v);
    }

    public void setClickListner(ComplaintsAdapter.ItemClickListner itemClickListner){
        this.itemListner=itemClickListner;
    }


}
