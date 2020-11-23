package com.unik.machinttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class IncentiveAdapter extends RecyclerView.Adapter<IncentiveAdapter.MyHolder> {
    Context context;
    ArrayList<LoanModel> loanModelArrayList;
    public IncentiveAdapter(Context context, ArrayList<LoanModel> loanModelArrayList) {
        this.context = context;
        this.loanModelArrayList = loanModelArrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_incentive,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        LoanModel loanModel = loanModelArrayList.get(position);
        holder.textView.setText(loanModel.loanName);
        holder.txtTotalSale.setText(""+loanModel.totalSale);
        holder.txtTotalIncentive.setText(""+loanModel.totalIncentives);

        loanModel.calculatedValue = ((loanModel.totalIncentives / loanModel.totalSale) * 1.0);
        holder.txtTotalCalculation.setText(((loanModel.totalIncentives+" / "+  loanModel.totalSale)+" * "+ "1.0") + " = "+loanModel.calculatedValue);

        holder.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                loanModel.calculatedValue = ((loanModel.totalIncentives / loanModel.totalSale) * (double) progress);
                holder.txtTotalCalculation.setText(((loanModel.totalIncentives+" / "+  loanModel.totalSale)+" * "+ progress) + " = "+loanModel.calculatedValue);// holder.txtTotalSale.setText(""+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return loanModelArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView txtTotalIncentive,txtTotalSale,txtTotalCalculation;
        SeekBar seekBar;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            textView =itemView.findViewById(R.id.textView);
            txtTotalSale = itemView.findViewById(R.id.txtTotalSale);
            txtTotalIncentive = itemView.findViewById(R.id.txtTotalIncentive);
            txtTotalCalculation = itemView.findViewById(R.id.txtTotalCalculation);
            seekBar = itemView.findViewById(R.id.seekBar);
        }
    }
}
