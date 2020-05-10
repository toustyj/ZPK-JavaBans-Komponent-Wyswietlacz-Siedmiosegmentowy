

import javax.swing.*;
import java.awt.*;

public class Wyswietlacz7seg extends JPanel {

    MechanizmWyswietlacza7seg mechanizmWyswietlacza;

     Integer wysokoscLinii = 100;
     Integer szerokoscLinii = 8;
     Character stan;
     Color kolorPalacegoSieSegmentu;
     Color kolorWylaczonegoSegmentu;
     Color kolorTla;
     Boolean czySkalowalny = true;
     Boolean czyRysowacRamke = true;
     Boolean czyZapalacWygaszonySegment = false;

     Integer domyslnaWysokoscWyswietlacza = 204;
     Integer domyslnaSzerokoscWyswietlacza = 104;
     Integer szerokoscSegmentu = 8;
     Integer gruboscRamki = 2;

     Double modyfikatorWielkosci;

    public Wyswietlacz7seg(){
        mechanizmWyswietlacza = new MechanizmWyswietlacza7seg();
        przygotowanieWyswietlacza();
    }

    // stworzenie wyswietlacza z ustaleniem stanu
    public Wyswietlacz7seg(boolean[] stan){
        mechanizmWyswietlacza = new MechanizmWyswietlacza7seg(stan);
        przygotowanieWyswietlacza();
    }

    // stworzenie wyswietlacza z ustaleniem stanu
    public Wyswietlacz7seg(char stan){
        mechanizmWyswietlacza = new MechanizmWyswietlacza7seg(stan);
        przygotowanieWyswietlacza();
    }

    private void przygotowanieWyswietlacza(){
        setSize(domyslnaSzerokoscWyswietlacza,domyslnaWysokoscWyswietlacza);
        setBackground(Color.WHITE);
        // domyslny kolor wyswietlacza - czerwony
        kolorPalacegoSieSegmentu = Color.RED;
        kolorWylaczonegoSegmentu = null;
        modyfikatorWielkosci = 1.0;
        setStan('8');
    }

    public void wylaczWyswietlacz(){
        mechanizmWyswietlacza.wyzerujStany();
        repaint();
    }

    public void ustaw(char stan){
        mechanizmWyswietlacza.ustawStan(stan);
        setStan(stan);
        repaint();
    }

    public void ustaw1(){
        mechanizmWyswietlacza.ustaw1();
        stan = '1';
        repaint();
    }
    public void ustaw2(){
        mechanizmWyswietlacza.ustaw2();
        setStan('2');
        repaint();
    }
    public void ustaw3(){
        mechanizmWyswietlacza.ustaw3();
        setStan('3');
        repaint();
    }
    public void ustaw4(){
        mechanizmWyswietlacza.ustaw4();
        setStan('4');
        repaint();
    }
    public void ustaw5(){
        mechanizmWyswietlacza.ustaw5();
        setStan('5');
        repaint();
    }
    public void ustaw6(){
        mechanizmWyswietlacza.ustaw6();
        setStan('6');
        repaint();
    }
    public void ustaw7(){
        mechanizmWyswietlacza.ustaw7();
        setStan('7');
        repaint();
    }
    public void ustaw8(){
        mechanizmWyswietlacza.ustaw8();
        setStan('8');
        repaint();
    }
    public void ustaw9(){
        mechanizmWyswietlacza.ustaw9();
        setStan('9');
        repaint();
    }
    public void ustawA(){
        mechanizmWyswietlacza.ustawA();
        setStan('A');
        repaint();
    }
    public void ustawB(){
        mechanizmWyswietlacza.ustawB();
        setStan('B');
        repaint();
    }
    public void ustawC(){
        mechanizmWyswietlacza.ustawC();
        setStan('C');
        repaint();
    }
    public void ustawD(){
        mechanizmWyswietlacza.ustawD();
        setStan('D');
        repaint();
    }
    public void ustawE(){
        mechanizmWyswietlacza.ustawE();
        setStan('E');
        repaint();
    }
    public void ustawF(){
        mechanizmWyswietlacza.ustawF();
        setStan('F');
        repaint();
    }

    // narysowanie wyswietlacza, należy wywołać po każdej zmianie stanu
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(kolorTla);

        Integer wysokoscLiniiSkorygowana = (int) (wysokoscLinii * modyfikatorWielkosci);
        Integer szerokoscLiniiSkorygowana = (int) (szerokoscLinii * modyfikatorWielkosci);
        
        Dimension dim = getSize();
        int x = (int) dim.getWidth();
        int y = (int) dim.getHeight();
        
        int dlugoscPoziomejKrechy = x - 4;
        int dlugoscPionowejKrechy = (y - 4) / 2;
        
        int gruboscRameczki;
        if(czyRysowacRamke) gruboscRameczki = gruboscRamki;
        else {
            gruboscRameczki = 0;
            dlugoscPoziomejKrechy = x;
            dlugoscPionowejKrechy = y/2;
        }
        
        if(czySkalowalny){
            // segment a
            if(mechanizmWyswietlacza.getStan()[0] == true) {
                g.setColor(kolorPalacegoSieSegmentu);
                g.fillRect(gruboscRameczki, gruboscRameczki, dlugoscPoziomejKrechy, szerokoscSegmentu);
            }
            else {
                if(kolorWylaczonegoSegmentu != null){
                    g.setColor(kolorWylaczonegoSegmentu);
                    g.fillRect(gruboscRameczki, gruboscRameczki, dlugoscPoziomejKrechy - gruboscRameczki*2, szerokoscSegmentu);
                }
            }
            // segment b
            if(mechanizmWyswietlacza.getStan()[1] == true){
                g.setColor(kolorPalacegoSieSegmentu);
                g.fillRect(x-szerokoscSegmentu-gruboscRameczki,gruboscRameczki,szerokoscSegmentu,dlugoscPionowejKrechy);
            }
            else {
                if(kolorWylaczonegoSegmentu != null){
                    g.setColor(kolorWylaczonegoSegmentu);
                    g.fillRect(x-szerokoscSegmentu-gruboscRameczki,gruboscRameczki,szerokoscSegmentu,dlugoscPionowejKrechy);
                }
            }
            // segment c
            if(mechanizmWyswietlacza.getStan()[2] == true){
                g.setColor(kolorPalacegoSieSegmentu);
                g.fillRect(x-szerokoscSegmentu-gruboscRameczki,gruboscRameczki+dlugoscPionowejKrechy,szerokoscSegmentu,dlugoscPionowejKrechy);
            }
            else {
                if(kolorWylaczonegoSegmentu != null){
                    g.setColor(kolorWylaczonegoSegmentu);
                    g.fillRect(x-szerokoscSegmentu-gruboscRameczki,gruboscRameczki+dlugoscPionowejKrechy,szerokoscSegmentu,dlugoscPionowejKrechy - gruboscRameczki *2);
                }
            }
            // segment d
            if(mechanizmWyswietlacza.getStan()[3] == true) {
                g.setColor(kolorPalacegoSieSegmentu);
                g.fillRect(gruboscRameczki,y-szerokoscSegmentu-gruboscRameczki,dlugoscPoziomejKrechy,szerokoscSegmentu+1);
            }
            else {
                if(kolorWylaczonegoSegmentu != null){
                    g.setColor(kolorWylaczonegoSegmentu);
                    g.fillRect(gruboscRameczki,y-szerokoscSegmentu-gruboscRameczki,dlugoscPoziomejKrechy,szerokoscSegmentu+1);
                }
            }
            // segment e
            if(mechanizmWyswietlacza.getStan()[4] == true) {
                g.setColor(kolorPalacegoSieSegmentu);
                g.fillRect(gruboscRameczki,gruboscRameczki+dlugoscPionowejKrechy,szerokoscSegmentu,dlugoscPionowejKrechy);
            }
            else {
                if(kolorWylaczonegoSegmentu != null){
                    g.setColor(kolorWylaczonegoSegmentu);
                    g.fillRect(gruboscRameczki,gruboscRameczki+dlugoscPionowejKrechy,szerokoscSegmentu,dlugoscPionowejKrechy - gruboscRameczki * 2);
                }
            }
            // segment f
            if(mechanizmWyswietlacza.getStan()[5] == true) {
                g.setColor(kolorPalacegoSieSegmentu);
                g.fillRect(gruboscRameczki,gruboscRameczki,szerokoscSegmentu,dlugoscPionowejKrechy);
            } 
            else {
                if(kolorWylaczonegoSegmentu != null){
                    g.setColor(kolorWylaczonegoSegmentu);
                    g.fillRect(gruboscRameczki,gruboscRameczki,szerokoscSegmentu,dlugoscPionowejKrechy);
                }
            }
            // segment g
            if(mechanizmWyswietlacza.getStan()[6] == true) {
                g.setColor(kolorPalacegoSieSegmentu);
                g.fillRect(gruboscRameczki,(y-szerokoscSegmentu)/2,dlugoscPoziomejKrechy,szerokoscSegmentu);
            } 
            else {
                if(kolorWylaczonegoSegmentu != null){
                    g.setColor(kolorWylaczonegoSegmentu);
                    g.fillRect(gruboscRameczki,(y-szerokoscSegmentu)/2,dlugoscPoziomejKrechy,szerokoscSegmentu);
                }
            }
            
            
            // ramka
            if(czyRysowacRamke){
                g.setColor(Color.black);
                g.fillRect(0,0,x,gruboscRamki);//gora
                g.fillRect(x-gruboscRamki,0,gruboscRamki,y);//prawo
                g.fillRect(0,y-gruboscRamki,x,gruboscRamki);//dol
                g.fillRect(0,0,gruboscRamki,y);//lewo
            }

        }//czySkalowalny
        
        
        else{
            // segment a
            if(mechanizmWyswietlacza.getStan()[0] == true) {
                g.setColor(kolorPalacegoSieSegmentu);
                g.fillRect((int) (2*modyfikatorWielkosci), (int) (2*modyfikatorWielkosci), wysokoscLiniiSkorygowana, szerokoscLiniiSkorygowana);
            }else {
                if(kolorWylaczonegoSegmentu != null){
                    g.setColor(kolorWylaczonegoSegmentu);
                    g.fillRect((int) (2*modyfikatorWielkosci), (int) (2*modyfikatorWielkosci), wysokoscLiniiSkorygowana, szerokoscLiniiSkorygowana);
                }
            }
            // segment b
            if(mechanizmWyswietlacza.getStan()[1] == true){
                g.setColor(kolorPalacegoSieSegmentu);
                g.fillRect((int)(94*modyfikatorWielkosci),(int) (2*modyfikatorWielkosci),szerokoscLiniiSkorygowana,wysokoscLiniiSkorygowana);
            }else {
                if(kolorWylaczonegoSegmentu != null){
                    g.setColor(kolorWylaczonegoSegmentu);
                    g.fillRect((int)(94*modyfikatorWielkosci),(int) (2*modyfikatorWielkosci),szerokoscLiniiSkorygowana,wysokoscLiniiSkorygowana);
                }
            }
            // segment c
            if(mechanizmWyswietlacza.getStan()[2] == true){
                g.setColor(kolorPalacegoSieSegmentu);
                g.fillRect((int)(94*modyfikatorWielkosci),(int)(102*modyfikatorWielkosci),szerokoscLiniiSkorygowana,wysokoscLiniiSkorygowana);
            } else {
                if(kolorWylaczonegoSegmentu != null){
                    g.setColor(kolorWylaczonegoSegmentu);
                    g.fillRect((int)(94*modyfikatorWielkosci),(int)(102*modyfikatorWielkosci),szerokoscLiniiSkorygowana,wysokoscLiniiSkorygowana);
                }
            }
            // segment d
            if(mechanizmWyswietlacza.getStan()[3] == true) {
                g.setColor(kolorPalacegoSieSegmentu);
                g.fillRect((int) (2*modyfikatorWielkosci), (int)(194*modyfikatorWielkosci), wysokoscLiniiSkorygowana, szerokoscLiniiSkorygowana);
            } else {
                if(kolorWylaczonegoSegmentu != null){
                    g.setColor(kolorWylaczonegoSegmentu);
                    g.fillRect((int) (2*modyfikatorWielkosci), (int)(194*modyfikatorWielkosci), wysokoscLiniiSkorygowana, szerokoscLiniiSkorygowana+1);
                }
            }
            // segment e
            if(mechanizmWyswietlacza.getStan()[4] == true) {
                g.setColor(kolorPalacegoSieSegmentu);
                g.fillRect((int) (2*modyfikatorWielkosci), (int)(102*modyfikatorWielkosci), szerokoscLiniiSkorygowana, wysokoscLiniiSkorygowana);
            } else {
                if(kolorWylaczonegoSegmentu != null){
                    g.setColor(kolorWylaczonegoSegmentu);
                    g.fillRect((int) (2*modyfikatorWielkosci), (int)(102*modyfikatorWielkosci), szerokoscLiniiSkorygowana, wysokoscLiniiSkorygowana);
                }
            }
            // segment f
            if(mechanizmWyswietlacza.getStan()[5] == true) {
                g.setColor(kolorPalacegoSieSegmentu);
                g.fillRect((int) (2*modyfikatorWielkosci), (int) (2*modyfikatorWielkosci), szerokoscLiniiSkorygowana, wysokoscLiniiSkorygowana);
            } else {
                if(kolorWylaczonegoSegmentu != null){
                    g.setColor(kolorWylaczonegoSegmentu);
                    g.fillRect((int) (2*modyfikatorWielkosci), (int) (2*modyfikatorWielkosci), szerokoscLiniiSkorygowana, wysokoscLiniiSkorygowana);
                }
            }
            // segment g
            if(mechanizmWyswietlacza.getStan()[6] == true) {
                g.setColor(kolorPalacegoSieSegmentu);
                g.fillRect((int) (2*modyfikatorWielkosci), (int)(102*modyfikatorWielkosci), wysokoscLiniiSkorygowana, szerokoscLiniiSkorygowana);
            } else {
                if(kolorWylaczonegoSegmentu != null){
                    g.setColor(kolorWylaczonegoSegmentu);
                    g.fillRect((int) (2*modyfikatorWielkosci), (int)(102*modyfikatorWielkosci), wysokoscLiniiSkorygowana, szerokoscLiniiSkorygowana);
                }
            }
            
            // ramka
            if(czyRysowacRamke){
                g.setColor(Color.black);
                g.fillRect(0,0,(int)(104* modyfikatorWielkosci),(int) (2*modyfikatorWielkosci));//gora
                g.fillRect((int)(102* modyfikatorWielkosci),0,(int) (2*modyfikatorWielkosci),(int)(202* modyfikatorWielkosci));//prawo
                g.fillRect(0,(int)(202* modyfikatorWielkosci),(int)(104* modyfikatorWielkosci),(int) (2*modyfikatorWielkosci));//dol
                g.fillRect(0,0,(int) (2*modyfikatorWielkosci),(int)(202* modyfikatorWielkosci));//lewo
            }
        }// jesli nie skalowalny (else)



    }

    public MechanizmWyswietlacza7seg getMechanizmWyswietlacza() {
        return mechanizmWyswietlacza;
    }

    public void setMechanizmWyswietlacza(MechanizmWyswietlacza7seg mechanizmWyswietlacza) {
        this.mechanizmWyswietlacza = mechanizmWyswietlacza;
    }

    public Integer getWysokoscLinii() {
        return wysokoscLinii;
    }

    public void setWysokoscLinii(Integer wysokoscLinii) {
        this.wysokoscLinii = wysokoscLinii;
    }

    public Character getStan() {
        return stan;
    }

    public void setStan(Character stan) {
        mechanizmWyswietlacza.ustawStan(stan);
        this.stan = stan;
        repaint();
    }

    public Color getKolorPalacegoSieSegmentu() {
        return kolorPalacegoSieSegmentu;
    }

    public void setKolorPalacegoSieSegmentu(Color kolorPalacegoSieSegmentu) {
        this.kolorPalacegoSieSegmentu = kolorPalacegoSieSegmentu;
    }

    public Color getKolorTla() {
        return kolorTla;
    }

    public void setKolorTla(Color kolorTla) {
        this.kolorTla = kolorTla;
    }

    public Color getKolorWylaczonegoSegmentu() {
        return kolorWylaczonegoSegmentu;
    }

    public void setKolorWylaczonegoSegmentu(Color kolorWylaczonegoSegmentu) {
        this.kolorWylaczonegoSegmentu = kolorWylaczonegoSegmentu;
        if(kolorWylaczonegoSegmentu != null){
            czyZapalacWygaszonySegment = true;
        }
        else if (kolorWylaczonegoSegmentu == null){
            czyZapalacWygaszonySegment = false;
        }
        setStan(stan);
    }

    public void setKolorWylaczonegoJakoPrzezroczysty(){
        this.kolorWylaczonegoSegmentu = null;
    }

    public Double getModyfikatorWielkosci() {
        return modyfikatorWielkosci;
    }

    public void setModyfikatorWielkosci(Double modyfikatorWielkosci) {
        this.modyfikatorWielkosci = modyfikatorWielkosci;
    }

    public Integer getDomyslnaWysokoscWyswietlacza() {
        return domyslnaWysokoscWyswietlacza;
    }

    public Integer getDomyslnaSzerokoscWyswietlacza() {
        return domyslnaSzerokoscWyswietlacza;
    }

    public Boolean getCzySkalowalny() {
        return czySkalowalny;
    }

    public void setCzySkalowalny(Boolean czySkalowalny) {
        this.czySkalowalny = czySkalowalny;
        setStan(stan); // do odrysowania
    }

    public Integer getSzerokoscSegmentu() {
        return szerokoscSegmentu;
    }

    public void setSzerokoscSegmentu(Integer szerokoscSegmentu) {
        this.szerokoscSegmentu = szerokoscSegmentu;
        repaint();
    }

    public Integer getGruboscRamki() {
        return gruboscRamki;
    }

    public void setGruboscRamki(Integer gruboscRamki) {
        this.gruboscRamki = gruboscRamki;
        setStan(stan);
    }

    public Boolean getCzyRysowacRamke() {
        return czyRysowacRamke;
    }

    public void setCzyRysowacRamke(Boolean czyRysowacRamke) {
        this.czyRysowacRamke = czyRysowacRamke;
        setStan(stan);
    }

    public Boolean getCzyZapalacWygaszonySegment() {
        return czyZapalacWygaszonySegment;
    }

    public void setCzyZapalacWygaszonySegment(Boolean czyZapalacWygaszonySegment) {
        this.czyZapalacWygaszonySegment = czyZapalacWygaszonySegment;
        if(czyZapalacWygaszonySegment){
            
        } else{
            setKolorWylaczonegoJakoPrzezroczysty();
        }
        
        setStan(stan);
    }
    
    
    
    
    
}
