/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.agencedelocationdevoiture;

/**
 * @author wiemhjiri
 */

public class CriterPrix implements Critere {
    private double prixMax;

    public CriterPrix(double prixMax) {
        this.prixMax = prixMax;
    }

    @Override
    public boolean estSatisfaitPar(Voiture v) {
        return v.getPrix() <= prixMax;
    }
}
