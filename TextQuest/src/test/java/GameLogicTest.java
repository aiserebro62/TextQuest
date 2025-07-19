import model.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.GameLogic;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {
        private GameState state;

        @BeforeEach
        void setUp() {
            state = new GameState("TestPlayer");
        }

        @Test
        void testStartToLeft() {
            state.setCurrentSituation("start");
            GameLogic.processChoice(state, "1");
            assertEquals("left", state.getCurrentSituation());
        }

        @Test
        void testStartToRight() {
            state.setCurrentSituation("start");
            GameLogic.processChoice(state, "2");
            assertEquals("right", state.getCurrentSituation());
        }

        @Test
        void testLeftBear() {
            state.setCurrentSituation("left");
            GameLogic.processChoice(state, "1");
            assertEquals("Bear", state.getCurrentSituation());
        }

        @Test
        void testLeftBack() {
            state.setCurrentSituation("left");
            GameLogic.processChoice(state, "2");
            assertEquals("back", state.getCurrentSituation());
            assertTrue(state.isGameOver());
            assertFalse(state.isVictory());
        }

        @Test
        void testBearVictory() {
            state.setCurrentSituation("Bear");
            GameLogic.processChoice(state, "1");
            assertTrue(state.isGameOver());
            assertTrue(state.isVictory());
        }

        @Test
        void testBearDefeat() {
            state.setCurrentSituation("Bear");
            GameLogic.processChoice(state, "2");
            assertTrue(state.isGameOver());
            assertFalse(state.isVictory());
        }

        @Test
        void testRightSongVictory() {
            state.setCurrentSituation("right");
            GameLogic.processChoice(state, "1");
            assertEquals("song", state.getCurrentSituation());
            assertTrue(state.isGameOver());
            assertTrue(state.isVictory());
        }

        @Test
        void testRightEscapeDefeat() {
            state.setCurrentSituation("right");
            GameLogic.processChoice(state, "2");
            assertEquals("escape", state.getCurrentSituation());
            assertTrue(state.isGameOver());
            assertFalse(state.isVictory());
        }

        @Test
        void testGetSituationDescription() {
            assertEquals("Ты стоишь на развилке дорог. Куда пойдёшь?",
                    GameLogic.getSituationDescription("start"));
            assertEquals("Неизвестная ситуация",
                    GameLogic.getSituationDescription("unknown"));
        }

        @Test
        void testGetChoices() {
            assertEquals(2, GameLogic.getChoices("start").length);
            assertEquals(0, GameLogic.getChoices("victory").length);
        }
    }

