package xyz.yakdmt.navremote.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import xyz.yakdmt.navremote.App;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Delivery;
import xyz.yakdmt.navremote.utils.Events;

/**
 * Created by yakdmt on 08/11/15.
 */
public class DeliveryHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.id) TextView mId;
    @Bind(R.id.client_name) TextView mClientName;
    @Bind(R.id.description) TextView mDescription;
    @Bind(R.id.status) TextView mStatus;
    @Bind(R.id.cargo_desc) TextView mCargoDesc;
    @Bind(R.id.departure_date) TextView mDepDate;
    @Bind(R.id.start_point) TextView mStartPoint;
    @Bind(R.id.receiver) TextView mReceiver;
    @Bind(R.id.finish_point) TextView mFinishPoint;
    @Bind(R.id.arrival_date) TextView mArrivalDate;

    public DeliveryHolder(Context context, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Delivery delivery) {

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new Events.OnDeliveryClick(delivery));
            }
        });
        if (!App.bindViews) {
            return;
        }
        mId.setText(delivery.getId());
        mClientName.setText("Клиент: "+delivery.getClient_name());
        mDescription.setText(delivery.getDescription());
        mStatus.setText(delivery.getStatus());
        mCargoDesc.setText("Груз: "+delivery.getCargo_description());
        mDepDate.setText("Ожид.: "+delivery.getExpected_start_date()+"Факт: "+delivery.getActual_start_date());
        mStartPoint.setText(delivery.getStart_country()+", "+delivery.getStart_checkpoint_name());
        mReceiver.setText(delivery.getReceiver_name());
        mFinishPoint.setText(delivery.getFinish_checkpoint_name());
        mArrivalDate.setText("Факт: "+delivery.getActual_finish_date());
    }

}
