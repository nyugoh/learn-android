package notesapp.com.quebasetech.joe.notestojoe;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Implicit_Intent extends AppCompatActivity {

    private Button callBtn, smsBtn,  emailBtn, dailBtn, browserBtn, gmapsBtn, contactBtn, shareBtn;
    private Context ctx;
    private EditText firstValue, secondValue;
    private String mFirst, mSecond;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        ctx = this;
        allocateMemory();

        setupEvents();
    }

    private void allocateMemory() {
        callBtn = (Button) this.findViewById(R.id.button);
        smsBtn = (Button) this.findViewById(R.id.button2);
        emailBtn = (Button) this.findViewById(R.id.button3);
        dailBtn = (Button) this.findViewById(R.id.dailer);
        browserBtn = (Button) this.findViewById(R.id.browser2);
        gmapsBtn = (Button) this.findViewById(R.id.browser);
        contactBtn = (Button) this.findViewById(R.id.browser3);
        shareBtn = (Button) this.findViewById(R.id.browser4);

        firstValue = (EditText) this.findViewById(R.id.firstValue);
        secondValue = (EditText) this.findViewById(R.id.secondValue);
    }

    private void setupEvents() {
        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupValues();
                try{
                    intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+mFirst));
                    // Pre-marshmellow and Post-Mashmellow
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){ // 23
                        // Check if can make calls else ask for permissions
                        if(checkSelfPermission(android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(ctx, "Permission granted", Toast.LENGTH_SHORT).show();
                            requestPermissions(new String[] { Manifest.permission.CALL_PHONE}, 10);
                            return;
                        }
                    }
                    ctx.startActivity(intent);
                } catch (SecurityException e) {
                    Log.e("CALL_ERROR", "Can't make call");
                    Toast.makeText(ctx, "Can't complete call", Toast.LENGTH_SHORT).show();
                }
            }
        });

        smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupValues();
                try{
                    //Check for second value
                    if(mSecond.isEmpty()) {
                        secondValue.setError("Second field is required");
                        Toast.makeText(ctx, "Second field is required", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("smsto:"));
                    intent.setType("vnd.android-dir/mms-sms");
                    intent.putExtra("address", mFirst);
                    intent.putExtra("sms_body", mSecond);
                    ctx.startActivity(intent);
                }catch (android.content.ActivityNotFoundException e){
                    Toast.makeText(ctx, "No intent to handle this", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                catch (Exception e) {
                    Toast.makeText(ctx, "Can't send text", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        emailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupValues();
                try{
                    //Check for second value
                    if(mSecond.isEmpty()) {
                        secondValue.setError("Second field is required");
                        Toast.makeText(ctx, "Second field is required", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    intent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_EMAIL, mFirst);
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Test email");
//                    intent.putExtra(Intent.EXTRA_CC, "nyugoh@gmail.com"); //Doesn't get picked by GMail composer
                    intent.putExtra(Intent.EXTRA_TEXT, mSecond);
                    startActivity(Intent.createChooser(intent, "Send email..."));
                }catch (android.content.ActivityNotFoundException e){
                    Toast.makeText(ctx, "No intent to handle this", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                catch (Exception e) {
                    Toast.makeText(ctx, "Can't send email", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });

        dailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupValues();
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ mFirst));
                startActivity(intent);
            }
        });

        browserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupValues();
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+mFirst));
                startActivity(intent);
            }
        });

        gmapsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupValues();
                //Check for second value
                if(mSecond.isEmpty()) {
                    secondValue.setError("Second field is required");
                    Toast.makeText(ctx, "Second field is required", Toast.LENGTH_SHORT).show();
                    return;
                }
                String coordinates = mFirst + "," + mSecond;
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+coordinates));
                startActivity(intent);
            }
        });

        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupValues();
            }
        });

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupValues();
            }
        });
    }

    private boolean setupValues() {
        // Get the fields
         mFirst = firstValue.getText().toString();
         mSecond = secondValue.getText().toString();

        // Validate fields
        if(mFirst.isEmpty()){
            firstValue.setError("Enter at least something here.");
            return false;
        } else
            return true;
    }
}
