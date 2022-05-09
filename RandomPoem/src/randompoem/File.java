package randompoem;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author KD-PC
 */
public class File {

    private ArrayList<String> lines;
    private ArrayList<Rule> Rules=new ArrayList<Rule>();
    private String poem = "";
    private int numberline;
    public String readDoc(String doc) {
        try {
            Charset charset = StandardCharsets.UTF_8;
            lines = new ArrayList<>(Files.readAllLines(Paths.get(doc), charset));
            for (int i = 0; i < lines.size(); i++) {
                ;
                Rule obj=new Rule();
                obj.setName(lines.get(i).split(":")[0]);
                //System.out.println(obj.getName());
                if(!obj.getName().equalsIgnoreCase("poem")){
                    String [] content =lines.get(i).split(":")[1].split(" ");
                obj.setWords(content[0].split("\\|"));
                //System.out.println(Arrays.toString(obj.getWords()));
                obj.setAction(content[1].split("\\|"));
                //System.out.println(Arrays.toString(obj.getAction()));
                }else{
                    numberline=lines.get(i).split(":")[1].split(" ").length;
                }
                Rules.add(obj);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        createPoem();
        return poem;
    }


    private void createPoem(){
        for (int i = 0; i < numberline; i++) {
            recursive("line");
        }
    }
    
    private void recursive (String param){
        
        Rules.stream().filter(rule -> rule.getName().
                    equalsIgnoreCase(param)).forEach((p)-> {
                        String select = p.getWords()[new Random().nextInt(p.getWords().length)];
                        String action = p.getAction()[new Random().nextInt(p.getAction().length)];
                        //System.out.println(select);
                        
                        if(select.startsWith("<")){
                            recursive(select.replace("<", "").replace(">", ""));
                        }else if (select.startsWith("$")){
                            if (action.equalsIgnoreCase("$LINEBREAK")) {
                                poem +="\n";
                            }else{
                                return;
                            }
                        }else{
                            poem = poem+" "+select;
                        }
                        
                        if(action.startsWith("<")){
                            recursive(action.replace("<", "").replace(">", ""));
                        }else if (action.startsWith("$")){
                            //System.out.println("keyword"+action);
                            if (action.equalsIgnoreCase("$LINEBREAK")) {
                                //System.out.println(action);
                                poem +="\n";
                                //System.out.println("line");
                            }else{
                                return;
                            }
                        }else{
                            poem = poem+" "+action;
                        }
                    });                
    }
    
}
