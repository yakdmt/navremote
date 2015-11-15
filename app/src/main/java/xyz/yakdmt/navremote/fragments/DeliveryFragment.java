package xyz.yakdmt.navremote.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.yakdmt.navremote.DetailActivity;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Delivery;

/**
 * Created by yakdmt on 10/11/15.
 */
public class DeliveryFragment extends Fragment {

    private Delivery delivery;
    //from holder
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
    //additional
    @Bind(R.id.cargo_ref) TextView mCargoRef;
    @Bind(R.id.transportation_method) TextView mMethod;
    @Bind(R.id.performer) TextView mPerformer;
    @Bind(R.id.auto_carrier) TextView mAutoCarrier;;
    @Bind(R.id.terminal) TextView mTerminal;
    @Bind(R.id.arrival_terminal_date) TextView mArrTermDate;
    @Bind(R.id.actual_release_terminal_date) TextView mActRelTerm;
    @Bind(R.id.container_number) TextView mContainerNum;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        delivery = (Delivery) getArguments().getSerializable("delivery");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delivery, container, false);
        ButterKnife.bind(this, view);
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
        if (delivery.getCargo()!=null) {
            SpannableString cargoId = new SpannableString(delivery.getCargo().getId());
            cargoId.setSpan(new UnderlineSpan(), 0, cargoId.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mCargoRef.setText("Груз:" + cargoId);
            mCargoRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DetailActivity)getActivity()).openCargoFragment(delivery.getCargo());
                }
            });
        }
        mMethod.setText("Метод: "+delivery.getTransportation_method());
        mPerformer.setText(delivery.getPerformer_name());
        mAutoCarrier.setText(delivery.getAuto_carrier()+"("+delivery.getAuto_train_number()+")");
        mTerminal.setText("Терминал: "+delivery.getTerminal_name());
        mArrTermDate.setText("Ожид.: "+delivery.getExpected_arrival_terminal_date()+"; Факт.:"+delivery.getActual_arrival_terminal_date());
        mActRelTerm.setText("Факт.: "+delivery.getActual_release_terminal_date());
        mContainerNum.setText("Номер контейнера: "+delivery.getContainer_number());

        return view;
    }

}
