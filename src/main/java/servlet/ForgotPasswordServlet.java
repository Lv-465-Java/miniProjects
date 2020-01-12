package servlet;

import service.impl.MailService;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/forgotPassword")
public class ForgotPasswordServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

//    private String host;
//    private String port;
//    private String email;
//    private String name;
//    private String pass;
//
//    public void init() {
//        // reads SMTP server setting from web.xml file
//        ServletContext context = getServletContext();
//        host = context.getInitParameter("host");
//        port = context.getInitParameter("port");
//        email = context.getInitParameter("email");
//        name = context.getInitParameter("name");
//        pass = context.getInitParameter("pass");
//    }

    public ForgotPasswordServlet() {
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
       // final String toEmail = recipient; // can be any email id

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        //create Authenticator object to pass in Session.getInstance argument
        Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        };
        Session session = Session.getInstance(props, auth);

        try {
            MailService.sendEmail(session, recipient,subject, content);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
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
