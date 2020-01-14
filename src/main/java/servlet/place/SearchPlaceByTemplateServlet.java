package servlet.place;

import dto.PlaceDto;
import exception.NotFoundException;
import service.PlaceService;
import service.impl.PlaceServiceImpl;
import servlet.JSPFILES;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Class processes requests for "/searchPlaceByTemplate"  url
 */
@WebServlet("/searchPlaceByTemplate")
public class SearchPlaceByTemplateServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private PlaceService placeService;

    /**
     * Method initializes required resources
     */
    @Override
    public void init() {
        placeService=new PlaceServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String template=String.valueOf(request.getParameter("search"));

        try {
            List<PlaceDto> list = placeService.getByTemplate(template);
            request.setAttribute("placeList", list);

            getServletConfig().getServletContext()
                    .getRequestDispatcher(JSPFILES.SEARCH_PLACE_BY_TEMPLATE.getPath()).forward(request,response);
            //dispatcher.forward(request, response);
//            response.sendRedirect( request.getContextPath()+"/searchPlaceByTemplate");
        } catch (NotFoundException e){
            request.setAttribute("error", e.getMessage());
        }

    }
}
