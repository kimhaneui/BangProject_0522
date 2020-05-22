package com.example.bangproject_0522;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.bangproject_0522.adapters.RoomAdapter;
import com.example.bangproject_0522.databinding.ActivityMainBinding;
import com.example.bangproject_0522.datas.Room;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    ActivityMainBinding binding;

    List<Room> rooms = new ArrayList<>();
    RoomAdapter mRoomAdapter;

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
        mRoomAdapter = new RoomAdapter(mContext,R.layout.room_list_item,rooms);
        binding.roomList.setAdapter(mRoomAdapter);

    }
    void addRooms(){
        rooms.add(new Room(7500,"은평구 불광동",4,"불광동의 흔한 집입니다."));
        rooms.add(new Room(9000,"마포구 서교동",3,"홍대 7번 출구 근처집입니다."));
        rooms.add(new Room(8000,"성북구 돈암동",2,"성신여대 근처 집입니다."));
        rooms.add(new Room(15000,"성북구 정릉동",8,"서경대 근처 집입니다."));
        rooms.add(new Room(5000,"성북구 길음동",3,"신혼부부한테 적합한 집입니다."));
    }
}
