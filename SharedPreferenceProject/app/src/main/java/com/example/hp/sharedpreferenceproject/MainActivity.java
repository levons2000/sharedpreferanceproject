package com.example.hp.sharedpreferenceproject;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<UserModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setList();
        setFab();
        setRecycler();
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveArrayList(list);
    }

    private void setList() {
        if (getArrayList() != null) {
            list = getArrayList();
        } else {
            list = new ArrayList<>();
        }
    }

    private void setFab() {
        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterDialogFragment dialogFragment = new RegisterDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "tag");
            }
        });
    }

    private void setRecycler() {
        final RecyclerView recyclerView = findViewById(R.id.recyc);
        final UserAdapter userAdapter = new UserAdapter(MainActivity.this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(userAdapter);
    }

    protected List<UserModel> getList() {
        return list;
    }


    private void saveArrayList(ArrayList<UserModel> list) {
        final SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Gson gson = new Gson();
        final String json = gson.toJson(list);
        editor.putString("MyList", json);
        editor.apply();
    }

    private ArrayList<UserModel> getArrayList() {
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        final Gson gson = new Gson();
        final String json = prefs.getString("MyList", null);
        final Type type = new TypeToken<ArrayList<UserModel>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
