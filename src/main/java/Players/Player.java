package Players;

import BlackJack.BlackJack;
import Cards.Card;
import java.util.List;

/**
 *
 * @author David
 */
public class Player {
    
    private final List<Card> bet;

    public Player(List<Card> bet) {
        this.bet = bet;
    }

    public List<Card> getBet() {
        return bet;
    }
    
    public void addCard(Card card){
        bet.add(card);
    }
    
    public boolean isWinner(Player croupier){
        
        int sumBetCrupier = BlackJack.calculateSumBet(croupier.getBet());
        int sumBetPlayer = BlackJack.calculateSumBet(this.bet);
        
        return (sumBetPlayer > sumBetCrupier) && (sumBetPlayer <= 21) || BlackJack.isBlackJack(this.bet);
    }
}
