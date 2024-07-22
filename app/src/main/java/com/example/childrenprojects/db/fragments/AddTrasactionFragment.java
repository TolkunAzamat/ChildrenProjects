package com.example.childrenprojects.db.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.childrenprojects.R;
import com.example.childrenprojects.db.App;
import com.example.childrenprojects.db.entities.Transaction;

import java.util.Calendar;
import java.util.Locale;

public class AddTrasactionFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_trasaction, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText nameEdit = view.findViewById(R.id.name_txt);
        EditText summaEdit = view.findViewById(R.id.summa);
        Button btn = view.findViewById(R.id.save);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names = nameEdit.getText().toString();
                int summas = Integer.parseInt(summaEdit.getText().toString());

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                String selectedDate = String.format(Locale.getDefault(), "%02d-%02d-%04d", day, month + 1, year);
                Log.d("NNN", names);

                 Transaction transaction = new Transaction(names, summas, selectedDate);
                 App.getDateBase().transactionDao().insert(transaction);
                 int s = App.getDateBase().transactionDao().getAll().size();
                 String size = String.valueOf(s);
                 Log.d("FFF",size);
            }
        });
    }
}
