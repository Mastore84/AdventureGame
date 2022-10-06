public class Adventure {
    private Player player;

    public Adventure() {
        Player player = new Player();
        Map map = new Map();
        map.createMap();
        player.setInitialRoom(map.getInitialRoom());
        this.player = player;
    }
    public Player getPlayer(){
        return player;
    }
}
