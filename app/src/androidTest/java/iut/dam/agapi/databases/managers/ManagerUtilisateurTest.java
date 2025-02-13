package iut.dam.agapi.databases.managers;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.content.Context;

import java.util.List;

import iut.dam.agapi.databases.models.Utilisateur;

@RunWith(AndroidJUnit4.class)
public class ManagerUtilisateurTest {

    private ManagerUtilisateur managerUtilisateur;
    private Context context;


    @Before
    public void setUp() {
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        managerUtilisateur = new ManagerUtilisateur(context);
    }
    @After
    public void tearDown() {
        managerUtilisateur.close();
    }

    @Test
    public void testAddUtilisateur() {
        Utilisateur utilisateur = new Utilisateur("Doe", "John", "john.doe@example.com", "password123");
        managerUtilisateur.addUtilisateur(utilisateur);
        Utilisateur addedUser = managerUtilisateur.getUtilisateurByEmail("john.doe@example.com");
        assertNotNull(addedUser);
        assertEquals(utilisateur.getNom(), addedUser.getNom());
        assertEquals(utilisateur.getPrenom(), addedUser.getPrenom());
        assertEquals(utilisateur.getEmail(), addedUser.getEmail());
        assertEquals(utilisateur.getMotDePasse(), addedUser.getMotDePasse());
    }



    @Test
    public void testGetUtilisateurByEmail() {
        Utilisateur user = new Utilisateur("Jane", "Doe", "jane.doe@example.com", "pass");
        managerUtilisateur.addUtilisateur(user);
        Utilisateur User = managerUtilisateur.getUtilisateurByEmail("jane.doe@example.com");
        assertEquals("Jane", User.getNom());
    }

    @Test
    public void testUpdateUtilisateur() {
        Utilisateur user = new Utilisateur("Emily", "Brown", "emily.brown@example.com", "oldpass");
        managerUtilisateur.addUtilisateur(user);
        user.setMotDePasse("newpass");
        boolean updated = managerUtilisateur.updateUtilisateur(user);
        assertTrue(updated);
        assertEquals("newpass", managerUtilisateur.getUtilisateurByEmail("emily.brown@example.com").getMotDePasse());
    }

    @Test
    public void testGetAllUtilisateurs() {
        managerUtilisateur.addUtilisateur(new Utilisateur("Alice", "Cooper", "alice@example.com", "1234"));
        managerUtilisateur.addUtilisateur(new Utilisateur("Bob", "Marley", "bob@example.com", "5678"));
        List<Utilisateur> users = managerUtilisateur.getAllUtilisateurs();
        assertTrue(users.size() >= 2);
        System.out.println(users);
    }

    @Test
    public void testUtilisateurExists() {
        managerUtilisateur.addUtilisateur(new Utilisateur("Charlie", "Puth", "charlie@example.com", "password"));
        assertTrue(managerUtilisateur.utilisateurExists("charlie@example.com"));
        assertFalse(managerUtilisateur.utilisateurExists("unknown@example.com"));
    }
}