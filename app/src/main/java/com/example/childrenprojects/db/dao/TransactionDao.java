package com.example.childrenprojects.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.childrenprojects.db.entities.Transaction;

import java.util.List;

@Dao

public interface TransactionDao {

@Insert

    void insert(Transaction transaction);

    @Query("SELECT * FROM `Transaction`")
    List<Transaction> getAll();




}
