package com.example.agustinmadina.sandwichshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by agustin.madina on 27/01/2015.
 */
public class SandwichEntryActivity extends ActionBarActivity {
    EditText mEditTextNumberSanwiches;
    Button mButtonConfirmNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwichcount);
        mEditTextNumberSanwiches=(EditText) findViewById(R.id.editTextNumberSandwiches);
        mButtonConfirmNumber=(Button) findViewById(R.id.buttonConfirmNumber);
        mButtonConfirmNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(mEditTextNumberSanwiches.getText())||(Float.valueOf(mEditTextNumberSanwiches.getText().toString()) > 5)) {
                    Toast.makeText(getApplicationContext(), "Enter a desired number of sandwiches, remember:Maximum 5",
                            Toast.LENGTH_LONG).show();
                }
                else{
                Intent i = new Intent (SandwichEntryActivity.this, MainActivity.class);
                i.putExtra("Quantity",mEditTextNumberSanwiches.getText().toString());
                ArrayList<Sandwich> mOrders= new ArrayList<Sandwich>();
                i.putParcelableArrayListExtra("orders",mOrders);
                startActivity(i);}
            }
        });

    }

}
