package net.eduard.curso.sistemas;

import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

/**
 * Scoreboard simples sem uso de API
 * 
 * @author Eduard

 */
public class ScoreboardBasica extends BukkitRunnable {

	/**
	 * Atualizado a Scoreboard dos jogadores
	 */
	@Override
	public void run() {
		for (Player p : Bukkit.getOnlinePlayers()) {
			newScoreboard(p, "titulo", "linha1");
		}

	}
	/**
	 * Construtor pedindo Plugin para ligar o sistema
	 * @param plugin Plugin
	 */
	public ScoreboardBasica(JavaPlugin plugin) {
		runTaskTimer(plugin, 20, 20);
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
		int id = 15;
		for (final String line : lines) {
			obj.getScore(new OfflinePlayer() {

				@Override
				public Map<String, Object> serialize() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public void setOp(boolean arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public boolean isOp() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public void setWhitelisted(boolean arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public void setBanned(boolean arg0) {
					// TODO Auto-generated method stub

				}

				@Override
				public boolean isWhitelisted() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean isOnline() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean isBanned() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean hasPlayedBefore() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public UUID getUniqueId() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Player getPlayer() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getName() {
					// TODO Auto-generated method stub
					return line;
				}

				@Override
				public long getLastPlayed() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public long getFirstPlayed() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public Location getBedSpawnLocation() {
					// TODO Auto-generated method stub
					return null;
				}
			}).setScore(id);
			;
			id--;
			if (id == 0) {
				break;
			}
		}

		player.setScoreboard(board);
		return board;
	}

}
