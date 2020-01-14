package com.softserve.onlineshop.servlet.phone;

import com.softserve.onlineshop.dto.ModelDto;
import com.softserve.onlineshop.dto.PhoneDto;
import com.softserve.onlineshop.service.ModelService;
import com.softserve.onlineshop.service.PhoneService;
import com.softserve.onlineshop.service.impl.ModelServiceImpl;
import com.softserve.onlineshop.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import static com.softserve.onlineshop.constant.Parameters.IMG_PATH;

@WebServlet("/update-phone")
@MultipartConfig
public class UpdatePhoneServlet extends HttpServlet {
    private PhoneService phoneService;
    private ModelService modelService;
    private Long phoneId;

    @Override
    public void init() {
        phoneService = new PhoneServiceImpl();
        modelService = new ModelServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        phoneId = Long.parseLong(request.getParameter("update"));
        List<ModelDto> models = modelService.getAll();
        request.setAttribute("models", models);
        request.getSession(false).setAttribute("phoneId", phoneId);
        request.setAttribute("old-year", phoneService.getById(phoneId).getYear());
        request.setAttribute("old-price", phoneService.getById(phoneId).getPrice());
//        request.setAttribute("old-photo", phoneService.getById(phoneId).getPhoto());
        request.setAttribute("old-color", phoneService.getById(phoneId).getColor());
        request.setAttribute("old-screen-diagonal", phoneService.getById(phoneId).getScreenDiagonal());
        request.setAttribute("old-internal-memory", phoneService.getById(phoneId).getInternalMemory());
        request.getRequestDispatcher("/WEB-INF/views/update-phone.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("photo");
        String fileName = UUID.randomUUID().toString() + "_" + Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        InputStream fileStream = filePart.getInputStream();
        byte[] bytes = new byte[fileStream.available()];
        fileStream.read(bytes);
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(
                        new File(IMG_PATH + fileName)));
        bos.write(bytes);
        bos.close();

        Long id = (Long) request.getSession(false).getAttribute("phoneId");
        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setYear(Integer.parseInt(request.getParameter("new-year")));
        phoneDto.setPrice(Integer.parseInt(request.getParameter("new-price")));
        phoneDto.setPhoto(fileName);
//        phoneDto.setPhoto(request.getParameter("new-photo"));
        phoneDto.setColor(request.getParameter("new-color"));
        phoneDto.setScreenDiagonal(Double.parseDouble(request.getParameter("new-screen-diagonal")));
        phoneDto.setInternalMemory(Integer.parseInt(request.getParameter("new-internal-memory")));
        phoneDto.setModelId(Long.parseLong(request.getParameter("models")));

        try {
            phoneService.updateById(phoneDto, id);
            response.sendRedirect(request.getContextPath() + "/add-phone");
        } catch (RuntimeException ex) {
            getServletConfig()
                    .getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/update-model.jsp")
                    .forward(request, response);
        }
    }
}
