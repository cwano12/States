package com.wano.statesservice.service;

import com.wano.statesservice.model.State;
import com.wano.statesservice.repository.StateRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StateServiceTest {

    @Mock
    private StateRepo mockStateRepo;

    @InjectMocks
    private StateService testStateService;
    private final long testId = 1;
    private State state;
    private List<State> states;

    @Before
    public void init() {
        initializeStates();
        initializeMocks();
    }

    private void initializeMocks() {
        when(mockStateRepo.getOne(testId)).thenReturn(state);
    }

    private void initializeStates() {
        state = new State(testId, "Delaware", "DE", "December 7, 1787", "Dover",
                "952,065", 1982);
        
    }

    @Test
    public void testGettingASingleStateById() {
        State foundState = testStateService.getState(testId);
        assertNotNull(foundState);
        assertEquals(state, foundState);
    }

    @Test
    public void testGettingAllStates() {
        List<State> foundStates = testStateService.getAllStates();
    }
}
