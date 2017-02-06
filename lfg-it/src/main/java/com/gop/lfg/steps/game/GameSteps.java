package com.gop.lfg.steps.game;

import com.gop.lfg.game.Game;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by GhostOfPQ on 04/02/2017.
 */
@Slf4j
public class GameSteps {

    private TestRestTemplate restTemplate = new TestRestTemplate();
    private ResponseEntity currentResponse = null;

    private String baseUrl = "http://localhost:8080";

    @Given("the following games exist")
    public void all_these_games_exists(DataTable games) {
        games.getGherkinRows().stream().map(DataTableRow::getCells).forEach(this::this_game_exists);
    }

    @Given("^the following game exists$")
    public void this_game_exists(List<String> game) {
        log.debug(game.toString());
    }

    @When("^the following game is created")
    public void create_game(List<String> game) {
        currentResponse = restTemplate.postForEntity(baseUrl + "/games",
                Game.builder()
                        .name(game.get(0))
                        .description(game.get(1))
                        .minPlayers(Integer.valueOf(game.get(2)))
                        .maxPlayers(Integer.valueOf(game.get(3)))
                        .build(),
                Game.class);
    }

    @Then("^the response has status code (\\d+)$")
    public void check_statusCode(long statusCode) {
        Assert.assertNotNull(currentResponse);
        Assert.assertEquals(statusCode, currentResponse.getStatusCode().value());
    }
}
