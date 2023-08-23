package com.example.nestedmovierv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nestedmovierv.adapter.ParentAdapter;
import com.example.nestedmovierv.model.ChildModelClass;
import com.example.nestedmovierv.model.ParentModelClass;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ParentModelClass> parentModelClasses;
    ArrayList<ChildModelClass> childModelClasses;
    ArrayList<ChildModelClass> bollywoodList;
    ArrayList<ChildModelClass> hollywoodList;
    ArrayList<ChildModelClass> southList;
    ArrayList<ChildModelClass> netflixList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_parent);
        childModelClasses = new ArrayList<>();
        parentModelClasses = new ArrayList<>();
        bollywoodList = new ArrayList<>();
        hollywoodList = new ArrayList<>();
        southList = new ArrayList<>();
        netflixList = new ArrayList<>();

        setTitle("Movie Apk");

        createBollywoodList(bollywoodList);
        createHollywoodList(hollywoodList);
        createSouthList(southList);
        createNetflixList(netflixList);

        parentModelClasses.add(new ParentModelClass("Bollywood",bollywoodList));
        parentModelClasses.add(new ParentModelClass("South", southList));
        parentModelClasses.add(new ParentModelClass("Netflix", netflixList));
        parentModelClasses.add(new ParentModelClass("Hollywood", hollywoodList));

        ParentAdapter parentAdapter = new ParentAdapter(parentModelClasses, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(parentAdapter);

    }

    private void createNetflixList(ArrayList<ChildModelClass> netflixList) {
        netflixList.add(new ChildModelClass(R.drawable.netflix1));
        netflixList.add(new ChildModelClass(R.drawable.netflix2));
        netflixList.add(new ChildModelClass(R.drawable.netflix3));
        netflixList.add(new ChildModelClass(R.drawable.netflix4));
        netflixList.add(new ChildModelClass(R.drawable.netflix5));
        netflixList.add(new ChildModelClass(R.drawable.netflix6));
        netflixList.add(new ChildModelClass(R.drawable.netflix7));
        netflixList.add(new ChildModelClass(R.drawable.netflix8));
    }

    private void createSouthList(ArrayList<ChildModelClass> southList) {
        southList.add(new ChildModelClass(R.drawable.south1));
        southList.add(new ChildModelClass(R.drawable.south2));
        southList.add(new ChildModelClass(R.drawable.south3));
        southList.add(new ChildModelClass(R.drawable.south4));
        southList.add(new ChildModelClass(R.drawable.south5));
        southList.add(new ChildModelClass(R.drawable.south6));
        southList.add(new ChildModelClass(R.drawable.south7));
    }

    private void createHollywoodList(ArrayList<ChildModelClass> hollywoodList) {
        hollywoodList.add(new ChildModelClass(R.drawable.hol1));
        hollywoodList.add(new ChildModelClass(R.drawable.hol3));
        hollywoodList.add(new ChildModelClass(R.drawable.hol5));
    }

    private void createBollywoodList(ArrayList<ChildModelClass> bollywoodList) {
        bollywoodList.add(new ChildModelClass(R.drawable.bol1));
        bollywoodList.add(new ChildModelClass(R.drawable.bol2));
        bollywoodList.add(new ChildModelClass(R.drawable.bol3));
        bollywoodList.add(new ChildModelClass(R.drawable.bol4));
        bollywoodList.add(new ChildModelClass(R.drawable.bol5));
        bollywoodList.add(new ChildModelClass(R.drawable.bol6));
        bollywoodList.add(new ChildModelClass(R.drawable.bol7));
    }
}
