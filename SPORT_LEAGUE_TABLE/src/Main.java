
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException{
//        CREATING LEAGUE-TABLE OBJECT
        LeagueTable<Team<CricketPlayer>> leagueTable = new LeagueTable<>("IPL");

        Team<CricketPlayer> CSK = new Team<>("CSK");
        leagueTable.addTeams(CSK);

        Team<CricketPlayer> MI = new Team<>("MI");
        leagueTable.addTeams(MI);
//
        Team<CricketPlayer> RCB = new Team<>("RCB");
        leagueTable.addTeams(RCB);

        Team<CricketPlayer> SRH = new Team<>("SRH");
        leagueTable.addTeams(SRH);
//
        Team<CricketPlayer> GT= new Team<>("GT");
        leagueTable.addTeams(GT);
//
        Team<CricketPlayer> DD= new Team<>("DD");
        leagueTable.addTeams(DD);
//
        Team<CricketPlayer> PK= new Team<>("PK");
        leagueTable.addTeams(PK);
//
        Team<CricketPlayer> KKR= new Team<>("KKR");
        leagueTable.addTeams(KKR);

//        Team<CricketPlayer> RR= new Team<>("RR");
//        leagueTable.addTeams(RR);

        Thread.sleep(700);
        System.out.println("Here it Starts!!!");
        Thread.sleep(250);
        System.out.println("Adding players to the team.");
        Thread.sleep(250);

//        ADDING PLAYERS TO ALL THE TEAM
        addTeamPlayers(leagueTable);

//        OPTION FEATURES
        boolean quit= false;
        while(!quit){
            System.out.println();
            printOptions();
            System.out.println("Choose the Option: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice){
                case 1:
                    printOptions();
                    break;
                case 2:
                    leagueTable.printTeams();
                    break;
                case 3:
                    toPrintPlayers(leagueTable);
                    System.out.println("Select Your Team No: ");
                    int teamChoose=  input.nextInt();
                    input.nextLine();
                    leagueTable.getArray().get(teamChoose-1).printPlayers();
                    break;
                case 4:
                    competeTeam(leagueTable);
                    break;
                case 5:
                    quit=true;
                    break;

            }
        }

    }

//    ADDING PLAYERS TO TEAM
    public static void addTeamPlayers(LeagueTable<Team<CricketPlayer>> leagueTable){
        Scanner sc = new Scanner(System.in);
        int playerCount=0;
        int teamCount=0;
        System.out.println(" >>>>>>>>>>>>>>>> >>>> >> > PICKING PLAYERS FOR "+leagueTable.getArray().get(teamCount).getName()+" < << <<<< <<<<<<<<<<<<<");

        while(leagueTable.getArray().size()>teamCount){
            Team<CricketPlayer> dummyTeam = leagueTable.getArray().get(teamCount);

            if(playerCount<11){
                System.out.println("Enter the name of the player: ");
                String name=sc.nextLine();
                Team<CricketPlayer> team = checkPlayer(leagueTable, name);
                if(team==null){
                    System.out.println("Type true, if he is batsman / else false");
                    String str = input.nextLine();
                    boolean isBatsman = str.charAt(0) == 't' || str.charAt(0) == 'T';
                    dummyTeam.addPlayers(new CricketPlayer(name,isBatsman));
                    playerCount++;
                }else{
                    System.out.println(name+" is already exist in the team "+team.getName());
                }

            }else{
                teamCount++;
                playerCount=0;
                if(leagueTable.getArray().size()>teamCount){
                    System.out.println(" >>>>>>>>>>>>>>>> >>>> >> > PICKING PLAYERS FOR "+leagueTable.getArray().get(teamCount).getName()+" < << <<<< <<<<<<<<<<<<<");
                }
          }

      }
    }

//    CHECK PLAYER NAME EXIST
    public static Team<CricketPlayer> checkPlayer(LeagueTable<Team<CricketPlayer>> leagueTable, String name){
        for(Team<CricketPlayer> team:leagueTable.getArray()){
            if(team.getPlayerNames().contains(name)){
                return team;
            }
        }

        return null;
    }

//    PRINTING TEAMS
    public static void toPrintPlayers(LeagueTable<Team<CricketPlayer>> leagueTable){
        int count=1;
        System.out.println("TeamNO | TeamName");
        for(Team<CricketPlayer> team:leagueTable.getArray() ){
            System.out.println(" "+count+"     |   "+team.getName());
            count++;
        }



    }

//    COMPETING WITH OTHER TEAM
    public static void competeTeam(LeagueTable<Team<CricketPlayer>> leagueTable){

        while(true){
            toPrintPlayers(leagueTable);
            System.out.println("Select Your Team 1: ");

            int firstTeam = input.nextInt();
            input.nextLine();
            System.out.println("Select Your Team 2: ");
            int secondTeam = input.nextInt();
            input.nextLine();


            if (firstTeam == secondTeam){
                System.out.println("Teams are similar!!. Choose Different team");
            }else{
                Team<CricketPlayer> teamOne= leagueTable.getArray().get(firstTeam-1);
                Team<CricketPlayer> teamTwo= leagueTable.getArray().get(secondTeam-1);
                teamOne.matchResult(teamTwo,teamOne.generateScore(),teamTwo.generateScore());
                break;
            }
            leagueTable.printTeams();
        }

    }

//    PRINTING OPTIONS
    public static void printOptions() {
        System.out.println("-- OPTIONS AVAILABLE --");
        System.out.println("1. PRINT OPTIONS AVAILABLE\n2. PRINT TEAMS WITH LEADER BOARD\n3. PRINT PLAYERS\n4. COMPETE WITH OTHER TEAMS\n5. QUIT THE OPTION");
    }


}