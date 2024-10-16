/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.agencedelocationdevoiture;

import java.util.List;

/**
 * @author wiemhjiri
 */

import java.util.ArrayList;
import java.util.List;

public class ListVoitures {
    private List<Voiture> voitures;

    public ListVoitures() {
        this.voitures = new ArrayList<>();
    }

    public void ajouterVoiture(Voiture voiture) {
        voitures.add(voiture);
    }

    public void supprimerVoiture(Voiture voiture) {
        voitures.remove(voiture);
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void afficherVoitures() {
        for (Voiture voiture : voitures) {
            System.out.println(voiture);
        }
    }
}