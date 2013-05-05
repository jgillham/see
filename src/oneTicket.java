import java.util.List;
public class oneTicket implements Strategy {
    //int numPlays;
    
    public oneTicket ( final int numPlays, final List <Drawing> history ) {
	//this.numPlays = numPlays;
        // Method headers will be adjusted later
	printResults ( analyze ( play ( history ), history ) ); 
    }
    public List< Ticket > play ( final List< Drawing > history ) {
        throw new UnsupportedOperationException( "Please implement." );
    }
    public List< Hit > analyze ( final List< Ticket > tickets,
     final List< Drawing > history ) {
        throw new UnsupportedOperationException( "Please implement." );
    }
    public void printResults ( List< Hit > hits ) {
        throw new UnsupportedOperationException( "Please implement." );
    }
}
