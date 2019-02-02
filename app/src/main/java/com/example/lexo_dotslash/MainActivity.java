package com.example.lexo_dotslash;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;


import com.google.android.gms.common.api.CommonStatusCodes;

import java.io.IOException;



public class MainActivity extends Activity implements View.OnClickListener {

    // Use a compound button so either checkbox or switch widgets work.
    private CompoundButton autoFocus;
    private CompoundButton useFlash;
    private TextView statusMessage;
    private TextView textValue;
    private CameraSource mCameraSource;

    private static final int RC_OCR_CAPTURE = 9003;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //autoFocus = findViewById(R.id.auto_focus);
        //useFlash = findViewById(R.id.use_flash);

        findViewById(R.id.read_text).setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.read_text) {
            // launch Ocr capture activity.
            Intent intent = new Intent(this, OcrReader.class);
            //intent.putExtra(OcrCaptureActivity.AutoFocus, autoFocus.isChecked());
            //intent.putExtra(OcrCaptureActivity.UseFlash, useFlash.isChecked());

            startActivity(intent);
        }
    }

    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == RC_OCR_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    String text = data.getStringExtra(OcrCaptureActivity.TextBlockObject);
                    statusMessage.setText("success");
                    textValue.setText(text);
                    Log.d(TAG, "Text read: " + text);
                } else {
                    statusMessage.setText("failed");
                    Log.d(TAG, "No Text captured, intent data is null");
                }
            } else {
                statusMessage.setText(R.string.ocr_error);
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }*/
}


