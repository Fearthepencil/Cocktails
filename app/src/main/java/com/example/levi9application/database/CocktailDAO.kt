package com.example.levi9application.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.levi9application.models.Cocktail

@Dao
interface CocktailDAO {
    @Upsert
    suspend fun insertCocktail(cocktail: Cocktail)

    @Query("DELETE FROM cocktail_table WHERE id = :cocktailId")
    suspend fun deleteCocktail(cocktailId: Int)

    //read where email = email_param
    @Query("SELECT * FROM cocktail_table ORDER BY alcoholic, id ASC")
    fun readCocktailData(): LiveData<List<Cocktail>>


    //read where email = email_param
    @Query("SELECT id FROM cocktail_table ORDER BY id ASC")
    suspend fun readFavoriteId(): List<Int>
}