package com.softserve.service.mapper;

import com.softserve.constant.ErrorMessage;
import com.softserve.dto.PlanedOutcomeDTO;
import com.softserve.entity.PlanedOutcome;
import com.softserve.exception.NoSuchEntityException;

import java.util.Optional;

public class PlanedOutcomeMapperObjects {

    public static PlanedOutcomeDTO planedOutcomeEntityToPlanedOutcomeDTO(PlanedOutcome entity) {
        return PlanedOutcomeDTO.Builder.aPlanedOutcomeDTO()
                .withId(entity.getId())
                .withSum(entity.getSum())
                .withDate(entity.getDate())
                .withNote(entity.getNote())
                .withUserId(entity.getUserId())
                .withCategoryId(entity.getCategoryId())
                .build();
    }

    public static PlanedOutcome verifyIfPlanedOutcomeIsPresent(Optional<PlanedOutcome> optionalPlanedOutcome)
            throws NoSuchEntityException {
        if (!optionalPlanedOutcome.isPresent()) {
            throw new NoSuchEntityException(ErrorMessage.FAIL_TO_FIND_A_PLANED_OUTCOME.getErrorMessage());
        }
        return optionalPlanedOutcome.get();
    }
}