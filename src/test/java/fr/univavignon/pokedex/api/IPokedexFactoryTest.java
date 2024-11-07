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
        provider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);



        when(pokedexFactory.createPokedex(provider, pokemonFactory)).thenReturn(pokedex);
    }

    @Test
    public void testCreatePokedex() {
        // Appel de la méthode et vérification des résultats
        IPokedex result = pokedexFactory.createPokedex(provider, pokemonFactory);
        assertNotNull(result);
        assertEquals(pokedex, result);
    }
}
