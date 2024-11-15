package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Concrete implementation of the IPokedex interface.
 */
public class Pokedex implements IPokedex {

    private final IPokemonMetadataProvider metadataProvider;
    private final IPokemonFactory pokemonFactory;
    private final List<Pokemon> pokemons;

    // Constructeur
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
        this.pokemons = new ArrayList<>();
    }

    // Retourne le nombre de Pokémon dans le Pokédex
    @Override
    public int size() {
        return pokemons.size();
    }

    // Ajoute un Pokémon au Pokédex et retourne son index
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1;  // Retourne l'index du Pokémon ajouté
    }

    // Récupère un Pokémon par son identifiant (index dans le Pokédex)
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        if (id < 0 || id >= pokemons.size()) {
            throw new PokedexException("Invalid ID");
        }
        return pokemons.get(id);
    }

    // Retourne une liste non modifiable de tous les Pokémon du Pokédex
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(pokemons);
    }

    // Retourne une liste triée de tous les Pokémon selon un critère donné (par exemple, par nom)
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedList = new ArrayList<>(pokemons);
        sortedList.sort(order);  // Trie la liste avec le comparateur
        return Collections.unmodifiableList(sortedList);
    }

    // Récupère les métadonnées d'un Pokémon par son index
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return metadataProvider.getPokemonMetadata(index);
    }

    // Crée un Pokémon en utilisant la méthode fournie par l'IPokemonFactory
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }
}
