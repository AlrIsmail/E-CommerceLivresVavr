import org.example.Client;
import org.example.Livre;
import org.example.Panier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PanierTest {
    private Livre livre1;
    private Livre livre2;
    private Livre livre3;
    private Panier panier;
    private Client client;

    @BeforeEach
    public void setUp() {
        livre1 = new Livre("Le Seigneur des Anneaux", 15.99, "J.R.R. Tolkien", 10);
        livre2 = new Livre("Harry Potter", 12.50, "J.K. Rowling", 20);
        livre3 = new Livre("1984", 9.99, "George Orwell", 15);
        client = new Client("John Doe", 0.1);
        panier = new Panier(client);
    }

    @Test
    public void testAjouterLivre() {
        panier.ajouterLivre(livre1, 2);
        panier.ajouterLivre(livre2, 1);
        assertEquals(2, panier.getQuantite(livre1));
        assertEquals(1, panier.getQuantite(livre2));
    }

    @Test
    public void testRetirerLivre() {
        panier.ajouterLivre(livre1, 2);
        panier.retirerLivre(livre1, 1);
        assertEquals(1, panier.getQuantite(livre1));
    }

    @Test
    public void testCalculerPrixTotal() {
        panier.ajouterLivre(livre1, 2);
        panier.ajouterLivre(livre2, 1);
        panier.ajouterLivre(livre3, 3);
        assertEquals(15.99 * 2 + 12.50 + 9.99 * 3, panier.calculerPrixTotal());
    }

    @Test
    public void testGenererFacture() {
        panier.ajouterLivre(livre1, 2);
        panier.ajouterLivre(livre2, 1);
        panier.ajouterLivre(livre3, 3);
        String expected = "Facture pour John Doe :\n" +
                "1984 (3) : 29.97\n" +
                "Harry Potter (1) : 12.5\n" +
                "Le Seigneur des Anneaux (2) : 31.98\n" +
                "Total : 74.45";
        assertEquals(expected, panier.genererFacture());
    }
}
