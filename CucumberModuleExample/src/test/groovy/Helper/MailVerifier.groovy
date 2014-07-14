package Helper

import javax.mail.Flags
import javax.mail.Folder
import javax.mail.Message
import javax.mail.Session
import javax.mail.Store

/**
 * Created with IntelliJ IDEA.
 * User: ee
 * Date: 25/06/14
 * Time: 09:14
 * To change this template use File | Settings | File Templates.
 */
class MailVerifier {

    String emailServer
    String email
    String password

    Folder folder
    Session session
    Store store

    Message[] messages = null

    boolean mailFound = false

    public MailVerifier(String emailServer, String email, String password){
        this.email = email
        this.emailServer = emailServer
        this.password = password
        emailPropertiesSetup()
    }

    public emailPropertiesSetup(){
        Properties props = System.getProperties()
        props.setProperty("mail.store.protocol", "imaps")

        session = Session.getDefaultInstance(props, null)
        store = session.getStore("imaps")
        store.connect(emailServer, email, password)
        folder = store.getFolder("INBOX")

        folder.open(Folder.READ_WRITE)
    }

    public boolean isMailFound(){
        messages = folder.getMessages()
        for(Message mail : messages){
            println mail.getFrom()
          if(mail.getSubject().equals("Forgot Password from the-internet")){
              mailFound = true
              mail.setFlag(Flags.Flag.DELETED, true)
          }
        }
        return mailFound
    }

    String getEmailServer() {
        return emailServer
    }

    String getEmail() {
        return email
    }

    String getPassword() {
        return password
    }
}
