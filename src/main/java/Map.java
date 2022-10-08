public class Map {
    private Room initialRoom;
    public void createMap() {
        Room room1 = new Room("Room1", "This room is filled with the stench of death and decay.\n" +
                "Rats run across the putrid corpses of other failed adventures. Maybe you will join them. Tread carefully.");
        room1.addItem("lamp", "a shiny brass lamp", false, false);
        room1.addMeleeWeapon("sword", "a shiny steel sword", false, true, 50);

        Room room2 = new Room("Room2", "The room appears very dark and desolate. The \n" +
                "freezing temperature chills you to the bone, almost numbing you in the process.\n" +
                "The feeling of wanting to escape grows increasingly stronger...");
        room2.addFood("beef", "a slab of rotten beef", true, false, -30);

        Room room3 = new Room("Room3", "You arrive in an ancient dungeon jail..\n" +
                "What meets you is the remains of a goblin, its skeleton embracing the rusty chains");
        room3.addRangedWeapon("crossbow", "a strong-looking crossbow", false, true, 35, 10);

        Room room4 = new Room("Room4", "What meets you in this room, is an old dining hall, which is centuries past \n" +
                "its prime. Old majestic dining tables and elegant chairs for ancient nobility have now dissolved to a \n" +
                "rusty and worn out version of its former glory. While you proceed through the room, you feel like you \n" +
                "can sense the souls of its former inhabitants... Maybe they are ghosts, still holding royal feasts to \n" +
                "this day");
        room4.addFood("apple", "a shiny red apple", true, false, 20);

        Room room5 = new Room("Room5", "When you enter you feel");

        Room room6 = new Room("Room6", "When you enter, the first thing you see is an old majestic bed. You are \n" +
                "speculating that the inhabitants of these chambers belonged to ancient nobility at some point. \n" +
                "At other times, you could get a very good nights of sleep here. Today, not so much....");

        Room room7 = new Room("Room7", "This bedroom doesn't quite seem fancy in any way. Maybe it would be" +
                "the sleeping chambers of some kind of servant?");

        Room room8 = new Room("Room8", "It seems like this room would be some kind of fancy entrance to this " +
                "establishment. The room is filled with various kinds of trophies and armour, the walls decorated with the \n" +
                "remains of pristine art, the floors are all covered with glass from the giant chandelier which once \n" +
                "hung from the ceiling. Maybe this room was used to impress important guests and project power to" +
                "its subjects?");

        Room room9 = new Room("Room9", "This room seems like an old food chamber. Once this room was used to store" +
                "locally produced delicacies from this region. Now it's only filled with dirt and rats scurrying across the floor.");

        //Room 1 connections
        room1.setEast(room2);
        room1.setSouth(room4);

        //Room 2 connections
        room2.setEast(room3);
        room2.setWest(room1);

        //Room 3 connections
        room3.setWest(room2);
        room3.setSouth(room6);

        //Room 4 connections
        room4.setNorth(room1);
        room4.setSouth(room7);

        //Room 5 connections
        room5.setSouth(room8);

        //Room 6 connections
        room6.setNorth(room3);
        room6.setSouth(room9);

        //Room 7 connections
        room7.setNorth(room4);
        room7.setEast(room8);

        //Room 8 connections
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);

        //Room 9 connections
        room9.setWest(room8);
        room9.setNorth(room6);

        //sets initial
        initialRoom = room1;

    }

    public Room getInitialRoom(){
        return initialRoom;
    }
}