package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest extends TestCase {

    private IPokemonTrainerFactory trainerFactory;
    private PokemonTrainer trainer;
    private IPokedex pokedex;
    private IPokedexFactory pokedexFactory;

    @BeforeEach
    public void setUp(){
        trainerFactory = mock(IPokemonTrainerFactory.class);
        pokedex = mock(IPokedex.class);
        pokedexFactory = mock(IPokedexFactory.class);
        trainer = new PokemonTrainer("Sacha", Team.MYSTIC, pokedex);
        when(trainerFactory.createTrainer("Sacha", Team.MYSTIC, pokedexFactory)).thenReturn(trainer);
    }

    @Test
    public void testGetName(){
        PokemonTrainer result = trainerFactory.createTrainer("Sacha", Team.MYSTIC, pokedexFactory);
        assertNotNull(result);
        assertEquals("Sacha", result.getName());
    }

    @Test
    public void testGetTeam(){
        PokemonTrainer result = trainerFactory.createTrainer("Sacha", Team.MYSTIC, pokedexFactory);
        assertNotNull(result);
        assertEquals(Team.MYSTIC, result.getTeam());
    }

    @Test
    public void testGetPokedex(){
        PokemonTrainer result = trainerFactory.createTrainer("Sacha", Team.MYSTIC, pokedexFactory);
        assertNotNull(result);
        assertEquals(pokedex, result.getPokedex());
    }
}