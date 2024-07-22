package com.example.childrenprojects.db.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Transaction {

    @PrimaryKey(autoGenerate = true)
    public  int id;
    public String name;
    public int summa;
    public String date;

    public  Transaction(String name, int summa, String date){
        this.name = name ;
        this. summa = summa;
        this. date = date;

    }
}

