package envio.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ObjetoEnviaEmail {
	
	private String userName = "emanuel82016@gmail.com";
	private String password = "jfldxljsrupggjiv";
	
	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assuntoEmail = "";
	private String messageEmail;
	
	public ObjetoEnviaEmail(String listaDestinatarios, String nomeRemetente, String assuntoEmail, String messageEmail) {
		this.listaDestinatarios = listaDestinatarios;
		this.nomeRemetente = nomeRemetente;
		this.assuntoEmail = assuntoEmail;
		this.messageEmail = messageEmail;
	}

	public void enviarEmail(boolean envioHtml) throws Exception{
		Properties props = new Properties();
		props.put("mail.smtp.ssl.trust", "*");
		props.put("mail.smtp.auth", "true"); /* Autorização */
		props.put("mail.smtp.starttls", "true"); /* Autenticação */
		props.put("mail.smtp.host", "smtp.gmail.com"); /* Servidor email outlook */
		props.put("mail.smtp.port", "465"); /* Porta do servidor */
		props.put("mail.smtp.socketFactory", "465"); /* Porta a ser conectada pelo socket */
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory"); /* Classe socket de conexão ao SMTP */

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(userName, password);
			}
		});

		session.setDebug(true);

		Address[] toUser = InternetAddress.parse("emanuel82016@gmail.com");

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(userName, "Emanuel Azevedo"));
		message.setRecipients(Message.RecipientType.TO, toUser);
		message.setSubject(assuntoEmail);
		
		if(envioHtml) {
			message.setContent(messageEmail, "text/html; charset=utf-8");
		} else {
			message.setText("Olá, você acaba de receber esse email enviado com Java!");			
		}
		

		Transport.send(message);
	}
}
