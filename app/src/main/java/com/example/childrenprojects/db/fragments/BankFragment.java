package com.example.childrenprojects.db.fragments;

import android.os.Bundle;

import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.childrenprojects.R;
import com.example.childrenprojects.TransactionAdapter;
import com.example.childrenprojects.db.App;
import com.example.childrenprojects.db.entities.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankFragment extends Fragment {
    RecyclerView recyclerView;
    TransactionAdapter transactionAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bank, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button addTransaction = view.findViewById(R.id.addTransactions);
        Button showTransaction = view.findViewById(R.id.showTransactions);
        addTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_bankFragment_to_addTrasactionFragment);
            }
        });
        showTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView = view.findViewById(R.id.recyclerView);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
                recyclerView.setLayoutManager(linearLayoutManager);

                transactionAdapter = new TransactionAdapter(requireContext(), new ArrayList<>());
                recyclerView.setAdapter(transactionAdapter);

                loadEvents();
            }
        });

    }
    private void loadEvents() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            List<Transaction> eventsList = App.getDateBase().transactionDao().getAll();
            requireActivity().runOnUiThread(() -> {
                    transactionAdapter.setEventsList(eventsList);
            });
        });
    }
}