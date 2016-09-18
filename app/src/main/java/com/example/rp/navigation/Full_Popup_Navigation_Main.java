package com.example.rp.navigation;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Full_Popup_Navigation_Main extends AppCompatActivity {

    android.support.v7.widget.Toolbar toolbar;
    ImageView img;

    LinearLayout date;
    TextView minutes;
    ImageView navigation;

    ListView list;
    String[] web = {"ACTIVITY","MY PROFILE","FRIENDS","MESSAGE","BOOKMARKS","SETTINGS"};

    private ArrayList<Bean> beanClassArrayList;
    private ListviewBaseAdapter listViewAdapter;

    private Dialog myDialog;
    private Dialog dialogBloodGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_popup_navigation_main);

        navigation = (ImageView) findViewById(R.id.navigation);

        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        img = (ImageView) toolbar.findViewById(R.id.navigation);

        navigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DisplayMetrics displaymetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                int height = displaymetrics.heightPixels-100;
                int width = displaymetrics.widthPixels-100;


                myDialog = new Dialog(Full_Popup_Navigation_Main.this, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
                myDialog.getWindow();


                myDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                myDialog.addContentView(new View(Full_Popup_Navigation_Main.this), (new LinearLayout.LayoutParams(width, height)));

                myDialog.setCancelable(true);
                myDialog.setContentView(R.layout.popup);
                list = (ListView) myDialog.findViewById(R.id.list);
                beanClassArrayList = new ArrayList<Bean>();


                for (int i = 0; i < web.length; i++) {

                    Bean beanClass = new Bean(web[i]);
                    beanClassArrayList.add(beanClass);

                }
                listViewAdapter = new ListviewBaseAdapter(Full_Popup_Navigation_Main.this, beanClassArrayList);
                list.setAdapter(listViewAdapter);


                ImageView cancle = (ImageView) myDialog.findViewById(R.id.cancle);
                cancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });

//                ArrayAdapter<String> adapter = new ArrayAdapter<String>(KnockAddNew.this, R.layout.list_single, R.id.txt, web);
//
//                list.setAdapter(adapter);
                list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        String curentMenu = web[+position];

                        Toast.makeText(Full_Popup_Navigation_Main.this,
                                "You Clicked at " + curentMenu,
                                Toast.LENGTH_SHORT).show();

//                        minutes.setText("" + web[+position]);
                        myDialog.dismiss();
                    }
                });

                myDialog.show();

            }
        });
    }
}
