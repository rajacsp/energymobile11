package com.example.rp.navigation;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ListviewBaseAdapter extends BaseAdapter {

    Context context;

    ArrayList<Bean>bean;


    public ListviewBaseAdapter(Context context, ArrayList<Bean> bean) {


        this.context = context;
        this.bean = bean;
    }



    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        ViewHolder viewHolder = null;

        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_single,null);

            viewHolder = new ViewHolder();
            viewHolder.txt = (TextView)convertView.findViewById(R.id.txt);





            convertView.setTag(viewHolder);


        }else {

            viewHolder = (ViewHolder)convertView.getTag();
        }



        Bean bean = (Bean)getItem(position);
        viewHolder.txt.setText(bean.getTitle());



        return convertView;
    }

    private class ViewHolder{

        TextView txt;


    }
}




