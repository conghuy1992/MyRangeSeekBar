package com.conghuy.MyRangeSeekBar;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.conghuy.MyRangeSeekBar.interfaces.OnRangeSeekbarChangeListener;
import com.conghuy.MyRangeSeekBar.interfaces.OnRangeSeekbarFinalValueListener;
import com.conghuy.MyRangeSeekBar.seekbar.MyRangeSeekbar;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mySeekBar();
    }

    private void mySeekBar() {
        // get seekbar from view
        final MyRangeSeekbar rangeSeekbar = (MyRangeSeekbar) findViewById(R.id.rangeSeekbar1);


        // set listener
        rangeSeekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue, double centerValue) {
                Log.d(TAG, "valueChanged minValue: " + minValue);
                Log.d(TAG, "valueChanged maxValue: " + maxValue);
                Log.d(TAG, "valueChanged centerValue: " + centerValue);
            }
        });

        // set final value listener
        rangeSeekbar.setOnRangeSeekbarFinalValueListener(new OnRangeSeekbarFinalValueListener() {
            @Override
            public void finalValue(Number minValue, Number maxValue, double centerValue) {
                Log.d(TAG, "-------------");
                Log.d(TAG, "finalValue minValue: " + minValue);
                Log.d(TAG, "finalValue maxValue: " + maxValue);
                Log.d(TAG, "finalValue centerValue: " + centerValue);
            }
        });

        rangeSeekbar
                // image for min seekbar
                .setThumbDrawable(R.mipmap.ic_launcher, rangeSeekbar.LEFT)
                .setThumbHighlightDrawable(R.mipmap.ic_launcher_round, rangeSeekbar.LEFT)
                // image for max seekbar
                .setThumbDrawable(R.mipmap.ic_launcher, rangeSeekbar.RIGHT)
                .setThumbHighlightDrawable(R.mipmap.ic_launcher_round, rangeSeekbar.RIGHT)
                // image for point center seekbar
                .setThumbDrawable(R.mipmap.ic_launcher_round, rangeSeekbar.CENTER)
                .setThumbHighlightDrawable(R.mipmap.ic_launcher, rangeSeekbar.CENTER)
                .setDataType(MyRangeSeekbar.DataType.FLOAT)
                .apply();

        rangeSeekbar.setMax(95)
                .setMin(10)
                .setCenter(45);

    }


}
