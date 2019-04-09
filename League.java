/**
 * Models a league with a set of teams and a schedule of matches between them
 * 
 * @author Guangming Chen 21664707
 * @version v1.0
 * Simply using makeSchedule()and print()to see the output, with the input of
 * noOfTeams or filename(please add""with filename if it returns error).
 */
import java.util.ArrayList;

public class League
{
    // the teams in the league
    private ArrayList<String>  teams;
    // the schedule of matches
    private ArrayList<Round> fixtures;

    /**
     * Creates an object with noOfTeams teams named T1, T2, T3, etc. and an empty schedule.
     * You may assume that noOfTeams >= 0. 
     */
    public League(int noOfTeams)
    {
        
        teams = new ArrayList<String>();
        fixtures = new ArrayList<Round>();
        String s;
        for(int i=1;i<=noOfTeams;i++){
            s = String.valueOf(i);     //Create Ti team for each loop
            teams.add("T"+s);          //adds team to teams
        }
            
            
    }

    /**
     * Creates an object with the team names from filename (one per line) and an empty schedule. 
     * Uses FileIO to read the file. 
     * You may assume that filename is a valid text file. 
     */
    public League(String filename)
    {
        
        teams = new ArrayList<String>();
        fixtures = new ArrayList<Round>();
        FileIO file = new FileIO(filename);
        teams = file.getLines();
        
        
    }
    
    /**
     * Returns the teams in the league.
     */
    public ArrayList<String> getTeams()
    {       
        return teams;
    }
    
    /**
     * Returns the fixtures for the league.
     */
    public ArrayList<Round> getFixtures()
    {        
        return fixtures;
    }
    
    /**
     * Adds the provided round to the end of the schedule.
     */
    public void addRound(Round r)
    {
        fixtures.add(r);
        
    }
    
    /**
     * Moves the last item on teams to index 1 on the list.
     * e.g. <"A", "B", "C", "D"> would become <"A", "D", "B", "C">. 
     * You may assume that teams.size() >= 2. 
     */
    public void rotateTeams()
    {
        
        int  a;
        String lteam;
        a = teams.size()-1;
        lteam = teams.get(a);     //get the last team
        teams.remove(a);          //remove the last team
        teams.add(1,lteam);       //adds the last team to the second index
        
    }
    
    /**
     * Makes a schedule for teams, if there are an even number of them. 
     * Generate teams.size()-1 rounds, rotating the teams between each one. 
     * Team 0 should be at home in the first round, then it should alternate home and away. 
     * See the project description for some examples. 
     * You may assume that teams.size() >= 2 and teams.size() is even. 
     */
    public void makeEvenSchedule()
    {
        
        boolean b = true;                     //set b to true at first
        fixtures.clear();
        for(int i=1;i<=(teams.size()-1);i++){
            Round a = new Round();            //create a new round at each loop
            a.makeRound(teams,b);
            rotateTeams();
            b = !b;                           //reverse value of b at each loop
            addRound(a);                      //add round to fixtures
            
        }
        
    }
    
    /**
     * Makes a schedule for teams. 
     * If there are an odd number of them, add a dummy team at the front of the list, 
     * then at the end of the process delete the dummy and all of its matches. 
     * See the project description for some examples. 
     * You may assume that teams.size() >= 2. 
     */
    public void makeSchedule()
    {
           boolean b = true;         
           fixtures.clear();
           if (teams.size()%2==0){                
               makeEvenSchedule();
            }
            else{
                for(int i=1;i<=teams.size();i++){
                    Round a = new Round();
                    teams.add(0,"dummy");         
                    a.makeRound(teams,b); 
                    a.deleteMatch(0);       //delete the first match of odd team
                    rotateTeams();      
                    teams.remove(0);            
                    b = !b;
                    addRound(a);
        }
    }
    }

    /**
     * Returns a string describing the schedule.
     * See the project description for the required format.
     */
    public String getDisplayValue()
    {        
        String showRounds;
        showRounds = "";
        
        for(int i=0;i<fixtures.size();i++){
            int a = i+1;
            showRounds = showRounds+"Round "+a+"\n"+fixtures.get(i).getDisplayValue()+"\n";
        }
        return showRounds;
        
    }
    
    /**
     * Prints the schedule. 
     */
    public void print()
    {
        System.out.println(getDisplayValue());
    }
}
