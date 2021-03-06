package sh.okx.rankup.requirements;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import sh.okx.rankup.Rankup;

public abstract class Requirement implements Cloneable {
  protected final Rankup plugin;
  @Getter
  protected final String name;
  @Setter
  private String value;

  public Requirement(Rankup plugin, String name) {
    this.plugin = plugin;
    this.name = name;
  }

  protected Requirement(Requirement clone) {
    this.plugin = clone.plugin;
    this.name = clone.name;
    this.value = clone.value;
  }

  public String getValueString() {
    return value;
  }

  public double getValueDouble() {
    return Double.parseDouble(value);
  }

  public int getValueInt() {
    return Integer.parseInt(value);
  }


  /**
   * Check if a player meets this requirement
   *
   * @param player the player to check
   * @return true if they meet the requirement, false otherwise
   */
  public abstract boolean check(Player player);

  /**
   * Get the remaining amount needed for <code>Requirement#check(Player)</code> to yield true.
   * This is not required and is only used in placeholders.
   *
   * @param player the player to find the remaining amount of
   * @return the remaining amount needed. Should be non-negative.
   */
  public double getRemaining(Player player) {
    return getValueDouble();
  }

  public abstract Requirement clone();
}
