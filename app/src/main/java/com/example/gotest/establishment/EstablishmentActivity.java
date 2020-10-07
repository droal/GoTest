package com.example.gotest.establishment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.gotest.R;
import com.example.gotest.databinding.ActivityEstablishmentBinding;
import com.example.gotest.establishment.adapter.EstablishmentListAdapter;

public class EstablishmentActivity extends AppCompatActivity {


    private EstablishmentViewModel viewModel;
    private ActivityEstablishmentBinding binding;
    private EstablishmentListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEstablishmentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewModel = new ViewModelProvider(this).get(EstablishmentViewModel.class);

        setUI();
        initObservers();
        viewModel.loadData();

    }

    private void setUI() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
        {
            actionBar.setTitle(R.string.establishment_name);
        }

        adapter = new EstablishmentListAdapter();
        binding.establishmentListRv.setAdapter(adapter);
        binding.establishmentListRv.setLayoutManager(new LinearLayoutManager(this));
    }


    private void initObservers() {
        viewModel.getMutableLivedataEstablishment().observe(this, establishment ->{
            adapter.refreshList(establishment);
        });
    }
}