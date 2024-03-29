package Tests;

import Cards.Ace;
import Cards.Card;
import Cards.Jack;
import Cards.King;
import Cards.PipCard;
import Players.Player;
import BlackJack.BlackJack;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author David
 */

   
public class GameTest{
    
    @Test
    public void test_caso_1() throws PipCard.BadValueException{
        
        // Player1 cards
        List<Card> bet_Player1 = new ArrayList<>();
        bet_Player1.add(new Jack());
        bet_Player1.add(new Ace());
        
        // Player2 cards
        List<Card> bet_Player2 = new ArrayList<>();
        bet_Player2.add(new PipCard(10));
        bet_Player2.add(new PipCard(5));
        bet_Player2.add(new PipCard(6));
        
        // Player3 cards
        List<Card> bet_Player3 = new ArrayList<>();
        bet_Player3.add(new PipCard(3));
        bet_Player3.add(new PipCard(6));
        bet_Player3.add(new Ace());
        bet_Player3.add(new PipCard(3));
        bet_Player3.add(new Ace());
        bet_Player3.add(new King());
        
        // Croupier cards
        List<Card> bet_Croupier = new ArrayList<>();
        bet_Croupier.add(new PipCard(9));
        bet_Croupier.add(new PipCard(7));
        
        //Players creation
        Player player1 = new Player(bet_Player1);
        Player player2 = new Player(bet_Player2);
        Player player3 = new Player(bet_Player3);
        Player croupier = new Player(bet_Croupier);
        
        // Deck as ArrayList
        List<Card> deck = new ArrayList<>();
        deck.add(new PipCard(5));
        deck.add(new PipCard(4));
        deck.add(new King());
        deck.add(new PipCard(2));
        
        // Ganadores reales
        List<Player> winners = new ArrayList<>();
        winners.add(player1);
        
        // Ganadores que devuelve el programa
        List<Player> test_winners = BlackJack.getWinners(player1, player2,
                player3, croupier, deck);
        
        assertEquals(winners, test_winners);
        
    }
    
    @Test
    public void test_caso_2() throws PipCard.BadValueException{
        
        List<Card> bet_Player1 = new ArrayList<>();
        bet_Player1.add(new PipCard(10));
        bet_Player1.add(new King());
        
        List<Card> bet_Player2 = new ArrayList<>();
        bet_Player2.add(new PipCard(10));
        bet_Player2.add(new PipCard(2));
        bet_Player2.add(new PipCard(6));
        
        List<Card> bet_Player3 = new ArrayList<>();
        bet_Player3.add(new PipCard(8));
        bet_Player3.add(new PipCard(8));
        bet_Player3.add(new PipCard(5));
        
        List<Card> bet_Croupier = new ArrayList<>();
        bet_Croupier.add(new PipCard(5));
        bet_Croupier.add(new PipCard(10));
        
        Player player1 = new Player(bet_Player1);
        Player player2 = new Player(bet_Player2);
        Player player3 = new Player(bet_Player3);
        Player croupier = new Player(bet_Croupier);
        
        List<Card> deck = new ArrayList<>();
        deck.add(new Ace());
        deck.add(new PipCard(3));
        deck.add(new King());
        deck.add(new PipCard(2));
        
        List<Player> winners = new ArrayList<>();
        winners.add(player1);
        winners.add(player3);
        
        List<Player> test_winners = BlackJack.getWinners(player1, player2,
                player3, croupier, deck);
        
        assertEquals(winners, test_winners);
        
    }
    
    @Test
    public void test_croupier_wins() throws PipCard.BadValueException{
        
        List<Card> bet_Player1 = new ArrayList<>();
        bet_Player1.add(new PipCard(10));
        bet_Player1.add(new PipCard(6));
        
        List<Card> bet_Player2 = new ArrayList<>();
        bet_Player2.add(new PipCard(10));
        bet_Player2.add(new PipCard(2));
        bet_Player2.add(new PipCard(6));
        
        List<Card> bet_Player3 = new ArrayList<>();
        bet_Player3.add(new PipCard(8));
        bet_Player3.add(new PipCard(8));
        bet_Player3.add(new PipCard(3));
        
        List<Card> bet_Croupier = new ArrayList<>();
        bet_Croupier.add(new PipCard(5));
        bet_Croupier.add(new PipCard(10));
        
        Player player1 = new Player(bet_Player1);
        Player player2 = new Player(bet_Player2);
        Player player3 = new Player(bet_Player3);
        Player croupier = new Player(bet_Croupier);
        
        List<Card> deck = new ArrayList<>();
        deck.add(new PipCard(5));
        deck.add(new PipCard(2));
        deck.add(new King());

        // Lista vacía, ya que gana el Croupier
        List<Player> winners = new ArrayList<>();
        
        List<Player> test_winners = BlackJack.getWinners(player1, player2,
                player3, croupier, deck);
        
        assertEquals(winners, test_winners);
        
    }
    
    @Test
    public void test_all_bets_are_17() throws PipCard.BadValueException{
        
        List<Card> bet_Player1 = new ArrayList<>();
        bet_Player1.add(new PipCard(10));
        bet_Player1.add(new PipCard(7));
        
        List<Card> bet_Player2 = new ArrayList<>();
        bet_Player2.add(new PipCard(10));
        bet_Player2.add(new PipCard(7));
        
        List<Card> bet_Player3 = new ArrayList<>();
        bet_Player3.add(new PipCard(8));
        bet_Player3.add(new PipCard(5));
        bet_Player3.add(new PipCard(4));
        
        List<Card> bet_Croupier = new ArrayList<>();
        bet_Croupier.add(new PipCard(7));
        bet_Croupier.add(new PipCard(10));
        
        Player player1 = new Player(bet_Player1);
        Player player2 = new Player(bet_Player2);
        Player player3 = new Player(bet_Player3);
        Player croupier = new Player(bet_Croupier);
        
        List<Card> deck = new ArrayList<>();
        deck.add(new PipCard(10));
        deck.add(new PipCard(2));
        deck.add(new King());

        // Lista vacía, ya que gana el Croupier
        List<Player> winners = new ArrayList<>();
        
        List<Player> test_winners = BlackJack.getWinners(player1, player2,
                player3, croupier, deck);
        
        assertEquals(winners, test_winners);
    }
    
    @Test
    public void test_croupier_more_than_21() throws PipCard.BadValueException{
        
        List<Card> bet_Player1 = new ArrayList<>();
        bet_Player1.add(new PipCard(10));
        bet_Player1.add(new PipCard(7));
        
        List<Card> bet_Player2 = new ArrayList<>();
        bet_Player2.add(new PipCard(10));
        bet_Player2.add(new PipCard(7));
        
        List<Card> bet_Player3 = new ArrayList<>();
        bet_Player3.add(new PipCard(8));
        bet_Player3.add(new PipCard(6));
        bet_Player3.add(new PipCard(8));
        
        List<Card> bet_Croupier = new ArrayList<>();
        bet_Croupier.add(new Jack());
        bet_Croupier.add(new PipCard(6));
        
        Player player1 = new Player(bet_Player1);
        Player player2 = new Player(bet_Player2);
        Player player3 = new Player(bet_Player3);
        Player croupier = new Player(bet_Croupier);
        
        List<Card> deck = new ArrayList<>();
        deck.add(new PipCard(10));
        deck.add(new PipCard(2));
        deck.add(new King());

        // Lista vacía, ya que gana el Croupier
        List<Player> winners = new ArrayList<>();
        winners.add(player1);
        winners.add(player2);
        
        List<Player> test_winners = BlackJack.getWinners(player1, player2,
                player3, croupier, deck);
        
        assertEquals(winners, test_winners);
    }
    
    @Test
    public void test_croupier_wins_with_blackjack() throws PipCard.BadValueException{
        
        List<Card> bet_Player1 = new ArrayList<>();
        bet_Player1.add(new PipCard(10));
        bet_Player1.add(new PipCard(7));
        
        List<Card> bet_Player2 = new ArrayList<>();
        bet_Player2.add(new PipCard(10));
        bet_Player2.add(new PipCard(7));
        
        List<Card> bet_Player3 = new ArrayList<>();
        bet_Player3.add(new PipCard(8));
        bet_Player3.add(new PipCard(5));
        bet_Player3.add(new PipCard(4));
        
        List<Card> bet_Croupier = new ArrayList<>();
        bet_Croupier.add(new Jack());
        bet_Croupier.add(new Ace());
        
        Player player1 = new Player(bet_Player1);
        Player player2 = new Player(bet_Player2);
        Player player3 = new Player(bet_Player3);
        Player croupier = new Player(bet_Croupier);
        
        List<Card> deck = new ArrayList<>();
        deck.add(new PipCard(10));
        deck.add(new PipCard(2));
        deck.add(new King());

        // Lista vacía, ya que gana el Croupier
        List<Player> winners = new ArrayList<>();
        
        List<Player> test_winners = BlackJack.getWinners(player1, player2,
                player3, croupier, deck);
        
        assertEquals(winners, test_winners);
    }
    
    
}