package xyz.yakdmt.navremote.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Cargo;
import xyz.yakdmt.navremote.utils.Events;

/**
 * Created by yakdmt on 08/11/15.
 */
public class CargoHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.id) TextView mId;
    @Bind(R.id.client_name) TextView mClientName;
    @Bind(R.id.description) TextView mDescription;
    @Bind(R.id.appearance_date) TextView mAppearanceDate;
    @Bind(R.id.sender_name) TextView mSenderName;
    @Bind(R.id.expected_departure_date) TextView mExpDepDate;
    @Bind(R.id.occurence) TextView mOccurence;
    @Bind(R.id.master_document) TextView mMasterDocument;
    @Bind(R.id.transport_line) TextView mTransportLine;
    @Bind(R.id.consignee_name) TextView mConsigneeName;
    @Bind(R.id.expected_arrival_date) TextView mExpArrDate;
    @Bind(R.id.destination) TextView mDestination;
    @Bind(R.id.weight) TextView mWeight;
    @Bind(R.id.volume) TextView mVolume;
    @Bind(R.id.count) TextView mCount;

    private Context mContext;

    public CargoHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        ButterKnife.bind(this, itemView);

    }

    public void bind(final Cargo cargo) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new Events.OnCargoClick(cargo));
            }
        });
        mId.setText(cargo.getId());
        mClientName.setText("Клиент: "+cargo.getClient_name());
        mDescription.setText("Описание: "+cargo.getDescription());
        mAppearanceDate.setText("Дата появления: "+cargo.getAppearance_date());
        mSenderName.setText(cargo.getSender_name());
        mExpDepDate.setText(cargo.getExpected_departure_date());
        mOccurence.setText(cargo.getOccurence_checkpoint_type()+", "+cargo.getOccurence_checkpoint_code());
        mMasterDocument.setText(cargo.getMaster_document());
        mTransportLine.setText(cargo.getTransport_line_code()+", "+cargo.getTransport_line_name());
        mConsigneeName.setText(cargo.getConsignee_name());
        mExpArrDate.setText(cargo.getExpected_arrival_date());
        mDestination.setText(cargo.getDestination_checkpoint_type()+", "+cargo.getDestination_checkpoint_code());
        mWeight.setText("Вес, кг: "+cargo.getWeight());
        mVolume.setText("Объем, м^3: "+cargo.getVolume());
        mCount.setText("Мест: "+cargo.getCount());
    }

}
