package com.ummehabiba.www.currencyconverter;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup myRadioGroup;
    RadioButton usd,rupee,euro;
    Button convert, home;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        //  actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        //actionBar.show();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);



        myRadioGroup= findViewById(R.id.myRadioGroup);
        usd= findViewById(R.id.usd);
        rupee = findViewById(R.id.rupee);
        euro = findViewById(R.id.euro);
        convert = findViewById(R.id.convert);
        input = findViewById(R.id.edit1);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usd.isChecked()) {
                    Log.d("inputTag",input.getText().toString());
                    float valueTaka = Float.parseFloat(input.getText().toString());
                    float valueUsd = valueTaka/80;
                    input.setText( valueUsd + " USD");
                } else if(rupee.isChecked()){
                    Log.d("inputTag",input.getText().toString());
                    float valueTaka = Float.parseFloat(input.getText().toString());
                    float valueRs = valueTaka/1.25f;
                    input.setText( valueRs + " Rs");

                }else {
                    Log.d("inputTag",input.getText().toString());
                    float valueTaka = Float.parseFloat(input.getText().toString());
                    float valueEuro = valueTaka/100;
                    input.setText(valueEuro + " E");
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout, menu);


        return super.onCreateOptionsMenu(menu);
    }

    //back
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home){
            this.finish();
        }

        if (id == R.id.aboutId) {
            Intent iab = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(iab);

        }

        return super.onOptionsItemSelected(item);


    } }


