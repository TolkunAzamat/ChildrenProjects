package com.example.childrenprojects.db.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Family {
    @PrimaryKey (autoGenerate = true)

    public int id;
    public String name;
    public Family(String name){
        this.name = name;

    }
}
