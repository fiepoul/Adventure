import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    public class Room {
        private String name;
        private String description;
        private Map<String, Room> exits;

        public Room(String name, String description) {
            this.name = name;
            this.description = description;
            this.exits = new HashMap<>();
        }

        public void addExit(String direction, Room room) {
            exits.put(direction, room);
        }

        public String getDescription() {
            return description;
        }

        public Room getExit(String direction) {
            return exits.get(direction);
        }

        public String getName() {
            return name;
        }
    }

