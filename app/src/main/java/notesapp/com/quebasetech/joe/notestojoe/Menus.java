package notesapp.com.quebasetech.joe.notestojoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Menus extends AppCompatActivity {
    private Button optionsBtn, popupOptionsMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        optionsBtn = (Button) findViewById(R.id.optionsMenuBtn);
        popupOptionsMenu = (Button) findViewById(R.id.popupMenuButton);

        optionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menus.this, OptionsMenu.class);
                startActivity(intent);
            }
        });

        popupOptionsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Setup PopupMenu object
                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), popupOptionsMenu);
                //Inflate menu
                popupMenu.getMenuInflater().inflate(R.menu.delivery_time_popup_menu, popupMenu.getMenu());
                // Handle options click
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getApplicationContext(), "Item selected: " + item.getItemId(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                //Show
                popupMenu.show();
            }
        });
    }
}
