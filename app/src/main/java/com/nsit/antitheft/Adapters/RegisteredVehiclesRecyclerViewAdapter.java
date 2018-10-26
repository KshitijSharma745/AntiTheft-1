package com.nsit.antitheft.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nsit.antitheft.R;

public class RegisteredVehiclesRecyclerViewAdapter extends RecyclerView.Adapter<RegisteredVehiclesRecyclerViewAdapter.StolenCarViewHolder>{

    private int totalCars;
    private static int viewHolderCount;

    public RegisteredVehiclesRecyclerViewAdapter(int n){
        totalCars = n;
        viewHolderCount = 0;
    }

    @NonNull
    @Override
    public StolenCarViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.registered_vehicles_single_layout,viewGroup,false);
        viewHolderCount++;

        return new StolenCarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StolenCarViewHolder stolenCarViewHolder, int i) {
        // stolenCarViewHolder.bind(MainActivity.);

    }

    @Override
    public int getItemCount() {
        return totalCars;
    }

    public class StolenCarViewHolder extends RecyclerView.ViewHolder{
        TextView type;
        TextView number;
        TextView date;
        TextView status;
        public StolenCarViewHolder(@NonNull View itemView) {
            super(itemView);

            type = itemView.findViewById(R.id.vehicleTypeTextView);
            number = itemView.findViewById(R.id.vehicleNumberTextView);
            date = itemView.findViewById(R.id.vehicleDateAddedTextView);
            status = itemView.findViewById(R.id.vehicleStatusTextView);

        }

        void bind(String stype, String snumber, String sdate, int sstatus) {
            type.setText(stype);
            number.setText(snumber);
            date.setText(sdate);
            status.setText(sstatus);
        }

    }
}