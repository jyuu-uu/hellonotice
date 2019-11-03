package com.example.hellonotice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivityAdapter extends ArrayAdapter {
    ArrayList<Post> data;
    Context context;
    public SearchActivityAdapter(Context context, int resource, ArrayList<Post> objects) {
        super(context, resource, objects);
        this.context = context;
        data = objects;
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.main_item, null);
        }
        final Post tmp = data.get(position);
        if (tmp != null) {
            TextView t1 = v.findViewById(R.id.mi_title);
            TextView t2 = v.findViewById(R.id.mi_content);
            t1.setText(tmp.getTitle());
            t2.setText(tmp.getContent());
        }

        return v;
    }

}