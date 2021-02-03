package net.eduard.curso.projeto.tag;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;

public class PlayerTag {
    private static HashMap<Player, PlayerTag> players = new HashMap<>();

    public static void setTag(Player player, String prefix, String suffix) {
        PlayerTag tag = new PlayerTag();
        tag.setName(player.getName());
        tag.setPrefix(prefix);
        tag.setSuffix(suffix);
        players.put(player, tag);

    }

    public static void updateTags() {
        Scoreboard main = Bukkit.getScoreboardManager().getMainScoreboard();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getScoreboard() == null)
                player.setScoreboard(main);
            else updateScore(player.getScoreboard());
        }
        updateScore(main);
    }

    public static void updateScore(Scoreboard score) {
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

    private String prefix;
    private String suffix;
    private String name;
    private int priority;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
