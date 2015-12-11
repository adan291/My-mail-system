
/**
 * Write a description of class MailItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    // instance variables 
    private String from;
    private String to;
    private String message;
    private String subject;
    /**
     * Constructor for objects of class MailItem
     */
    public MailItem( String from,String to, String subject, String message)
    {
        // initialise instance variables with the parametres from,to and message
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.message = message;
    }

    /**
     * A method get in order to from
     */
    public String getFrom()
    {
        // return from
        return from;
    }
    
    /**
     * A method get in order to to
     */
    public String getTo()
    {
        // return to
        return to;
    }
    
    /**
     * A method get in order to to
     */
    public String getMessage()
    {
        // return message
        return message;
    }
    /**
     * A method get in order to subject
     */
    public String getSubject()
    {
        // return subject
        return subject;
    }
     /**
     * A method get in order to print that show the parametres from,to and message
     */
    public void print()
    {
        // show the parametres
        System.out.println ( "From " + from);
        System.out.println ( "To " + to);
        System.out.println ( "Subject " + subject);
        System.out.println ( "Message " + message);
    }
}
