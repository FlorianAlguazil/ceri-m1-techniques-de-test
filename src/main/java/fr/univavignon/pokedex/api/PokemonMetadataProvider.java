package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of IPokemonMetadataProvider.
 * Provides metadata for Pokemon using a static data source.
 */
public class PokemonMetadataProvider implements IPokemonMetadataProvider {

    // Utilisation d'une Map statique pour stocker les métadonnées des Pokémon par index.
    private static final Map<Integer, PokemonMetadata> pokemonData = new HashMap<>();

    static {
        // Ajout de quelques exemples de Pokémon avec leur index et métadonnées.
        pokemonData.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonData.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        // Vérifie si l'index existe dans les données.
        if (!pokemonData.containsKey(index)) {
            // Lance une exception si l'index n'est pas trouvé.
            throw new PokedexException("Index invalide pour le Pokémon : " + index);
        }
        // Retourne les métadonnées du Pokémon pour cet index.
        return pokemonData.get(index);
    }
}
