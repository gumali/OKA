package com.abdalkareem.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class carsAdapter extends RecyclerView.Adapter<carsAdapter.ViewHolder> {
    private Context context;
    private List<Cars> items;
    private CarSelectListener listener;

    public carsAdapter(Context context, List<Cars> items, CarSelectListener listener) {
        this.context = context;
        this.items = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.car_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Cars car = items.get(position);
        CardView cardView = holder.cardView;
        ImageView imageView = cardView.findViewById(R.id.image);
        Glide.with(context).load(car.getCarImage()).into(imageView);
        TextView txt = cardView.findViewById(R.id.txtName);
        txt.setText("Name: " + car.getName() + " Company: " + car.getCompany() + " Model " + car.getModel() + " car License " + car.getLicinse());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(car);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;

        public ViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }
}
