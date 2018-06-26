package category;

import framework.Helper;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//import org.junit.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CategoriesPage;

public class TestCategories {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static CategoriesPage categoriesPage;
    
    private static DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @BeforeClass
    public static void setUpClass() {
        
        System.out.println("@BeforeClass (setUpClass): " + dateFormat.format(new Date()));
        
        
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        categoriesPage = new CategoriesPage();

        driver.manage().window().maximize();
        driver.get("http://bvtest.school.cubes.rs/login");
        
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        emailField.sendKeys("qa@cubes.rs");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
        passwordField.sendKeys("cubesqa");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("btn-primary")));
        loginButton.click();

        System.out.println("Page title is: " + driver.getTitle());
    }

    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        Thread.sleep(3000);
        
        System.out.println("@AfterClass (tearDownClass): " + dateFormat.format(new Date()));
        driver.quit();
    }

    @Before
    public void setUp() {
        System.out.println("@Before (setUp): " + dateFormat.format(new Date()));
        
        WebElement categories = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Categories")));

        categories.click();
        System.out.println("Page title is: " + driver.getTitle());
    }

    @After
    public void tearDown() throws InterruptedException {
    
        Thread.sleep(1500);
        System.out.println("@After (tearDown): " + dateFormat.format(new Date()));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreateNewCategory() throws InterruptedException {
        System.out.println("@Test (testCreateNewCategory): " + dateFormat.format(new Date()));

        for (int i = 0; i < 1; i++) {
            
            categoriesPage.addNewCategory(driver);
            
            

            String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
            String actualUrl = driver.getCurrentUrl();

            Assert.assertEquals("Urls doesn't match!!!", expectedUrl, actualUrl);

            String expectedTitle = "Brze vesti admin  | Categories ".replaceAll("\\s+", " ").trim();
            String actualTitle = driver.getTitle();

//            System.out.println("expected title: '" + expectedTitle + "'");
//            System.out.println("actual title: '" + actualTitle + "'");

            Assert.assertEquals("Titles doesn't match.", expectedTitle, actualTitle);
        }

    }

    @Test
    public void testEditLastCategory() {
            
        System.out.println("Test edit category");
        System.out.println("@Test (testEditCategory): " + dateFormat.format(new Date()));
        
        
        categoriesPage.editLastCategory(driver, wait);
        
        
        String expectedUrl = "http://bvtest.school.cubes.rs/admin/categories";
            String actualUrl = driver.getCurrentUrl();

            Assert.assertEquals("Urls doesn't match!!!", expectedUrl, actualUrl);

            String expectedTitle = "Brze vesti admin  | Categories ".replaceAll("\\s+", " ").trim();
            String actualTitle = driver.getTitle();

//            System.out.println("expected title: '" + expectedTitle + "'");
//            System.out.println("actual title: '" + actualTitle + "'");

            Assert.assertEquals("Titles doesn't match.", expectedTitle, actualTitle);
        
    }
    
    @Test
    public void testEditFirstCategory() {
        
        categoriesPage.editFirstCategory(driver, wait);
        
    }
    
    @Test
    public void testEditRandomCategory() {
        
        categoriesPage.editRandomCategory(driver, wait);
        
    }

    @Test
    public void testDeleteFirstCategory() {
//        System.out.println("@BeforeClass (setUpClass): " + dateFormat.format(new Date()));
//        System.out.println("Test delete category");
        
        categoriesPage.deleteFirstCategory(driver, wait);
    }
    
    @Test
    public void testDeleteLastCategory() {
        
        categoriesPage.deleteLastCategory(driver, wait);
        
    }
    
    @Test
    public void testDeleteRandomCategory() {
        
        categoriesPage.deleteLastCategory(driver, wait);
        
    }
    
    @Test
    public void testAddEditDeleteCategory() {
        categoriesPage.addNewCategory(driver);
        categoriesPage.editLastCategory(driver, wait);
        categoriesPage.deleteLastCategory(driver, wait);
    }
    
}
