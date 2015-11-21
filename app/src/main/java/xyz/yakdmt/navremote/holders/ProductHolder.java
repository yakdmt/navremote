package xyz.yakdmt.navremote.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Product;

/**
 * Created by yakdmt on 08/11/15.
 */
public class ProductHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    @Bind(R.id.object) TextView mObject;
    @Bind(R.id.number) TextView mNumber;
    @Bind(R.id.description) TextView mDescription;
    @Bind(R.id.count) TextView mCount;
    @Bind(R.id.brutto_weight) TextView mBruttoWeight;


    public ProductHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Product product) {
        mObject.setText(product.getOrder_id());
        mNumber.setText("Номер п/п: "+product.getCount());
        mDescription.setText(product.getDescription());
        mCount.setText("Количество: "+product.getCount());
        mBruttoWeight.setText("Вес брутто: "+ product.getBrutto_weight());
    }


}
