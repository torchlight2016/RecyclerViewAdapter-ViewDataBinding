package torchlight.recyclerview.adapter.sample.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import torchlight.recyclerview.adapter.base.BaseRecyclerViewHolder;
import torchlight.recyclerview.adapter.MultiItemAdapter;
import torchlight.recyclerview.adapter.sample.R;
import torchlight.recyclerview.adapter.sample.databinding.ListItem1Binding;
import torchlight.recyclerview.adapter.sample.databinding.ListItem2Binding;
import torchlight.recyclerview.adapter.sample.item.Item1;
import torchlight.recyclerview.adapter.sample.item.Item2;

/**
 * Created by jklee on 2016. 12. 7..
 */

public class MultiItemSampleAdapter extends MultiItemAdapter {

    public static final int VIEW_TYPE_1 = 100;
    public static final int VIEW_TYPE_2 = 101;
    @Override
    public int getItemViewType(Object item) {
        int viewType = 0;
        if(item instanceof Item1)
            viewType = VIEW_TYPE_1;
        else if(item instanceof Item2)
            viewType = VIEW_TYPE_2;
        return viewType;
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseRecyclerViewHolder holder = null;

        switch (viewType){
            case VIEW_TYPE_1:
                holder =  new Item1ViewHolder(parent, R.layout.list_item_1);
                break;
            case VIEW_TYPE_2:
                ListItem2Binding binding2 = DataBindingUtil.bind(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_2, parent, false));
                holder = new Item2ViewHolder(binding2);
                break;
        }
        return holder;
    }

    static class Item1ViewHolder extends BaseRecyclerViewHolder<ListItem1Binding,Item1>{

        public Item1ViewHolder(ViewGroup parent, @LayoutRes int layoutId) {
            super(parent, layoutId);
        }

        @Override
        public void onBindItemView(Item1 item1) {
            getItemViewDataBinding().text.setText(item1.getText());
        }
    }
    static class Item2ViewHolder extends BaseRecyclerViewHolder<ListItem2Binding,Item2>{

        public Item2ViewHolder(ListItem2Binding viewDataBinding) {
            super(viewDataBinding);
        }

        @Override
        public void onBindItemView(Item2 item2) {
            getItemViewDataBinding().text1.setText(item2.getTitle());
            getItemViewDataBinding().text2.setText(item2.getContent());
        }
    }
}