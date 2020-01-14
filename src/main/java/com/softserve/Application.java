package com.softserve;

import com.softserve.dao.implementation.RecordDAOImpl;
import com.softserve.dto.RecordDTO;
import com.softserve.service.implementation.PlanedOutcomeServiceImpl;
import com.softserve.service.implementation.RecordServiceImpl;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
//        List<Object> dates = new ArrayList<>();
//        dates.add(2L);
//        dates.add(LocalDate.parse("2020-01-01"));
//        dates.add(LocalDate.parse("2020-01-30"));
//
//        RecordServiceImpl recordService = new RecordServiceImpl();
//        System.out.println(recordService.filter(13L, dates));

//        RecordDAOImpl recordDAO = new RecordDAOImpl();
//        System.out.println(recordDAO.getAllBySelectedFilters(13L, 1L, LocalDate.parse("2020-01-22"), LocalDate.parse("2020-01-24")));



//        recordService.checkIfPlanedOutcomeMatchesCategory(3L, 7L);
        PlanedOutcomeServiceImpl planedOutcomeService = new PlanedOutcomeServiceImpl();
//        System.out.println(recordDAO.generateSearchQuery(13L, LocalDate.parse("2020-01-22"),
        //         LocalDate.parse("2020-01-24"), 2L));

//        recordService.increasePlannedOutcomeSum(6L, 500.66);
//        System.out.println(planedOutcomeService.getById(14L));
//        System.out.println((double)Math.round((34.445354360d * 1000d) / 1000d));
//        RecordDTO recordDTO = new RecordDTO();
//        Double d = 28786.024525;
//        String str = String.format("%1.2f", d);
//        d = Double.parseDouble(str);
//        DecimalFormat df = new DecimalFormat("#.##");
//        double dou= Double.parseDouble(df.format(d));
//        System.out.println(dou);
//        recordDTO.setSum(2200.67);
//        System.out.println(Math.nextUp(d));
//        recordDTO.setDate(LocalDate.parse("2020-01-01"));
//        recordDTO.setNote("Test planned outcome sum");
//        recordDTO.setFinancialTypeId(2L);
//        recordDTO.setUserId(13L);
//        recordDTO.setCategoryId(10L);
//        recordDTO.setPlanedOutcomeId(5L);
//        recordService.create(recordDTO);
//
//
//        System.out.println(recordService.delete(21L));
//        System.out.println(planedOutcomeService.getById(6L));
    }
}