/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
/**
 * @class CommandeMP3WS le service web permettant de décoder les actions
 * et les titres dans une chaine de caractères
 */
@WebService(serviceName = "CommandeMP3WS")
public class CommandeMP3WS {

    //Les différents mots pour l'action jouer
    private ArrayList<String> listJouer = new ArrayList<String>();
    //Les différents mot pour l'action supprimer
    private ArrayList<String> listSupprimer = new ArrayList<String>();
    //Les différents mot pour l'action rechercher
    private ArrayList<String> listRechercher = new ArrayList<String>();
    //Les différents mot pour l'action ajouter
    private ArrayList<String> listAjouter = new ArrayList<String>();
    
    /**
     * Constructeur du service web
     * Permet d'initialiser les listes pour reconnaitre les 
     * différentes actions possiblent 
     */
    public CommandeMP3WS()
    {
        //Pour jouer
        listJouer.add("jouer");
        listJouer.add("joue");
        listJouer.add("lance");
        listJouer.add("lire");

        //Pour supprimer
        listSupprimer.add("supprime");
        listSupprimer.add("supprimer");
        listSupprimer.add("enleve");

        //Pour rechercher
        listRechercher.add("recherche");
        listRechercher.add("rechercher");

        //Pour ajouter
        listAjouter.add("ajoute");
        listAjouter.add("ajouter");
        listAjouter.add("rajoute");         
    }
    /**
     * Méthode getAction permet de définir quel action est voulue par
     * rapport à une chaine de caractères
     * @param phrase la phrase reçu à décoder
     * @return l'action a effectuer sur le client
     */
    @WebMethod(operationName = "getAction")
    public String getAction(@WebParam(name = "phrase") String phrase)
    {
        //Détection de jouer
           for(String jouer : listJouer)
               //Si un mot dans la phrase est dans la liste jouer
                if(phrase.toLowerCase().contains(jouer))
                    //On retourne l'action jouer
                    return "jouer";

            //Détection de rechercher
            for(String rechercher : listRechercher)
                //Si un mot dans la phrase est dans la liste rechercher
                if(phrase.toLowerCase().contains(rechercher))
                    //On retourne l'action rechercher
                    return "rechercher";

            //Détection de supprimer
            for(String supprimer : listSupprimer)
                //Si un mot dans la phrase est dans la liste supprimer
                if(phrase.toLowerCase().contains(supprimer))
                    //On retourne l'action supprimer
                    return "supprimer";

            //Détection d'ajouter
            for(String ajouter : listAjouter)
                //Si un mot dans la phrase est dans la liste ajouter
                if(phrase.toLowerCase().contains(ajouter))
                    //On retourne l'action ajouter
                    return "ajouter";

            //Si aucune action n'est trouvé, on retourne l'action erreur
            return "erreur";
    }

    /**
     * Méthode permettant de retourner le titre présent dans une chaine de caractères
     * @param phrase La chaine de caractères à décoder
     * @return titre le titre de la chanson
     */
    @WebMethod(operationName = "getTitre")
    public String getTitre(@WebParam(name = "phrase") String phrase)
    {
        String titre = phrase;
        //On retourne le titre trouvé
        return titre;
    }
}