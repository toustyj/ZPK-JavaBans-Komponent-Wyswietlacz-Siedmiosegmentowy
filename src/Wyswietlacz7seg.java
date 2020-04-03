

import javax.swing.*;
import java.awt.*;

public class Wyswietlacz7seg extends JPanel {

    MechanizmWyswietlacza7seg mechanizmWyswietlacza;

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
        setSize(100,200);
    }

    public void wylaczWyswietlacz(){
        mechanizmWyswietlacza.wyzerujStany();
        repaint();
    }

    public void ustaw(char stan){
        mechanizmWyswietlacza.ustawStan(stan);
        repaint();
    }

    public void ustaw1(){
        mechanizmWyswietlacza.ustaw1();
        repaint();
    }
    public void ustaw2(){
        mechanizmWyswietlacza.ustaw2();
        repaint();
    }
    public void ustaw3(){
        mechanizmWyswietlacza.ustaw3();
        repaint();
    }
    public void ustaw4(){
        mechanizmWyswietlacza.ustaw4();
        repaint();
    }
    public void ustaw5(){
        mechanizmWyswietlacza.ustaw5();
        repaint();
    }
    public void ustaw6(){
        mechanizmWyswietlacza.ustaw6();
        repaint();
    }
    public void ustaw7(){
        mechanizmWyswietlacza.ustaw7();
        repaint();
    }
    public void ustaw8(){
        mechanizmWyswietlacza.ustaw8();
        repaint();
    }
    public void ustaw9(){
        mechanizmWyswietlacza.ustaw9();
        repaint();
    }
    public void ustawA(){
        mechanizmWyswietlacza.ustawA();
        repaint();
    }
    public void ustawB(){
        mechanizmWyswietlacza.ustawB();
        repaint();
    }
    public void ustawC(){
        mechanizmWyswietlacza.ustawC();
        repaint();
    }
    public void ustawD(){
        mechanizmWyswietlacza.ustawD();
        repaint();
    }
    public void ustawE(){
        mechanizmWyswietlacza.ustawE();
        repaint();
    }
    public void ustawF(){
        mechanizmWyswietlacza.ustawF();
        repaint();
    }

    // narysowanie wyswietlacza, należy wywołać po każdej zmianie stanu
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.RED);

        // segment a
        if(mechanizmWyswietlacza.getStan()[0] == true) {
            g.fillRect(0, 0, 100, 8);
        }
        // segment b
        if(mechanizmWyswietlacza.getStan()[1] == true){
            g.fillRect(92,0,8,100);
        }
        // segment c
        if(mechanizmWyswietlacza.getStan()[2] == true){
            g.fillRect(92,100,8,100);
        }
        // segment d
        if(mechanizmWyswietlacza.getStan()[3] == true) {
            g.fillRect(0, 192, 100, 8);
        }
        // segment e
        if(mechanizmWyswietlacza.getStan()[4] == true) {
            g.fillRect(0, 100, 8, 100);
        }
        // segment f
        if(mechanizmWyswietlacza.getStan()[5] == true) {
            g.fillRect(0, 0, 8, 100);
        }
        // segment g
        if(mechanizmWyswietlacza.getStan()[6] == true) {
            g.fillRect(0, 100, 100, 8);
        }
    }

    public MechanizmWyswietlacza7seg getMechanizmWyswietlacza() {
        return mechanizmWyswietlacza;
    }

    public void setMechanizmWyswietlacza(MechanizmWyswietlacza7seg mechanizmWyswietlacza) {
        this.mechanizmWyswietlacza = mechanizmWyswietlacza;
    }
}
