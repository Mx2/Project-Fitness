package com.android.projectfitness;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Calories extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calories, menu);
        return true;
    }
}
