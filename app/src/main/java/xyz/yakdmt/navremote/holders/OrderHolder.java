package xyz.yakdmt.navremote.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.greenrobot.event.EventBus;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Order;
import xyz.yakdmt.navremote.utils.Events;

/**
 * Created by yakdmt on 08/11/15.
 */
public class OrderHolder extends RecyclerView.ViewHolder {

    private TextView mId;
    private ImageView mImageView;
    private Context mContext;

    public OrderHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        mImageView = (ImageView) itemView.findViewById(R.id.image);
        mId = (TextView) itemView.findViewById(R.id.id);
    }

    public void bind(final Order order) {
        mId.setText(order.getId());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new Events.OnOrderClick(order));
            }
        });
    }

}
