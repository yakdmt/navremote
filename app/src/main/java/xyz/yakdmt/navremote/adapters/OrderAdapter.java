package xyz.yakdmt.navremote.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Order;
import xyz.yakdmt.navremote.holders.OrderHolder;

/**
 * Created by yakdmt on 08/11/15.
 */
public class OrderAdapter extends RecyclerView.Adapter {
    private ArrayList<Order> mFullData = new ArrayList<>();
    private ArrayList<Order> mData = new ArrayList<>();
    private Context mContext;

    public OrderAdapter(Context context, ArrayList<Order> items) {
        this.mFullData = items;
        this.mData = items;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.holder_order, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        OrderHolder holder = new OrderHolder(mContext, v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((OrderHolder)viewHolder).bind(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
