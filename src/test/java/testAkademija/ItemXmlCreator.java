package testAkademija;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.annotations.Test;

import models.ShopItem;
import utils.XmlWriter;

public class ItemXmlCreator {

	private List<ShopItem> itemsList;
	private ShopItem item;

	@Test
	public void createItemsList() throws IOException {
		
		itemsList = new ArrayList<ShopItem>();
		
//		itemsList.add(new ShopItem("HP LP3065", "Hewlett-Packard", "$122.00", "Product 21"));
//		itemsList.add(new ShopItem("HP LP3065s", "Hewlett-Packard", "$122.00", "Product 21"));
//		System.out.println(itemsList);
//		XmlWriter.writeList("src/test/resources/hp.xml", itemsList);
		
		
		itemsList.add(new ShopItem("Palm Treo Pro", "10"));
		itemsList.add(new ShopItem("Samsung Galaxy Tab 10.1", "2"));
		itemsList.add(new ShopItem("HP LP3065", "50"));
		System.out.println(itemsList);
		XmlWriter.writeList("src/test/resources/ItemAndAmount.xml", itemsList);

	}
	
	@Test
	public void createOneItem() throws IOException {
		
		item = new ShopItem("HP LP3065", "Hewlett-Packard", "$122.00", "Product 21");
		XmlWriter.write("src/test/resources/hp.xml", item);


	}


}
