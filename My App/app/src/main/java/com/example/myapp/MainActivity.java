package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Spinner SelectPhone;

    private Spinner SelectColor;

    private String SelectedPhone;

    private String SelectedColor;

    private Button Signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This spiner is for selecting the phone
        SelectPhone=(Spinner) findViewById(R.id.SelectPhone);

        SelectColor=(Spinner) findViewById(R.id.SelectColor);



        ////////
        //Storing the username
        EditText username=(EditText) findViewById(R.id.username);
        String  Username=username.getText().toString();

        //Storing the downpayment
        EditText Dpaay=(EditText) findViewById(R.id.downpayment);
        String  Dpayment=Dpaay.getText().toString();

        setupspineerforPhone();
        setupspineerforColor();

        Signup=(Button) findViewById(R.id.signup);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Detail.class);
                startActivity(intent);
            }
        });
    }


    private void setupspineerforPhone(){
        /*
         * The createFromResource() method allows you to create an ArrayAdapter from the string array.
         * The third argument for this method is a layout resource that defines how the selected choice
         * appears in the spinner control. The simple_spinner_item layout is provided by the platform and
         * is the default layout you should use unless you'd like to define your own layout for the spinner's
         * appearance.*/
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.Selectphone, android.R.layout.simple_spinner_item);

        //specifying the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply the adapter to the spinner
        SelectPhone.setAdapter(adapter);



        SelectPhone.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SelectedPhone=parent.getItemAtPosition(position).toString();

                Toast.makeText(parent.getContext(),SelectedPhone,Toast.LENGTH_SHORT).show();



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    private void setupspineerforColor(){
        //This spinner is for selecting the color


        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(this,R.array.selectcolor, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        SelectColor.setAdapter(adapter2);

        SelectColor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SelectedColor=parent.getItemAtPosition(position).toString();

                Toast.makeText(parent.getContext(),SelectedColor,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

   



}