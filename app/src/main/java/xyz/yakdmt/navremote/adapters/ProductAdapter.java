package xyz.yakdmt.navremote.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Product;
import xyz.yakdmt.navremote.holders.ProductHolder;

/**
 * Created by yakdmt on 11/11/15.
 */
public class ProductAdapter extends RecyclerView.Adapter{
    private ArrayList<Product> mFullData = new ArrayList<>();
    private ArrayList<Product> mData = new ArrayList<>();
    private Context mContext;

    public ProductAdapter(Context context, ArrayList<Product> items) {
        this.mFullData = items;
        this.mData = items;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.holder_product, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        return new ProductHolder(mContext, v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((ProductHolder)viewHolder).bind(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
