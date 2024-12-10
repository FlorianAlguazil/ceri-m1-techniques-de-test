package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RocketPokemonFactoryTest {

    private IPokemonFactory pokemonFactory;

    @Before
    public void setUp() {
        // On utilise la nouvelle implémentation RocketPokemonFactory
        pokemonFactory = new RocketPokemonFactory();
    }

    @Test
    public void testGetPokemonCp() {
        // Test de la valeur du CP
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(613, result.getCp());
    }

    @Test
    public void testGetPokemonHp() {
        // Test de la valeur du HP
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(64, result.getHp());
    }

    @Test
    public void testGetPokemonDust() {
        // Test de la valeur du Dust
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(4000, result.getDust());
    }

    @Test
    public void testGetPokemonCandy() {
        // Test de la valeur du Candy
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);
        assertEquals(4, result.getCandy());
    }

    @Test
    public void testGetPokemonIv() {
        Pokemon result = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
        assertNotNull(result);

        // Vérification que l'IV est dans une plage valide (entre 0% et 100%)
        double iv = result.getIv();
        assertTrue("L'IV doit être compris entre 0 et 100", iv >= 0.0 && iv <= 100.0);
    }
}
