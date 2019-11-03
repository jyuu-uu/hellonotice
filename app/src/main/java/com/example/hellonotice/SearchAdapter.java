package com.example.hellonotice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;


public class SearchAdapter extends ArrayAdapter {
    Context context;
    ArrayList<Post> data;

    public SearchAdapter( Context context, int resource, int textViewResourceId, ArrayList<Post> objects) {
        super(context, resource, textViewResourceId, objects);
        this.context = context;
        data = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.search_item, null);
        }
        return v;
    }
}
