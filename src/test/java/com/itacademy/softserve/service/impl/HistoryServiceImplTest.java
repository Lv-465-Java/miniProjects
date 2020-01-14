package com.itacademy.softserve.service.impl;

import com.itacademy.softserve.dao.HistoryDao;
import com.itacademy.softserve.service.HistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.MockitoAnnotations.initMocks;


class HistoryServiceImplTest {
    @Mock
    private HistoryDao historyMock;

    @InjectMocks
    private HistoryService service = new HistoryServiceImpl();

    @BeforeEach
    void init() {
        initMocks(this);
    }

    @Test
    void getHistorySet() throws Exception {
    }

    @Test
    void getNumberOfPages() {
    }

    @Test
    void clear() {
    }

    @Test
    void addRecord() {
    }
}