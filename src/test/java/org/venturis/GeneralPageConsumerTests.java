package org.venturis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.venturis.PageConsumer;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link PageConsumer}.
 *
 * @author Manjit Johal
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(PageConsumer.class)
public class GeneralPageConsumerTests {

	@Autowired
	ApplicationContext ctx;

	
	@Test
	public void testContextLoads() throws Exception {
		assertThat(this.ctx).isNotNull();
		assertThat(this.ctx.containsBean("pageConsumerService")).isTrue();
		assertThat(this.ctx.containsBean("jsonBuilderService")).isTrue();
		assertThat(this.ctx.containsBean("pageConsumer")).isTrue();
	}
}