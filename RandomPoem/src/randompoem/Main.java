package randompoem;

/**
 *
 * @author KD-PC
 */

public class Main {
    public static void main(String[] args) {
//        Poema poema = new Poema();
//        poema.imprimirPoema();
        File fr = new File();
       System.out.println(fr.readDoc("src/randompoem/reglas.txt"));
        //System.out.println(fr.countLine());
       // fr.splitLine();
       //fr.createPoem();
        //System.out.println(fr.poem);
        
    }
}
