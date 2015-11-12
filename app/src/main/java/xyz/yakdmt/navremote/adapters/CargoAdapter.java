package xyz.yakdmt.navremote.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Cargo;
import xyz.yakdmt.navremote.holders.CargoHolder;

/**
 * Created by yakdmt on 11/11/15.
 */
public class CargoAdapter extends RecyclerView.Adapter{
    private ArrayList<Cargo> mFullData = new ArrayList<>();
    private ArrayList<Cargo> mData = new ArrayList<>();
    private Context mContext;

    public CargoAdapter(Context context, ArrayList<Cargo> items) {
        this.mFullData = items;
        this.mData = items;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.holder_cargo, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        CargoHolder holder = new CargoHolder(mContext, v);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((CargoHolder)viewHolder).bind(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
