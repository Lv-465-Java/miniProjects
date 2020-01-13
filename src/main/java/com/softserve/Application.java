package com.softserve;

import com.softserve.dto.RecordDTO;
import com.softserve.service.implementation.PlanedOutcomeServiceImpl;
import com.softserve.service.implementation.RecordServiceImpl;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {

        RecordServiceImpl recordService = new RecordServiceImpl();
//        recordService.checkIfPlanedOutcomeMatchesCategory(3L, 7L);
        PlanedOutcomeServiceImpl planedOutcomeService = new PlanedOutcomeServiceImpl();

//        recordService.increasePlannedOutcomeSum(6L, 500.66);
//        System.out.println(planedOutcomeService.getById(7L));
//        RecordDTO recordDTO = new RecordDTO();
//        recordDTO.setSum(2200.67);
//        recordDTO.setDate(LocalDate.parse("2020-01-01"));
//        recordDTO.setNote("Test planned outcome sum");
//        recordDTO.setFinancialTypeId(2L);
//        recordDTO.setUserId(13L);
//        recordDTO.setCategoryId(10L);
//        recordDTO.setPlanedOutcomeId(5L);
//        recordService.create(recordDTO);
//

        System.out.println(recordService.delete(21L));
        System.out.println(planedOutcomeService.getById(6L));
    }
}