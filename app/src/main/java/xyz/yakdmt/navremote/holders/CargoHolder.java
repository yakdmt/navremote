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
import xyz.yakdmt.navremote.database.Cargo;
import xyz.yakdmt.navremote.utils.Events;
import xyz.yakdmt.navremote.utils.TextUtil;

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
        if (!App.bindViews) {
            return;
        }
        mId.setText(TextUtil.removeNulls(cargo.getId()));
        mClientName.setText(TextUtil.removeNulls("Клиент: "+cargo.getClient_name()));
        mDescription.setText(TextUtil.removeNulls("Описание: "+cargo.getDescription()));
        mAppearanceDate.setText(TextUtil.removeNulls("Дата появ.: "+cargo.getAppearance_date()));
        mSenderName.setText(TextUtil.removeNulls(cargo.getSender_name()));
        mOccurence.setText(TextUtil.removeNulls(cargo.getOccurence_checkpoint_type()+", "+cargo.getOccurence_checkpoint_code()));
        mMasterDocument.setText(TextUtil.removeNulls(cargo.getMaster_document()));
        mTransportLine.setText(TextUtil.removeNulls(cargo.getTransport_line_code()+", "+cargo.getTransport_line_name()));
        mConsigneeName.setText(TextUtil.removeNulls(cargo.getConsignee_name()));
        mDestination.setText(TextUtil.removeNulls(cargo.getDestination_checkpoint_type()+", "+cargo.getDestination_checkpoint_code()));
        mWeight.setText(TextUtil.removeNulls("Вес, кг: "+cargo.getWeight()));
        mVolume.setText(TextUtil.removeNulls("Объем, м^3: "+cargo.getVolume()));
        mCount.setText(TextUtil.removeNulls("Мест: "+cargo.getCount()));
    }

}
