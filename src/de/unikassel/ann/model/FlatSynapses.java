package de.unikassel.ann.model;

import java.util.logging.Logger;

public class FlatSynapses {
	
	Logger log = Logger.getAnonymousLogger();
	
	Synapse[][] flatSynapses;
	
	public FlatSynapses(Integer fromSize, Integer toSize) {
		flatSynapses = new Synapse[fromSize][toSize];
	}
	
	public void addSynapse(Integer from, Integer to, Synapse s) {
		flatSynapses[from][to] = s;
	}
	
	public Synapse getSynapse(Integer from, Integer to) {
		try {
			return flatSynapses[from][to];
		} catch (ArrayIndexOutOfBoundsException e) {
			log.severe("["+from+"]["+to+"]");
			log.severe(e.getMessage());
			return null;
		} catch (NullPointerException e) {
			log.severe("["+from+"]["+to+"]");
			log.severe(e.getMessage());
			return null;
		}
		
	}
	
	public Double getSynapseWeight(Integer from, Integer to) {
		try {
			return flatSynapses[from][to].getWeight();
		} catch (ArrayIndexOutOfBoundsException e) {
			log.severe("["+from+"]["+to+"]");
			log.severe(e.getMessage());
			return null;
		} catch (NullPointerException e) {
			log.severe("["+from+"]["+to+"]");
			log.severe(e.getMessage());
			return null;
		}
		
	}
	
	public boolean setSynapseWeight(Integer from, Integer to, Double value) {
		try {
			flatSynapses[from][to].setWeight(value);
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			log.severe("["+from+"]["+to+"]");
			log.severe(e.getMessage());
			return false;
		} catch (NullPointerException e) {
			log.severe("["+from+"]["+to+"]");
			log.severe(e.getMessage());
			return false;
		}
	}
}