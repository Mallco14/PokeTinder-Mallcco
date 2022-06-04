package com.mallcco.poketindernew.domain.usecase

import com.mallcco.poketindernew.data.PokemonRepository
import com.mallcco.poketindernew.domain.model.MyPokemon
import javax.inject.Inject

class GetMyPokemonsUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(): List<MyPokemon> {
        return pokemonRepository.getMyPokemonsFromDatabase()
    }

}