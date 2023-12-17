package interfaces;

import Enums.*;

public interface OptionalHuman {
    public String getName();

    public int getHealth();

    public Location getLocation();

    public void setName(String name);

    public void setHealth(int health);

    public void setLocation(Location location);
}
