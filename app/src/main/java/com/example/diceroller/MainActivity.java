package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int randomNum, guessNum, userPoints;
    private String userPointsString;

    TextView mDisplayRandNum, mCongrats, mUserPoints;
    EditText mGuessNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int roll_the_dice(){

        Random roll = new Random();
        randomNum = roll.nextInt(6 - 1 + 1) + 1; // generate random number between 1 and 6.

        return randomNum;
    }

    private void onGuess(){

        mGuessNum = (EditText) findViewById(R.id.guessNum);
        mCongrats = (TextView) findViewById(R.id.congrats);
        mUserPoints = (TextView) findViewById(R.id.userPoints);

        if (mGuessNum.length() != 0) {
            guessNum = Integer.valueOf(mGuessNum.getText().toString());
            if (guessNum <= 6 && guessNum >= 1) {
                if (guessNum == randomNum) {
                    mCongrats.setText("Congratulations! you guessed the correct number");
                    userPoints++;
                    userPointsString = Integer.toString(userPoints);
                    mUserPoints.setText("User points: " + userPointsString);
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

    public void onClick(View v) {

        mDisplayRandNum = this.findViewById(R.id.displayRandNum);

        String randomNumString = Integer.toString(roll_the_dice()); // convert randomNum (int) to a string.

        mDisplayRandNum.setText(randomNumString); // display string randomNumString.
        onGuess();
    }

    public void onDIceBreaker(View v){

        mDisplayRandNum = this.findViewById(R.id.displayRandNum);

        roll_the_dice();

        switch (randomNum){
            case 1 :
                mDisplayRandNum.setText("If you could go anywhere in the world, where would you go?");
                break;
            case 2:
                mDisplayRandNum.setText("If you were stranded on a desert island, what three things would you want to take with you?");
                break;
            case 3:
                mDisplayRandNum.setText("If you could eat only one food for the rest of your life, what would that be?");
                break;
            case 4:
                mDisplayRandNum.setText("If you won a million dollars, what is the first thing you would buy?");
                break;
            case 5:
                mDisplayRandNum.setText("If you could spaned the day with one fictional character, who would it be?");
                break;
            case 6:
                mDisplayRandNum.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
                break;

                default:
                    mDisplayRandNum.setText("Error");
        }
    }

    public void NewDIceBreaker(View v){

        Intent intent = new Intent(this, DIceBreaker.class);
        startActivity(intent);

    }
}

// TODO: 1) Add another button 'Add a new D-icebreaker'.
// TODO: 2) Start a new activity.
