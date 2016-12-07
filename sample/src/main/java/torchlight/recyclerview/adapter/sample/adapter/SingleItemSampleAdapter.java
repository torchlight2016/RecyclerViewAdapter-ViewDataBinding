package torchlight.recyclerview.adapter.sample.adapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import torchlight.recyclerview.adapter.SingleItemAdapter;
import torchlight.recyclerview.adapter.sample.R;
import torchlight.recyclerview.adapter.sample.databinding.ListItem1Binding;
import torchlight.recyclerview.adapter.sample.item.Item1;

/**
 * Created by jklee on 2016. 12. 7..
 */

public class SingleItemSampleAdapter extends SingleItemAdapter<ListItem1Binding,Item1> {

    @Override
    protected ListItem1Binding onCreateItemView(ViewGroup parent) {
        return DataBindingUtil.bind(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_1, parent, false));
    }

    @Override
    protected void onBindItemView(ListItem1Binding viewDataBinding, Item1 item) {
        viewDataBinding.text.setText(item.getText());
    }
}
