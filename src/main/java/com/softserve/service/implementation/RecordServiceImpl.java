package com.softserve.service.implementation;

import com.softserve.constant.ErrorMessage;
import com.softserve.dao.implementation.RecordDAOImpl;
import com.softserve.dto.RecordDTO;
import com.softserve.entity.FinancialType;
import com.softserve.entity.Record;
import com.softserve.exception.NoSuchEntityException;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.ReadAllService;
import com.softserve.service.mapper.RecordMapperObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecordServiceImpl implements ReadAllService<RecordDTO> {

    private RecordDAOImpl recordDAO;

    public RecordServiceImpl() {
        this.recordDAO = new RecordDAOImpl();
    }

    @Override
    public boolean create(RecordDTO recordDTO) throws NotCompletedActionException {
        Record record = new Record(recordDTO.getSum(), recordDTO.getDate(), recordDTO.getNote(),
                recordDTO.getFinancialTypeId(), recordDTO.getUserId(), recordDTO.getCategoryId(), recordDTO.getPlanedOutcomeId());
        if (!recordDAO.save(record)) {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_SAVE_A_RECORD.getErrorMessage());
        }
        return true;
    }

    @Override
    public RecordDTO getById(Long id) throws NoSuchEntityException {
        Record record = RecordMapperObjects.verifyIfRecordIsPresent(recordDAO.getById(id));
        return RecordMapperObjects.recordEntityToRecordDTO(record);
    }

    public List<RecordDTO> getAllByUserId(Long id) {
        List<RecordDTO> recordDTOList = new ArrayList<>();
        List<Record> recordList = recordDAO.getAllByUserId(id);
        for (Record record : recordList) {
            recordDTOList.add(RecordMapperObjects.recordEntityToRecordDTO(record));
        }
        return recordDTOList;
    }

    @Override
    public boolean update(Long id, RecordDTO recordDTO)
            throws NoSuchEntityException, NotCompletedActionException {
        Record record = RecordMapperObjects.verifyIfRecordIsPresent(recordDAO.getById(id));
        record.setSum(recordDTO.getSum());
        record.setDate(recordDTO.getDate());
        record.setNote(recordDTO.getNote());
        record.setFinancialTypeId(recordDTO.getFinancialTypeId());
        record.setCategoryId(recordDTO.getCategoryId());
        record.setPlanedOutcomeId(recordDTO.getPlanedOutcomeId());
        if (!recordDAO.update(id, record)) {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_UPDATE_A_RECORD.getErrorMessage());
        }
        return true;
    }

    @Override
    public boolean delete(Long id) throws NotCompletedActionException {
        if (!recordDAO.delete(id)) {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_DELETE_A_RECORD.getErrorMessage());
        }
        return true;
    }

    public List<FinancialType> getTypes() {
        return Arrays.asList(FinancialType.values());
    }
    // filter method
}