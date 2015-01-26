package com.example.agustinmadina.sandwichshop;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by agustin.madina on 26/01/2015.
 */
public class ConfirmationActivity extends ActionBarActivity {
    TextView mTextViewBread;
    TextView mTextViewPaddings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        mTextViewBread=(TextView)findViewById(R.id.textViewBreadChosen);
        String Bread=getIntent().getStringExtra("Bread");
        mTextViewBread.setText(Bread);
        mTextViewPaddings=(TextView) findViewById(R.id.textViewPaddingsChosen);
        String Paddings=getIntent().getStringExtra("Special Sauce")+" "+getIntent().getStringExtra("Bacon")+" "+getIntent().getStringExtra("Onion");
        mTextViewPaddings.setText(Paddings);
    }

}
