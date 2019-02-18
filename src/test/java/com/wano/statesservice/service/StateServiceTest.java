package com.wano.statesservice.service;

import com.wano.statesservice.AbstractStateServiceTest;
import com.wano.statesservice.model.State;
import com.wano.statesservice.repository.StateRepo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

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
        when(mockStateRepo.getOne(anyLong())).thenReturn(DELAWARE);
        when(mockStateRepo.findByName(anyString())).thenReturn(DELAWARE);
        when(mockStateRepo.findByAbbreviation(anyString())).thenReturn(DELAWARE);
        when(mockStateRepo.findAll()).thenReturn(states);
        when(mockStateRepo.save(DELAWARE)).thenReturn(DELAWARE);
        when(mockStateRepo.save(updatedState)).thenReturn(updatedState);
    }

    @Test
    public void gettingASingleState_withTestId_shouldReturn_Delaware() {
        State foundState = testStateService.getState(TEST_ID);
        assertEquals(DELAWARE, foundState);
    }

    @Test
    public void gettingAStateByName_withTestName_shouldReturn_Delaware() {
        State foundState = testStateService.getStateByName(TEST_STATE_NAME);
        assertEquals(DELAWARE, foundState);
    }

    @Test
    public void gettingAStateByAbbreviation_withTestAbbreviation_shouldReturn_Delaware() {
        State foundState = testStateService.getStateByAbbreviation(TEST_STATE_ABBREVIATION);
        assertEquals(DELAWARE, foundState);
    }

    @Test
    public void gettingAllStates_shouldReturn_aListOfSizeTen() {
        List<State> foundStates = testStateService.getAllStates();
        assertEquals(10, foundStates.size());
    }

    @Test
    public void gettingAllStates_shouldReturn_states() {
        List<State> foundStates = testStateService.getAllStates();
        assertEquals(states, foundStates);
    }

    @Test
    public void addingState_ofDelaware_shouldReturn_Delaware() {
        State addedState = testStateService.addState(DELAWARE);
        assertEquals(DELAWARE, addedState);
    }

    @Test
    public void gettingAbbreviation_fromAddedStateOfDelaware_shouldReturn_testAbbreviation() {
        State addedState = testStateService.addState(DELAWARE);
        assertEquals(TEST_STATE_ABBREVIATION, addedState.getAbbreviation());
    }

    @Test
    public void updatingPopulation_shouldReturn_updatedState() {
        updatedState.setPopulation(UPDATED_POPULATION);
        State addedState = testStateService.updateState(updatedState);
        assertEquals(updatedState, addedState);
    }

    @Test
    public void gettingPopulation_whenUpdatingStatePopulation_shouldReturn_updatedPopulation() {
        updatedState.setPopulation(UPDATED_POPULATION);
        State addedState = testStateService.updateState(updatedState);
        assertEquals(UPDATED_POPULATION, addedState.getPopulation());
    }

    @Test
    public void stateRepo_deleteById_shouldBeCalled_whenDeletingAStateById() {
        testStateService.deleteState(TEST_ID);
        verify(mockStateRepo, times(1)).deleteById(TEST_ID);
    }

    @Test
    public void gettingAllStates_afterDeletingAStateById_shouldReturn_aListOfSizeNine() {
        testStateService.deleteState(TEST_ID);
        when(mockStateRepo.findAll()).thenReturn(states.subList(1, states.size()));

        List<State> stateList = testStateService.getAllStates();
        assertEquals(9, stateList.size());
    }

    @Test
    public void gettingAStateById_withTestID_shouldReturnNull_afterDeletingAStateByTestId(){
        testStateService.deleteState(TEST_ID);
        when(mockStateRepo.getOne(TEST_ID)).thenReturn(null);

        State deletedState = testStateService.getState(TEST_ID);
        assertNull(deletedState);
    }

    @Test
    public void gettingAllStates_afterDeletingAState_byTestID_shouldReturn_aListWithoutDelaware() {
        testStateService.deleteState(TEST_ID);
        when(mockStateRepo.findAll()).thenReturn(states.subList(1, states.size()));

        List<State> stateList = testStateService.getAllStates();
        assertThat(stateList, not(hasItem(DELAWARE)));
    }

    @Test
    public void stateRepo_delete_shouldBeCalled_whenDeletingAStateByStateObject() {
        testStateService.deleteState(DELAWARE);
        verify(mockStateRepo, times(1)).delete(DELAWARE);
    }

    @Test
    public void gettingAllStates_afterDeletingAStateByStateObject_shouldReturn_aListOfSizeNine() {
        testStateService.deleteState(DELAWARE);
        when(mockStateRepo.findAll()).thenReturn(states.subList(1, states.size()));

        List<State> stateList = testStateService.getAllStates();
        assertEquals(9, stateList.size());
    }

    @Test
    public void gettingAStateById_withTestID_shouldReturnNull_afterDeleting_stateOfDelaware(){
        testStateService.deleteState(DELAWARE);
        when(mockStateRepo.getOne(TEST_ID)).thenReturn(null);

        State deletedState = testStateService.getState(TEST_ID);
        assertNull(deletedState);
    }

    @Test
    public void gettingAllStates_afterDeleting_stateOfDelaware_shouldReturn_aListWithoutDelaware() {
        testStateService.deleteState(TEST_ID);
        when(mockStateRepo.findAll()).thenReturn(states.subList(1, states.size()));

        List<State> stateList = testStateService.getAllStates();
        assertThat(stateList, not(hasItem(DELAWARE)));
    }
}
