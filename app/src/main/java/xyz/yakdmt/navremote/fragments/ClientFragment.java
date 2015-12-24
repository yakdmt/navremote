package xyz.yakdmt.navremote.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.yakdmt.navremote.App;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Client;
import xyz.yakdmt.navremote.utils.TextUtil;

/**
 * Created by yakdmt on 10/11/15.
 */
public class ClientFragment extends Fragment {

    private Client client;

    @Bind(R.id.id) TextView mId;
    @Bind(R.id.name) TextView mName;
    @Bind(R.id.ext_name) TextView mExtName;
    @Bind(R.id.inn) TextView mInn;
    @Bind(R.id.kpp) TextView mKpp;
    @Bind(R.id.email) TextView mEmail;
    @Bind(R.id.phone) TextView mPhone;
    @Bind(R.id.contact) TextView mContact;
    @Bind(R.id.address_actual) TextView mAddressActual;
    @Bind(R.id.address_legal) TextView mAddressLegal;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = (Client) getArguments().getSerializable("client");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_client, container, false);
        ButterKnife.bind(this, view);
        if (!App.bindViews) {
            return view;
        }
        mId.setText("Клиент: "+TextUtil.removeNulls(client.getId()));
        mName.setText(TextUtil.removeNulls(client.getName()));
        mExtName.setText(TextUtil.removeNulls(client.getName()));
        mEmail.setText(TextUtil.removeNulls("Email: "+client.getEmail()));
        mPhone.setText(TextUtil.removeNulls("Телефон: "+client.getPhone()));
        mContact.setText(TextUtil.removeNulls("Контакт: "+client.getContact()));
        mInn.setText(TextUtil.removeNulls("ИНН: "+client.getInn()));
        mKpp.setText(TextUtil.removeNulls("КПП: "+client.getKpp()));
        mAddressActual.setText(TextUtil.removeNulls("Адрес факт.: "+client.getAddress_actual()));
        mAddressLegal.setText(TextUtil.removeNulls("Адрес юрид.: "+client.getAddress_legal()));

        return view;
    }

}
