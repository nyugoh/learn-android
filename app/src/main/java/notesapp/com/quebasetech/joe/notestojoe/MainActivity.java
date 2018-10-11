package notesapp.com.quebasetech.joe.notestojoe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Context ctx;
    ListView listViewNormal;
    String[] listValues = new String[] {
      "Introduction", "Required-tools", "Android Studio", "First sample Program", "Volume Calculator", "Toast","Unit Converter","Explicit intent", "Implicit Intent", "Notifications","Text to Speak", "Rate App", "Menus"
    };
    String[] activityIntents = new String[] {

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ctx = this;
        this.allocateMemory();
        this.setEvents();
    }

    // Set-up events ~ Button click events
    private void setEvents() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ctx, android.R.layout.simple_list_item_1, listValues);
        listViewNormal.setAdapter(adapter);
        listViewNormal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(ctx, Introduction.class);
                        break;
                    case 4:
                        intent = new Intent(ctx, volume_calculator.class);
                        break;
                    case 6:
                        intent = new Intent(ctx, unit_converter.class);
                        break;
                    case 7:
                        intent = new Intent(ctx, Explicit_intent.class);
                        break;
                    case 8:
                        intent = new Intent(ctx, Implicit_Intent.class);
                        break;
                    case 9:
                        intent = new Intent(ctx, Notifications.class);
                        break;
                    case 10:
                        intent = new Intent(ctx, Rating_App.class);
                    case 12:
                        intent = new Intent(ctx, Menus.class);
                        break;
                    default:
                        intent = new Intent(ctx, Introduction.class);
                        Toast.makeText(MainActivity.this, listValues[position] + " selected, index:" + position, Toast.LENGTH_SHORT).show();
                }

                ctx.startActivity(intent);
            }
        });
    }

    //
    private void allocateMemory() {
        listViewNormal = (ListView) findViewById(R.id.list_view_normal);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
