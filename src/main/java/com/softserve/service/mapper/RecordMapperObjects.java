package com.softserve.service.mapper;

import com.softserve.constant.ErrorMessage;
import com.softserve.dto.RecordDTO;
import com.softserve.entity.Record;
import com.softserve.exception.NoSuchEntityException;

import java.util.Optional;

public class RecordMapperObjects {

    public static RecordDTO recordEntityToRecordDTO(Record entity) {
        return new RecordDTO(entity.getId(), entity.getSum(), entity.getDate(),
                entity.getNote(), entity.getFinancialTypeId(), entity.getUserId(),
                entity.getCategoryId(), entity.getPlanedOutcomeId());
    }

    public static Record verifyIfRecordIsPresent(Optional<Record> optionalRecord) throws NoSuchEntityException{
        if (!optionalRecord.isPresent()) {
            throw new NoSuchEntityException(ErrorMessage.FAIL_TO_FIND_A_RECORD.getErrorMessage());
        }
        return optionalRecord.get();
    }
}