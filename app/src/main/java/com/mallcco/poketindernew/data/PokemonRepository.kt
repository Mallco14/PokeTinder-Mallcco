package com.mallcco.poketindernew.data


import com.mallcco.poketindernew.data.database.dao.PokemonDao
import com.mallcco.poketindernew.data.database.entities.MyPokemonEntity
import com.mallcco.poketindernew.data.model.PokemonListModel
import com.mallcco.poketindernew.data.model.PokemonModel
import com.mallcco.poketindernew.data.network.PokemonService
import com.mallcco.poketindernew.domain.model.MyPokemon
import com.mallcco.poketindernew.domain.model.Pokemon
import com.mallcco.poketindernew.domain.model.toDomain
import javax.inject.Inject

class PokemonRepository @Inject constructor(
    private val pokemonService: PokemonService,
    private val pokemonDao: PokemonDao
) {
    suspend fun getAllPokemonFromApi(): List<Pokemon> {
        val listResponse: PokemonListModel = pokemonService.getPokemons()
        val response: List<PokemonModel> = listResponse.results
        return response.map { it.toDomain() }
    }

    suspend fun getMyPokemonsFromDatabase(): List<MyPokemon> {
        val response: List<MyPokemonEntity> = pokemonDao.getAllPokemons()
        return response.map { it.toDomain() }
    }

    suspend fun insertMyPokemon(myPokemon: MyPokemonEntity) {
        pokemonDao.insert(myPokemon)
    }
}