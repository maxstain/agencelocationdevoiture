/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.agencedelocationdevoiture;

import java.util.*;

/**
 * @author wiemhjiri
 */

public class Agence {
    private String nom;
    private ListVoitures parking;
    private Map<Client, ListVoitures> clientVoitureLoue;

    public Agence(String nom) {
        this.nom = nom;
        this.parking = new ListVoitures();
        this.clientVoitureLoue = new HashMap<>();
    }

    public void louerVoiture(Client client, Voiture voiture) {
        if (!clientVoitureLoue.containsKey(client)) {
            clientVoitureLoue.put(client, new ListVoitures());
        }
        clientVoitureLoue.get(client).ajouterVoiture(voiture);
        parking.supprimerVoiture(voiture);
    }

    public void retournerVoiture(Client client, Voiture voiture) {
        if (clientVoitureLoue.containsKey(client)) {
            clientVoitureLoue.get(client).supprimerVoiture(voiture);
            parking.ajouterVoiture(voiture);
        }
    }

    public List<Voiture> getVoituresSelonCritere(Critere critere) {
        List<Voiture> result = new ArrayList<>();
        for (Voiture voiture : parking.getVoitures()) {
            if (critere.estSatisfaitPar(voiture)) {
                result.add(voiture);
            }
        }
        return result;
    }

    public List<Client> getClientsAvecVoituresLoue() {
        return new ArrayList<>(clientVoitureLoue.keySet());
    }

    public List<Voiture> getVoituresEnLocation() {
        List<Voiture> result = new ArrayList<>();
        for (ListVoitures listVoitures : clientVoitureLoue.values()) {
            result.addAll(listVoitures.getVoitures());
        }
        return result;
    }

    public void afficherClientsEtVoituresLoue() {
        for (Map.Entry<Client, ListVoitures> entry : clientVoitureLoue.entrySet()) {
            System.out.println("Client: " + entry.getKey());
            entry.getValue().afficherVoitures();
        }
    }

    public void trierClientsParCode(List<Client> clients) {
        clients.sort(Comparator.comparing(Client::getCode));
    }

    public void trierClientsParNom(List<Client> clients) {
        clients.sort(Comparator.comparing(Client::getNom));
    }

    public void trierVoituresParMarque(List<Voiture> voitures) {
        voitures.sort(Comparator.comparing(Voiture::getMarque));
    }
}