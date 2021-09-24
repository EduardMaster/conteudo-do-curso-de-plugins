package net.eduard.curso.projeto.gladiador;

import java.util.*;
import java.util.stream.Collectors;

import net.eduard.api.lib.config.BukkitConfigs;
import net.eduard.curso.Curso;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

@SuppressWarnings("unused")
public class GladiadorEvento extends BukkitRunnable implements Listener {

	private final ArrayList<Player> players = new ArrayList<>();
	private final ArrayList<Player> jogadoresAssistindo = new ArrayList<>();

	private GladiadorEstagio estagio = GladiadorEstagio.DESATIVADO;
	private int tempo = 5*60;
	private Location spawn,camarote,saida;
	private final Map<Player, Integer> kills = new HashMap<>();
	private final Map<String, Integer> clansVitorias = new HashMap<>();

	public Map<Player, Integer> getKills() {
		return kills;
	}
	public void addKill(Player jogador){
		Integer killsAtual = kills.getOrDefault(jogador, 0);
		kills.put(jogador, killsAtual +  1);

	}
	public List<Map.Entry<Player, Integer>> getTopKillerOfClanMembers(List<Player> members){
		final HashMap<Player , Integer> membersKills = new HashMap<>();
		members.forEach(member -> {
			membersKills.put(member ,  kills.getOrDefault(member , 0));
		});
		List<Map.Entry<Player, Integer>> topCrescente = membersKills.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toList());

		Collections.reverse(topCrescente);

		return topCrescente;
	}
	public Player getTopKiller(List<Player> members){
		List<Map.Entry<Player, Integer>> top = getTopKillerOfClanMembers(members);
		if (top.isEmpty())return null;
		return top.get(0).getKey();
	}

	public List<Map.Entry<String, Integer>> generateTop(){
		List<Map.Entry<String, Integer>> topCrescente = clansVitorias.entrySet().stream().sorted(
						Map.Entry.comparingByValue())
				.collect(Collectors.toList());

		Collections.reverse(topCrescente);
		return topCrescente;

	}

	public void showTop(){
		List<Map.Entry<String, Integer>> top = generateTop();
		Bukkit.broadcastMessage("       TOP GLADIADOR");
		for (int pos = 1; pos <= 10; pos++){
			if (top.size() <= pos)return;
			Map.Entry<String, Integer> entry = top.get(pos-1);
			Bukkit.broadcastMessage("  "+pos +" "+ entry.getKey() +" "+ entry.getValue());
		}
	}

	/**
	 * Usa o save() no onDisable() do plugin
	 */
	public void save(){
		BukkitConfigs config = new BukkitConfigs("gladiador.yml");
		clansVitorias.put("TOP", 10);

		config.set("Spawn", this.spawn);
		config.set("Saida" , this.saida);
		config.set("Camarote" , this.camarote);
		config.set("Vitorias" , this.clansVitorias);
		config.saveConfig();

	}

	/**
	 * Usa o reload() no onEnable() do plugin
	 */
	public void reload(){
		BukkitConfigs config = new BukkitConfigs("gladiador.yml");
		if (config.contains("Spawn")){
			this.spawn = (Location) config.get("Spawn");
		}
		if (config.contains("Saida")){
			this.spawn = (Location) config.get("Saida");
		}
		if (config.contains("Camarote")){
			this.spawn = (Location) config.get("Camarote");
		}
		if (config.contains("Vitorias")){
			Map<String, Integer> vitorias = (Map<String, Integer>)
					config.getConfig().get("Vitorias");
			this.clansVitorias.putAll(vitorias);
		}
	}

	
	public void ligar(JavaPlugin plugin) {
		this.runTaskTimer(Curso.getInstance(),29,20);
		//Bukkit.getScheduler().runTaskTimer(plugin, this, 20, 20);
	}
	public void desligar() {
		cancel();
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

	public Location getSpawn() {
		return spawn;
	}

	public void setSpawn(Location spawn) {
		this.spawn = spawn;
	}

	public Location getCamarote() {
		return camarote;
	}

	public void setCamarote(Location camarote) {
		this.camarote = camarote;
	}

	public Location getSaida() {
		return saida;
	}

	public void setSaida(Location saida) {
		this.saida = saida;
	}

	public GladiadorEstagio getEstagio() {
		return estagio;
	}
	public void setEstagio(GladiadorEstagio estagio) {
		this.estagio = estagio;
	}


	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}


	public enum GladiadorEstagio {
		
		INICIANDO , JOGANDO , DESATIVADO
		
	}


	@Override
	public void run() {

		
		
		
		
		
		
	}
	
	
	
}
