package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class IPokemonFactoryTest {

    IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp(){
        //on crée un mock de pokemon factory
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokemon(){
        //on définit le comportement du mock avec des valeurs spécifiques
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4))
                .thenReturn(new Pokemon(0, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56.0));

        //appel de la fonction avec les mêmes valeurs spécifiques
        Pokemon pokemon = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        //on vérifie ces valeurs spécifiques
        assertNotNull(pokemon);
        assertEquals(0, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(613, pokemon.getCp());
        assertEquals(64, pokemon.getHp());
        assertEquals(4000, pokemon.getDust());
        assertEquals(4, pokemon.getCandy());
        assertEquals(56.0, pokemon.getIv(), 0.001);
    }
}