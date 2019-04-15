package com.github.ruleant.getback_gps.lib;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.ruleant.Sensor.ActivitySensor;
import com.github.ruleant.getback_gps.DetailsActivity;
import com.github.ruleant.getback_gps.MainActivity;
import com.github.ruleant.getback_gps.R;
import com.github.ruleant.gps.GPSActivity;

public class StartActivity extends Activity {
    public String state = "DEFAULT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }
    @Override
    public final boolean onCreateOptionsMenu(final Menu menu) {
        boolean superResult = super.onCreateOptionsMenu(menu);

        DebugLevel debug = new DebugLevel(this);

        // don't add details button when debugging is disabled
        if (debug.checkDebugLevel(DebugLevel.DEBUG_LEVEL_LOW)) {
            // Inflate the menu;
            // this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
        }

//            case R.id.GPS:
//                state = "GPS";
//                Intent intents = new Intent(MainActivity.this, MainActivity.class);
//                startActivity(intents);
//                return true;



        //   }

        return superResult;
    }

    @Override
    public final boolean onOptionsItemSelected(final MenuItem item) {
        // One of the group items (using the onClick attribute) was clicked
        // The item parameter passed here indicates which item it is
        // All other menu item clicks are handled by onOptionsItemSelected()
        if (item.getItemId() == R.id.menu_details) {
            displayDetails(item);
            return true;
        }
        int id = item.getItemId();
        switch (id) {
            case R.id.Sensor:
                state = "Sensor";
                Intent intent = new Intent(StartActivity.this, ActivitySensor.class);
                startActivity(intent);
                return true;
            case R.id.GPS:
                state = "gps";
                Intent intentGps = new Intent(StartActivity.this, GPSActivity.class);
                startActivity(intentGps);
                return true;
            case R.id.Main:
                state = "gps";
                Intent intentMain = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intentMain);
                return true;
        }
        {
            return super.onOptionsItemSelected(item);
        }


    }
    public final void displayDetails(final MenuItem item) {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }
    // }
    @Override
    public boolean onPrepareOptionsMenu(final Menu menu) {
        MenuItem miDetails = menu.findItem(R.id.menu_details);
        DebugLevel debug = new DebugLevel(this);

        if (miDetails != null) {
            // hide details button when debugging is disabled
            miDetails.setVisible(
                    debug.checkDebugLevel(DebugLevel.DEBUG_LEVEL_LOW));
        }

        return super.onPrepareOptionsMenu(menu);
    }
}
