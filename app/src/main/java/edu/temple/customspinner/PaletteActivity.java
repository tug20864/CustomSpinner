package edu.temple.customspinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class PaletteActivity extends AppCompatActivity {

    private ArrayList<ColorItem> pColorList;
    private ColorAdapter pColorAdapter;
    private boolean isSpinnerTouched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        //Initialize color items to be added to spinner by creating instances of color
        //items and adding them to the arrayList of colorItems
        initList();

        //create handle for spinner in the main activity
        Spinner spinnerColors = findViewById(R.id.spinner_colors);
        //create instance of custom adapter that will be used to populate the spinner
        ColorAdapter colorAdapter = new ColorAdapter(this, pColorList);
        //now give the spinner an adapter(the custom one that was created) by setting the spinners
        //adapter
        spinnerColors.setAdapter(colorAdapter);


        //This will stop the spinner from selected the first item in the list when initially loaded
        //by using the isSpinnerTouched boolean
        spinnerColors.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                isSpinnerTouched = true;
                return false;
            }
        });

        //CREATE AN ITEM SELECTED LISTENER ON FOR THE SPINNER
        //THIS WILL LOAD THE NEW ACTIVITY WHEN ONE OF THE COLORS ARE SELECTED AND WILL PASS THE
        //SELECTED COLOR STRING TO THE NEW ACTIVITY TO SET THE BACKGROUND COLOR
        spinnerColors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //if the user has not touched the spinner then stop and return
                //do not load the new activity
                if(!isSpinnerTouched) {
                    return;
                }
                ColorItem clickedColor = (ColorItem) parent.getItemAtPosition(position);
                String chosenColor = clickedColor.getColor();
                openCanvasActivity(chosenColor);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    //This method will load the new activity and pass the color string that was to the new activity
    public void openCanvasActivity(String selectedColor){
        Intent intent = new Intent(this, CanvasActivity.class);
        intent.putExtra("colorUserSelected", selectedColor);
        startActivity(intent);
    }

    private void initList(){
        pColorList = new ArrayList<>();
        pColorList.add(new ColorItem("BLUE"));
        pColorList.add(new ColorItem("WHITE"));
        pColorList.add(new ColorItem("GREEN"));
        pColorList.add(new ColorItem("YELLOW"));
        pColorList.add(new ColorItem("MAGENTA"));

    }
}
