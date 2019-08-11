package net.eduard.curso.faction;

import java.util.ArrayList;

import net.eduard.api.lib.storage.Storable;

public class Faction implements Storable{

	private ArrayList<FactionUser> members = new ArrayList<>();

	public ArrayList<FactionUser> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<FactionUser> members) {
		this.members = members;
	}
}
