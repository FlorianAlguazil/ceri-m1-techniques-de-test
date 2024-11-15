package fr.univavignon.pokedex.api;
import java.util.Random;

public class PokemonFactory implements IPokemonFactory {

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        // On génère les iv des tats du pokemon
        int ivAttack = (int) (Math.random() * 16);   // Random entre 0 et 15
        int ivDefense = (int) (Math.random() * 16);  // Random entre 0 et 15
        int ivStamina = (int) (Math.random() * 16);  // Random entre 0 et 15

        // on calcule l'iv global du pokemon
        double ivPercentage = calculateIV(ivAttack, ivDefense, ivStamina);

        // Créer une instance de Pokémon avec les IV calculés
        return new Pokemon(index, "NomDuPokemon", ivAttack, ivDefense, ivStamina, cp, hp, dust, candy, ivPercentage);
    }

    /**
     * Calcul le pourcentage global d'IV.
     *
     * @param ivAttack IV pour l'attaque (entre 0 et 15)
     * @param ivDefense IV pour la défense (entre 0 et 15)
     * @param ivStamina IV pour l'endurance (entre 0 et 15)
     * @return Pourcentage global d'IV
     */
    private double calculateIV(int ivAttack, int ivDefense, int ivStamina) {
        double totalIV = ivAttack + ivDefense + ivStamina;
        double maxIV = 45.0;
        return (totalIV / maxIV) * 100.0; // Retourne un pourcentage entre 0% et 100%
    }
}
