package xyz.yakdmt.navremote.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Delivery;
import xyz.yakdmt.navremote.holders.DeliveryHolder;

/**
 * Created by yakdmt on 11/11/15.
 */
public class DeliveryAdapter extends RecyclerView.Adapter{
    private ArrayList<Delivery> mFullData = new ArrayList<>();
    private ArrayList<Delivery> mData = new ArrayList<>();
    private Context mContext;

    public DeliveryAdapter(Context context, ArrayList<Delivery> items) {
        this.mFullData = items;
        this.mData = items;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.holder_delivery, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        DeliveryHolder holder = new DeliveryHolder(mContext, v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((DeliveryHolder)viewHolder).bind(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
