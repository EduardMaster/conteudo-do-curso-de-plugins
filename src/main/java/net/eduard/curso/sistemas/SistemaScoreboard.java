package net.eduard.curso.sistemas;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import net.eduard.curso.Sistema;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

/**
 * Scoreboard simples sem uso de API
 * 
 * @author Eduard

 */
public class SistemaScoreboard extends Sistema {
	@Override
	public void onEnable() {
		registerEvents();
		registerAsyncTimer(20,20);
	}

	@Override
	public void onDisable() {

	}
	private static final HashMap<Player, Scoreboard> scores =  new HashMap<>();

	static class FakeOfflinePlayer implements  OfflinePlayer{


		public FakeOfflinePlayer(String text) {
			this.text = text;
		}

		private String text;

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		@Override
		public boolean isOnline() {
			return false;
		}

		@Override
		public String getName() {
			return getText();
		}

		@Override
		public UUID getUniqueId() {
			return UUID.nameUUIDFromBytes(("OfflinePlayer:"+
					getText()).getBytes(StandardCharsets.UTF_8));

		}

		@Override
		public boolean isBanned() {
			return false;
		}

		@Override
		public void setBanned(boolean banned) {

		}

		@Override
		public boolean isWhitelisted() {
			return false;
		}

		@Override
		public void setWhitelisted(boolean value) {

		}

		@Override
		public Player getPlayer() {
			return Bukkit.getPlayer(text);
		}

		@Override
		public long getFirstPlayed() {
			return 0;
		}

		@Override
		public long getLastPlayed() {
			return 0;
		}

		@Override
		public boolean hasPlayedBefore() {
			return true;
		}

		@Override
		public Location getBedSpawnLocation() {
			return null;
		}

		@Override
		public Map<String, Object> serialize() {
			return null;
		}

		@Override
		public boolean isOp() {
			return false;
		}

		@Override
		public void setOp(boolean value) {

		}
	}
	@EventHandler
	public void join(PlayerJoinEvent e){
		ativar(e.getPlayer());
	}



	/**
	 * Atualizado a Scoreboard dos jogadores
	 */
	@Override
	public void run() {
		for (Player player : Bukkit.getOnlinePlayers()) {
			atualizar(player);
		}

	}

	public void ativar(Player player){
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("board", "score");
		obj.setDisplayName("§6§lScoreboard");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);

		{
			String linha = "§aVida: §2";
			Team team = board.registerNewTeam("linha10");
			team.setSuffix("" + player.getHealth());
			team.addEntry(linha);
			obj.getScore(linha).setScore(10);
		}

		obj.getScore("§a").setScore(9);

		{
			String linha = "§eFome: §6";
			Team team = board.registerNewTeam("linha8");
			team.setSuffix("" + player.getFoodLevel());
			team.addEntry(linha);
			obj.getScore(linha).setScore(8);
		}

		player.setScoreboard(board);
	}

	public void atualizar(Player player){

		Scoreboard score = scores.get(player);
		if (score == null)return;
		{
			Team team = score.getTeam("linha10");
			team.setSuffix("" + player.getHealth());
		}
		{
			Team team = score.getTeam("linha8");
			team.setSuffix("" + player.getFoodLevel());
		}


	}

	/**
	 * Criar uma Scoreboard nova para o Jogador, com Titulo expecificado e as linhas feitas
	 * @param player Jogador 
	 * @param title Titulo
	 * @param lines Linhas
	 * @return A Scoreboard nova feita
	 */
	@SuppressWarnings("deprecation")
	public static Scoreboard newScoreboard(Player player, String title, String... lines) {
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("board", "score");
		obj.setDisplayName(title);
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);

		Objective vida = board.registerNewObjective("health", "health");
		vida.setDisplayName("Vida");
		vida.setDisplaySlot(DisplaySlot.BELOW_NAME);
		vida.getScore(player).setScore(20);


		int id = 15;
		for (final String line : lines) {

			obj.getScore(new FakeOfflinePlayer(line)).setScore(id);
			id--;
			if (id == 0) {
				break;
			}
		}

		player.setScoreboard(board);
		scores.put(player, board);
		return board;
	}

}
