import java.util.ArrayList;

public class CricketPlayer extends Player{
    private int totalRuns;
    private int totalWickets;
    private int highestRun;
    private int highestWickets;

    private boolean batsman;





    public CricketPlayer(String name,   boolean batsman) {
        super(name);
        this.batsman=batsman;
        if(this.batsman){
            int min = 3000;
            int max=10000;
            this.totalRuns = (int)(Math.random()*(max-min+1)+min);
            this.totalWickets = (int)(Math.random()*(50-1+1)+0);
            this.highestRun = (int)(Math.random()*(300-50+1)+50);
            this.highestWickets = (int)(Math.random()*(5+1));
        }else{
            this.totalRuns = (int)(Math.random()*(1000-100+1)+100);
            this.totalWickets = (int)(Math.random()*(800-100+1)+100);
            this.highestRun = (int)(Math.random()*(100-10+1)+10);
            this.highestWickets = (int)(Math.random()*(10-1+1)+1);
        }



    }

    public int getTotalRuns() {
        return totalRuns;
    }

    public void setTotalRuns(int totalRuns) {
        this.totalRuns = totalRuns;
    }

    public int getTotalWickets() {
        return totalWickets;
    }



    public int getHighestRun() {
        return highestRun;
    }



    public int getHighestWickets() {
        return highestWickets;
    }

    public void setHighestWickets(int highestWickets) {
        this.highestWickets = highestWickets;
    }
}
