package controller;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.GameState;
import service.GameLogic;

import java.io.IOException;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameState state = (GameState) session.getAttribute("gameState");

        if (state == null) {
            String playerName = req.getParameter("playerName");
            if (playerName == null || playerName.trim().isEmpty()) {
                playerName = "Игрок";
            }
            state = new GameState(playerName);
            state.setCurrentSituation("start");
            session.setAttribute("gameState", state);
        }

        req.setAttribute("description", GameLogic.getSituationDescription(state.getCurrentSituation()));
        req.setAttribute("choices", GameLogic.getChoices(state.getCurrentSituation()));
        req.setAttribute("gameOver", state.isGameOver());
        req.setAttribute("victory", state.isVictory());
        req.setAttribute("playerName", state.getPlayerName());
        req.setAttribute("gamesPlayed", state.getGamesPlayed());

        req.getRequestDispatcher("/WEB-INF/views/game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        HttpSession session = req.getSession();
        GameState state = (GameState) session.getAttribute("gameState");

        if (state == null) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        if (state.isGameOver()) {
            state.incrementGamesPlayed();
            state.setCurrentSituation("start");
            state.setGameOver(false);
            state.setVictory(false);
        } else {
            String choice = req.getParameter("choice");
            GameLogic.processChoice(state, choice);
        }

        resp.sendRedirect(req.getContextPath() + "/game");
    }
}