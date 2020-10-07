package com.example.gotest.signin;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.gotest.R;
import com.example.gotest.database.User;
import com.example.gotest.databinding.ActivityEstablishmentBinding;
import com.example.gotest.databinding.ActivitySignInBinding;
import com.example.gotest.establishment.EstablishmentViewModel;
import com.example.gotest.establishment.adapter.EstablishmentListAdapter;
import com.example.gotest.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class SignInActivity extends AppCompatActivity {

    SignInViewModel viewModel;
    ActivitySignInBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(SignInViewModel.class);

        setUI();
        initObservers();
    }



    private void setUI() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.setTitle(R.string.registro_name);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tiposdoc_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.signinTipoDocSp.setAdapter(adapter);


        binding.signinCrearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.signingMsgTv.setVisibility(View.GONE);

                viewModel.crearUsuario(
                        binding.signinTipoDocSp.getSelectedItem().toString().trim(),
                        binding.signinNumDocEt.getText().toString().trim(),
                        binding.signinNombresEt.getText().toString().trim(),
                        binding.signinApellidosEt.getText().toString().trim(),
                        binding.signinTelEt.getText().toString().trim(),
                        binding.signinCorreoEt.getText().toString().trim(),
                        binding.signinPassEt.getText().toString().trim()
                );
            }
        });
    }

    private void initObservers() {
        viewModel.getMutableCreateResult().observe(this, result ->{
            if (result) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.putExtra("correo", binding.signinCorreoEt.getText().toString().trim());
                intent.putExtra("password", binding.signinPassEt.getText().toString().trim());
                startActivity(intent);
            }
        });


        viewModel.getMutableErrorMsg().observe(this, msg ->{
            binding.signingMsgTv.setVisibility(View.VISIBLE);
            binding.signingMsgTv.setText(msg);
        });
    }
}