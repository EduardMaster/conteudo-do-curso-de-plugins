package net.eduard.curso.projeto.gladiador;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class EventoGladiador implements Listener , Runnable{

	private ArrayList<Player> players = new ArrayList<>();
	
	private EstagioDoGladiador estagio = EstagioDoGladiador.DESATIVADO;
	
	private int tempo = 5*60;
	
	private BukkitTask timer = null;
	
	
	public void ligar(JavaPlugin plugin) {
		
		timer = Bukkit.getScheduler().runTaskTimer(plugin, this, 20, 20);
		
		
	}
	public void desligar() {
		
		timer.cancel();
		
		timer = null;
	}
	
	@EventHandler
	public void aoSair(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (estaJogando(p)) {
			jogadorSaiuPartida(p);
		}
	}
	@EventHandler
	public void aoSerKickado(PlayerKickEvent e) {
		Player p = e.getPlayer();
		if (estaJogando(p)) {
			jogadorSaiuPartida(p);
		}
	}
	
	
	public void jogadorEntrouPartida(Player player) {
		players.add(player);
	}
	public void jogadorSaiuPartida(Player player) {
		players.remove(player);
	}
	public boolean estaJogando(Player player) {
		return players.contains(player);
	}
	
	
	public EstagioDoGladiador getEstagio() {
		return estagio;
	}
	public void setEstagio(EstagioDoGladiador estagio) {
		this.estagio = estagio;
	}


	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}


	public enum EstagioDoGladiador{
		
		INICIANDO , JOGANDO , DESATIVADO
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
}
