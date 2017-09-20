package edu.orangecoastcollege.cs273.mmendoza.paintestimator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Member variables for the  Views
    private EditText mLengthEditText;
    private EditText mWidthEditText;
    private EditText mHeightEditText;

    private EditText mDoorsEditText;
    private EditText mWindowsEditText;

    private TextView mGallonsTextView;

    // Member variables for the model
    private interiorRoom mRoom = new interiorRoom();

    // Member variables for the SharedPreferences
    private SharedPreferences mPrefs;
    private void initializeViews()
    {
        mLengthEditText = (EditText) findViewById(R.id.lengthEditText);
        // TODO: Finish initialization
        mWidthEditText = (EditText) findViewById(R.id.widthEditText);
        mHeightEditText = (EditText) findViewById(R.id.heightEditText);
        mDoorsEditText = (EditText) findViewById(R.id.doorsEditText);
        mWindowsEditText = (EditText) findViewById(R.id.windowsEditText);
        mGallonsTextView = (TextView) findViewById(R.id.gallonsTextView);
    }

    private void loadSharedPreferences()
    {
        mPrefs = getSharedPreferences("edu.orangecoastcollege.cs273.mmendoza.PaintEstimator", MODE_PRIVATE);
        if (mPrefs != null)
        {
            // Load all the room information
            mRoom.setDoors(mPrefs.getInt("doors", 0));
            mDoorsEditText.setText(String.valueOf(mRoom.getDoors()));
            mRoom.setHeight(mPrefs.getFloat("height", 0.0f));
            mHeightEditText.setText(String.valueOf(mRoom.getHeight()));
            mRoom.setLength(mPrefs.getFloat("length", 0.0f));
            mLengthEditText.setText(String.valueOf(mRoom.getLength()));
            mRoom.setWidth(mPrefs.getFloat("width", 0.0f));
            mWidthEditText.setText(String.valueOf(mRoom.getWidth()));
            mRoom.setWindows(mPrefs.getInt("windows", 0));
            mWindowsEditText.setText(String.valueOf(mRoom.getWindows()));
        }
    }

    private void saveSharedPreferences()
    {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.clear();
        editor.putFloat("length", mRoom.getLength());
        editor.putFloat("width", mRoom.getWidth());
        editor.putFloat("height", mRoom.getHeight());
        // TODO: Keep going...
        editor.putInt("doors", mRoom.getDoors());
        editor.putInt("windows", mRoom.getWindows());
        // Save the changes to the SharedPreferences file
        editor.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        loadSharedPreferences();
    }

    protected void computeGallons(View v)
    {
        // Update the model first, then calculate
        mRoom.setLength(Float.parseFloat(mLengthEditText.getText().toString()));
        mRoom.setWidth(Float.parseFloat(mWidthEditText.getText().toString()));
        // TODO: Finish the rest
        mRoom.setHeight(Float.parseFloat(mHeightEditText.getText().toString()));

        mGallonsTextView.setText(getString(R.string.interior_surface_area_text) + " " + mRoom.totalSurfaceArea()
        + "\n" + getString(R.string.gallons_needed_text) + " " + mRoom.gallonsOfPaintRequired());
        saveSharedPreferences();
    }

    protected void gotoHelp(View v)
    {
        // Construct an explicit Intent to go to HelpActivity
        // Intent: specify where to start (context) and where we're going (next Activity)
        Intent helpIntent = new Intent(this, HelpActivity.class);
        helpIntent.putExtra("gallons", mRoom.gallonsOfPaintRequired());
        startActivity(helpIntent);
    }

}
