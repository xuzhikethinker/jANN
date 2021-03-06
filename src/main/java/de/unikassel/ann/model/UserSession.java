/**
 * Projekt ANNtool 
 *
 * Copyright (c) 2011 github.com/timaschew/jANN
 * 
 * anton
 */
package de.unikassel.ann.model;

import java.util.Set;
import java.util.TreeSet;

import de.unikassel.ann.config.NetConfig;

/**
 * @author anton
 * 
 */
public class UserSession {

	private String name;

	private NetConfig config;

	private static Set<String> names;

	/**
	 * Should only called by Settings class
	 * 
	 * @param name
	 */
	public UserSession(final String name, final NetConfig cfg) {
		initName(name);
		if (cfg == null) {
			config = new NetConfig();
		} else {
			config = cfg;
		}

		// TODO add sidebar as listener
		// not at this time, it does not exist at this time!
	}

	/**
	 * Creates user session when name is null <br>
	 * unnamed, unnamed(1), unnamed(2) ...
	 * 
	 * @param name
	 */
	private void initName(final String name) {
		String realName;
		if (name == null) {
			realName = "Session";
		} else {
			realName = name;
		}
		if (names == null) {
			names = new TreeSet<String>();
		}
		int count = 1;
		while (names.contains(realName)) {
			realName = name + "(" + count + ")";
			count++;
		}
		names.add(realName);
		this.name = realName;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getName() {
		return name;
	}

	/**
	 * @return the config
	 */
	public NetConfig getNetworkConfig() {
		return config;
	}

}
