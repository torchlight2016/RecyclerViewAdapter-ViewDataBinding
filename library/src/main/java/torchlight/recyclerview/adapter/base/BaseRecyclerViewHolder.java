package torchlight.recyclerview.adapter.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by torchlight on 2016. 10. 14..
 */

public abstract class BaseRecyclerViewHolder<T1 extends ViewDataBinding, T2> extends RecyclerView.ViewHolder{

    protected T1 mItemViewDataBinding;

    public BaseRecyclerViewHolder(T1 itemViewDataBinding){
        super(itemViewDataBinding.getRoot());
        mItemViewDataBinding = itemViewDataBinding;
    }

    public BaseRecyclerViewHolder(ViewGroup parent, @LayoutRes int layoutId){
        this((T1) DataBindingUtil.bind(LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false)));
    }

    public T1 getItemViewDataBinding(){
        return mItemViewDataBinding;
    }

    public abstract void onBindItemView(T2 item);
}
