package com.gop.lfg;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Created by GhostOfPQ on 04/02/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com.gop.lfg.steps")
public class GameTests {
}
