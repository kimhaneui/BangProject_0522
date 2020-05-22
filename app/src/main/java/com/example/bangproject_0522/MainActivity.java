package com.example.bangproject_0522;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.bangproject_0522.databinding.ActivityMainBinding;
import com.example.bangproject_0522.datas.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    List<Room> rooms = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

        addRooms();
    }
    void addRooms(){
        rooms.add(new Room(7500,"은평구 불광동",4,"불광동의 흔한 집입니다."));
    }
}
