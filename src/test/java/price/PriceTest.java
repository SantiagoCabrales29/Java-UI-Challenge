package price;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PriceTest extends BaseTest {

	@Test
	public void testFilterPrice(){
		var resultsPage = homePage.searchItem("Gibson Les Paul");
		int max = 2300;
		int min = 1000;
		resultsPage.addPriceFilter(min,max);
		List<String> productPrices = resultsPage.getProductPrices();
		//productPrices.forEach(System.out::println);
		List<Double> convertedPrices = convertPricesToInteger(productPrices);
		//convertedPrices.forEach(System.out::println);
		boolean isLessThanMin = false, isGreaterThanMax = false;
		for(Double price: convertedPrices){
			if (price>max) {
				isGreaterThanMax = true;
			}
			if(price<min){
				isLessThanMin=true;
			}
		}
		Assert.assertFalse(isLessThanMin);
		Assert.assertFalse(isGreaterThanMax);
	}

	public List<Double> convertPricesToInteger(List<String> prices){
		List<Double> intPrices = new ArrayList<>();
		StringBuilder aux;
		for(String price : prices){
			aux = new StringBuilder(price);
			aux.deleteCharAt(0);
			if (aux.indexOf(",")!= -1){
				aux.deleteCharAt(aux.indexOf(","));
			}
			double num = Double.parseDouble(String.valueOf(aux));
			intPrices.add(num);
		}
		return intPrices;
	}

	@Test
	public void orderPriceHighToLow(){
		var resultsPage = homePage.searchItem("Condenser Microphones");
		resultsPage.addSortFilter();
		List<String> resultsPrices = resultsPage.getProductPrices();
		List<Double> convertedPrices = convertPricesToInteger(resultsPrices);
		boolean isOrdered = true;
		for(int i=0, j=1; i<convertedPrices.size()-1;i++,j++){
			if (convertedPrices.get(i) > convertedPrices.get(j)) {
				isOrdered = false;
				break;
			}
		}
		Assert.assertTrue(isOrdered);
	}

}
