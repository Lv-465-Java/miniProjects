package com.softserve.service.mapper;

import com.softserve.constant.ErrorMessage;
import com.softserve.dto.PlanedOutcomeDTO;
import com.softserve.entity.PlanedOutcome;

import java.util.Optional;

public class PlanedOutcomeMapperObjects {

    public static PlanedOutcomeDTO planedOutcomeEntityToPlanedOutcomeDTO(PlanedOutcome entity) {
        return new PlanedOutcomeDTO(entity.getSum(), entity.getDate(), entity.getNote(),
                entity.getUserId(), entity.getCategoryId());
    }

    public static PlanedOutcome verifyIfPlanedOutcomeIsPresent(Optional<PlanedOutcome> optionalPlanedOutcome) {
        if (!optionalPlanedOutcome.isPresent()) {
            throw new RuntimeException(ErrorMessage.FAIL_TO_FIND_A_PLANED_OUTCOME.getErrorMessage());
        }
        return optionalPlanedOutcome.get();
    }
}