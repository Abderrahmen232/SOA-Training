package metiers;

import entities.UniteEnseignement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UniteEnsRestAPIBusiness {

    private static List<UniteEnseignement> unitesEnseignement;

    public UniteEnsRestAPIBusiness() {

        unitesEnseignement = new ArrayList<UniteEnseignement>();

        // Initialisation avec quelques UE de test
        unitesEnseignement.add(
                new UniteEnseignement(
                        1,
                        "Informatique",
                        "Mme Maroua Nouiri",
                        5,
                        1
                )
        );

        unitesEnseignement.add(
                new UniteEnseignement(
                        2,
                        "Mathématiques",
                        "Mme Ines El Mejidi",
                        4,
                        1
                )
        );

        unitesEnseignement.add(
                new UniteEnseignement(
                        3,
                        "Physique",
                        "Mme Sarra Abidi",
                        3,
                        2
                )
        );

        unitesEnseignement.add(
                new UniteEnseignement(
                        4,
                        "Infographie",
                        "Mme Oumeima Ibnelfkir",
                        3,
                        2
                )
        );

        unitesEnseignement.add(
                new UniteEnseignement(
                        5,
                        "Chimie",
                        "M. Mohamed Amine Chebbi",
                        3,
                        2
                )
        );
    }


    // =========================================
    // Ajouter une UE
    // =========================================
    public boolean addUniteEnseignement(UniteEnseignement ue) {

        if (ue == null) {
            return false;
        }

        // Vérifier si le code existe déjà
        if (getUEByCode(ue.getCode()) != null) {
            return false;
        }

        return unitesEnseignement.add(ue);
    }


    // =========================================
    // Récupérer une UE par son code
    // =========================================
    public UniteEnseignement getUEByCode(int code) {

        for (UniteEnseignement ue : unitesEnseignement) {

            if (ue.getCode() == code) {
                return ue;
            }
        }

        return null;
    }


    // =========================================
    // Récupérer toutes les UE
    // =========================================
    public List<UniteEnseignement> getAllUnitesEnseignement() {

        return unitesEnseignement;
    }


    // =========================================
    // Récupérer les UE par domaine
    // =========================================
    public List<UniteEnseignement> getUEByDomaine(String domaine) {

        List<UniteEnseignement> result = new ArrayList<>();

        for (UniteEnseignement ue : unitesEnseignement) {

            if (ue.getDomaine().equalsIgnoreCase(domaine)) {
                result.add(ue);
            }
        }

        return result;
    }


    // =========================================
    // Récupérer les UE par semestre
    // =========================================
    public List<UniteEnseignement> getUEBySemestre(int semestre) {

        List<UniteEnseignement> result = new ArrayList<>();

        for (UniteEnseignement ue : unitesEnseignement) {

            if (ue.getSemestre() == semestre) {
                result.add(ue);
            }
        }

        return result;
    }


    // =========================================
    // Modifier une UE
    // =========================================
    public boolean updateUniteEnseignement(
            int code,
            UniteEnseignement updatedUE) {

        for (int i = 0; i < unitesEnseignement.size(); i++) {

            if (unitesEnseignement.get(i).getCode() == code) {

                unitesEnseignement.set(i, updatedUE);

                return true;
            }
        }

        return false;
    }


    // =========================================
    // Supprimer une UE
    // =========================================
    public boolean deleteUniteEnseignement(int code) {

        Iterator<UniteEnseignement> iterator =
                unitesEnseignement.iterator();

        while (iterator.hasNext()) {

            UniteEnseignement ue = iterator.next();

            if (ue.getCode() == code) {

                iterator.remove();

                return true;
            }
        }

        return false;
    }
}
