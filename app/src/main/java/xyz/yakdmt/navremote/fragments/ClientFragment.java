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

/**
 * Created by yakdmt on 10/11/15.
 */
public class ClientFragment extends Fragment {

    private Client client;

    @Bind(R.id.id) TextView mId;
    @Bind(R.id.name) TextView mName;
    @Bind(R.id.ext_name) TextView mExtName;
    @Bind(R.id.last_comment) TextView mLastComment;
    @Bind(R.id.email) TextView mEmail;
    @Bind(R.id.phone) TextView mPhone;
    @Bind(R.id.contact) TextView mContact;
    
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
        mId.setText(client.getId());
        mName.setText(client.getName());
        mExtName.setText(client.getName());
        mLastComment.setText(client.getLast_comment());
        mEmail.setText("Email: "+client.getEmail());
        mPhone.setText("Телефон: "+client.getPhone());
        mContact.setText("Контакт: "+client.getContact());

        return view;
    }

}
