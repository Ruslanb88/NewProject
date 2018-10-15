package com.example.rbula.newproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;


public abstract class MainActivity extends AppCompatActivity {

    List<WorkerObject.Worker> name = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


//    String[] myDataset = {
//            "Уральск",
//            "Атырау",
//    };

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 1; i++) {
            WorkerObject.Worker worker = new WorkerObject.Worker();
            worker.worker = "Rus: " + String.valueOf(i);
            name.add(worker);
        }
//        Log.d("Massiv :"+ String.val);


        mRecyclerView = (RecyclerView) findViewById(R.id.rc);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new AdapterR(name);
        mRecyclerView.setAdapter(mAdapter);
    }


    // menu Start
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        Intent intent = new Intent(getApplicationContext(), FormRegistration.class);
        Intent intent2 = new Intent(getApplicationContext(), FormAdd.class);
        switch (id) {
            case R.id.action_settings:
                startActivityForResult(intent, 1);
                return true;
            case R.id.open_settings:
                return true;
            case R.id.save_settings:
                startActivityForResult(intent2, 1);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    // Menu End
}