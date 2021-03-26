package search;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest {

	@Test
	public void searchProduct(){
		String text = "Fender Stratocaster";
		var resultsPage = homePage.searchItem(text);
		String[] terms = separateSearchTerms(text);
		List<String> popularProductNames = resultsPage.getPopularProductNames();
		int index = (int) (Math.random() * (popularProductNames.size()));
		if (terms.length>0){
			boolean isTermInProduct = false;
			for (String term : terms) {
				if (popularProductNames.get(index).contains(term)) {
					isTermInProduct = true;
					break;
				}
			}
			Assert.assertTrue(isTermInProduct);
		}else {
			Assert.assertTrue(popularProductNames.get(index).contains(text));
		}
	}

	public String[] separateSearchTerms(String text){
		String[] splited = new String[0];
		for (int i=0;i<text.length();i++){
			if (text.charAt(i) == ' ') {
				splited = text.split("\\s+");
				break;
			}
		}
		return splited;

	}
}
