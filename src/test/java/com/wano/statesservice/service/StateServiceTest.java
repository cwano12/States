package com.wano.statesservice.service;

import com.wano.statesservice.AbstractStateServiceTest;
import com.wano.statesservice.model.State;
import com.wano.statesservice.repository.StateRepo;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class StateServiceTest implements AbstractStateServiceTest {

    @Mock
    private StateRepo mockStateRepo;

    @InjectMocks
    private StateService testStateService;


    @Override
    @Before
    public void init() {
        initializeStates();
        initializeMocks();
    }

    @Override
    @After
    public void destroy() {
        states.clear();
    }

    @Override
    public void initializeMocks() {
        when(mockStateRepo.getOne(anyLong())).thenReturn(state);
        when(mockStateRepo.findByName(anyString())).thenReturn(state);
        when(mockStateRepo.findByAbbreviation(anyString())).thenReturn(state);
        when(mockStateRepo.findAll()).thenReturn(states);
        when(mockStateRepo.save(state)).thenReturn(state);
        when(mockStateRepo.save(updatedState)).thenReturn(updatedState);
    }



    @Test
    public void testGettingASingleStateById() {
        State foundState = testStateService.getState(TEST_ID);
        assertNotNull(foundState);
        assertEquals(state, foundState);
    }

    @Test
    public void testGettingAStateByName() {
        State foundState = testStateService.getStateByName(TEST_STATE_NAME);
        assertNotNull(foundState);
        assertEquals(state, foundState);
    }

    @Test
    public void testGettingAStateByAbbreviation() {
        State foundState = testStateService.getStateByAbbreviation(TEST_STATE_ABBREVIATION);
        assertNotNull(foundState);
        assertEquals(state, foundState);
    }

    @Test
    public void testGettingAllStates() {
        List<State> foundStates = testStateService.getAllStates();
        assertNotNull(foundStates);
        assertEquals(10, foundStates.size());
        assertEquals(states, foundStates);
    }

    @Test
    public void testAddingState() {
        State addedState = testStateService.addState(state);
        assertNotNull(addedState);
        assertEquals(TEST_STATE_ABBREVIATION, addedState.getAbbreviation());
        assertEquals(state, addedState);
    }

    @Test
    public void testUpdatingAState() {
        updatedState.setPopulation(UPDATED_POPULATION);
        State addedState = testStateService.updateState(updatedState);
        assertNotNull(addedState);
        assertEquals(UPDATED_POPULATION, addedState.getPopulation());
        assertEquals(updatedState, addedState);
    }

    @Test
    public void testDeletingAStateById() {
        testStateService.deleteState(TEST_ID);
        verify(mockStateRepo, times(1)).deleteById(TEST_ID);
        when(mockStateRepo.findAll()).thenReturn(states.subList(1, states.size()));
        when(mockStateRepo.getOne(TEST_ID)).thenReturn(null);

        List<State> stateList = testStateService.getAllStates();
        State deletedState = testStateService.getState(TEST_ID);

        assertNull(deletedState);
        assertEquals(9, stateList.size());
        assertThat(stateList, not(hasItem(state)));
    }

    @Test
    public void testDeletingAStateByStateObject() {
        testStateService.deleteState(state);
        verify(mockStateRepo, times(1)).delete(state);
        when(mockStateRepo.findAll()).thenReturn(states.subList(1, states.size()));
        when(mockStateRepo.getOne(TEST_ID)).thenReturn(null);

        List<State> stateList = testStateService.getAllStates();
        State deletedState = testStateService.getState(TEST_ID);

        assertNull(deletedState);
        assertEquals(9, stateList.size());
        assertThat(stateList, not(hasItem(state)));
    }
}
