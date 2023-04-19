class Celle{
    boolean levende = false;
    Celle[] naboer = new Celle[8];
    int antNaboer = 0;
    int antLevendeNaboer = 0;
    int teller = 0;

    public void settLevende(){
        levende = true;
    }

    public void settDoed(){
        levende = false;
    }

    public boolean erLevende(){
        return levende;
    }

    public int hentAntNaboer(){
        return antNaboer;
    }

    public char hentStatusTegn(){
        if (levende){
            return 'O';
        } else {
            return '.';
        }
    }

    public void leggTilNabo(Celle celle){
        if (antNaboer != 8){
            naboer[antNaboer] = celle;
            antNaboer++;
        }
        
    }

    public void tellLevendeNaboer(){
        int antall = 0;
        for (int i = 0; i < naboer.length; i++){
            if (naboer[i] != null && naboer[i].erLevende()){
                antall++;
            }
        }
        antLevendeNaboer = antall;
    }

    public void oppdaterStatus(){
        tellLevendeNaboer();
        if (levende && (antLevendeNaboer == 2 || antLevendeNaboer == 3)){
            levende = true;
        } else if (levende == false && antLevendeNaboer == 3){
            levende = true;
        } else {
            levende = false;
        }
    }    
}

