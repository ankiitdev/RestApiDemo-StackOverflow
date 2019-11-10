package com.example.stackoverflowapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

 private List<User> users;
 private Context context;
 private int rowLayout;

 public UsersAdapter( List<User> users, int rowLayout, Context context) {
     this.setUsers(users);
     this.setRowLayout(rowLayout);
     this.setContext(context);
 }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getRowLayout() {
        return rowLayout;
    }

    public void setRowLayout(int rowLayout) {
        this.rowLayout = rowLayout;
    }

    @NonNull
    @Override
    public UsersAdapter.UsersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(rowLayout, viewGroup, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapter.UsersViewHolder usersViewHolder, int i) {

        usersViewHolder.userLocation.setText("Location: "+users.get(i).getLocation());
        usersViewHolder.userReputation.setText("Reputation: "+users.get(i).getReputation());
        usersViewHolder.userName.setText("Username: "+users.get(i).getUserName());

        Iterator<Map.Entry<String, Integer>> it = users.get(i).getBadges().entrySet().iterator();

        Map.Entry<String, Integer> pair = it.next();
        usersViewHolder.goldenBadge.setText(pair.getKey() + " : ");
        usersViewHolder.goldenValue.setText(pair.getKey().toString());

        pair = it.next();
        usersViewHolder.silverValue.setText(pair.getKey() + " : ");
        usersViewHolder.silverValue.setText(pair.getKey().toString());

        pair = it.next();
        usersViewHolder.bronzeBadge.setText(pair.getKey() + " : ");
        usersViewHolder.bronzeValue.setText(pair.getKey().toString());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UsersViewHolder extends RecyclerView.ViewHolder {

       LinearLayout usersLayout;
       TextView userName;
       TextView userReputation;
       TextView userLocation;
       TextView goldenBadge;
       TextView goldenValue;
       TextView silverBadge;
       TextView silverValue;
       TextView bronzeBadge;
       TextView bronzeValue;

        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);

            usersLayout = itemView.findViewById(R.id.usersLayout);
            userName = itemView.findViewById(R.id.userName);
            userReputation = itemView.findViewById(R.id.userReputation);
            userLocation = itemView.findViewById(R.id.userLocation);
            goldenBadge = itemView.findViewById(R.id.goldenBadge);
            goldenValue = itemView.findViewById(R.id.goldenValue);
            silverBadge = itemView.findViewById(R.id.silverBadge);
            silverValue = itemView.findViewById(R.id.silverValue);
            bronzeBadge = itemView.findViewById(R.id.bronzeBadge);
            bronzeValue = itemView.findViewById(R.id.bronzeValue);

        }
    }
}
