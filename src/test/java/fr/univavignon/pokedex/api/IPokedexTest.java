package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon bulbasaur;
    private Pokemon charmander;

    @Before
    public void setUp() throws PokedexException {
        pokedex = mock(IPokedex.class);

        // Mocking some Pokemon
        bulbasaur = new Pokemon(1, "Bulbasaur", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        charmander = new Pokemon(4, "Charmander", 128, 108, 78, 500, 58, 3000, 4, 39.0);

        // Defining mock behavior
        when(pokedex.size()).thenReturn(2);
        when(pokedex.addPokemon(bulbasaur)).thenReturn(0);

        // Utilisation de doReturn pour éviter les exceptions non capturées
        doReturn(bulbasaur).when(pokedex).getPokemon(1);

        when(pokedex.getPokemons()).thenReturn(Arrays.asList(bulbasaur, charmander));
    }

    @Test
    public void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        assertEquals(0, pokedex.addPokemon(bulbasaur));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(bulbasaur, pokedex.getPokemon(1));
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
        assertEquals(bulbasaur, pokemons.get(0));
        assertEquals(charmander, pokemons.get(1));
    }

    @Test
    public void testGetPokemonsSorted() {
        Comparator<Pokemon> byName = Comparator.comparing(Pokemon::getName);
        List<Pokemon> sortedPokemons = Arrays.asList(bulbasaur, charmander);
        when(pokedex.getPokemons(byName)).thenReturn(sortedPokemons);

        List<Pokemon> pokemons = pokedex.getPokemons(byName);
        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
        assertEquals(bulbasaur, pokemons.get(0));  // Bulbasaur should come first in alphabetical order
    }

    // Corrected test to use assertThrows instead of @Test(expected = ...)
    @Test
    public void testGetPokemonInvalidId() throws PokedexException {
        // Define behavior for an invalid ID
        when(pokedex.getPokemon(anyInt())).thenThrow(new PokedexException("Invalid ID"));

        // Use assertThrows to capture the exception
        PokedexException exception = assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(999);  // Invalid ID, should throw exception
        });

        // Check the exception message
        assertEquals("Invalid ID", exception.getMessage());
    }
}
