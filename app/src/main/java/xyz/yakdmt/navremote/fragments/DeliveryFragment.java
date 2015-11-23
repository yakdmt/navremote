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
import xyz.yakdmt.navremote.App;
import xyz.yakdmt.navremote.DetailActivity;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.CommentDao;
import xyz.yakdmt.navremote.database.DaoTask;
import xyz.yakdmt.navremote.database.Delivery;
import xyz.yakdmt.navremote.database.WorkDao;
import xyz.yakdmt.navremote.utils.TextUtil;

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
    @Bind(R.id.route_ref) TextView mRouteRef;

    @Bind(R.id.works_ref) TextView mWorksRef;
    @Bind(R.id.comments_ref) TextView mCommentsRef;

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
        if (!App.bindViews) {
            return view;
        }
        mId.setText(TextUtil.removeNulls(delivery.getId()));
        mClientName.setText(TextUtil.removeNulls("Клиент: "+delivery.getClient_name()));
        mDescription.setText(TextUtil.removeNulls(delivery.getDescription()));
        mStatus.setText(TextUtil.removeNulls(delivery.getStatus()));
        mCargoDesc.setText(TextUtil.removeNulls("Груз: "+delivery.getCargo_description()));
        mDepDate.setText(TextUtil.removeNulls("Ожид.: "+delivery.getExpected_start_date()+"Факт: "+delivery.getActual_start_date()));
        mStartPoint.setText(TextUtil.removeNulls(delivery.getStart_country()+", "+delivery.getStart_checkpoint_name()));
        mReceiver.setText(TextUtil.removeNulls(delivery.getReceiver_name()));
        mFinishPoint.setText(TextUtil.removeNulls(delivery.getFinish_checkpoint_name()));
        mArrivalDate.setText(TextUtil.removeNulls("Факт: "+delivery.getActual_finish_date()));
        if (delivery.getCargo()!=null) {
            SpannableString cargoId = new SpannableString(delivery.getCargo().getId());
            cargoId.setSpan(new UnderlineSpan(), 0, cargoId.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mCargoRef.setText(TextUtil.removeNulls("Груз:" + cargoId));
            mCargoRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DetailActivity)getActivity()).openCargoFragment(delivery.getCargo());
                }
            });
        }
        mMethod.setText(TextUtil.removeNulls("Метод: "+delivery.getTransportation_method()));
        mPerformer.setText(TextUtil.removeNulls(delivery.getPerformer_name()));
        mAutoCarrier.setText(TextUtil.removeNulls(delivery.getAuto_carrier()+"("+delivery.getAuto_train_number()+")"));
        mTerminal.setText(TextUtil.removeNulls("Терминал: "+delivery.getTerminal_name()));
        mArrTermDate.setText(TextUtil.removeNulls("Ожид.: "+delivery.getExpected_arrival_terminal_date()+"; Факт.:"+delivery.getActual_arrival_terminal_date()));
        mActRelTerm.setText(TextUtil.removeNulls("Факт.: "+delivery.getActual_release_terminal_date()));
        mContainerNum.setText(TextUtil.removeNulls("Номер контейнера: "+delivery.getContainer_number()));
        mRouteRef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DetailActivity) getActivity()).openRouteFragment(delivery);
            }
        });

        long worksCount = DaoTask.getInstance().getSession().getWorkDao().queryBuilder().where(WorkDao.Properties.Delivery_id.eq(delivery.getId())).count();
        mWorksRef.setText(TextUtil.removeNulls("Работы: " + worksCount));
        if (worksCount>0) {
            mWorksRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DetailActivity)getActivity()).openWorksFragment(delivery);
                }
            });
        }
        long commentsCount = DaoTask.getInstance().getSession().getCommentDao().queryBuilder().where(CommentDao.Properties.Object_id.eq(delivery.getId())).count();
        mCommentsRef.setText(TextUtil.removeNulls("Комментарии: "+commentsCount));
        if (commentsCount>0) {
            mCommentsRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DetailActivity)getActivity()).openCommentsFragment(delivery);
                }
            });
        }
        return view;
    }

}
