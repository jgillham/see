import java.util.List;
public class oneTicket implements Strategy {
    int numPlays;
    final List <Drawing> history;
    
    public oneTicket ( final int numPlays, final List <Drawing> history ) {
	this.numPlays = numPlays;
	this.history = history;
        // Method headers will be adjusted later
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
