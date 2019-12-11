package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddNewDIceBreaker extends AppCompatActivity {

    private String newRuleString;

    EditText mNewRule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_dice_breaker);
    }

    public void Save(View view){
        mNewRule =  findViewById(R.id.newRule);
        newRuleString = mNewRule.getText().toString();

        MainActivity s = new MainActivity();

        Intent result = new Intent();
        result.putExtra("newRule", newRuleString);
        setResult(1, result);

        finish();
    }

    public void cancel(View view){
        finish();
    }
}
