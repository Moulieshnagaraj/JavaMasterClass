import java.util.ArrayList;
import java.util.spi.AbstractResourceBundleProvider;

public class Team<T extends CricketPlayer> implements Comparable<Team<T>>{
    private String name;
    private int won=0;
    private int lost=0;
    private int played=0;
    private int tied=0;
    private int points=0;
    private static int totalCount=0;
    private ArrayList<T> players = new ArrayList<>();
    private ArrayList<String> playerNames=new ArrayList<>();

//    CONSTRUCTOR
    public Team(String name) {
        if(totalCount < 10) {
            this.name = name;
            totalCount++;
        }
    }


//    ADDING PLAYERS
    public boolean addPlayers(T player){

        if(players.contains(player)){
            return false;
        }else {
           players.add(player);
           playerNames.add(player.getName());
            return true;
        }
    }

//  LET'S PLAY
    public int generateScore(){
        int max=250;
        int min=20;
        return  (int)(Math.random()*(max-min+1)+min);

    }

//  MATCH RESULT
    public void matchResult(Team<T> opponentTeam, int ourScore, int theirScore){
        String msg;
        if(ourScore > theirScore){
            won++;
            points = won*2;
            msg=" beat ";
        }else if(theirScore > ourScore){
            lost++;
            msg=" lost to ";
        }else{
            tied++;
            msg=" tied to ";
        }
        played++;

        if(opponentTeam!=null){
            System.out.println();
            System.out.println("########################### "+this.getName()+msg+opponentTeam.getName()+" ###########################");
            opponentTeam.matchResult(null,theirScore, ourScore);
        }
    }

//    PRINT PLAYERS
    public void printPlayers(){
        System.out.println("_".repeat(75));
        System.out.println("------------------------------------ "+this.getName()+" ----------------------------------");
        int order=1;
        int nameSize=0;
        System.out.println("Order           Name      TotalRuns  TotalWickets  HighestRun  HighestWicket");
        for(T player: players){
            nameSize = player.getName().length();
            System.out.println("  "+order+"    "+player.getName()+" ".repeat(20-player.getName().length())+player.getTotalRuns()+"          "+player.getTotalWickets()+"           "+player.getHighestRun()+"           "+player.getHighestWickets());
            order++;
        }
    }


//    GETTERS
    public String getName() {
        return name;
    }

    public int getWon() {
        return won;
    }

    public int getLost() {
        return lost;
    }

    public int getPlayed() {
        return played;
    }

    public int getTied() {
        return tied;
    }

    public int getPoints() {
        return points;
    }

    public ArrayList<String> getPlayerNames(){
        return this.playerNames;
    }

    @Override
    public int compareTo(Team<T> otherTeam) {
        if(this.points > otherTeam.getPoints()){
            return -1;
        }else if(this.points<otherTeam.getPoints()){
            return 1;
        }else{
            return 0;
        }
    }
}
