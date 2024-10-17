package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest extends TestCase{

    private IPokemonFactory pokemonFactory;
    private Pokemon pokemon;

    @BeforeEach
    public void setUp(){
        pokemonFactory = mock(IPokemonFactory.class);
        pokemon = new Pokemon(1, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon);
    }

    @Test
    public void testGetPokemonCp(){
        //on test si le pokemon crée a le bon cp
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(613, result.getCp());
    }

    @Test
    public void testGetPokemonHp(){
        //on test si le pokemon crée a le bon hp
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(64, result.getHp());
    }

    @Test
    public void testGetPokemonDust(){
        //on test si le pokemon crée a le bon dust
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(4000, result.getDust());
    }

    @Test
    public void testGetPokemonCandy(){
        //on test si le pokemon crée a le bon candy
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(4, result.getCandy());
    }
}