package com.gop.lfg.steps.game;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import gherkin.formatter.model.DataTableRow;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Created by GhostOfPQ on 04/02/2017.
 */
@Slf4j
public class GameSteps {
    @Given("the following games exist")
    public void all_these_games_exists(DataTable games) {
        games.getGherkinRows().stream().map(DataTableRow::getCells).forEach(this::this_game_exists);
    }

    @Given("^the following game exists$")
    public void this_game_exists(List<String> game) {
        log.debug(game.toString());
    }

}
