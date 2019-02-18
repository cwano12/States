package com.wano.statesservice.controller;

import com.wano.statesservice.AbstractStateServiceTest;
import com.wano.statesservice.model.State;
import com.wano.statesservice.service.StateService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(StateController.class)
public class StateControllerTest implements AbstractStateServiceTest {

    @MockBean
    private StateService mockStateService;

    @InjectMocks
    private StateController testStateController;

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
        when(mockStateService.getState(TEST_ID)).thenReturn(DELAWARE);
        when(mockStateService.getStateByName(anyString())).thenReturn(DELAWARE);
        when(mockStateService.getStateByAbbreviation(anyString())).thenReturn(DELAWARE);
        when(mockStateService.getAllStates()).thenReturn(states);
    }

    @Test
    public void testGettingASingleState() {
        State foundState = testStateController.getState(TEST_ID);

        assertEquals(DELAWARE, foundState);
    }

    @Test
    public void testGettingStateByName() {
        State foundState = testStateController.getStateByName(TEST_STATE_NAME);

        assertEquals(DELAWARE, foundState);
    }

    @Test
    public void testGettingStateByAbbreviation() {
        State foundState = testStateController.getStateByAbbreviation(TEST_STATE_ABBREVIATION);

        assertEquals(DELAWARE, foundState);
    }
    @Test
    public void testGettingAllStates() {
        List<State> foundStates = testStateController.getAllStates();

        assertEquals(states, foundStates);
    }
}
