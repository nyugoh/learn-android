package notesapp.com.quebasetech.joe.notestojoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Home_page extends AppCompatActivity {
    private TextView username, userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        username = (TextView) findViewById(R.id.userName);
        userid = (TextView) findViewById(R.id.userID);

        Bundle extras = getIntent().getExtras();
        String user = extras.getString("username");
        int id = extras.getInt("userId");

        username.setText(user);
        userid.setText("" + id);
    }
}
