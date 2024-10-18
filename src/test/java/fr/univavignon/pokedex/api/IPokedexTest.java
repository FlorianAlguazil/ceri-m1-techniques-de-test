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
    private Pokemon bulbizarre;
    private Pokemon aquali;

    @Before
    public void setUp() throws PokedexException {
        pokedex = mock(IPokedex.class);

        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        when(pokedex.size()).thenReturn(2);
        when(pokedex.addPokemon(bulbizarre)).thenReturn(0);

        doReturn(bulbizarre).when(pokedex).getPokemon(0);

        when(pokedex.getPokemons()).thenReturn(Arrays.asList(bulbizarre, aquali));
    }

    @Test
    public void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        assertEquals(0, pokedex.addPokemon(bulbizarre));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(bulbizarre, pokedex.getPokemon(0));
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
        assertEquals(bulbizarre, pokemons.get(0));
        assertEquals(aquali, pokemons.get(1));
    }

    @Test
    public void testGetPokemonsSorted() {
        Comparator<Pokemon> byName = Comparator.comparing(Pokemon::getName);
        List<Pokemon> sortedPokemons = Arrays.asList(bulbizarre, aquali);
        when(pokedex.getPokemons(byName)).thenReturn(sortedPokemons);

        List<Pokemon> pokemons = pokedex.getPokemons(byName);
        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
        assertEquals(bulbizarre, pokemons.get(0));
    }

    @Test
    public void testGetPokemonInvalidId() throws PokedexException {
        when(pokedex.getPokemon(anyInt())).thenThrow(new PokedexException("Invalid ID"));

        PokedexException exception = assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(999);  // Invalid ID, should throw exception
        });

        assertEquals("Invalid ID", exception.getMessage());
    }
}
