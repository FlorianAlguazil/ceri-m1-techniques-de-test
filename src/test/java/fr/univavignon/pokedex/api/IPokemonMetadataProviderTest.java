package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider provider;
    private PokemonMetadata metadata;

    @Before
    public void setUp() throws PokedexException {
        provider = mock(IPokemonMetadataProvider.class);
        metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);

        when(provider.getPokemonMetadata(0)).thenReturn(metadata);

        when(provider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Invalid index"));
        when(provider.getPokemonMetadata(151)).thenThrow(new PokedexException("Invalid index"));
    }

    @Test
    public void testGetPokemonMetadataIndex() throws PokedexException {
        // On test si l'index correspond quand on renseigne le bon pokemon
        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals(0, result.getIndex());
    }

    @Test
    public void testGetPokemonMetadataName() throws PokedexException {
        // On test si le nom correspond quand on renseigne le bon pokemon
        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals("Bulbizarre", result.getName());
    }

    @Test
    public void testGetPokemonMetadataAttack() throws PokedexException {
        // On test si l'attaque correspond quand on renseigne le bon pokemon
        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals(126, result.getAttack());
    }

    @Test
    public void testGetPokemonMetadataDefense() throws PokedexException {
        // On test si la défense correspond quand on renseigne le bon pokemon
        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals(126, result.getDefense());
    }

    @Test
    public void testGetPokemonMetadataStamina() throws PokedexException {
        // On test si la stamina correspond quand on renseigne le bon pokemon
        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals(90, result.getStamina());
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndexNegative() throws PokedexException {
        // Test pour vérifier qu'une exception est levée pour un index négatif
        provider.getPokemonMetadata(-1);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonMetadataInvalidIndexAbove() throws PokedexException {
        // Test pour vérifier qu'une exception est levée pour un index supérieur à 150
        provider.getPokemonMetadata(151);
    }
}
