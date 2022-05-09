/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randompoem;

/**
 *
 * @author KD-PC
 */
public class Rule {
private String name;
private String [] words;
private String [] action;

    public Rule(String name, String[] words, String[] action) {
        this.name = name;
        this.words = words;
        this.action = action;
    }

    Rule() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public String[] getAction() {
        return action;
    }

    public void setAction(String[] action) {
        this.action = action;
    }
    
}
