package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int randomNum, guessNum, userPoints;
    private String userPointsString;

    public ArrayList<String> ruleArray = new ArrayList<>();

    TextView mDisplayRandNum, mCongrats, mUserPoints;
    EditText mGuessNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ruleArray.add(0,"If you could go anywhere in the world, where would you go?");
        ruleArray.add(1, "If you were stranded on a desert island, what three things would you want to take with you?");
        ruleArray.add(2, "If you could eat only one food for the rest of your life, what would that be?");
        ruleArray.add(3, "If you won a million dollars, what is the first thing you would buy?");
        ruleArray.add(4, "If you could spend the day with one fictional character, who would it be?");
        ruleArray.add(5, "If you found a magic lantern and a genie gave you three wishes, what would you wish?");
    }

    public void addNewDIcebreaker(View view){
        Intent intent = new Intent(this, AddNewDIceBreaker.class);
        startActivityForResult(intent, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == 1 && resultCode == 1 && data != null) {
            ruleArray.add(data.getStringExtra("newRule"));
        }
    }

    private int roll_the_dice(){

        Random roll = new Random();
        randomNum = roll.nextInt(6 - 1 + 1) + 1; // generate random number between 1 and 6.

        return randomNum;
    }

    private void onGuess(){

        mGuessNum = findViewById(R.id.guessNum);
        mCongrats = findViewById(R.id.congrats);
        mUserPoints = findViewById(R.id.userPoints);

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

        Random roll = new Random();
        randomNum = roll.nextInt(ruleArray.size() - 1 + 1);

        mDisplayRandNum.setText(ruleArray.get(randomNum));
    }
}

// TODO 1) Add a finish button on the main Activity screen, clicking the button sends you to a new screen
//On the new screen there must be one button called "Share your score on slack"
//When you click the button your current score should be posted on the slack channel #test-android
