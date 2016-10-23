/**
 * HSV Color Picker is a an application with  Hue, Saturation and Value Seekbar
 * sliding the seekbars will slide the color swatch and display new colors. There is also
 * pre set color buttons
 *
 * @author Shannon Wilson (wils0751@algonquinlive.com)
 */
package com.algonquincollege.wils0751.hsccolorpicker;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

import org.w3c.dom.Text;

import java.util.Observable;
import java.util.Observer;

import model.HSVModel;


public class MainActivity extends AppCompatActivity implements Observer, SeekBar.OnSeekBarChangeListener, View.OnClickListener {

    private static final String ABOUT_DIALOG_TAG = "About";
    private AboutDialogFragment mAboutDialog;
    private HSVModel mModel;
    private SeekBar mHueSb;
    private SeekBar mSatSb;
    private SeekBar mValSb;
    private TextView mColorSwatch;
    private TextView mHueTv;
    private TextView mSatTv;
    private TextView mValTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAboutDialog = new AboutDialogFragment();

        mModel = new HSVModel();

        mModel.addObserver(this);

        mColorSwatch = (TextView) findViewById(R.id.colorSwatch);
        mHueSb = (SeekBar) findViewById(R.id.hueSb);
        mSatSb = (SeekBar) findViewById(R.id.Satsb);
        mValSb = (SeekBar) findViewById(R.id.Valsb);
        Button black = (Button) findViewById(R.id.blackButton);
        Button red = (Button) findViewById(R.id.redButton);
        Button lime = (Button) findViewById(R.id.limeButton);
        Button blue = (Button) findViewById(R.id.blueButton);
        Button yellow = (Button) findViewById(R.id.yellowButton);
        Button cyan = (Button) findViewById(R.id.cyanButton);
        Button magenta = (Button) findViewById(R.id.magentaButton);
        Button silver = (Button) findViewById(R.id.silverButton);
        Button gray = (Button) findViewById(R.id.grayButton);
        Button maroon = (Button) findViewById(R.id.maroonButton);
        Button olive = (Button) findViewById(R.id.oliveButton);
        Button green = (Button) findViewById(R.id.greenButton);
        Button purple = (Button) findViewById(R.id.purpleButton);
        Button teal = (Button) findViewById(R.id.tealButton);
        Button navy = (Button) findViewById(R.id.navyButton);

        mHueTv = (TextView) findViewById(R.id.Hue);
        mSatTv = (TextView) findViewById(R.id.Sat);
        mValTv = (TextView) findViewById(R.id.Val);

        mHueSb.setMax((int) HSVModel.MAX_HUE);
        mSatSb.setMax((int) HSVModel.MAX_SAT);
        mValSb.setMax((int) HSVModel.MAX_VAL);

        mHueSb.setOnSeekBarChangeListener(this);
        mSatSb.setOnSeekBarChangeListener(this);
        mValSb.setOnSeekBarChangeListener(this);


        this.updateView();

        black.setOnClickListener(this);
        red.setOnClickListener(this);
        lime.setOnClickListener(this);
        blue.setOnClickListener(this);
        yellow.setOnClickListener(this);
        cyan.setOnClickListener(this);
        magenta.setOnClickListener(this);
        silver.setOnClickListener(this);
        gray.setOnClickListener(this);
        maroon.setOnClickListener(this);
        olive.setOnClickListener(this);
        green.setOnClickListener(this);
        purple.setOnClickListener(this);
        teal.setOnClickListener(this);
        navy.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.blackButton:
                mModel.asBlack();
                // Toast.makeText(getApplicationContext(), "H: 0 S:0 V: 0", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;
            case R.id.redButton:
                //Toast.makeText(getApplicationContext(), "H: 0 S:100 V: 100", Toast.LENGTH_SHORT).show();
                mModel.asRed();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;
            case R.id.limeButton:
                // Toast.makeText(getApplicationContext(), "H:120 S:76 V: 80", Toast.LENGTH_SHORT).show();
                mModel.asLime();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;
            case R.id.blueButton:
                //Toast.makeText(getApplicationContext(), "H: 240 S:100 V: 100", Toast.LENGTH_SHORT).show();
                mModel.asBlue();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;
            case R.id.yellowButton:
                //Toast.makeText(getApplicationContext(), "H: 60 S:100 V: 100", Toast.LENGTH_SHORT).show();
                mModel.asYellow();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cyanButton:
                //Toast.makeText(getApplicationContext(), "H: 180 S:100 V: 100", Toast.LENGTH_SHORT).show();
                mModel.asCyan();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;
            case R.id.magentaButton:
                //Toast.makeText(getApplicationContext(), "H: 300 S:100 V: 100", Toast.LENGTH_SHORT).show();
                mModel.asMagenta();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;
            case R.id.silverButton:
                //Toast.makeText(getApplicationContext(), "H: 0 S:0 V: 75", Toast.LENGTH_SHORT).show();
                mModel.asSilver();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;
            case R.id.grayButton:
                //Toast.makeText(getApplicationContext(), "H: 0 S:0 V: 50", Toast.LENGTH_SHORT).show();
                mModel.asGray();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;
            case R.id.maroonButton:
                //Toast.makeText(getApplicationContext(), "H: 0 S:100 V: 50", Toast.LENGTH_SHORT).show();
                mModel.asMaroon();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;
            case R.id.oliveButton:
                //Toast.makeText(getApplicationContext(), "H: 60 S:100 V:50", Toast.LENGTH_SHORT).show();
                mModel.asOlive();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;
            case R.id.greenButton:
                //  Toast.makeText(getApplicationContext(), "H:120 S:100 V: 50", Toast.LENGTH_SHORT).show();
                mModel.asGreen();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;
            case R.id.purpleButton:
                // Toast.makeText(getApplicationContext(), "H: 300 S:100 V: 50", Toast.LENGTH_SHORT).show();
                mModel.asPurple();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tealButton:
                // Toast.makeText(getApplicationContext(), "H: 180 S:100 V: 50", Toast.LENGTH_SHORT).show();
                mModel.asTeal();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navyButton:
                //  Toast.makeText(getApplicationContext(), "H:240 S:100 V: 50", Toast.LENGTH_SHORT).show();
                mModel.asNavy();
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                break;

        }
        mColorSwatch.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "H:" + mModel.getHue() + "°" + "S:" + mModel.getSaturation() * 100 + "%" + "V:" + mModel.getValue() * 100 + "%", Toast.LENGTH_SHORT).show();
                return true;
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_about:
                mAboutDialog.show(getFragmentManager(), ABOUT_DIALOG_TAG);
                return true;
            default:
                Toast.makeText(this, "MenuItem: " + item.getTitle(), Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser) {

        // Did the user cause this event?
        // YES > continue
        // NO  > leave this method


        if (fromUser == false) {

            return;
        }


        switch (seekbar.getId()) {
            case R.id.hueSb:
                mModel.setHue((float) mHueSb.getProgress());

                // mHueTv.setText(String.valueOf("Hue " + mHueSb.getProgress() + "\u00B0"));
                mHueTv.setText(getResources().getString(R.string.hueProgress, progress).toUpperCase());
                break;
            case R.id.Satsb:

                mModel.setSaturation((float) mSatSb.getProgress());
                //  mModel.setSaturation((float) progress/100);
                mSatTv.setText(getResources().getString(R.string.satProgress, progress).toUpperCase());
                break;
            case R.id.Valsb:

                mModel.setValue((float) mValSb.getProgress());
                // mModel.setValue((float) progress/100);
                mValTv.setText(getResources().getString(R.string.valProgress, progress).toUpperCase());
                break;


        }

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

        // No-Operation
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // No-Operation

        switch (seekBar.getId()) {
            case R.id.hueSb: {
                mHueTv.setText(getResources().getString(R.string.Hue));
                break;

            }
            case R.id.Satsb: {
                mSatTv.setText(getResources().getString(R.string.Saturation));
                break;
            }
            case R.id.Valsb: {
                mValTv.setText(getResources().getString(R.string.Value));
                break;
            }
        }
    }

    @Override
    public void update(Observable observable, Object data) {
        this.updateView();

    }

    private void updateColorSwatch() {
        mColorSwatch.setBackgroundColor(Color.HSVToColor(new float[]{mModel.getHue()
                , mModel.getSaturation()
                , mModel.getValue()}));
//        Log.d("TAG","H: "+mModel.getHue()+" s: "+mModel.getSaturation()+" v: "+mModel.getValue());

    }

    private void updateHueSB() {
        mHueSb.setProgress((int) (mModel.getHue()));
    }

    private void updateSatSB() {
        mSatSb.setProgress((int) (mModel.getSaturation() * 100));
    }

    private void updateValSB() {
        mValSb.setProgress((int) (mModel.getValue() * 100));
    }

    public void updateView() {
        this.updateColorSwatch();
        this.updateHueSB();
        this.updateSatSB();
        this.updateValSB();
    }

//https://github.com/RosyTucker/AndroidHSVColourSelectionDialog/blob/master/HSVColourPickerDialog.java
    //http://android-er.blogspot.ca/2013/09/adjust-hsvhue-saturation-and-value-of.html
}



