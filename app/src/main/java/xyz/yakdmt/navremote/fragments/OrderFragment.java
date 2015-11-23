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

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.yakdmt.navremote.App;
import xyz.yakdmt.navremote.DetailActivity;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.DaoTask;
import xyz.yakdmt.navremote.database.Document;
import xyz.yakdmt.navremote.database.DocumentDao;
import xyz.yakdmt.navremote.database.Order;
import xyz.yakdmt.navremote.database.Product;
import xyz.yakdmt.navremote.database.ProductDao;
import xyz.yakdmt.navremote.utils.TextUtil;

/**
 * Created by yakdmt on 10/11/15.
 */
public class OrderFragment extends Fragment {

    private Order order;

    //from holder
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
    //additional views
    @Bind(R.id.client_ref) TextView mClientRef;
    @Bind(R.id.contact_ref) TextView mContactRef;
    @Bind(R.id.cargo_ref) TextView mCargoRef;
    @Bind(R.id.delivery_ref) TextView mDeliveryRef;
    @Bind(R.id.manager) TextView mManager;
    @Bind(R.id.performer) TextView mPerformer;
    @Bind(R.id.productsRef) TextView mProductsRef;
    @Bind(R.id.documentsRef) TextView mDocumentsRef;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        order = (Order) getArguments().getSerializable("order");
        if (order!=null) {
            order.__setDaoSession(DaoTask.getInstance().getSession());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        ButterKnife.bind(this, view);
        if (!App.bindViews) {
            return view;
        }
        //from holder
        mId.setText(TextUtil.removeNulls(order.getId()));
        StringBuilder departureBuilder = new StringBuilder();
        departureBuilder.append(order.getDeparture_country_name());
        departureBuilder.append(", ");
        departureBuilder.append(order.getDeparture_checkpoint_name());
        departureBuilder.append(", ");
        departureBuilder.append(order.getDeparture_checkpoint_address());
        mDeparture.setText(TextUtil.removeNulls(departureBuilder));
        mDateTime.setText(TextUtil.removeNulls(order.getDate() + " " + order.getTime()));
        mDeclarant.setText(TextUtil.removeNulls(order.getDeclarant_code()));
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
        //additional views
        if (order.getClient()!=null) {
            SpannableString clientId = new SpannableString(order.getClient().getId());
            clientId.setSpan(new UnderlineSpan(), 0, clientId.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mClientRef.setText(TextUtil.removeNulls("Клиент:" + clientId));
            mClientRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DetailActivity)getActivity()).openClientFragment(order.getClient());
                }
            });
        }
        if (order.getContact()!=null) {
            SpannableString contactId = new SpannableString(order.getContact().getId());
            contactId.setSpan(new UnderlineSpan(), 0, contactId.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mContactRef.setText(TextUtil.removeNulls("Контакт:" + contactId));
            mContactRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DetailActivity)getActivity()).showContactDialog(order.getContact());
                }
            });
        }
        if (order.getCargo()!=null) {
            SpannableString cargoId = new SpannableString(order.getCargo().getId());
            cargoId.setSpan(new UnderlineSpan(), 0, cargoId.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mCargoRef.setText(TextUtil.removeNulls("Груз:" + cargoId));
            mCargoRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DetailActivity)getActivity()).openCargoFragment(order.getCargo());
                }
            });
        }
        if (order.getDelivery()!=null) {
            SpannableString deliveryId = new SpannableString(order.getDelivery().getId());
            deliveryId.setSpan(new UnderlineSpan(), 0, deliveryId.length()-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            mDeliveryRef.setText(TextUtil.removeNulls("Доставка:" + deliveryId));
            mDeliveryRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DetailActivity)getActivity()).openDeliveryFragment(order.getDelivery());
                }
            });
        }

        mManager.setText(TextUtil.removeNulls(order.getManager()));
        mPerformer.setText(TextUtil.removeNulls(order.getPerformer_name()));

        final ArrayList<Product> products = (ArrayList<Product>) DaoTask.getInstance().getSession().getProductDao().queryBuilder().where(ProductDao.Properties.Order_id.eq(order.getId())).list();
        if (products!=null && products.size()>0) {
            mProductsRef.setText(TextUtil.removeNulls("Товары: "+products.size()));
            mProductsRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DetailActivity)getActivity()).openProductsFragment(order);
                }
            });
        }
        final Document document = DaoTask.getInstance().getSession().getDocumentDao().queryBuilder().where(DocumentDao.Properties.OrderId.eq(order.getId())).unique();
        if (document!=null) {
            mDocumentsRef.setText(TextUtil.removeNulls("Документ: "+document.getDocument_name()));
            mDocumentsRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((DetailActivity)getActivity()).showDocumentDialog(document);
                }
            });
        }

        return view;
    }

    public Order getOrder(){
        return order;
    }

}
