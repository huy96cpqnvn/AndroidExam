package com.haquanghuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btAdd ,btSearch;
    EditText edName, edEmail, edPhone;
    RadioGroup rgGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edPhone = findViewById(R.id.edPhone);
        btAdd = findViewById(R.id.btAdd);
        rgGender = findViewById(R.id.rgGender);
        btSearch = findViewById(R.id.btSearch);
        btAdd.setOnClickListener(this::onClick);
        btSearch.setOnClickListener(this::onClick);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btAdd:
                if (!validate()) {
                    return;
                }
                edPhone.setText("");
                break;
            case R.id.btSearch:
                goSearch();
                break;
            default:
                break;
        }
    }
    private void goSearch(){
        Intent intent = new Intent(this,SearchActivity.class);
        startActivity(intent);
    }
    private void CheckValidate() {
        if (edName.getText().toString().isEmpty()) {
            Toast.makeText(this,"Please enter Customer Name", Toast.LENGTH_LONG).show();
            return;
        }

        if (edEmail.getText().toString().isEmpty()) {
            Toast.makeText(this,"Please enter Email Address", Toast.LENGTH_LONG).show();
            return;
        }

        if (edPhone.getText().toString().isEmpty()) {
            Toast.makeText(this,"Please enter Phone Number", Toast.LENGTH_LONG).show();
            return;
        }

        if (rgGender.getCheckedRadioButtonId() == -1){
            Toast.makeText(this,"Please select Gender", Toast.LENGTH_LONG).show();
            return;
        }
    }
    private boolean validate() {
        String mess = null;
        if (edName.getText().toString().trim().isEmpty()) {
            mess = "Customer name is required";
        }
        if (edEmail.getText().toString().isEmpty()) {
            mess = "Email is required";
        }
        if (edPhone.getText().toString().trim().isEmpty()) {
            mess = "Phone is required";
        }
        if (rgGender.getCheckedRadioButtonId() == -1) {
            mess = "Please choose your gender";
        }
        if (mess != null) {
            Toast.makeText(this, mess, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}