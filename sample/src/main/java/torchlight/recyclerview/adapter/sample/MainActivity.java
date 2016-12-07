package torchlight.recyclerview.adapter.sample;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import torchlight.recyclerview.adapter.sample.adapter.MultiItemSampleAdapter;
import torchlight.recyclerview.adapter.sample.adapter.SingleItemSampleAdapter;
import torchlight.recyclerview.adapter.sample.databinding.ActivityMainBinding;
import torchlight.recyclerview.adapter.sample.item.Item1;
import torchlight.recyclerview.adapter.sample.item.Item2;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MultiItemSampleAdapter mMultiItemSampleAdapter;
    private SingleItemSampleAdapter mSingleItemSampleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mRecyclerView = activityMainBinding.recyclerview;
        mMultiItemSampleAdapter = new MultiItemSampleAdapter();
        mSingleItemSampleAdapter = new SingleItemSampleAdapter();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        activityMainBinding.recyclerview.setLayoutManager(layoutManager);
    }

    public void onSingleItemClick(View v){
        mRecyclerView.setAdapter(mSingleItemSampleAdapter);
        mSingleItemSampleAdapter.set(createItem1List());
    }

    public void onMultiItemClick(View v){
        mRecyclerView.setAdapter(mMultiItemSampleAdapter);
        List list = new ArrayList();
        list.addAll(createItem2List());
        list.addAll(createItem1List());
        mMultiItemSampleAdapter.set(list);
    }

    public List<Item1> createItem1List(){
        List<Item1> items = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++)
            items.add(new Item1("Item " + i));
        return items;
    }

    public List<Item2> createItem2List(){
        List<Item2> items = new ArrayList<>();

        for(int i = 0 ; i < 5 ; i++)
            items.add(new Item2("Title" + i , "Content " + i));
        return items;
    }



}
