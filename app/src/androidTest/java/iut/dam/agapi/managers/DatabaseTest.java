//package iut.dam.agapi.managers;
//
//import androidx.room.Room;
//import androidx.test.ext.junit.runners.AndroidJUnit4;
//import androidx.test.platform.app.InstrumentationRegistry;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import iut.dam.agapi.managers.AppDatabase;
//import iut.dam.agapi.managers.DAO.AdministrateurAssoDAO;
//import iut.dam.agapi.managers.DAO.AdministrateurDAO;
//import iut.dam.agapi.managers.DAO.AssociationDAO;
//import iut.dam.agapi.managers.DAO.CategorieDAO;
//import iut.dam.agapi.managers.DAO.DonDAO;
//import iut.dam.agapi.managers.DAO.RapportDAO;
//import iut.dam.agapi.managers.DAO.UtilisateurDao;
//import iut.dam.agapi.managers.models.Administrateur;
//import iut.dam.agapi.managers.models.AdministrateurAsso;
//import iut.dam.agapi.managers.models.Association;
//import iut.dam.agapi.managers.models.Categorie;
//import iut.dam.agapi.managers.models.Don;
//import iut.dam.agapi.managers.models.Rapport;
//import iut.dam.agapi.managers.models.Utilisateur;
//
//import static org.junit.Assert.assertEquals;
//
//@RunWith(AndroidJUnit4.class)
//public class DatabaseTest {
//    @Rule
//    public InstantTaskExecutorRule instantTaskExecutorRule;
//
//    private AppDatabase db;
//    private UtilisateurDao utilisateurDAO;
//    private AdministrateurDAO administrateurDAO;
//    private CategorieDAO categorieDAO;
//    private AssociationDAO associationDAO;
//    private DonDAO donDAO;
//    private AdministrateurAssoDAO administrateurAssoDAO;
//    private RapportDAO rapportDAO;
//
//    @Before
//    public void createDb() {
//        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getInstrumentation().getTargetContext(),
//                AppDatabase.class).build();
//        utilisateurDAO = db.utilisateurDao();
//        administrateurDAO = db.administrateurDAO();
//        categorieDAO = db.categorieDAO();
//        associationDAO = db.associationDAO();
//        donDAO = db.donDao();
//        administrateurAssoDAO = db.administrateurAssoDAO();
//        rapportDAO = db.rapportDAO();
//        instantTaskExecutorRule = new InstantTaskExecutorRule();
//    }
//
//    @After
//    public void closeDb() {
//        db.close();
//    }
//
//    @Test
//    public void testUtilisateurDAO() {
//        Utilisateur utilisateur = new Utilisateur();
//        utilisateur.nom = "Doe";
//        utilisateur.prenom_ = "John";
//        utilisateur.email_ = "john.doe@example.com";
//        utilisateur.mot_de_passe_ = "password";
//        utilisateur.date_inscription_ = "2023-01-01";
//
//        utilisateurDAO.insert(utilisateur);
//        Utilisateur byEmail = utilisateurDAO.getUtilisateurByEmail("john.doe@example.com");
//        assertEquals("John", byEmail.prenom_);
//    }
//
//    @Test
//    public void testAdministrateurDAO() {
//        Administrateur administrateur = new Administrateur();
//        administrateur.Id_admin = "admin1";
//        administrateur.id_utilisateur = 1;
//
//        administrateurDAO.insert(administrateur);
//        Administrateur byId = administrateurDAO.getAdministrateurById("admin1");
//        assertEquals(1, byId.id_utilisateur);
//    }
//
//    @Test
//    public void testCategorieDAO() {
//        Categorie categorie = new Categorie();
//        categorie.idCategorie = "cat1";
//        categorie.categorie = "Sport";
//
//        categorieDAO.insert(categorie);
//        Categorie byId = categorieDAO.getCategorieById("cat1");
//        assertEquals("Sport", byId.categorie);
//    }
//
//    @Test
//    public void testAssociationDAO() {
//        Association association = new Association();
//        association.nom_association_ = "Association Test";
//        association.Description_ = "Description Test";
//        association.idCategorie = "cat1";
//
//        associationDAO.insert(association);
//        Association byId = associationDAO.getAssociationById(1);
//        assertEquals("Association Test", byId.nom_association_);
//    }
//
//    @Test
//    public void testDonDAO() {
//        Don don = new Don();
//        don.montant = 100.0;
//        don.date_don = "2023-01-01";
//        don.type_don = "Espèces";
//        don.id_utilisateur = 1;
//        don.id_association = 1;
//
//        donDAO.insert(don);
//        Don byId = donDAO.getDonById(1);
//        assertEquals(100.0, byId.montant, 0.01);
//    }
//
//    @Test
//    public void testAdministrateurAssoDAO() {
//        AdministrateurAsso administrateurAsso = new AdministrateurAsso();
//        administrateurAsso.Id_admin = "admin1";
//        administrateurAsso.id_association = 1;
//        administrateurAsso.id_utilisateur = 1;
//
//        administrateurAssoDAO.insert(administrateurAsso);
//        AdministrateurAsso byId = administrateurAssoDAO.getAdministrateurAssoById("admin1");
//        assertEquals(1, byId.id_association);
//    }
//
//    @Test
//    public void testRapportDAO() {
//        Rapport rapport = new Rapport();
//        rapport.rapport = "Rapport Test";
//        rapport.date_rapport = "2023-01-01";
//        rapport.Id_admin = "admin1";
//
//        rapportDAO.insert(rapport);
//        Rapport byId = rapportDAO.getRapportById(1);
//        assertEquals("Rapport Test", byId.rapport);
//    }
//}
