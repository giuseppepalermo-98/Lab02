package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class FXMLController {

	private Model modello;
	
    @FXML 
    private ResourceBundle resources;

    @FXML 
    private URL location;

    @FXML 
    private TextField txtTestoInserito;

    @FXML
    private ImageView image;
    
    @FXML 
    private Button btnTranslate; 

    @FXML 
    private TextArea txtRisposta; 

    @FXML 
    private Button btnClear; 

    @FXML
    void doReset(ActionEvent event) {
    	this.txtRisposta.clear();
    	this.txtRisposta.appendText("Welcom to Alien Dictionary v2019.");;
    	this.txtTestoInserito.clear();
    	this.modello.resetDictionary();
    }

    @FXML
    void doTraslate(ActionEvent event) {
    	String temp= this.txtTestoInserito.getText();
    	String alienWord="";
    	String translate="";
    	
    	for(int i=0; i<temp.length(); i++) {
    		char s= temp.charAt(i);
    		if(Character.isDigit(s)) {
    			this.txtRisposta.clear();
    			this.txtRisposta.appendText("Testo inserito NON valido! Inserire solo lettere.\n");
    			return;
    		}
    	}
    	
    	if(temp.contains(" ")) {
    		String array[]= temp.split(" ");
    		alienWord= array[0];
    		translate= array[1];
    		
    		this.modello.addWord(alienWord, translate);
    		
    		//nel caso inserisco una sola parola ma con uno spazio involontario
    		/*
    		if(translate.equals("")) {
    			this.txtRisposta.clear();
        		String parola=this.modello.translateWord(temp);
        		if(parola!=null)
        		this.txtRisposta.appendText(parola);
        		else
        			this.txtRisposta.appendText("Parola inserita inesistente nel dizionario!\n");
    		}*/
    	}
    	
    	else {
    		this.txtRisposta.clear();
    		String parola=this.modello.translateWord(temp);
    		if(parola!=null)
    		this.txtRisposta.appendText(parola);
    		else
    			this.txtRisposta.appendText("Parola inserita inesistente nel dizionario!\n");
    	}
    }

    @FXML 
    void initialize() {
        assert txtTestoInserito != null : "fx:id=\"txtTestoInserito\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisposta != null : "fx:id=\"txtRisposta\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'Scene.fxml'.";
    }
    
    public void setModel(Model model) {
    	this.modello=model;
    }
}
