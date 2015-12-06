package xyz.yakdmt.navremote.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import xyz.yakdmt.navremote.App;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Order;
import xyz.yakdmt.navremote.utils.Events;
import xyz.yakdmt.navremote.utils.TextUtil;

/**
 * Created by yakdmt on 08/11/15.
 */
public class OrderHolder extends RecyclerView.ViewHolder {


    @Bind(R.id.id) TextView mId;
    @Bind(R.id.departure) TextView mDeparture;
    @Bind(R.id.date_time) TextView mDateTime;
    @Bind(R.id.declarant) TextView mDeclarant;
    @Bind(R.id.arrival) TextView mArrival;
    @Bind(R.id.weight) TextView mWeight;
    @Bind(R.id.volume) TextView mVolume;
    @Bind(R.id.count) TextView mCount;
    @Bind(R.id.client_name) TextView mClientName;
    @Bind(R.id.cargo_desc) TextView mCargoDesc;
    @Bind(R.id.departure_date) TextView mDepartureDate;
    private ImageView mImageView;
    private Context mContext;

    public OrderHolder(Context context, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = context;
        mImageView = (ImageView) itemView.findViewById(R.id.image);
        mId = (TextView) itemView.findViewById(R.id.id);

    }

    public void bind(final Order order) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new Events.OnOrderClick(order));
            }
        });
        if (!App.bindViews) {
            return;
        }
        mId.setText(TextUtil.removeNulls(order.getId()));
        StringBuilder departureBuilder = new StringBuilder();
        departureBuilder.append(order.getDeparture_country_name());
        departureBuilder.append(", ");
        departureBuilder.append(order.getDeparture_checkpoint_name());
        departureBuilder.append(", ");
        departureBuilder.append(order.getDeparture_checkpoint_address());
        mDeparture.setText(TextUtil.removeNulls(departureBuilder));
        mDateTime.setText(TextUtil.removeNulls(order.getDate() + " " + order.getTime()));
        StringBuilder arrivalBuilder = new StringBuilder();
        arrivalBuilder.append(order.getDestination_country_name());
        arrivalBuilder.append(", ");
        arrivalBuilder.append(order.getDestination_checkpoint_name());
        arrivalBuilder.append(", ");
        arrivalBuilder.append(order.getDestination_checkpoint_address());
        mArrival.setText(TextUtil.removeNulls(arrivalBuilder));
        mWeight.setText(TextUtil.removeNulls(order.getBrutto_weight() + " кг."));
        mVolume.setText(TextUtil.removeNulls(order.getVolume()+" м^3"));
        mCount.setText(TextUtil.removeNulls(order.getCount()));
        mClientName.setText(TextUtil.removeNulls(order.getClient_name()));
        mCargoDesc.setText(TextUtil.removeNulls(order.getCargo_description()));
        mDepartureDate.setText(TextUtil.removeNulls(order.getDeparture_date()));
    }

}
