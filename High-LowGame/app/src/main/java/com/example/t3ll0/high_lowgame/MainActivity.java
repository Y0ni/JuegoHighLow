package com.example.t3ll0.high_lowgame;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    int rad;
    int attemptsNumber=0;

public void guessNumber(View view){

    EditText attempt= (EditText)findViewById(R.id.editText);
    if(attempt.getText().toString().equals("")) {
        Toast.makeText(this, "Input a number \n >:(", Toast.LENGTH_LONG).show();
    }else{

        int att = Integer.parseInt(attempt.getText().toString());
        TextView attemptNumberView = (TextView) findViewById(R.id.AttemptTextView);
        if (att == rad) {
            Toast.makeText(this, "you WON! in \n " + Integer.toString(attemptsNumber) + " Attempts", Toast.LENGTH_LONG).show();
            attemptsNumber = 0;
            attemptNumberView.setText("Number of Attempts: " + Integer.toString(attemptsNumber));
            Toast.makeText(this, "Can you guess again?", Toast.LENGTH_LONG).show();
            Random random= new Random();
            rad=random.nextInt(21);
        } else {
            if (att > rad) {
                Toast.makeText(this, "Your number its higher that the secret number ", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Your number its lower that the secret number ", Toast.LENGTH_LONG).show();
            }
            attemptsNumber++;
            attemptNumberView.setText(("Number of Attempts: " + Integer.toString(attemptsNumber)));
        }
    }

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Random random= new Random();
        rad=random.nextInt(21);
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
