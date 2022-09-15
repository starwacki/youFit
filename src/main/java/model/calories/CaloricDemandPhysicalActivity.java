package model.calories;

public enum CaloricDemandPhysicalActivity {
    VERY_LOW("Znikoma aktywnosc, praca siedzaca, bez treningu "),
    LOW("Lekka praca, cwiczenia raz na tydzien"),
    AVERAGE("Cwiczenia kilka razy w tygodniu"),
    BIG("Cwiczenia kilka razy w tygodniu + ciezka praca fizyczna"),
    VERY_BIG("Bardzo ciezka praca fizyczna, cwiczenia codziennie/kilka razy w tygodniu");

    CaloricDemandPhysicalActivity(String description) {

    }
}
