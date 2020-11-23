package com.unik.machinttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<LoanModel> loanModelArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        LoanModel loanModel = new LoanModel("Personal Loan", 2.0, 140000.0, 1.0, 0.0);
        loanModelArrayList.add(loanModel);

        LoanModel loanModel1 = new LoanModel("Credit Loan", 4.0, 20000.0, 1.0, 0.0);
        loanModelArrayList.add(loanModel1);

        LoanModel loanModel2 = new LoanModel("Health Loan", 20.0, 30000.0, 1.0, 0.0);
        loanModelArrayList.add(loanModel2);

        LoanModel loanMode3 = new LoanModel("Personal Insurance", 8.0, 14000.0, 1.0, 0.0);
        loanModelArrayList.add(loanMode3);

        LoanModel loanModel4 = new LoanModel("Credit card", 10.0, 20000.0, 1.0, 0.0);
        loanModelArrayList.add(loanModel4);

        LoanModel loanModel5 = new LoanModel("Vehicle Loan", 40.0, 30000.0, 1.0, 0.0);
        loanModelArrayList.add(loanModel5);

        IncentiveAdapter incentiveAdapter = new IncentiveAdapter(this, loanModelArrayList);
        recyclerView.setAdapter(incentiveAdapter);
    }
}