package com.softserve;

import com.softserve.dto.RecordDTO;
import com.softserve.service.implementation.PlanedOutcomeServiceImpl;
import com.softserve.service.implementation.RecordServiceImpl;

import java.sql.SQLException;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) throws SQLException {
        RecordServiceImpl recordService = new RecordServiceImpl();

        PlanedOutcomeServiceImpl planedOutcomeService = new PlanedOutcomeServiceImpl();
 //       PlanedOutcomeDTO planedOutcomeDTO = new PlanedOutcomeDTO(34.22, LocalDate.parse("2019-01-16"), "PLAN", 13L, 4L);
//        planedOutcomeService.create(planedOutcomeDTO);

        RecordDTO recordDTO = RecordDTO.Builder.aRecordDTO()
                .withSum(39.3)
                .withDate(LocalDate.parse("2019-01-16"))
                .withNote("note")
                .withUserId(13L)
                .withFinancialTypeId(1L)
                .withCategoryId(4L)
                .withPlanedOutcomeId(2L)
                .build();

      //  System.out.println(planedOutcomeService.getById(2L));
        System.out.println(recordService.create(recordDTO));

    }




}