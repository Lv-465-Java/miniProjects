package com.softserve.onlineshop.servlet.phone;

import com.softserve.onlineshop.dto.ModelDto;
import com.softserve.onlineshop.dto.PhoneDto;
import com.softserve.onlineshop.dto.ProducerDto;
import com.softserve.onlineshop.service.ModelService;
import com.softserve.onlineshop.service.PhoneService;
import com.softserve.onlineshop.service.ProducerService;
import com.softserve.onlineshop.service.impl.ModelServiceImpl;
import com.softserve.onlineshop.service.impl.PhoneServiceImpl;
import com.softserve.onlineshop.service.impl.ProducerServiceImpl;

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

@WebServlet("/add-phone")
@MultipartConfig
public class AddPhoneServlet extends HttpServlet {
    private PhoneService phoneService;
    private ModelService modelService;
    private ProducerService producerService;

    @Override
    public void init() {
        phoneService = new PhoneServiceImpl();
        modelService = new ModelServiceImpl();
        producerService = new ProducerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<PhoneDto> phones = phoneService.getAll();
            List<ModelDto> models = modelService.getAll();
            List<ProducerDto> producers = producerService.getAll();
            request.setAttribute("phones", phones);
            request.setAttribute("models", models);
            request.setAttribute("producers", producers);
            request.getRequestDispatcher("/WEB-INF/views/add-phone.jsp").include(request, response);
        } catch (RuntimeException e) {
            request.setAttribute("error", "Empty phones list");
            request.getRequestDispatcher("/WEB-INF/views/add-phone.jsp")
                    .forward(request, response);
        }
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


        PhoneDto phoneDto = new PhoneDto();
        phoneDto.setYear(Integer.parseInt(request.getParameter("year")));
        phoneDto.setPrice(Integer.parseInt(request.getParameter("price")));
        phoneDto.setPhoto(fileName);
//        phoneDto.setPhoto(request.getParameter("photo"));
        phoneDto.setColor(request.getParameter("color"));
        phoneDto.setScreenDiagonal(Double.parseDouble(request.getParameter("screen-diagonal")));
        phoneDto.setInternalMemory(Integer.parseInt(request.getParameter("internal-memory")));
        phoneDto.setModelId(Long.parseLong(request.getParameter("models")));
        try {
            phoneService.save(phoneDto);
            request.setAttribute("success", "Phone successfully added");
            doGet(request, response);
            request.getRequestDispatcher("/WEB-INF/views/add-phone.jsp")
                    .forward(request, response);
        } catch (RuntimeException e) {
            doGet(request, response);
            request.getRequestDispatcher("/WEB-INF/views/add-phone.jsp")
                    .forward(request, response);
        }
    }

}
