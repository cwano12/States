package com.wano.statesservice.controller;

import com.wano.statesservice.AbstractStateServiceTest;
import com.wano.statesservice.model.State;
import com.wano.statesservice.service.StateService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(StateController.class)
public class StateControllerTest implements AbstractStateServiceTest {

    @MockBean
    StateService mockStateService;

    @InjectMocks
    StateController testStateController;

    @Override
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        initializeStates();
        initializeMocks();
    }

    @Override
    @After
    public void destroy() {

    }

    @Override
    public void initializeMocks() {
        when(mockStateService.getState(TEST_ID)).thenReturn(state);
    }

    @Test
    public void testGettingASingleState() {
        State foundState = testStateController.getState(TEST_ID);

        assertEquals(state, foundState);
    }
}
