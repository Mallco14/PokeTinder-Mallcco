package com.mallcco.poketindernew.domain.usecase

import com.mallcco.poketindernew.data.PokemonRepository
import com.mallcco.poketindernew.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(private val repository: PokemonRepository) {
    suspend operator fun invoke():List<Pokemon> {
        return repository.getAllPokemonFromApi()
    }
}