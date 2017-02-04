package com.gop.lfg.steps.game;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import gherkin.formatter.model.DataTableRow;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by GhostOfPQ on 04/02/2017.
 */
@Slf4j
public class GameSteps {
    @Given("The following games exist: (.*)")
    public void all_these_games_exists(DataTable games) {
        games.getGherkinRows().forEach(this::this_game_exists);
    }

    @Given("^The following game exists$")
    public void this_game_exists(DataTableRow game) {
        log.debug(game.toString());
    }
}
