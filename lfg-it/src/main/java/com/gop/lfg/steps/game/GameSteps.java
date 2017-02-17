package com.gop.lfg.steps.game;

import com.gop.lfg.game.Game;
import com.gop.lfg.game.GameDTO;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by GhostOfPQ on 04/02/2017.
 */
@Slf4j
public class GameSteps {

    private TestRestTemplate restTemplate = new TestRestTemplate();
    private ResponseEntity currentResponse = null;

    private String baseUrl = "http://localhost:8080";

    @Given("^there is no game")
    public void delete_all_existing_games() {
        currentResponse = restTemplate.getForEntity(
                baseUrl + "/games",
                List.class
        );
        Assert.assertEquals(200, currentResponse.getStatusCode().value());

        List<GameDTO> existingGames = (List<GameDTO>) currentResponse.getBody();
        existingGames.forEach(gameDTO -> delete_game_by_id(gameDTO.getId()));
    }

    @Given("the following games exist")
    public void all_these_games_exists(DataTable games) {
        games.getGherkinRows().stream().map(DataTableRow::getCells).forEach(this::this_game_exists);
    }

    @Given("^the following game exists$")
    public void this_game_exists(List<String> game) {
        create_game(game);
        Assert.assertEquals(201, currentResponse.getStatusCode().value());
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

    @When("^I search for a game named \"(.*)\"")
    public void get_game_by_name(String gameName) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", gameName);

        currentResponse =
                restTemplate.getForEntity(
                        baseUrl + "/games",
                        Game.class,
                        params
                );
    }

    public void delete_game_by_id(String id) {
        restTemplate.delete(baseUrl + "/games/" + id);
    }

    @Then("^the response has status code (\\d+)$")
    public void check_statusCode(long statusCode) {
        Assert.assertNotNull(currentResponse);
        Assert.assertEquals(statusCode, currentResponse.getStatusCode().value());
    }


}
