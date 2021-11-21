package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {

    @FindBy(xpath="(//h4[contains(text(),'Categories')]/following-sibling::div[@class='list-group']/a)[1]")
    private WebElement firstCategoryUnderCategories;

    @FindBy(css ="div#products :first-of-type a")
    private WebElement firstProductUnderFirstCategory;

    public CategoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void selectCategory() {
        //click on the first category on the left pane under the categories
        firstCategoryUnderCategories.click();
    }
    public void selectProduct(){
        //Add the first product after clicking on the first category
        firstProductUnderFirstCategory.click();
    }
}
