package com.example.childrenprojects.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.childrenprojects.db.dao.FamilyDao;
import com.example.childrenprojects.db.dao.TransactionDao;
import com.example.childrenprojects.db.entities.Family;
import com.example.childrenprojects.db.entities.Transaction;


@Database(entities = {Transaction.class, Family.class}, version = 2, exportSchema = true)
public abstract class AppDateBase extends RoomDatabase {
public abstract FamilyDao familyDao();

public abstract TransactionDao transactionDao();


}
