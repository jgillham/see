/**
 * The experiment runner sets up and runs an experiment.
 *
 * @author Josh Gillham
 * @version 5-4-13
 */
public enum Experiment {
    NONE
    ,
    /** Can the same numbers eventually win? */
    STUBORN_PLAYER
    ,
    /** Can winning be guaranteed with a subset of tickets? */
    MANIAC_PLAYER
    ,
    /** Can we get a better winning probability with high numbers? */
    PICKY_HIGH_NUMBERS_PLAYER
    ,
    /** Can we get a better winning probability with low numbers? */
    PICKY_LOW_NUMBERS_PLAYER
    ;
    /** Set to true to enable debugging. */
    static public boolean DEBUG = false;
    /** Potential error values. */
    public enum Error {
        /** No arguments were given to the program. */
        NO_ARGUMENTS
        ,
        /** The experiment is not defined. */
        NO_SUCH_EXPERIMENT
        ,
        /** The experiment has not been implimented. */
        UNIMPLEMENTED_EXPERIMENT
        ;
    }
    
    /**
     * Starts the experiment from the command line.
     *
     * @param args expects a number designating the experiment to run.
     */
    static public void main( String[] args ) {
        // DEBUG print all arguments.
        if ( DEBUG ) {
            for( int i = 0; i < args.length; ++i ) {
                System.out.printf( "Argument[%d]: %s\n", i, args[i] );
            }
        }
        // Check for minimum arguments.
        if ( args.length < 1 ) {
            printUsage();
            System.exit( Error.NO_ARGUMENTS.ordinal() );
        }
        // Select an experiment using the arguments.
        Experiment choice = null;
        try {
            choice = Experiment.values()[ Integer.valueOf( args[0] ) ];
        }
        catch ( Exception e ) {
            System.out.println( "Bad experiment choice." );
            printUsage();
            System.exit( Error.NO_SUCH_EXPERIMENT.ordinal() );
        }
        // Run the selected experiment.
        switch ( choice ) {
        case NONE:
            System.out.println( "Bad experiment choice." );
            printUsage();
            System.exit( Error.NO_SUCH_EXPERIMENT.ordinal() );
        case STUBORN_PLAYER:
            runStubornPlayer();
        break;
        case MANIAC_PLAYER:
        case PICKY_HIGH_NUMBERS_PLAYER:
        case PICKY_LOW_NUMBERS_PLAYER:
        default:
            System.out.println( "Experiment needs implementation." );
            printUsage();
            System.exit( Error.UNIMPLEMENTED_EXPERIMENT.ordinal() );
        }
    }
    
    /** Show the current commands for this program. */
    static public void printUsage() {
        System.out.println( "Usage: <experiment number>" );
        System.out.println( "experiment number -- chooses the experiment." );
    }
    
    /** Run the stuborn player experiment. */
    static public void runStubornPlayer() {
    }
}