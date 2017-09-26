package edu.orangecoastcollege.cs273.mmendoza.paintestimator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;
import android.content.Intent;

public class HelpActivity extends AppCompatActivity
{
    private TextView mEstimatedGallonsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        mEstimatedGallonsTextView = (TextView) findViewById(R.id.estimatedPaintRequiredTextView);
        Intent helperIntent = getIntent();
        mEstimatedGallonsTextView.setText((String) helperIntent.getExtras().get("gallons"));
    }

    /**
     * Goes back to the MainActivity when the user presses the button to input room dimensions
     *
     * @param v
     */
    protected void gotoInput(View v)
    {
        Intent inputIntent = new Intent(this, MainActivity.class);
        startActivity(inputIntent);
    }
}
