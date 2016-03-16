package org.venturis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.OutputCapture;

/**
 * Tests for {@link PageConsumer}.
 *
 * @author Manjit Johal
 */
public class PageConsumerTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();


	@Test
	public void testEmptyURL() throws Exception {
		PageConsumer.main(new String[0]);
		String output = this.outputCapture.toString();
		assertThat(output).contains("Please specify a valid url");
	}

	@Test
	public void testValidURL() throws Exception {
		
		String url = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?msg=&langId=44&categoryId=185749&storeId=10151&krypto=lIMmjlSSD%2FBfugUE5e%2BZ7BQ17Y%2BdwnSH1FDzpuKnH6KQztVoW%2FvROK0LPAj4Sxlbi9mYPVJ7ozApp38iU3JPXmWE2hklcjjajOUUMtE6Y6Lffq79VjeQYlmfpzu3lU5m02sUhwhv4IaQRcxZLyJEEac1W8WH2hcnf65ihjc8qwwBSxNBMlL03tdLev2YNnmZbhAaFYwjqlF7Xh0u%2FXsoeioeMPrkL5MJUYzwrqBMfzBMXEGbTcPwZev3J1AndQnlkPdbDASog7isMYdY7hHgBF%2BFu%2F3jPfPqQOF4j%2BdKRcM%2BtJMxLGgW%2BicSQKNs35C8HbrItPdsIljGTfz7e8JGyA%3D%3D#langId=44&storeId=10151&catalogId=10122&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0";
		
		String[] array = new String[1];
		array[0] = url;
		
		PageConsumer.main(array);
		String output = this.outputCapture.toString();
		assertThat(output).contains("json has been generated below");
	}

	@Test
	public void testInvalidURL() throws Exception {
		
		String url = "http://www.google.com";
		
		String[] array = new String[1];
		array[0] = url;
		
		PageConsumer.main(array);
		String output = this.outputCapture.toString();
		assertThat(output).contains("invalid");
	}	
}