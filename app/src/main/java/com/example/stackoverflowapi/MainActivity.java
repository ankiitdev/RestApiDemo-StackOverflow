package com.example.stackoverflowapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<User> myDataSource = new ArrayList<>();
    RecyclerView.Adapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.usersRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new UsersAdapter(myDataSource, R.layout.list_item_user,getApplicationContext());
        mRecyclerView.setAdapter(myAdapter);

        loadUsers();
    }

    private void loadUsers() {

        UserEndPoints apiService = APIClient.getClient()
                .create(UserEndPoints.class);
        Call<UsersReceivedModel> call = apiService.getUsers("reputation");
        call.enqueue(new Callback<UsersReceivedModel>() {
            @Override
            public void onResponse(Call<UsersReceivedModel> call, Response<UsersReceivedModel> response) {

                myDataSource.clear();
                myDataSource.addAll(response.body().getUsers());
                myAdapter.notifyDataSetChanged();

                //List<User> users = response.body().getUsers();

            }

            @Override
            public void onFailure(Call<UsersReceivedModel> call, Throwable t) {

            }
        });
    }
}
