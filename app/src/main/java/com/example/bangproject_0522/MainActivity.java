package com.example.bangproject_0522;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;

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
        binding.roomList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
//                목록에서 빼주세요~!
                AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                alert.setTitle("방 목록 삭제 확인");
                alert.setMessage("정말 이 방을 삭제하시겠습니까?");
                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        rooms.remove(position);

                        mRoomAdapter.notifyDataSetChanged();

                        Toast.makeText(mContext,"방이 삭제 되었습니다",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("취소",null);

                alert.show();

                return false;
            }
        });
        binding.roomList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Room cllickedRoom = rooms.get(position);

                Intent myintent = new Intent(mContext,DetailRoomActivity.class);
                myintent.putExtra("room",cllickedRoom);
                startActivity(myintent);
            }
        });

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
