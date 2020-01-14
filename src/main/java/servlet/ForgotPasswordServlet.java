package servlet;

import service.impl.MailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.util.Properties;

/**
 * Class processes requests for "/forgotPassword"  url
 */
@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private MailService mailService;

    //    private String host;
//    private String port;
//    private String email;
//    private String name;
//    private String pass;
//
//    public void init() {
//        mailService = new MailService();
//
//    }
//        // reads SMTP server setting from web.xml file
//        ServletContext context = getServletContext();
//        host = context.getInitParameter("host");
//        port = context.getInitParameter("port");
//        email = context.getInitParameter("email");
//        name = context.getInitParameter("name");
//        pass = context.getInitParameter("pass");
//    }

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


        final String fromEmail = "maryankakravets@gmail.com"; //requires valid gmail id
        final String password = "18081989mar"; // correct password for gmail id

        System.out.println("TLSEmail Start");
        String host="smtp.gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
//        Authenticator auth = new Authenticator() {
//            //override the getPasswordAuthentication method
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(fromEmail, password);
//            }
//        };
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
            //JOptionPane.showMessageDialog(null,"fvgggg");
            // MailService.sendEmail(session, recipient,subject, content);
//
//
//
//        try {
//            MailService.sendEmail(host, port, email, name, pass,
//                    recipient, subject, content);
            message = "The e-mail was sent successfully. Please check your e-mail.";
            request.getRequestDispatcher(JSPFILES.LOGIN_JSP.getPath()).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            message = "There were an error: " + ex.getMessage();
        } finally {
            request.setAttribute("message", message);
//            request.getRequestDispatcher(JSPFILES.LOGIN_JSP.getPath()).forward(request, response);
        }
    }
}

