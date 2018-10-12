package notesapp.com.quebasetech.joe.notestojoe;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class OrdersAdapter extends ArrayAdapter<String> {

    private  final Context context;
    private final String[] items;
    private final Double[] prices;
    private final String[] sellers;

    public OrdersAdapter(@NonNull Context context, String[] items, Double[] prices, String[] sellers) {
        super(context, R.layout.items_list, items);
        this.context = context;
        this.items = items;
        this.prices = prices;
        this.sellers = sellers;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.items_list, parent, false);
        TextView itemName = (TextView) rowView.findViewById(R.id.item_name);
        TextView itemPrice = (TextView) rowView.findViewById(R.id.item_price_value);
        TextView itemSeller = (TextView) rowView.findViewById(R.id.seller_value);
        itemName.setText(items[position]);
        itemPrice.setText(prices[position].toString());
        itemSeller.setText(sellers[position]);
        return rowView;
    }
}
