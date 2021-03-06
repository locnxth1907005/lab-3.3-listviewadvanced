package com.example.contact3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnChildItemClick{
    private List<ContactModel> listContact = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        mAdapter = new ContactAdapter(this,listContact);
        mAdapter.registerChildItemClick(this);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel model = listContact.get(i);
                Toast.makeText(MainActivity.this,model.getName()+":"+model.getPhone(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        listContact.add(new ContactModel("Pham Van Hoa","0399807181",R.drawable.img));
        listContact.add(new ContactModel("Pham Van Hoa","0399807181",R.drawable.img));
        listContact.add(new ContactModel("Pham Van Hoa","0399807181",R.drawable.img));
        listContact.add(new ContactModel("Pham Van Hoa","0399807181",R.drawable.img));
        listContact.add(new ContactModel("Pham Van Hoa","0399807181",R.drawable.img));
        listContact.add(new ContactModel("Pham Van Hoa","0399807181",R.drawable.img));
        listContact.add(new ContactModel("Pham Van Hoa","0399807181",R.drawable.img));
    }

    private void initView() {
        lvContact= (ListView) findViewById(R.id.lvContact);
        ivUser= (ImageView) findViewById(R.id.ivUser);
        tvName= (TextView) findViewById(R.id.tvName);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mAdapter.unRegisterChildItemClick();
    }
    @Override
    public void onItemChildClick(int position) {
        ContactModel contact = listContact.get(position);
        ivUser.setImageResource(contact.getImage());
        tvName.setText(contact.getName());
    }
}