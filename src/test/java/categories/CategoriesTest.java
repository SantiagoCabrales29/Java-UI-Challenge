package categories;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPopup;
import pages.SubCategoryPage;

public class CategoriesTest extends BaseTest {

	@Test
	public void navigateToAcousticDrumsCategory(){
		CategoryPopup category = homePage.clickCategory("Drums");
		String text = "Acoustic Drums";
		SubCategoryPage subCategory = category.clickSubCategory(text);
		Assert.assertEquals(subCategory.getTitle(),text);
	}
}
