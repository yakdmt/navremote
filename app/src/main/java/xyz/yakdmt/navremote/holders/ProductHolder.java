package xyz.yakdmt.navremote.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.yakdmt.navremote.App;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Product;
import xyz.yakdmt.navremote.utils.TextUtil;

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
        if (!App.bindViews) {
            return;
        }
        mObject.setText(TextUtil.removeNulls(product.getOrder_id()));
        mNumber.setText(TextUtil.removeNulls("Номер п/п: "+product.getCount()));
        mDescription.setText(TextUtil.removeNulls(product.getDescription()));
        mCount.setText(TextUtil.removeNulls("Количество: "+product.getCount()));
        mBruttoWeight.setText(TextUtil.removeNulls("Вес брутто: "+ product.getBrutto_weight()));
    }


}
