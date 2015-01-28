package com.example.agustinmadina.sandwichshop;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    Button mButtonConfirm;
    RadioButton mRadioButtonWheat;
    RadioButton mRadioButtonWhite;
    RadioButton mRadioButtonRye;
    CheckBox mCheckBoxSpecialSauce;
    CheckBox mCheckBoxBacon;
    CheckBox mCheckBoxOnion;
    ArrayList<Sandwich> mOrders;
    Bundle mBundle;
    Sandwich mSandwich;
    String SpecialSauce;
    String Bacon;
    String Onion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareCheckAndButtons();
        mBundle=this.getIntent().getExtras();
        mOrders=mBundle.getParcelableArrayList("orders");
        prepareButtonListener();

    }

    private void prepareCheckAndButtons() {
        mRadioButtonWheat=(RadioButton) findViewById(R.id.radioButtonWheat);
        mRadioButtonWhite=(RadioButton) findViewById(R.id.radioButtonWhite);
        mRadioButtonRye=(RadioButton) findViewById(R.id.radioButtonRye);
        mCheckBoxSpecialSauce=(CheckBox) findViewById(R.id.checkBoxSpecialSauce);
        mCheckBoxBacon=(CheckBox) findViewById(R.id.checkBoxBacon);
        mCheckBoxOnion=(CheckBox) findViewById(R.id.checkBoxOnion);
    }

    private void prepareButtonListener() {
        mButtonConfirm=(Button) findViewById(R.id.buttonConfirmOrder);
        final RadioGroup mRadiogroup=(RadioGroup) findViewById(R.id.radio_group_bread);

        mButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float quantity=Float.valueOf(getIntent().getStringExtra("Quantity"));
                Intent i = new Intent (MainActivity.this, MainActivity.class);
                decideSandwich();
                mSandwich=new Sandwich((((RadioButton) findViewById(mRadiogroup.getCheckedRadioButtonId())).getText().toString()),SpecialSauce,Bacon,Onion);

                mOrders.add(mSandwich);

                Bundle extrasBundle = new Bundle();
                extrasBundle.putParcelableArrayList("orders", mOrders);

                quantity--;
                if (quantity==0) {
                    Intent finalIntent=new Intent(MainActivity.this,ConfirmationActivity.class);
                    finalIntent.putExtras(extrasBundle);
                    startActivity(finalIntent);
                }
                else{i.putExtra("Quantity",String.valueOf(quantity));
                    i.putExtras(extrasBundle);
                    startActivity(i);}
            }
        });

    }

    private void decideSandwich() {
        if (mCheckBoxSpecialSauce.isChecked()) {
            SpecialSauce="Special Sauce";}
            else{
            SpecialSauce="";}

        if (mCheckBoxBacon.isChecked()) {
            Bacon="Bacon";}
            else
            {Bacon="";
        }
        if (mCheckBoxOnion.isChecked()) {
            Onion="Onion";}
        else{
            Onion="";
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
