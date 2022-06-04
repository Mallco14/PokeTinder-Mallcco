package com.mallcco.poketindernew.domain.usecase

import com.mallcco.poketindernew.data.PokemonRepository
import com.mallcco.poketindernew.data.database.entities.toDatabase
import com.mallcco.poketindernew.domain.model.MyPokemon
import javax.inject.Inject

class SaveMyPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(myPokemon: MyPokemon) {
        pokemonRepository.insertMyPokemon(myPokemon.toDatabase())
    }

}