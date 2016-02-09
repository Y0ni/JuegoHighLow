package com.example.t3ll0.money_exchange;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class CurrencySelector extends AppCompatActivity {
Spinner CFrom;
    Spinner CTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_selector);
        CFrom=(Spinner)findViewById(R.id.spinnerFrom);
        String[] spfrom= getResources().getStringArray(R.array.currency_array);
        ArrayAdapter<String> myAdapter =new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item,spfrom);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CFrom.setAdapter(myAdapter);

        CTo=(Spinner)findViewById(R.id.spinnerTo);
        String[] spto= getResources().getStringArray(R.array.currency_array);
        ArrayAdapter<String> myAdapter2 =new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item,spto);
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        CTo.setAdapter(myAdapter2);
    }
    @Override
    protected  void onResume(){
        super.onResume();
        String From;
        String To;
        SharedPreferences settings = getSharedPreferences("dateishon", 0);
        From=settings.getString("fromString","USD");
        To=settings.getString("toString","MXN");
CFrom.setSelection(((ArrayAdapter<String>) CFrom.getAdapter()).getPosition(From));
        CTo.setSelection(((ArrayAdapter<String>)CFrom.getAdapter()).getPosition(To));
    }
    public void onClick(View view){
        String spinnerSelectedFrom=CFrom.getSelectedItem().toString();
        String spinnerSelectedTo=CTo.getSelectedItem().toString();
        SharedPreferences settings= getSharedPreferences("dateishon", 0);
        SharedPreferences.Editor editor=settings.edit();
        editor.putString("fromString",spinnerSelectedFrom);
        editor.putString("toString",spinnerSelectedTo);
        editor.commit();
        finish();
    }
}
