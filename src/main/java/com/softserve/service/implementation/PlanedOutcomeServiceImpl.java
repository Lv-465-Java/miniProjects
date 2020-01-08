package com.softserve.service.implementation;

import com.softserve.constant.ErrorMessage;
import com.softserve.dao.implementation.PlanedOutcomeDAOImpl;
import com.softserve.dto.PlanedOutcomeDTO;
import com.softserve.entity.PlanedOutcome;
import com.softserve.exception.NoSuchEntityException;
import com.softserve.exception.NotCompletedActionException;
import com.softserve.service.ReadAllService;
import com.softserve.service.mapper.PlanedOutcomeMapperObjects;

import java.util.ArrayList;
import java.util.List;

public class PlanedOutcomeServiceImpl implements ReadAllService<PlanedOutcomeDTO> {

    private PlanedOutcomeDAOImpl planedOutcomeDAO;

    public PlanedOutcomeServiceImpl() {
        this.planedOutcomeDAO = new PlanedOutcomeDAOImpl();
    }

    @Override
    public boolean create(PlanedOutcomeDTO planedOutcomeDTO) throws NotCompletedActionException {
        PlanedOutcome planedOutcome = new PlanedOutcome(planedOutcomeDTO.getSum(),
                planedOutcomeDTO.getDate(), planedOutcomeDTO.getNote(), planedOutcomeDTO.getUserId(),
                planedOutcomeDTO.getCategoryId());
        if (!planedOutcomeDAO.save(planedOutcome)) {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_SAVE_A_PLANED_OUTCOME.getErrorMessage());
        }
        return true;
    }

    @Override
    public PlanedOutcomeDTO getById(Long id) throws NoSuchEntityException{
        PlanedOutcome planedOutcome = PlanedOutcomeMapperObjects.verifyIfPlanedOutcomeIsPresent
                (planedOutcomeDAO.getById(id));
        return PlanedOutcomeMapperObjects.planedOutcomeEntityToPlanedOutcomeDTO(planedOutcome);
    }

    @Override
    public List<PlanedOutcomeDTO> getAllByUserId(Long id) {
        List<PlanedOutcomeDTO> listDTO = new ArrayList<>();
        List<PlanedOutcome> list = planedOutcomeDAO.getAllByUserId(id);
        for (PlanedOutcome planedOutcome : list) {
            listDTO.add(PlanedOutcomeMapperObjects.planedOutcomeEntityToPlanedOutcomeDTO(planedOutcome));
        }
        return listDTO;
    }

    @Override
    public boolean update(Long id, PlanedOutcomeDTO planedOutcomeDTO) {
        PlanedOutcome planedOutcome = new PlanedOutcome();
        planedOutcome.setSum(planedOutcomeDTO.getSum());
        planedOutcome.setDate(planedOutcomeDTO.getDate());
        planedOutcome.setNote(planedOutcomeDTO.getNote());
        planedOutcome.setCategoryId(planedOutcomeDTO.getCategoryId());
        if (!planedOutcomeDAO.update(id, planedOutcome)) {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_UPDATE_A_PLANED_OUTCOME.getErrorMessage());
        }
        return true;
    }

    @Override
    public boolean delete(Long id) throws NotCompletedActionException {
        if (!planedOutcomeDAO.delete(id)) {
            throw new NotCompletedActionException(ErrorMessage.FAIL_TO_DELETE_A_PLANED_OUTCOME.getErrorMessage());
        }
        return false;
    }
}