import java.util.*;
import java.io.*;

/** This class will drive the lotto analyzation program. It will simulate 
 *   several strategies for playing the lottery.
 *
 *  @author Jesse Nelson
 *  @author Josh Gillham
 *  @version May 04, 2013 : OS:3.8.10-1-ARCH : JavaVersion:ArchLinux build 7.u21_2.3.9-1-x86_64 
 */
public class Plays {
    private static Calendar cal = Calendar.getInstance();
    private List<Drawing> lottoHistory;
    // Add your strategies to this list
    private List<Strategy> strategies; 
    static public class BadFileFormatException extends Exception {
        public BadFileFormatException( Throwable cause ) {
            super( cause );
        }
    }
    public static void main( String[] args ) {
        try {
            List<Drawing> lottoHistory = storeLottoHistory ( args [0] );
        }
        catch ( FileNotFoundException e ) {
            System.exit( 1 );
        }
        catch ( BadFileFormatException e ) {
            System.exit( 1 );
        }
        // XXX Add sample code to boot strap simulation.
    }
    public Plays( List< Drawing > lottoHistory, List< Strategy > strategies ) {
        this.lottoHistory = lottoHistory;
        this.strategies = strategies;
    }
    private void playStrategies (  ) {
        playStrategies( this.lottoHistory, this.strategies );
    }

    /** Read lottery data from file specified on command line
     *  @param fileName Name of file holding lottery data
     *  @return games A list of lottoGame objects created from lottery history 
     */
    public static List<Drawing> storeLottoHistory ( String fileName )
     throws BadFileFormatException, FileNotFoundException {
	ArrayList<Drawing> games = new ArrayList<Drawing> ( );
	ArrayList<Integer> gameNumbers;
	StringTokenizer st;
	String line;

	try { // This is hardcoded for our CO data set but it can easily be fixed 
	    Scanner infile = new Scanner ( new FileReader ( fileName ) );
            // Skip header.
            infile.nextLine();
	    while ( infile.hasNextLine ( ) ) {
		gameNumbers = new ArrayList<Integer> ( );
		line = infile.nextLine ( );
		st = new StringTokenizer ( line, "," );   // We can pass delimeter from regex string if needed
		st.nextToken ( ); // Get rid of state token ( CO data set )
		//while ( st.hasMoreTokens ( ) ) { // Incase we have data formatted differently
		    Date drawingDate = parseDate( st.nextToken ( ) );
		    for ( int i = 0; i < 5; i++ ) {
			gameNumbers.add ( Integer.parseInt ( st.nextToken ( ) ) ); 
		    }
		    games.add ( new Drawing ( drawingDate, gameNumbers, 0.0 ) ); 
		    //}
	    }
	}
	/*catch ( IOException e ) {
	    System.out.println ( e );
	    }*/
	
	catch ( NumberFormatException e ) {
            //e.printStackTrace();
            throw new BadFileFormatException( e );
	}
	
	return games;
    }
    
    /** This method will will iterate through the strategies and play them
     *
     * @param strats list of strategies
     */
    private static void playStrategies ( List<Drawing> lottoHistory, 
     List<Strategy> strats ) {
	Strategy current;
	for ( int i = 0; i < strats.size ( ); i++ ) {
	    current = strats.get ( i );
	    current.printResults ( current.analyze ( current.play ( lottoHistory ), lottoHistory ) );
	}
    }

    /** Parses a date out of a string
     *  
     *  @param date Lottery drawing date from history
     *  @return a date object representing date of drawing
     */
    private static Date parseDate ( String date ) {
	StringTokenizer st = new StringTokenizer ( date, "/" );
	cal.set ( Calendar.MONTH, Integer.parseInt ( st.nextToken ( ) ) );
	cal.set ( Calendar.DAY_OF_MONTH, Integer.parseInt ( st.nextToken ( ) ) );
	cal.set ( Calendar.YEAR, Integer.parseInt ( st.nextToken ( ) ) );
	
	return cal.getTime();
    }
}
 
