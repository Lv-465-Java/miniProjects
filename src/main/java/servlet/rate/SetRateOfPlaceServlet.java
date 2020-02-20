package servlet.rate;

import dto.PlaceDto;
import entity.Comment;
import entity.Rate;
import exception.NotFoundException;
import service.CommentService;
import service.PlaceService;
import service.RateService;
import service.impl.CommentServiceImpl;
import service.impl.PlaceServiceImpl;
import service.impl.RateServiceImpl;
import servlet.JSPFILES;
import utils.SessionCookieManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Class processes requests for "/evaluatePlace"  url
 */
@WebServlet("/evaluatePlace")
public class SetRateOfPlaceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private RateService rateService;
    private PlaceService placeService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        rateService=new RateServiceImpl();
        placeService=new PlaceServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            List<PlaceDto> placeDto=placeService.getAll();
            request.setAttribute("placeDtoList",placeDto);

            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.EVALUATE_PLACE.getPath());
            dispatcher.forward(request, response);
        } catch (NotFoundException e){
            request.setAttribute("error",e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.MAIN_PAGE.getPath());
            dispatcher.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();

        int rate= Integer.parseInt(request.getParameter("rateValue"));
        Long placeId = Long.parseLong(request.getParameter("placeId"));
        Long userId= SessionCookieManager.getLoginedUser(session).getId();

        Rate rate1= Rate.builder().value(rate).userId(userId).placeId(placeId).build();

        try {
            rateService.insert(rate1);
            request.setAttribute("rate", rate1);
            response.sendRedirect(request.getContextPath() + "/mainPage");
        } catch (NotFoundException e){
            request.setAttribute("error", e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher(JSPFILES.EVALUATE_PLACE.getPath());
            dispatcher.forward(request, response);
        }

    }
}
