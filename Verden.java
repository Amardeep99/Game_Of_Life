class Verden{
    Rutenett rutenett;
    int genNr = 0;
    int rad;
    int kol;

    Verden(int rader, int kolonner){
        rad = rader;
        kol = kolonner;
        rutenett = new Rutenett(rader, kolonner);
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
    }

    public void tegn(){
        rutenett.tegnRutenett();
        System.out.println("Generasjonsnummer: " + genNr);
        System.out.println("Levende celler: " + rutenett.antallLevende());
    }

    public void oppdatering(){
        // Setter naboer for hver celle
        for (int i = 0; i < rad; i++){
            for (int j = 0; j < kol; j++){
                rutenett.hentCelle(i, j).oppdaterStatus();
            }
        }
        tegn();
        genNr++;
    }
}