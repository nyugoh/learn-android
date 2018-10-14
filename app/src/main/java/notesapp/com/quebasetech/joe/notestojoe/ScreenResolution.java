package notesapp.com.quebasetech.joe.notestojoe;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScreenResolution extends AppCompatActivity {
    private Button detect, configButton;
    private TextView orientation, resolution;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_resolution);

        detect = (Button) findViewById(R.id.detect);
        configButton = (Button) findViewById(R.id.configQualifiers);
        orientation = (TextView) findViewById(R.id.orientation);
        resolution = (TextView) findViewById(R.id.resolution);
    }

    public void detectScreen(View view) {
        Display display = getWindowManager().getDefaultDisplay();
        orientation.setText(""+ display.getRotation());

        //Resolution
        Point xy = new Point();
        display.getSize(xy);
        resolution.setText("Screen resolution: X="+ xy.x + " y=" + xy.y);
    }

    public void launchConfig(View view) {
        Intent intent = new Intent(getApplicationContext(), OrientationsConfig.class);
        startActivity(intent);
    }
}
