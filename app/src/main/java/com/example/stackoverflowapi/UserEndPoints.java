package com.example.stackoverflowapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserEndPoints {

    @GET("/2.2/users?page=1&pagesize=50&order=desc&site=stackoverflow")
    Call<UsersReceivedModel> getUsers (@Query("sort") String sort);

}
