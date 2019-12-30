package com.softserve.dao.implementation;

import com.softserve.dao.SearchDAO;
import com.softserve.entity.PlanedOutcome;

import java.util.List;
import java.util.Optional;

public class PlanedOutcomeDAOImpl implements SearchDAO<PlanedOutcome> {
    @Override
    public List<PlanedOutcome> getAllByUserId(Long id) {
        return null;
    }

    @Override
    public int save(PlanedOutcome planedOutcome) {
        return 8;
    }

    @Override
    public Optional<PlanedOutcome> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public int update(Long id, PlanedOutcome object) {
        return 9;
    }

    @Override
    public int delete(Long id) {
        return 9;
    }
}