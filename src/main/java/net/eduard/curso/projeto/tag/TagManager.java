package net.eduard.curso.projeto.tag;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;

public class TagManager {

    private final HashMap<Player, PlayerTag> players = new HashMap<>();

    public void setTag(Player player, String prefix, String suffix) {
        PlayerTag tag = new PlayerTag();
        tag.setName(player.getName());
        tag.setPrefix(prefix);
        tag.setSuffix(suffix);
        players.put(player, tag);

    }

    public void updateTags() {
        Scoreboard main = Bukkit.getScoreboardManager().getMainScoreboard();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getScoreboard() == null)
                player.setScoreboard(main);
            else updateScore(player.getScoreboard());
        }
        updateScore(main);
    }

    public void updateScore(Scoreboard score) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerTag tag = players.get(player);
            if (tag == null) continue;
            Team team = getTeam(tag.getPriority(), player.getName(), score);
            if (!tag.getPrefix().equals(team.getPrefix()))
                team.setPrefix(tag.getPrefix());
            if (!tag.getSuffix().equals(team.getSuffix()))
                team.setSuffix(tag.getSuffix());
            if (!team.hasPlayer(player))
                team.addPlayer(player);

        }
    }

    public static Team getTeam(int prioridade, String teamName, Scoreboard score) {
        Team team = score.getTeam("" + prioridade + teamName);
        if (team == null) {
            team = score.registerNewTeam("" + prioridade + teamName);
        }
        return team;
    }

}
