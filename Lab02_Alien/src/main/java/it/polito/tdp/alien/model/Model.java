package it.polito.tdp.alien.model;


import java.util.*;

public class Model {

	Map<String, Word> mappaTraduzione;

	public Model() {
		mappaTraduzione =new TreeMap<String, Word>();
	}
	
	public void addWord(String alienWord,  String translate) {
		if(mappaTraduzione.containsKey(alienWord)) {
			Word tempw= new Word(alienWord, translate);
			mappaTraduzione.remove(alienWord);
			mappaTraduzione.put(alienWord, tempw);
		}
		else
		mappaTraduzione.put(alienWord, new Word(alienWord, translate));
	}
	/**
	 * Aggiungo le parole tradotte al dizionario, passando
	 * sia la parola dell'alieno che la sua traduzione.
	 * 
	 * @param alienWord 
	 * @return
	 */
	
	public String translateWord(String alienWord) {
		if(mappaTraduzione.containsKey(alienWord)) {
			return mappaTraduzione.get(alienWord).getTranslate();
		}
		return null;
	}
	
	public void resetDictionary() {
		mappaTraduzione.clear();
	}
	
}
