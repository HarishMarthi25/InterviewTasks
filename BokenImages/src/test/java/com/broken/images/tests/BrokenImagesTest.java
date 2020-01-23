package com.broken.images.tests;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.broken.images.TestBase;
import com.broken.images.utils.Utils;

public class BrokenImagesTest extends TestBase {
	private int invalidImageCount;

	@Test
	public void verifyBrokenImages() {
		WebElement brokenImagesHeaderText = driver.findElement(By.xpath("//h3[text()='Broken Images']"));
		assertEquals(brokenImagesHeaderText.getText().toString(), "Broken Images");
		assertEquals(getBrokenImagesCount(), 2);
	}

	public int getBrokenImagesCount() {
		try {
			invalidImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			System.out.println("Total no. of images are  :  " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					Utils.highLightElement(driver, imgElement);
					verifyimageActive(imgElement);
				}
			}
			System.out.println("Total no. of invalid images are :  " + invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return invalidImageCount;
	}

	public void verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != 200)
				invalidImageCount++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
