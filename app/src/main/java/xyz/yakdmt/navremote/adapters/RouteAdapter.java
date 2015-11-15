package xyz.yakdmt.navremote.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.RouteRow;
import xyz.yakdmt.navremote.holders.RouteRowHolder;

/**
 * Created by yakdmt on 11/11/15.
 */
public class RouteAdapter extends RecyclerView.Adapter{
    private ArrayList<RouteRow> mFullData = new ArrayList<>();
    private ArrayList<RouteRow> mData = new ArrayList<>();
    private Context mContext;

    public RouteAdapter(Context context, ArrayList<RouteRow> items) {
        this.mFullData = items;
        this.mData = items;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.holder_route_row, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        return new RouteRowHolder(mContext, v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((RouteRowHolder)viewHolder).bind(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
