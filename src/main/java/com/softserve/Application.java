package com.softserve;

import com.softserve.dao.RecordDAO;
import com.softserve.dao.implementation.CategoryDAOImpl;
import com.softserve.dao.implementation.RecordDAOImpl;
import com.softserve.dao.implementation.UserDAOImpl;
import com.softserve.entity.Category;
import com.softserve.entity.Record;
import com.softserve.entity.User;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class Application {

    public static void main(String[] args) throws SQLException {

        User us1 = new User("Halina", "fdsjlfkj", "kjsd'kj.e", "868");
        UserDAOImpl userDAO = new UserDAOImpl();
        CategoryDAOImpl catDAO = new CategoryDAOImpl();
        RecordDAOImpl recordDAO = new RecordDAOImpl();
        // System.out.println(userDAO.save(us1));

        Record record = new Record(98.09, LocalDate.parse("1193-03-15"),
                "awdwadawdawd", 2L, 1L, 3L);
//        System.out.println(userDAO.getById(6L));

 //              System.out.println(recordDAO.save(record));
        // System.out.println(recordDAO.getAllByUserId(1L));
        // System.out.println(recordDAO.getById(2L));
 //       System.out.println(recordDAO.update(2L, record));
 //       System.out.println(recordDAO.delete(2L));

  //      System.out.println(recordDAO.getAllByUserIdAndFinancialTypeId(1L, 2L));
//        us1.setPhoto("Some sefs");
//        System.out.println(us1);
//        System.out.println(userDAO.update(1L, us1));

        //       userDAO.delete(3L);

        Category category = new Category("title", "#5479", "short or long description", 1L, 1L);

//
//        System.out.println(catDAO.save(category));
//        System.out.println(catDAO.getById(1L));
        // System.out.println(catDAO.getAllByUserId(4L));
    }
}