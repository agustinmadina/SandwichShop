package com.example.agustinmadina.sandwichshop;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by agustin.madina on 26/01/2015.
 */
public class ConfirmationActivity extends ActionBarActivity {
    ArrayList<Sandwich> mOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        TextView summaryText = (TextView) findViewById(R.id.text_view_summary);
        Bundle mBundle=this.getIntent().getExtras();
        mOrders=mBundle.getParcelableArrayList("orders");
        String summary = "";
        int n = 0;

        for (Sandwich s : mOrders){
            n++;
            String result = "Sandwich " + Integer.toString(n) + ": ";
            result += s.getmBread() + " " + (s.getmSpecialSauce()) +""+
                    s.getmBacon()+"" +
                    s.getmOnion()+""+"\n";
            summary += result;
        }

        summaryText.setText(summary);
    }

}
