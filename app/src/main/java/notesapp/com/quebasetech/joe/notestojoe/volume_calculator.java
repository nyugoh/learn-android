package notesapp.com.quebasetech.joe.notestojoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class volume_calculator extends AppCompatActivity {

    private Button calculate;
    private EditText heightField, widthField, lengthField;
    private TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_calculator);

        allocatememory();
        setupEvents();
    }

    private void allocatememory() {
        //Initialize widgets
        calculate = (Button) findViewById(R.id.calculate);
        heightField = (EditText) findViewById(R.id.heightValue);
        widthField = (EditText) findViewById(R.id.widthValue);
        lengthField = (EditText) findViewById(R.id.lengthValue);
        results = (TextView) findViewById(R.id.results);
    }

    private  void setupEvents() {
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String h = heightField.getText().toString();
                String w = widthField.getText().toString();
                String l = lengthField.getText().toString();

                if (h.isEmpty() || w.isEmpty() || l.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                float height= Float.parseFloat(h);
                float width = Float.parseFloat(w);
                float length = Float.parseFloat(l);

                //Check for  empty fields
                if(height <= 0) {
                    heightField.setError("Enter a value greater than 0");
                    Toast.makeText(getApplicationContext(), "Enter a valid value for height", Toast.LENGTH_SHORT).show();
                }
                if(width <= 0) {
                    widthField.setError("Enter a value greater than 0");
                    Toast.makeText(getApplicationContext(), "Enter a valid value for width", Toast.LENGTH_SHORT).show();
                }
                if(length <= 0) {
                    lengthField.setError("Enter a value greater than 0");
                    Toast.makeText(getApplicationContext(), "Enter a valid value for length", Toast.LENGTH_SHORT).show();
                }

                float volume = height * width * length;
                results.setText("" + volume);
            }
        });
    }
}
