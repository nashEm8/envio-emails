package envio.email;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.experimental.theories.suppliers.TestedOn;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@org.junit.Test
	public void testeEmail() throws Exception {
		
		
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
		
		stringBuilderTextoEmail.append("Olá, tudo bom? Bem vindo! <br/>");
		stringBuilderTextoEmail.append("<h2>Você está sendo convidado a participar da comunidade de <span style=color:#ff0000>JAVA</span></h2>");
		stringBuilderTextoEmail.append("<hr/>");
		stringBuilderTextoEmail.append("<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>");
		stringBuilderTextoEmail.append("<a href=\"https://emanuelazevedo.netlify.app\" \"_blank\" style=\"background-color:#F4FA58; padding: 5px 10px; border-radius: 2px; border: 1px solid #000; color:#000; font-size:12px; text-decoration:none; font-weight: bold;\"> Entrar em contato </a> <br/>");
		
		ObjetoEnviaEmail envioEmail = 
			new ObjetoEnviaEmail(
					"emanuel82016@gmail.com, elzinamas@gmail.com", 
					"Emanuel Azevedo", 
					"Teste envio de emails com Java", 
					stringBuilderTextoEmail.toString());
		
		envioEmail.enviarEmail(true);
		
	}
}
