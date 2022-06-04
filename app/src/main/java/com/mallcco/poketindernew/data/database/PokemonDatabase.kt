package com.mallcco.poketindernew.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mallcco.poketindernew.data.database.dao.PokemonDao
import com.mallcco.poketindernew.data.database.entities.MyPokemonEntity

@Database(entities = [MyPokemonEntity::class], version = 1)
abstract class PokemonDatabase: RoomDatabase() {

    abstract fun getPokemonDao(): PokemonDao
}