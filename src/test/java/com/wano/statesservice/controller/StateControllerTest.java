package com.wano.statesservice.controller;

import com.wano.statesservice.AbstractStateServiceTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(StateController.class)
public class StateControllerTest implements AbstractStateServiceTest {

}
