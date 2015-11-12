package xyz.yakdmt.navremote.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Cargo;

/**
 * Created by yakdmt on 10/11/15.
 */
public class CargoFragment extends Fragment {

    private Cargo mCargo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCargo = (Cargo) getArguments().getSerializable("cargo");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cargo, container, false);

        return view;
    }

}
