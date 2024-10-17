package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest extends TestCase {

    private IPokemonMetadataProvider provider;
    private PokemonMetadata metadata;

    @BeforeEach
    public void setUp() throws PokedexException {
        provider = mock(IPokemonMetadataProvider.class);
        metadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        when(provider.getPokemonMetadata(0)).thenReturn(metadata);
    }

    @Test
    public void testGetPokemonMetadataIndex() throws PokedexException {
        //On test si l'index correspondent quand on renseigne le bon pokemon
        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals(0, result.getIndex());
    }

    @Test
    public void testGetPokemonMetadataName() throws PokedexException {
        //On test si le nom correspondent quand on renseigne le bon pokemon
        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals("Bulbizarre", result.getName());
    }

    @Test
    public void testGetPokemonMetadataAttack() throws PokedexException {
        //On test si l'attaque correspondent quand on renseigne le bon pokemon
        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals(126, result.getAttack());
    }

    @Test
    public void testGetPokemonMetadataDefense() throws PokedexException {
        //On test si la defense correspondent quand on renseigne le bon pokemon
        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals(126, result.getDefense());
    }

    @Test
    public void testGetPokemonMetadataStamina() throws PokedexException {
        //On test si la stamina correspondent quand on renseigne le bon pokemon
        PokemonMetadata result = provider.getPokemonMetadata(0);
        assertNotNull(result);
        assertEquals(90, result.getStamina());
    }
}