package com.example.childrenprojects.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.childrenprojects.db.entities.Family;

import java.util.List;

@Dao
public interface FamilyDao {

    @Insert

    void insert(Family family);

    @Query("SELECT * FROM Family")
    List<Family> getAll();


}
