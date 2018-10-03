package edu.temple.customspinner;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        //get the intent message that was passed to this activity
        Intent intent = getIntent();
        String colorUserSelected = intent.getStringExtra("colorUserSelected");
        //set the text to the color selected
        TextView textView = findViewById(R.id.theSelectedColor);
        textView.setText(colorUserSelected);
        //change the background to the color selected
        //create handle to the canvas activity layout
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.canvas_activityID);
        layout.setBackgroundColor(Color.parseColor(colorUserSelected));

    }
}
