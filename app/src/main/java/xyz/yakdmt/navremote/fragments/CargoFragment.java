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
import xyz.yakdmt.navremote.database.Cargo;
import xyz.yakdmt.navremote.database.CommentDao;
import xyz.yakdmt.navremote.database.DaoTask;
import xyz.yakdmt.navremote.database.WorkDao;

/**
 * Created by yakdmt on 10/11/15.
 */
public class CargoFragment extends Fragment {

    private Cargo cargo;
    //from holder
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
    //additional
    @Bind(R.id.route) TextView mRoute;
    @Bind(R.id.transport) TextView mTransport;
    @Bind(R.id.customs_clearance) TextView mCustoms;
    @Bind(R.id.broker) TextView mBroker;
    @Bind(R.id.delivery_conditions) TextView mDeliveryConditions;
    @Bind(R.id.processing_mode) TextView mProcessingMode;
    @Bind(R.id.cost) TextView mCost;
    @Bind(R.id.insurance) TextView mInsurance;
    @Bind(R.id.performer) TextView mPerformer;
    @Bind(R.id.status) TextView mStatus;
    @Bind(R.id.ready_state) TextView mReadyState;
    @Bind(R.id.order_ref) TextView mOrderRef;

    @Bind(R.id.works_ref) TextView mWorksRef;
    @Bind(R.id.comments_ref) TextView mCommentsRef;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cargo = (Cargo) getArguments().getSerializable("cargo");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cargo, container, false);
        ButterKnife.bind(this, view);
        if (!App.bindViews) {
            return view;
        }
        //from holder
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
        //additional
        mRoute.setText("Маршрут: "+cargo.getRoute());
        mTransport.setText("Транспорт: "+cargo.getTransport());
        mCustoms.setText("Таможенное оформление: "+cargo.getCustoms_clearance());
        mBroker.setText("Брокер: "+cargo.getBroker_name());
        mDeliveryConditions.setText("Условия поставки: "+cargo.getDelivery_conditions());
        mProcessingMode.setText("Режим обработки: "+cargo.getProcessing_mode());
        mCost.setText("Стоимость: "+cargo.getCost()+" "+cargo.getCurrency_code());
        mInsurance.setText("Страховка: "+cargo.getInsurance()+", "+cargo.getInsurance_amount());
        mPerformer.setText("Исполнитель: "+cargo.getStatus());
        mStatus.setText("Статус: " + cargo.getStatus());
        mReadyState.setText("Готов к выдаче: "+cargo.getReady_state());
        if (cargo.getOrder()!=null) {
            SpannableString orderId = new SpannableString(cargo.getOrder().getId());
            orderId.setSpan(new UnderlineSpan(), 0, orderId.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mOrderRef.setText("Заказ:" + orderId);
            mOrderRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DetailActivity)getActivity()).openOrderFragment(cargo.getOrder());
                }
            });
        }
        long worksCount = DaoTask.getInstance().getSession().getWorkDao().queryBuilder().where(WorkDao.Properties.Cargo_id.eq(cargo.getId())).count();
        mWorksRef.setText("Работы: "+worksCount);
        if (worksCount>0) {
            mWorksRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DetailActivity)getActivity()).openWorksFragment(cargo);
                }
            });
        }
        long commentsCount = DaoTask.getInstance().getSession().getCommentDao().queryBuilder().where(CommentDao.Properties.Object_id.eq(cargo.getId())).count();
        mCommentsRef.setText("Комментарии: "+commentsCount);
        if (commentsCount>0) {
            mCommentsRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DetailActivity)getActivity()).openCommentsFragment(cargo);
                }
            });
        }
        return view;
    }

}
