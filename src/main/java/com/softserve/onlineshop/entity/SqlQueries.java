package com.softserve.onlineshop.entity;

public enum SqlQueries {
    INSERT,
    GET_BY_ID,
    GET_BY_USER_ID,
    GET_BY_MODEL_ID,
    GET_BY_PRODUCER_ID,
    GET_BY_FIELD,
    GET_ALL,
    UPDATE_BY_ID,
    UPDATE_BY_FIELD,
    DELETE_BY_ID;

    private SqlQueries() {
    }
}
