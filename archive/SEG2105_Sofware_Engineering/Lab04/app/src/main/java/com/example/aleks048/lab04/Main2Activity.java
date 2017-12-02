package com.example.aleks048.lab04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.content.Intent;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void SetTeamIcon(View view) {
//Creating a Return intent to pass to the Main Activity
        Intent returnIntent = new Intent();
//Figuring out which image was clicked
        ImageView selectedImage = (ImageView) view;
//Adding stuff to the return intent
        returnIntent.putExtra("imageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);
//Finishing Activity and return to main screen!
        finish();
    }
}
