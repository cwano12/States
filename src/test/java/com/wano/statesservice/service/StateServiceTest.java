package com.wano.statesservice.service;

import com.wano.statesservice.repository.StateRepo;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;

import static junit.framework.TestCase.fail;

public class StateServiceTest {

    @Mock
    StateRepo mockStateRepo;

    @InjectMocks
    StateService testStateService;

    @Test
    public void testGettingASingleStateById() {
        fail();
    }
}
