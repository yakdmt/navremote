package xyz.yakdmt.navremote.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.yakdmt.navremote.DetailActivity;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Checkpoint;
import xyz.yakdmt.navremote.database.RouteRow;

/**
 * Created by yakdmt on 08/11/15.
 */
public class RouteRowHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    @Bind(R.id.checkpoint_ref) TextView mCheckpointRef;
    @Bind(R.id.address) TextView mAddress;
    @Bind(R.id.procedure_type) TextView mProcedureType;
    @Bind(R.id.expected_arrival) TextView mExpectedArrival;
    @Bind(R.id.actual_arrival) TextView mActualArrival;
    @Bind(R.id.expected_departure) TextView mExpectedDeparture;
    @Bind(R.id.actual_departure) TextView mActualDeparture;

    public RouteRowHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        ButterKnife.bind(this, itemView);
    }

    public void bind(final RouteRow routeRow) {
        final Checkpoint checkpoint = routeRow.getCheckpoint();
        if (checkpoint!=null) {
            mCheckpointRef.setText("Пункт: "+checkpoint.getName());
            mCheckpointRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DetailActivity)mContext).showCheckpointDialog(checkpoint);
                }
            });
        }
        mAddress.setText(routeRow.getCountry_name()+", "+routeRow.getAddress());
        mProcedureType.setText("Тип процедуры: "+routeRow.getProcedure_type());
        mExpectedArrival.setText("Ожид.: "+routeRow.getExpected_arrival_date());
        mActualArrival.setText("Факт.: "+routeRow.getActual_arrival_date()+" "+routeRow.getActual_arrival_time());
        mExpectedDeparture.setText("Ожид.: "+routeRow.getExpected_departure_date()+" "+routeRow.getExpected_departure_time());
        mActualDeparture.setText("Факт.: "+routeRow.getActual_departure_date()+" "+routeRow.getActual_departure_time());

    }


}
