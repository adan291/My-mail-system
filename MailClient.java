/**
 * A class to model a simple email client. The client is run by a
 * particular user, and sends and retrieves mail via a particular server.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MailClient
{
    // The server used for sending and receiving.
    private MailServer server;
    // The user running this client.
    private String user;
    // Es spam
    private boolean spam;

    /**
     * Create a mail client run by user and attached to the given server.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
    }

    /**
     * Return the next mail item (if any) for this user.
     */
    public MailItem getNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if (item == null){
            spam = false;
            return item;
        }
        else if((item.getMessage().contains("promocion"))||(item.getMessage().contains("regalo"))) {
            spam = true;
            return null;    
        }
        else if (item.getMessage().contains("trabajo")){
            spam = false;
            return item;
        }
        else {
            spam = false;
            return item;
        }
    }

    /**
     * Print the next mail item (if any) for this user to the text 
     * terminal.
     */
    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item == null) {
            if (spam == true){
                System.out.println("Se ha recibido spam");
            }
            else{
                System.out.println("No new mail.");
            }
        }
        else {

            item.print();
        }
    }

    /**
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendMailItem(String to, String subject, String message)
    {
        MailItem item = new MailItem(user, to, subject, message);
        server.post(item);
    }

    /**
     * A method call getNextMailItemAndAutorespond that recover of the server the next mail and return other different ("No estoy en la oficina"),
     * the same message has  the prefix "Re" too.
     */
    public void getNexMailItemAndAutorespond()
    {
        MailItem item = server.getNextMailItem (user);

        if (item == null||(item.getMessage().contains("promocion"))||(item.getMessage().contains("regalo")))
        {
            System.out.println ("No new mail."); //si quisiera una línea sin salto de linea System.out.print();
        }
        else
        {   
            // \n salta a una nueva línea
            // \t introduce un tabulador

            sendMailItem (item.getFrom(),"Re"  + item.getSubject(),"No estoy en la oficina.\n\t" + item.getMessage() );

        }
    }
}
