package demoJDBC;

import ma.projet.beans.client;
import ma.projet.service.ClientService;

public class test { public static void main (String[] args) {
    ClientService cs = new ClientService();
    cs.create(new client("SAFI", "ali"));
    cs.create(new client("ALAOUI", "widane"));
    cs.create(new client("RAMI", "amine"));
    cs.create(new client("ALAMI", "kamal"));
    cs.create(new client("SELAMI", "mohamed"));
    client c = cs.findById(3);
    System.out.println(c.getNom()+" "+c.getPrenom());
    cs.delete(cs.findById(3));
    client cc = cs.findById(2);
    cc.setNom("nouveau nom");
    cc.setPrenom("nouveau Prénom");
    cs.update(c);
    for(client cl : cs.findAll()) System.out.println(cl.getNom());
}}