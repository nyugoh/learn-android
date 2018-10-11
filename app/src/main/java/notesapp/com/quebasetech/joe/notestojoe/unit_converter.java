package notesapp.com.quebasetech.joe.notestojoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class unit_converter extends AppCompatActivity {
    private EditText mInches;
    private CheckBox footCb, metersCb, kilometerCb;
    private Button convertBtn;
    private TextView ftView, mtView, kmView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);

        allocateMemory();
        setupEvents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.color) {
            Toast.makeText(getApplicationContext(), "Color selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.backgroundOption) {
            Toast.makeText(getApplicationContext(), "Background color selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.others) {
            Toast.makeText(getApplicationContext(), "Others selected", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void allocateMemory() {
        mInches = (EditText) findViewById(R.id.inches);
        footCb = (CheckBox) findViewById(R.id.footCbtn);
        metersCb = (CheckBox) findViewById(R.id.meterCbtn);
        kilometerCb = (CheckBox) findViewById(R.id.kilometerCbtn);
        convertBtn = (Button) findViewById(R.id.calculate);
        ftView = (TextView) findViewById(R.id.ftResult);
        mtView = (TextView) findViewById(R.id.mtResults);
        kmView = (TextView) findViewById(R.id.kmResults);
    }

    private void setupEvents() {
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inchesString = mInches.getText().toString();
                float inches;

                if (inchesString.isEmpty()){
                    mInches.setError("Enter a value");
                    return;
                }

                inches = Float.parseFloat(inchesString);
                if(inches <= 0) {
                    Toast.makeText(getApplicationContext(), "Enter a value greater than 0", Toast.LENGTH_SHORT).show();
                    return;
                }

                convert(inches);
            }
        });
    }

    private void convert(float inches) {
        float ft, mt, km = 0;

        if(footCb.isChecked()){
            ft = inches/ 12.0f;
            ftView.setText("" + ft);
        } else {
            ftView.setText("");
        }

        if(metersCb.isChecked()){
            mt = (inches/ 12.0f) / 3;
            mtView.setText("" + mt);
        } else {
            mtView.setText("");
        }

        if(kilometerCb.isChecked()){
            km = ((inches/ 12.0f) / 3) / 1000;
            kmView.setText("" + km);
        } else {
            kmView.setText("");
        }
    }
}
