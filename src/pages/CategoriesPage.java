package pages;

import framework.Helper;
import framework.Page;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoriesPage extends Page {

    private void clickOnAddCategoryButton(WebDriver driver) {

        WebElement addCategoryButton = driver.findElement(By.linkText("Add category"));
        addCategoryButton.click();

    }
    
    private void sendTextOnTitleField(WebDriver driver) {
        
        WebElement newCategoryName = driver.findElement(By.id("title"));
        newCategoryName.sendKeys(Helper.getRandomText());
        
    }
    
    private void clickOnSaveCategoryButton(WebDriver driver) {
        
        WebElement saveCategoryButton = driver.findElement(By.id("save-category-button"));
        saveCategoryButton.click();
        
    }

    public void addNewCategory(WebDriver driver) {

        clickOnAddCategoryButton(driver);
        sendTextOnTitleField(driver);
        clickOnSaveCategoryButton(driver);

    }
    
    private void clickOnEditButton(WebElement row) {
        
        WebElement editButton = row.findElement(By.cssSelector("a[title='Edit']"));
        editButton.click();
        
    }
    
    private void clickOnDeleteButton(WebElement row) {
        
        WebElement deleteButton = row.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();
        
        
    }
    
    private void sendTextOnTitleFieldWithClear(WebDriver driver) {
        
        WebElement newCategoryName = driver.findElement(By.id("title"));
        newCategoryName.clear();
        newCategoryName.sendKeys(Helper.getRandomText());
        
    }
    
    private List<WebElement> getRowsFromTable(WebDriverWait wait) {
        WebElement tBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-sortable")));
        List<WebElement> rows = tBody.findElements(By.tagName("tr"));
        System.out.println("Number of rows: " + rows.size());
        return rows;
    }
    
    private WebElement chooseFirstCategory(WebDriverWait wait) {
        
        List<WebElement> rows = getRowsFromTable(wait);
        WebElement firstRow = rows.get(0);
//        WebElement lastRow = rows.get(rows.size()-1);
        return firstRow;
        
    }
    
    private WebElement chooseLastCategory(WebDriverWait wait) {
        
        List<WebElement> rows = getRowsFromTable(wait);
//        WebElement firstRow = rows.get(0);
        WebElement lastRow = rows.get(rows.size()-1);
        return lastRow;
        
    }
    
    private WebElement chooseRandomCategory(WebDriverWait wait) {
        
        List<WebElement> rows = getRowsFromTable(wait);
        WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size()));
        return randomRow;
        
    }

    public void editFirstCategory(WebDriver driver, WebDriverWait wait) {
        
         WebElement firstRow = chooseFirstCategory(wait);
         clickOnEditButton(firstRow);
         sendTextOnTitleFieldWithClear(driver);
         clickOnSaveCategoryButton(driver);
        
    }

    public void editLastCategory(WebDriver driver, WebDriverWait wait) {
        
         WebElement lastRow = chooseLastCategory(wait);
         clickOnEditButton(lastRow);
         sendTextOnTitleFieldWithClear(driver);
         clickOnSaveCategoryButton(driver);
        
        
    }

    public void editRandomCategory(WebDriver driver, WebDriverWait wait) {
         
         WebElement randomRow = chooseRandomCategory(wait);
         clickOnEditButton(randomRow);
         sendTextOnTitleFieldWithClear(driver);
         clickOnSaveCategoryButton(driver);
        
    }
    
    
    private void clickOnConfirmDeleteButton(WebDriverWait wait) {
        
        WebElement confirmDeleteButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'categoryDeleteDialog\']/div/div/div[3]/button[2]")));
        confirmDeleteButton.click();
        
    }

    public void deleteFirstCategory(WebDriver driver, WebDriverWait wait) {
        
        WebElement firstRow = chooseFirstCategory(wait);
        clickOnDeleteButton(firstRow);
        clickOnConfirmDeleteButton(wait);
        
    }

    public void deleteLastCategory(WebDriver driver, WebDriverWait wait) {

        WebElement lastRow = chooseLastCategory(wait);
        clickOnDeleteButton(lastRow);
        clickOnConfirmDeleteButton(wait);

    }
    
    public void deleteRandomCategory(WebDriver driver, WebDriverWait wait) {

        WebElement randomRow = chooseRandomCategory(wait);
        clickOnDeleteButton(randomRow);
        clickOnConfirmDeleteButton(wait);

    }

}
