package com.example.listview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Item> itemList;

    public CustomListAdapter(Context context, ArrayList<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        // Bind data from the data model to the UI elements in the layout
        TextView nameTextView = convertView.findViewById(R.id.name_text_view);
        TextView descriptionTextView = convertView.findViewById(R.id.description_text_view);
        Item item = itemList.get(position);
        nameTextView.setText(item.getName());
        descriptionTextView.setText(item.getDescription());

        return convertView;
    }
}
