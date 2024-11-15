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
        //avant implementation
        /*
        trainerFactory = mock(IPokemonTrainerFactory.class);
        pokedex = mock(IPokedex.class);
        pokedexFactory = mock(IPokedexFactory.class);

        trainer = new PokemonTrainer("Sacha", Team.MYSTIC, pokedex);

        when(trainerFactory.createTrainer("Sacha", Team.MYSTIC, pokedexFactory)).thenReturn(trainer);
         */
        pokedexFactory = new PokedexFactory();  // Instance réelle de IPokedexFactory
        trainerFactory = new PokemonTrainerFactory();  // Instance réelle de IPokemonTrainerFactory

        // Créer un Pokédex en utilisant la factory
        pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());

        // Créer un PokemonTrainer réel
        trainer = trainerFactory.createTrainer("Sacha", Team.MYSTIC, pokedexFactory);
    }

    @Test
    public void testGetName() {
        // Test pour vérifier le nom du dresseur
        assertNotNull(trainer);
        assertEquals("Sacha", trainer.getName());
    }

    @Test
    public void testGetTeam() {
        // Test pour vérifier l'équipe du dresseur
        assertNotNull(trainer);
        assertEquals(Team.MYSTIC, trainer.getTeam());
    }

    @Test
    public void testGetPokedex() {
        // Test pour vérifier le pokédex du dresseur
        assertNotNull(trainer);
        assertEquals(pokedex, trainer.getPokedex());  // Comparaison basée sur le contenu
    }

}
