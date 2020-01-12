package com.softserve;

import com.softserve.dao.implementation.CategoryDAOImpl;
import com.softserve.service.implementation.CategoryServiceImpl;

public class Application {

    public static void main(String[] args) {

        //    CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
        CategoryServiceImpl categoryService = new CategoryServiceImpl();

        System.out.println(categoryService.getAllByUserIdAndFinancialTypeId(13L));

        //  System.out.println(categoryDAO.getAllByUserIdAndFinancialTypeId(1L, 2L));


    }
}