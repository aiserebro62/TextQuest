package service;


import model.GameState;

public class GameLogic {
    public static void processChoice(GameState state, String choice) {
        switch (state.getCurrentSituation()) {
            case "start":
                if ("1".equals(choice)) {
                    state.setCurrentSituation("left");
                } else if ("2".equals(choice)) {
                    state.setCurrentSituation("right");
                }
                break;
            case "left":
                if ("1".equals(choice)) {
                    state.setCurrentSituation("Bear");
                } else if ("2".equals(choice)) {
                    state.setCurrentSituation("back");
                    state.setGameOver(true);
                    state.setVictory(false);
                }
                break;
            case "right":
                if ("1".equals(choice)) {
                    state.setCurrentSituation("Wolf");

                } else if ("2".equals(choice)) {
                    state.setCurrentSituation("escape");
                    state.setGameOver(true);
                    state.setVictory(false);
                }
                break;
            case "Bear", "Wolf":
                if ("1".equals(choice)) {
                    state.setCurrentSituation("victory");
                    state.setGameOver(true);
                    state.setVictory(true);
                } else if ("2".equals(choice)) {
                    state.setCurrentSituation("defeat");
                    state.setGameOver(true);
                    state.setVictory(false);
                }
                break;

            case "song":
                state.setCurrentSituation("victory");
                state.setGameOver(true);
                state.setVictory(true);
                break;
        }
    }

    public static String getSituationDescription(String situation) {
        return switch (situation) {
            case "start" -> "Ты стоишь на развилке дорог. Куда пойдёшь?";
            case "left" -> " Впереди медведь! Что будешь делать?";
            case "right" -> "Впереди волк! Твои действия?";
            case "Bear" -> "Медведь хочет тебя съесть.";
            case "back" -> "Ты возвращаешься назад, но медведь догнал тебя и съел.Поражение.";
            case "Wolf" -> "Волк хочет тебя съесть.";
            case "escape" -> "Ты бежишь от волка, но волк догнал тебя и съел.Поражение.";
            case "victory" -> "Поздравляем! Ты победил!";
            case "defeat" -> "К сожалению, ты проиграл.";
            default -> "Неизвестная ситуация";
        };
    }

    public static String[] getChoices(String situation) {
        return switch (situation) {
            case "start" -> new String[]{"1. Пойти налево", "2. Пойти направо"};
            case "left" -> new String[]{"1. Встретиться с медведем", "2. Вернуться домой"};
            case "right" -> new String[]{"1. Встретиться с волком", "2. Вернуться домой"};
            case "Bear", "Wolf" -> new String[]{"1. Спеть песенку", "2. Попытаться убежать"};
            default -> new String[]{};
        };
    }
}


