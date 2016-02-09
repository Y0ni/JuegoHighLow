package com.example.t3ll0.money_exchange;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
String From;
    String To;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SharedPreferences settings = getSharedPreferences("dateishon", 0);
    From=settings.getString("fromString","USD");
        To=settings.getString("toString","MXN");
        ((TextView)findViewById(R.id.textViewFromCurr)).setText(From);
        ((TextView)findViewById(R.id.textViewToCurr)).setText(To);


    }
    @Override
    protected  void onResume(){
        super.onResume();

        SharedPreferences settings = getSharedPreferences("dateishon", 0);
        From=settings.getString("fromString","USD");
        To=settings.getString("toString","MXN");
        ((TextView)findViewById(R.id.textViewFromCurr)).setText(From);
        ((TextView)findViewById(R.id.textViewToCurr)).setText(To);


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
    public  void onClickSelector(View view){
        startActivity(new Intent("com.example.t3ll0.CurrencySelector"));
    }
    public void onClickConvert(View view){
        double multiplier=0.0;
        EditText attempt= (EditText)findViewById(R.id.editTextCurrency);
        if(attempt.getText().toString().equals("")) {
            Toast.makeText(this, "Input a number \n >:(", Toast.LENGTH_LONG).show();
        }else{
            if(attempt.getText().toString().matches("[a-z,A-Z]")){
                Toast.makeText(this, "No letters allowed \n >:(", Toast.LENGTH_LONG).show();

            }else{

        String F= ((TextView)findViewById(R.id.textViewFromCurr)).getText().toString();
        String T= ((TextView)findViewById(R.id.textViewToCurr)).getText().toString();
        switch (F){
            case "USD": {switch (T){
                            case "USD": { multiplier=1;break;}
                            case "EUR": { multiplier=0.892231; break;}
                            case "MXN": { multiplier=18.7407;break;}
                            }break;
                        }
            case "EUR": {switch (T){
                            case "USD": { multiplier=1.12066;break;}
                            case "EUR": { multiplier=1;break;}
                            case "MXN": { multiplier=21.0046;break;}
                            }break;
                        }
            case "MXN": {switch (T){
                            case "USD": { multiplier=.0533578;break;}
                            case "EUR": { multiplier=.0476086;break;}
                            case "MXN": { multiplier=1;break;}
                            }break;
                        }
        }
        double valGet = Double.parseDouble(((EditText) findViewById(R.id.editTextCurrency)).getText().toString());
        valGet=valGet*multiplier;
        Toast.makeText(this,"$ "+ String.valueOf(valGet),Toast.LENGTH_LONG).show();
    }}}
}
