package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest extends TestCase {

    private IPokemonMetadataProvider provider;
    private IPokemonFactory pokemonFactory;
    private IPokedexFactory pokedexFactory;
    private IPokedex pokedex;

    @BeforeEach
    public void setUp(){
        provider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedexFactory = mock(IPokedexFactory.class);
        pokedex = mock(IPokedex.class);
        when(pokedexFactory.createPokedex(provider, pokemonFactory)).thenReturn(pokedex);
    }

    @Test
    public void testCreatePokedex(){
        IPokedex result = pokedexFactory.createPokedex(provider, pokemonFactory);
        assertNotNull(result);
        assertEquals(pokedex, result);
    }
}