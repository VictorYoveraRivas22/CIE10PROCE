package com.khs.cie10proce.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.khs.cie10proce.R;
import com.khs.cie10proce.model.Cieandproc;

import java.util.List;

public class ListCieprocAdapter extends BaseAdapter {

private Context mcontext ;
private List<Cieandproc>mcieList;


    public ListCieprocAdapter(Context context, List<Cieandproc> mcieList) {
        this.mcontext = context;
        this.mcieList = mcieList;
    }

    @Override
    public int getCount() {

        return mcieList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
        View v=View.inflate(mcontext, R.layout.activity_listcie,null);


}
