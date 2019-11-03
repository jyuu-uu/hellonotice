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

public class ScrapAdapter extends ArrayAdapter {
    Context context;
    ArrayList<Post> data;

    public ScrapAdapter(Context context, int resource, ArrayList<Post> objects) {
        super(context, resource, objects);
        this.context = context;
        data = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.list_item, null);
        }
        final Post tmp = data.get(position);
        if (tmp != null) {
            TextView t1 = v.findViewById(R.id.li_title);
            TextView t2 = v.findViewById(R.id.li_content);
            //ImageView i1 = v.findViewById(R.id.li_btn);
            t1.setText(tmp.getTitle());
            t2.setText(tmp.getContent());
        }

        return v;
    }
}
