package com.hanbit.memberapp.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hanbit.memberapp.R;
import com.hanbit.memberapp.domain.MemberBean;
import com.hanbit.memberapp.service.MemberService;
import com.hanbit.memberapp.service.MemberServiceImpl;

public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    TextView tvID,tvPass,tvName,tvPhone,tvAddr;
    Button btCall,btMap,btMessage,btUpdate,btDelete,btList;
    MemberService service;
    MemberBean member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        service = new MemberServiceImpl(this.getApplicationContext());
        member = service.detail("hong");
        tvID = (TextView) findViewById(R.id.tvID);
        tvPass = (TextView) findViewById(R.id.tvPass);
        tvName = (TextView) findViewById(R.id.tvName);
        tvPhone = (TextView) findViewById(R.id.tvPhone);
        tvAddr = (TextView) findViewById(R.id.tvAddr);
        tvID.setText(member.getId());
        tvPass.setText(member.getPass());
        tvName.setText(member.getName());
        tvPhone.setText(member.getPhone());
        tvAddr.setText(member.getAddr());

        btCall = (Button) findViewById(R.id.btCall);
        btMap = (Button) findViewById(R.id.btMap);
        btMessage = (Button) findViewById(R.id.btMessage);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btDelete = (Button) findViewById(R.id.btDelete);
        btList = (Button) findViewById(R.id.btList);
        btCall.setOnClickListener(this);
        btCall.setOnClickListener(this);
        btCall.setOnClickListener(this);
        btCall.setOnClickListener(this);
        btCall.setOnClickListener(this);
        btCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btCall: break;
            case R.id.btMap: break;
            case R.id.btMessage: break;
            case R.id.btUpdate:
                startActivity(new Intent(DetailActivity.this, UpdateActivity.class));
                break;
            case R.id.btDelete:
                service.delete(tvID.getText().toString());
                startActivity(new Intent(DetailActivity.this, ListActivity.class));
                break;
            case R.id.btList:
                startActivity(new Intent(DetailActivity.this, ListActivity.class));
                break;
        }
    }
}
