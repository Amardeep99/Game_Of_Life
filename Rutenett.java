class Rutenett{
    int antRader;
    int antKolonner;
    Celle[][] rutene;

    Rutenett(int antRader, int antKolonner){
        this.antRader = antRader;
        this.antKolonner = antKolonner;
        rutene = new Celle[antRader][antKolonner];
    }

    public void lagCelle(int rad, int kol){
        Celle celle = new Celle();
        boolean sjanseLevende = Math.random() <= 0.3333;
        if (sjanseLevende){
            celle.settLevende();
        }
        
        rutene[rad][kol] = celle;
    }

    public void fyllMedTilfeldigeCeller(){
        for (int i = 0; i < rutene.length; i++){
            for (int j = 0; j < rutene[i].length; j++){
                lagCelle(i, j);
            }
        }
    }

    public Celle hentCelle(int rad, int kol){
        if (rad >= 0 &&  rad < rutene.length && kol >= 0 && rutene[0].length > kol){
            return rutene[rad][kol];
        } else {
            return null;
        }
    }

    // Hjelpemetode saa jeg slipper aa skrive paa nytt.
    private void tegnStreker(){
        for (int i = 0; i < rutene[0].length; i++){
            System.out.print("+---");
        }
        System.out.println("+"); 
    } 

    public void tegnRutenett(){
        tegnStreker();
        
        for (int i = 0; i < rutene.length; i++){
            for (int j = 0; j < rutene[i].length; j++){
                System.out.print("| " + rutene[i][j].hentStatusTegn() + " ");
                if (j == rutene[i].length - 1){
                    System.out.println("|");
                    tegnStreker();
                }
            } 
        } 
    }

    public int settNaboer(int rad, int kol){
       Celle cellen = rutene[rad][kol];
       if (rad < 0 || rad > rutene.length){
        return 0;
       } else if (kol < 0 || kol > rutene[0].length) {
            return 0;
       }
       
       for (int i = -1; i < 2; i++){
        for (int j = -1; j < 2; j++){
            int varRad = rad + i;
            int varKol = kol + j;
            // Hopper over iterasjon om man er ute av indeks eller paa egen posisjon. 
            if (varRad < 0 || varRad >= rutene.length || varKol < 0 || varKol >= rutene[0].length){
                continue;
            } else if (varRad == rad && varKol == kol){
                continue;
            }
            cellen.leggTilNabo(rutene[varRad][varKol]);
        }
       }
       return cellen.hentAntNaboer(); 
    }

    public void kobleAlleCeller(){
        for (int i = 0; i < rutene.length; i++){
            for (int j = 0; j < rutene[0].length; j++){
                settNaboer(i, j);
            }
        }
    }

    public int antallLevende(){
        int antall = 0;

        for (int i = 0; i < rutene.length; i++){
            for (int j = 0; j < rutene[i].length; j++){
                if (rutene[i][j].erLevende()){
                    antall++;
                }
            }
        }

        return antall;
    }
    
}