package skinny.mailer.test

import org.jvnet.mock_javamail.Mailbox
import skinny.mailer.implicits.SkinnyMailerImplicits
import skinny.SkinnyEnv

trait SkinnyMailTestSupport extends SkinnyMailerImplicits {

  // set skinny.env as "test"
  System.setProperty(SkinnyEnv.PropertyKey, "test")

  /**
    * Creates a new Mailbox for specified email.
    */
  def mailbox(address: String): RichMailBox = new RichMailBox {
    override def underlying: Mailbox = Mailbox.get(address)
  }

  /**
    * Clears received messages from this mailbox.
    */
  def clearMailbox(address: String) = mailbox(address).clearReceivedMessages

}
