package com.example.agustinmadina.sandwichshop;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends ActionBarActivity {

    Button mButtonConfirm;
    RadioButton mRadioButtonWheat;
    RadioButton mRadioButtonWhite;
    RadioButton mRadioButtonRye;
    CheckBox mCheckBoxSpecialSauce;
    CheckBox mCheckBoxBacon;
    CheckBox mCheckBoxOnion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prepareButtonListener();

    }

    private void prepareButtonListener() {
        mButtonConfirm=(Button) findViewById(R.id.buttonConfirmOrder);
        mButtonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (MainActivity.this, ConfirmationActivity.class);
                if (mRadioButtonWheat.isChecked()) {
                    i.putExtra("Bread", "Wheat");
                }else
                     if (mRadioButtonWhite.isChecked()) {
                    i.putExtra("Bread", "White");
                     }
                    else
                         if (mRadioButtonRye.isChecked()) {
                            i.putExtra("Bread","Rye");
                }
                if (mCheckBoxSpecialSauce.isChecked()) {
                    i.putExtra("Special Sauce", "Special Sauce" + "");}
                    else{
                    i.putExtra("Special Sauce", "");}

                if (mCheckBoxBacon.isChecked()) {
                    i.putExtra("Bacon", "Bacon" + "");}
                    else
                    {i.putExtra("Bacon", "");
                }
                if (mCheckBoxOnion.isChecked()) {
                    i.putExtra("Onion", "Onion" + "");}
                else
                    {i.putExtra("Onion", "");
                }
                startActivity(i);
            }
        });
        mRadioButtonWheat=(RadioButton) findViewById(R.id.radioButtonWheat);
        mRadioButtonWhite=(RadioButton) findViewById(R.id.radioButtonWhite);
        mRadioButtonRye=(RadioButton) findViewById(R.id.radioButtonRye);
        mCheckBoxSpecialSauce=(CheckBox) findViewById(R.id.checkBoxSpecialSauce);
        mCheckBoxBacon=(CheckBox) findViewById(R.id.checkBoxBacon);
        mCheckBoxOnion=(CheckBox) findViewById(R.id.checkBoxOnion);
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
