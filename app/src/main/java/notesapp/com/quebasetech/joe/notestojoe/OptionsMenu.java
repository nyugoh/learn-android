package notesapp.com.quebasetech.joe.notestojoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class OptionsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
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
            Toast.makeText(OptionsMenu.this, "Color selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.backgroundOption) {
            Toast.makeText(OptionsMenu.this, "Background color selected", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (id == R.id.others) {
            Toast.makeText(OptionsMenu.this, "Others selected", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
