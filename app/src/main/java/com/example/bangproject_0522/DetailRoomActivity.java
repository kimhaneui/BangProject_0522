package com.example.bangproject_0522;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.bangproject_0522.databinding.ActivityDetailRoomBinding;
import com.example.bangproject_0522.datas.Room;

public class DetailRoomActivity extends BaseActivity {

    ActivityDetailRoomBinding binding;

//    이화면에 전체적으로 사용할 방객체
    Room mRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_detail_room);
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
//        전화번호 버튼 누르면 해당 전화번호로 연결
        binding.dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String telNum = binding.userPhone.getText().toString();
                Uri myUri = Uri.parse(String.format("tel:%s",telNum));
                Intent myintent = new Intent(Intent.ACTION_DIAL,myUri);
                startActivity(myintent);

            }
        });
        binding.closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    public void setValues() {
        mRoom = (Room) getIntent().getSerializableExtra("room");

        binding.priceTxt.setText(mRoom.getFormattedPrice());
        binding.descTxt.setText(mRoom.getDescription());
        binding.addressTxt.setText(mRoom.getAddress());
        binding.floorTxt.setText(mRoom.getFormattedFloor());
    }
}
