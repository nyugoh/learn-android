package notesapp.com.quebasetech.joe.notestojoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Explicit_intent extends AppCompatActivity {
    private Button loginBtn;
    private EditText usernameInput, passInput;
    private TextView errorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        allocateMemory();
        setupEvents();
    }

    private void allocateMemory() {
        loginBtn = (Button) findViewById(R.id.loginBtn);
        usernameInput = (EditText) findViewById(R.id.username);
        passInput = (EditText) findViewById(R.id.password);
        errorText = (TextView) findViewById(R.id.feedbackView);
    }

    private void setupEvents() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get actual text
                String username = usernameInput.getText().toString();
                String password = passInput.getText().toString();

                //Validate the data
                if(username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(username.equals("admin") && password.equals("admin")) {
                    // Launch new intent
                    Intent homePage = new Intent(Explicit_intent.this, Home_page.class);
                    homePage.putExtra("username", username);
                    homePage.putExtra("userId", 2456);
                    startActivity(homePage);
//                    finish();
                } else {
                    errorText.setText("Invalid username/password");
                    errorText.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                }
            }
        });
    }
}
