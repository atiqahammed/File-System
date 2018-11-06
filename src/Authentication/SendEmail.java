package Authentication;

import java.util.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;

public class SendEmail {

	private static String USER_NAME = "neverbetterpakas@gmail.com"; // GMail
																	// user name
																	// (just the
																	// part
																	// before
																	// "@gmail.com")
	private static String PASSWORD = "neverbetterpakas"; // GMail password
	private String RECIPIENT;// = "bsse0@iit.du.ac.bd";

	public void welcome(String user, String email) {
		String from = USER_NAME;
		String pass = PASSWORD;
		RECIPIENT = email;
		String[] to = { RECIPIENT }; // list of recipient email addresses
		String subject = "WELCOME TO FILE SYSTEM";
		String body = "Welcome " + user + ",\n Your registration completed.\nThank you for using our system.\n";

		sendFromGMail(from, pass, to, subject, body);
		// return false;
	}

	public void recoverMessage(String user, String email, int x) {
		String from = USER_NAME;
		String pass = PASSWORD;
		RECIPIENT = email;
		String[] to = { RECIPIENT }; // list of recipient email addresses
		String subject = "RECOVER ACCOUNT";
		String body = "DEAR " + user + ",\n Your varification code: " + x;

		sendFromGMail(from, pass, to, subject, body);
		// return false;
	}

	private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
		Properties props = System.getProperties();
		String host = "smtp.gmail.com";
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(from));
			InternetAddress[] toAddress = new InternetAddress[to.length];

			// To get the array of addresses
			for (int i = 0; i < to.length; i++) {
				toAddress[i] = new InternetAddress(to[i]);
			}

			for (int i = 0; i < toAddress.length; i++) {
				message.addRecipient(Message.RecipientType.TO, toAddress[i]);
			}

			message.setSubject(subject);
			message.setText(body);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}
}