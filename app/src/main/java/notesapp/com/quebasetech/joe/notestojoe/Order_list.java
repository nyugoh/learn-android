package notesapp.com.quebasetech.joe.notestojoe;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Order_list extends AppCompatActivity {

    Context context;
    ListView listView;
    private String[] items = {
            "Smokies",
            "Smokies & eggs",
            "Eggs",
            "Apples",
            "Groceries",
            "Milk",
    };
    private Double[] prices = {
            20.0,
            40.0,
            20.0,
            25.0,
            75.0,
            35.0,
    };
    private String[] sellers = {
            "Jane Doe",
            "Awesome Dude",
            "John Doe",
            "Joe Nyugoh",
            "Fisher Maxwell",
            "Milly Bett",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        context = this;
        listView = (ListView) findViewById(R.id.listView);
        OrdersAdapter adapter = new OrdersAdapter(context, items, prices, sellers);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, "You selected: " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
