package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {

    private IPokemonMetadataProvider provider;
    private IPokemonFactory pokemonFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @Before
    public void setUp() {
        //avant implementation
        /*
        provider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(provider, pokemonFactory)).thenReturn(pokedex);
         */
        provider = new PokemonMetadataProvider();  // Instance réelle de IPokemonMetadataProvider
        pokemonFactory = new PokemonFactory();    // Instance réelle de IPokemonFactory
        pokedexFactory = new PokedexFactory();    // Instance réelle de IPokedexFactory

        // Créer une instance réelle de IPokedex en utilisant la factory
        pokedex = pokedexFactory.createPokedex(provider, pokemonFactory);
    }

    @Test
    public void testCreatePokedex() {
        // Vérifie que l'instance créée n'est pas nulle
        assertNotNull(pokedex);

        // Vérifie que l'instance de Pokedex est bien une instance réelle de la classe Pokedex
        assertTrue(pokedex instanceof Pokedex);
    }
}
