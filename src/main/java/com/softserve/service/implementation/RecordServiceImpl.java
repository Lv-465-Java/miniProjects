package com.softserve.service.implementation;

import com.softserve.constant.ErrorMessage;
import com.softserve.dao.implementation.PlanedOutcomeDAOImpl;
import com.softserve.dao.implementation.RecordDAOImpl;
import com.softserve.dto.RecordDTO;
import com.softserve.entity.FinancialType;
import com.softserve.entity.PlanedOutcome;
import com.softserve.entity.Record;
import com.softserve.exception.NoSuchEntityException;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.ReadAllService;
import com.softserve.service.mapper.PlanedOutcomeMapperObjects;
import com.softserve.service.mapper.RecordMapperObjects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class RecordServiceImpl implements ReadAllService<RecordDTO> {

    private RecordDAOImpl recordDAO;
    private PlanedOutcomeDAOImpl planedOutcomeDAO;
    private Logger LOG = LoggerFactory.getLogger(RecordServiceImpl.class);

    public RecordServiceImpl() {
        this.recordDAO = new RecordDAOImpl();
        this.planedOutcomeDAO = new PlanedOutcomeDAOImpl();
    }

    @Override
    public boolean create(RecordDTO recordDTO) throws NotCompletedActionException {
        if (recordDTO.getPlanedOutcomeId() != null) {
            checkIfPlanedOutcomeMatchesFinancialType(recordDTO.getFinancialTypeId());
            checkIfPlanedOutcomeMatchesCategory(recordDTO.getCategoryId(), recordDTO.getPlanedOutcomeId());
            reducePlannedOutcomeSum(recordDTO.getPlanedOutcomeId(), recordDTO.getSum());
        }
        Record record = new Record(recordDTO.getSum(), recordDTO.getDate(), recordDTO.getNote(),
                recordDTO.getFinancialTypeId(), recordDTO.getUserId(), recordDTO.getCategoryId(),
                recordDTO.getPlanedOutcomeId());
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
        if (recordDTO.getPlanedOutcomeId() != null) {
            checkIfPlanedOutcomeMatchesFinancialType(recordDTO.getFinancialTypeId());
            checkIfPlanedOutcomeMatchesCategory(recordDTO.getCategoryId(), recordDTO.getPlanedOutcomeId());
            reducePlannedOutcomeSum(recordDTO.getPlanedOutcomeId(), recordDTO.getSum());
        }
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
    public boolean delete(Long recordId) throws NotCompletedActionException {
        checkIfRecordHasPlannedOutcome(recordId);
        if (!recordDAO.delete(recordId)) {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_DELETE_A_RECORD.getErrorMessage());
        }
        return true;
    }

    private void checkIfRecordHasPlannedOutcome(Long recordId) {
        Record record = RecordMapperObjects.verifyIfRecordIsPresent(recordDAO.getById(recordId));
        if (record.getPlanedOutcomeId() != null) {
            increasePlannedOutcomeSum(record.getPlanedOutcomeId(), record.getSum());
        }
    }

    private void increasePlannedOutcomeSum(Long plannedOutcomeId, Double sum) {
        PlanedOutcome planedOutcome = PlanedOutcomeMapperObjects.
                verifyIfPlanedOutcomeIsPresent(planedOutcomeDAO.getById(plannedOutcomeId));
        planedOutcome.setSum(planedOutcome.getSum() + sum);
        planedOutcomeDAO.update(plannedOutcomeId, planedOutcome);
    }

    public List<FinancialType> getTypes() {
        return Arrays.asList(FinancialType.values());
    }

    private void checkIfPlanedOutcomeMatchesFinancialType(Long financialTypeId) throws NotCompletedActionException {
        if (!financialTypeId.equals(FinancialType.OUTCOME.getId())) {
            throw new NotCompletedActionException(ErrorMessage.FINANCIAL_TYPE_DO_NOT_MATCH.getErrorMessage());
        }
    }

    private void checkIfPlanedOutcomeMatchesCategory(Long categoryId, Long planedOutcomeId) throws NotCompletedActionException {
        Optional<PlanedOutcome> planedOutcome = planedOutcomeDAO.getById(planedOutcomeId);
        if (planedOutcome.isPresent()) {
            if (!planedOutcome.get().getCategoryId().equals(categoryId)) {
                throw new NotCompletedActionException(ErrorMessage.CATEGORY_ID_DO_NOT_MATCH.getErrorMessage());
            }
        }
    }

    private void reducePlannedOutcomeSum(Long plannedOutcomeId, Double sum) {
        PlanedOutcome planedOutcome = PlanedOutcomeMapperObjects.
                verifyIfPlanedOutcomeIsPresent(planedOutcomeDAO.getById(plannedOutcomeId));
        double plannedOutcomeSumRemaining = planedOutcome.getSum() - sum;
        if (plannedOutcomeSumRemaining < 0) {
            throw new NotCompletedActionException(ErrorMessage.PLANNED_OUTCOME_SUM_DO_NOT_MATCH.getErrorMessage());
        }
        planedOutcome.setSum(planedOutcome.getSum() - sum);
        planedOutcomeDAO.update(plannedOutcomeId, planedOutcome);
    }


    //TO DO!
    public List<RecordDTO> filter(Long userId, List<Object> parameters) {
        List<RecordDTO> dtoList = new ArrayList<>();
        List<Record> list = recordDAO.getAllBySelectedFilters(userId, parameters);
        for (Record record : list) {
            dtoList.add(RecordMapperObjects.recordEntityToRecordDTO(record));
        }
        return dtoList;
    }
}