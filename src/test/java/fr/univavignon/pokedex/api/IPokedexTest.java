package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon bulbizarre;
    private Pokemon aquali;
    private Pokemon pikachu;
    private Comparator<Pokemon> byName;

    @Before
    public void setUp() throws PokedexException {
        //avant implementation
        /*
        pokedex = mock(IPokedex.class);

        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);

        when(pokedex.size()).thenReturn(2);
        when(pokedex.addPokemon(bulbizarre)).thenReturn(0);

        doReturn(bulbizarre).when(pokedex).getPokemon(0);

        when(pokedex.getPokemons()).thenReturn(Arrays.asList(bulbizarre, aquali));

        byName = Comparator.comparing(Pokemon::getName);
        List<Pokemon> sortedPokemons = Arrays.asList(bulbizarre, aquali);
        when(pokedex.getPokemons(byName)).thenReturn(sortedPokemons);
         */

        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider();
        PokemonFactory pokemonFactory = new PokemonFactory();
        pokedex = new Pokedex(metadataProvider, pokemonFactory);

        // Créer quelques Pokémon pour les tests
        bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        aquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100.0);
        pikachu = new Pokemon(25, "Pikachu", 112, 90, 120, 3200, 150, 3500, 3, 35.0);

        // Ajouter des Pokémon au Pokédex
        pokedex.addPokemon(bulbizarre);
        pokedex.addPokemon(aquali);

        // Initialiser un comparateur pour trier les Pokémon par nom
        byName = Comparator.comparing(Pokemon::getName);

    }

    @Test
    public void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        assertEquals(2, pokedex.addPokemon(pikachu));
        assertEquals(3, pokedex.size());
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(bulbizarre, pokedex.getPokemon(0));
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
        assertEquals(bulbizarre, pokemons.get(0));
        assertEquals(aquali, pokemons.get(1));
    }

    @Test
    public void testGetPokemonsSorted() {
        List<Pokemon> pokemons = pokedex.getPokemons(byName);
        assertNotNull(pokemons);
        assertEquals(2, pokemons.size());
        assertEquals(aquali, pokemons.get(0));
    }

    @Test
    public void testGetPokemonInvalidId() {
        PokedexException exception = assertThrows(PokedexException.class, () -> {
            pokedex.getPokemon(999);
        });

        assertEquals("Invalid ID", exception.getMessage());
    }

    @Test
    public void testCreatePokemon() {
        // Appel de createPokemon pour créer un nouveau Pokémon
        Pokemon newPokemon = pokedex.createPokemon(25, 150, 120, 2000, 3);

        // Vérification que le Pokémon a été créé avec les bonnes valeurs
        assertNotNull(newPokemon);
        assertEquals(25, newPokemon.getIndex());  // Vérifie l'index
        assertEquals(150, newPokemon.getCp());  // Vérifie le CP
        assertEquals(120, newPokemon.getHp());  // Vérifie les HP
        assertEquals(2000, newPokemon.getDust());  // Vérifie le nombre de poussière
        assertEquals(3, newPokemon.getCandy());  // Vérifie le nombre de bonbons
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);

        // Vérification que les métadonnées sont correctement retournées
        assertNotNull(metadata);
        assertEquals("Bulbizarre", metadata.getName());  // Vérifie que le nom est correct pour l'index 0
    }




}
