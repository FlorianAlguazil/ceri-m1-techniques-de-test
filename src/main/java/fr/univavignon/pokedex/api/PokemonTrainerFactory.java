package fr.univavignon.pokedex.api;

/**
 * Concrete implementation of the IPokemonTrainerFactory interface.
 */
public class PokemonTrainerFactory implements IPokemonTrainerFactory {

    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        // Créer un pokédex en utilisant la factory
        IPokedex pokedex = pokedexFactory.createPokedex(new PokemonMetadataProvider(), new PokemonFactory());
        // Créer un PokemonTrainer avec le nom, l'équipe et le pokédex
        return new PokemonTrainer(name, team, pokedex);
    }
}
