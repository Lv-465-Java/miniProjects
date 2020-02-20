package servlet;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * Class processes requests for "/forgotPassword"  url
 */
@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher(JSPFILES.FORGOT_PASSWORD.getPath()).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String recipient = request.getParameter("recipient_address");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");


        String message = "";


        final String fromEmail = "maryankakravets@gmail.com";
        final String password = "18081989mar";

        System.out.println("TLSEmail Start");
        String host="smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, null);


        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient, false));

            String finalText = "subject" + subject + message + "message";

            msg.setSubject(subject);

            msg.setSubject("Contact Details");
            Transport transport=session.getTransport("smtp");
            transport.connect(host, fromEmail,password);
            Transport.send(msg, msg.getAllRecipients());
            transport.close();


            message = "The e-mail was sent successfully. Please check your e-mail.";
            request.getRequestDispatcher(JSPFILES.LOGIN_JSP.getPath()).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            message = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("message", message);

        }
    }
}

