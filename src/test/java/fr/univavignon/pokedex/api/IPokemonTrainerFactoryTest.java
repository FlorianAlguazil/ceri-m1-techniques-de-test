package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {

    private IPokemonTrainerFactory trainerFactory;
    private PokemonTrainer trainer;
    private IPokedex pokedex;
    private IPokedexFactory pokedexFactory;

    @Before
    public void setUp() {
        trainerFactory = mock(IPokemonTrainerFactory.class);
        pokedex = mock(IPokedex.class);
        pokedexFactory = mock(IPokedexFactory.class);

        trainer = new PokemonTrainer("Sacha", Team.MYSTIC, pokedex);

        when(trainerFactory.createTrainer("Sacha", Team.MYSTIC, pokedexFactory)).thenReturn(trainer);
    }

    @Test
    public void testGetName() {
        // Test pour vérifier le nom du dresseur
        PokemonTrainer result = trainerFactory.createTrainer("Sacha", Team.MYSTIC, pokedexFactory);
        assertNotNull(result);
        assertEquals("Sacha", result.getName());
    }

    @Test
    public void testGetTeam() {
        // Test pour vérifier l'équipe du dresseur
        PokemonTrainer result = trainerFactory.createTrainer("Sacha", Team.MYSTIC, pokedexFactory);
        assertNotNull(result);
        assertEquals(Team.MYSTIC, result.getTeam());
    }

    @Test
    public void testGetPokedex() {
        // Test pour vérifier le pokédex du dresseur
        PokemonTrainer result = trainerFactory.createTrainer("Sacha", Team.MYSTIC, pokedexFactory);
        assertNotNull(result);
        assertEquals(pokedex, result.getPokedex());
    }
}
