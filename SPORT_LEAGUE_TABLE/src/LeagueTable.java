import java.util.ArrayList;
import java.util.Collections;

public class LeagueTable<T extends  Team> {
    private String sportsName;
    private ArrayList<T> teams =new ArrayList<>();

//    CONSTRUCTOR
    public LeagueTable(String sportsName) {
        this.sportsName = sportsName;
    }

//    ADDING TEAMS
    public boolean addTeams(T team){
        if(teams.contains(team)){
            return false;
        }
        teams.add(team);
        return true;
    }

//  PRINT-TEAMS
    public void printTeams(){
        Collections.sort(teams);
        System.out.println("**************************** "+this.getSportsName()+" *******************************\n");
        int order=1;
        int nameSize=0;
        System.out.println("Order |  Name   |  Played  |  Won  |  Lost  |  Tied  |  Points");
        System.out.println("-".repeat(63));
        for(T team: teams){
            nameSize = team.getName().length();
            int dum = "  Name   ".length()-nameSize;
            System.out.println("  "+order+"   |"+" ".repeat(dum/2)+team.getName()+" ".repeat(dum-dum/2)+"|    "+team.getPlayed()+"     |   "+team.getWon()+"   |   "+team.getLost()+"    |     "+team.getTied()+"  |   "+team.getPoints());
            System.out.println("-".repeat(63));
            order++;
        }
    }

    public String getSportsName() {
        return sportsName;
    }

    public ArrayList<T> getArray(){
        return this.teams;
    }

}
