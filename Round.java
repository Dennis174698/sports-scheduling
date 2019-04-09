/**
 * Models a round of matches in a league schedule.
 * 
 * @author Dennis Chen
 * @version v1.0
 */
import java.util.ArrayList;

public class Round
{
    // the list of matches
    private ArrayList<Match> matches;

    /**
     * Creates an empty round of matches.
     */
    public Round()
    {
        
        matches = new ArrayList<Match>();
        
    }
    
    /**
     * Returns the list of matches.
     */
    public ArrayList<Match> getMatches()
    { 
        return matches;
    }
    
    /**
     * Adds the provided match at the end of the round.
     */
    public void addMatch(Match match)
    {
        matches.add(match);
    }
    
    /**
     * Removes the indicated match from the round, if the index is legal.
     */
    public void deleteMatch(int index)
    {
        
        if (matches.size()>index){        //delete matches only if matches size
        matches.remove(index);            //bigger than input index
    }
        
    }
    
    /**
     * Makes a round of matches for the provided teams. 
     * Teams 0 & 1 play each other (Team 0 at home iff the second argument is true), then 
     * Team 2 is at home to the last team, Team 3 is at home to the next-to-last team, and so on. 
     * e.g. for six teams A,B,C,D,E,F and second argument true, 
     * we would get the three matches A vs. B, C vs. F, D vs. E. 
     * e.g. for eight teams A,B,C,D,E,F,G,H and second argument false, 
     * we would get the four matches B vs. A, C vs. H, D vs. G, E vs. F. 
     * You may assume that teams.size() >= 2 and teams.size() is even. 
     */
    public void makeRound(ArrayList<String> teams, boolean b)
    {
        
        int MatchNum = teams.size()/2;
        int size = teams.size();
        matches.clear();
        for(int i=0;i<=MatchNum;i++){
            if(i==0 && b ){    //if b is true then t1 vs t2
                Match a = new Match(teams.get(0),teams.get(1));
                addMatch(a);
            }
            else if(i==0&&!b){ //if b is false then t2 vs t1
                Match a = new Match(teams.get(1),teams.get(0));
                addMatch(a);
            }
            else if(i>=2){     
                Match a = new Match(teams.get(i),teams.get(size-i+1));
                addMatch(a);
                //for the rest of teams
                //team at index i vs team at index size-i-1
            }
            
        }
        
        
    }
    
    /**
     * Returns a string describing this round of matches. 
     * See the project description for the required format. 
     */
    public String getDisplayValue()
    {
        
        String showMatches;
        showMatches = "";
        
        for(int i=0;i<matches.size();i++){
            
            showMatches = showMatches+matches.get(i).getDisplayValue()+"\n";
        }
        return showMatches;
    }

}
