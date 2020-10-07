package com.example.gotest.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gotest.R;
import com.example.gotest.databinding.ActivityLoginBinding;
import com.example.gotest.establishment.EstablishmentActivity;
import com.example.gotest.signin.SignInActivity;


public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        setUI();
        initObservers();
    }


    private void setUI() {
        binding.loginMsgTv.setText("");
        binding.loginMsgTv.setVisibility(View.GONE);
        binding.loginCorreoEt.setText("");
        binding.loginPasswordEt.setText("");

        if(getIntent().getExtras() != null){
            binding.loginCorreoEt.setText(getIntent().getExtras().get("correo").toString());
            binding.loginPasswordEt.setText(getIntent().getExtras().get("password").toString());
        }

        binding.signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.loginMsgTv.setText("");
                binding.loginMsgTv.setVisibility(View.GONE);
                Intent intent = new Intent(getApplicationContext(), SignInActivity.class);
                startActivity(intent);
            }
        });

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.loginMsgTv.setText("");
                binding.loginMsgTv.setVisibility(View.GONE);
                viewModel.login(
                        binding.loginCorreoEt.getText().toString().trim(),
                        binding.loginPasswordEt.getText().toString().trim()
                );
            }
        });
    }


    private void initObservers() {
        viewModel.getMutableResult().observe(this, resoult ->{
            if (resoult) {
                Intent intent = new Intent(getApplicationContext(), EstablishmentActivity.class);
                startActivity(intent);
            }else{
                binding.loginMsgTv.setVisibility(View.VISIBLE);
                binding.loginMsgTv.setText(getString(R.string.login_err));
            }
        });


        viewModel.getMutableErrorMsg().observe(this, msg ->{
            binding.loginMsgTv.setVisibility(View.VISIBLE);
            binding.loginMsgTv.setText(msg);
        });


        viewModel.getUsers().observe(this, users ->{
            viewModel.setUserList(users);
        });

    }

}