package com.abdalkareem.project;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private String[] carTypes;
    private int[] carImages;
    private LayoutInflater inflater;

    public ListViewAdapter(Context context, String[] carTypes, int[] carImages) {
        this.context = context;
        this.carTypes = carTypes;
        this.carImages = carImages;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return carTypes.length;
    }

    @Override
    public Object getItem(int position) {
        return carTypes[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view_card, parent, false);
        }

        ImageView carImageView = convertView.findViewById(R.id.carImageView);
        TextView carTypeTextView = convertView.findViewById(R
                .id.carTypeTextView);

        carImageView.setImageResource(carImages[position]);
        carTypeTextView.setText(carTypes[position]);

        return convertView;
    }
}