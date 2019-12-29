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
    public Long save(PlanedOutcome planedOutcome) {
        return null;
    }

    @Override
    public Optional<PlanedOutcome> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(PlanedOutcome object, Long id) {

    }

    @Override
    public void delete(Long id) {

    }
}