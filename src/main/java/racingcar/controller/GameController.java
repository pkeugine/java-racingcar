package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.domain.car.CarRepository;
import racingcar.domain.car.Game;
import racingcar.view.GamePage;

public class GameController {

    private Game game;

    public void startGame(Game game) {
        this.game = game;
        GamePage.printResult();
        while (game.notFinished()) {
            game.incrementCount();
            playSingleRound();
        }
        // 최종 결과 출력
    }

    public void playSingleRound() {
        for (Car car : CarRepository.cars()) {
            car.tryToMoveForward(Game.generateRandomInteger());
        }
        GamePage.printSingleRoundResult();
    }
}