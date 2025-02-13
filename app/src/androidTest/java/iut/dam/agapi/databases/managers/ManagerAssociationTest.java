package iut.dam.agapi.databases.managers;

import static org.junit.jupiter.api.Assertions.*;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import iut.dam.agapi.databases.models.Association;

@RunWith(AndroidJUnit4.class)
public class ManagerAssociationTest {
    private ManagerAssociation managerAssociation;
    private Context context;

    @Before
    public void setUp() {
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        managerAssociation = new ManagerAssociation(context);
    }

    @After
    public void tearDown() {
        managerAssociation.close();
    }

    @Test
    public void testAddUtilisateur() {
        Association association = new Association("Association1", "Description1", "Logo1", "QRCode1");
        managerAssociation.addAssociation(association);
        Association retrievedAssociation = managerAssociation.getAssociationById(association.getId());
        assertNotNull(retrievedAssociation);
    }

    @Test
    public void getAssociationById() {
        Association association1 = new Association("Association1", "Description1", "Logo1", "QRCode1");
        managerAssociation.addAssociation(association1);
        Association retrievedAssociation = managerAssociation.getAssociationById(association1.getId());
        assertEquals("Association1" ,retrievedAssociation.getNom());
    }

    @Test
    public void getAllAssociations() {
        Association association1 = new Association("Association1", "Description1", "Logo1", "QRCode1");

    }
}