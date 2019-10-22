package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int randomNum, guessNum;

    TextView mDisplayRandNum, mCongrats;
    EditText mGuessNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {

        mDisplayRandNum = this.findViewById(R.id.displayRandNum);

        Random roll = new Random();
        randomNum = roll.nextInt(6 - 1 + 1) + 1; // generate random number between 1 and 6.
        String randomNumString = Integer.toString(randomNum); // convert randomNum (int) to a string.

        mDisplayRandNum.setText(randomNumString); // display string randomNumString.
        onGuess();
    }

    public void onGuess(){

        mGuessNum = (EditText) findViewById(R.id.guessNum);
        mCongrats = (TextView) findViewById(R.id.congrats);

        if (mGuessNum.length() != 0) {
            guessNum = Integer.valueOf(mGuessNum.getText().toString());
            if (guessNum <= 6 && guessNum >= 1) {
                if (guessNum == randomNum) {
                    mCongrats.setText("Congratulations! you guessed the correct number");
                } else {
                    mCongrats.setText("Unlucky! try again");
                }
            }
            else{
                mCongrats.setText("Error guess number 1- 6");
            }
        }
        else {
            mCongrats.setText("Error guess number 1- 6");
        }
    }
}
