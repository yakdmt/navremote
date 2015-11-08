package xyz.yakdmt.navremote.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Order;

/**
 * Created by yakdmt on 08/11/15.
 */
public class OrderHolder extends RecyclerView.ViewHolder {

    private TextView mTextView;
    private ImageView mImageView;
    private Context mContext;

    public OrderHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        mImageView = (ImageView) itemView.findViewById(R.id.image);
        mTextView = (TextView) itemView.findViewById(R.id.title);
    }

    public void bind(Order order) {

        mTextView.setText(order.getId());
    }

}
