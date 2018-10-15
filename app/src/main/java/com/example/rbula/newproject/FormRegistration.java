package com.example.rbula.newproject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class FormRegistration extends AppCompatActivity {
    Button back;
    ListView working;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);



        working = (ListView)findViewById(R.id.working) ;
        back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {





            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });
    }
    private void sendRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);

        Call<WorkerObject> call = api.getWorks();
        call.enqueue(new Callback<WorkerObject>() {
            @Override
            public void onResponse(Call<WorkerObject> call, Response<WorkerObject> response) {
                Log.e("WORKER", "SUCCESS");

                WorkerObject workers = response.body();

                ArrayList<String> data=new ArrayList<String>();



                for (WorkerObject.Worker h: workers.data){
                    data.add(String.valueOf(h.worker));
                    data.add(String.valueOf(h.time));
                    data.add(String.valueOf(h.lastSeen));
                    data.add(String.valueOf(h.reportedHashrate));
                    data.add(String.valueOf(h.currentHashrate));
                    data.add(String.valueOf(h.validShares));
                    data.add(String.valueOf(h.invalidShares));
                    data.add(String.valueOf(h.staleShares));
                    data.add(String.valueOf(h.averageHashrate));


//                    Log.d("worker", String.valueOf(h.worker));
//                    Log.d("time", String.valueOf(h.time));
//                    Log.d("lastSeen", String.valueOf(h.lastSeen));
//                    Log.d("reportedHashrate", String.valueOf(h.reportedHashrate));
//                    Log.d("currentHashrate", String.valueOf(h.currentHashrate));
//                    Log.d("validShares", String.valueOf(h.validShares));
//                    Log.d("invalidShares", String.valueOf(h.invalidShares));
//                    Log.d("staleShares", String.valueOf(h.staleShares));
//                    Log.d("averageHashrate", String.valueOf(h.averageHashrate));
                }

                Log.d("Array list", String.valueOf(data));
                working.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, data));
            }
            @Override
            public void onFailure(Call<WorkerObject> call, Throwable t) {
                Log.e("WORKER", "FAILURE" + t.getLocalizedMessage());
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}