package com.meli.shop;

import com.meli.shop.utils.ArticleTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ShopApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldGetAllArticles() throws Exception {
		this.mockMvc.perform(get("/api/v1/articles"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json(ArticleTest.allArticlesJson));
	}
/*
	@Test
	void shouldGetCalories() throws Exception {
		this.mockMvc.perform(post("/calculatecalories")
				.contentType(APPLICATION_JSON)
				.content("{\"name\":\"Fideos\",\"ingredients\":[{\"name\":\"Tomate triturado en conserva\",\"weight\":200},{\"name\":\"Zanahoria\",\"weight\":12},{\"name\":\"Queso parmesano\",\"weight\":5},{\"name\":\"Harina de ma\u00edz\",\"weight\":5}]}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().json("{\"fullCalories\":12014,\"ingredientsWithCalories\":[{\"name\":\"Tomate triturado en conserva\",\"calorie\":7800},{\"name\":\"Zanahoria\",\"calorie\":504},{\"name\":\"Queso parmesano\",\"calorie\":1965},{\"name\":\"Harina de ma\u00edz\",\"calorie\":1745}],\"ingredientMoreCalories\":{\"name\":\"Tomate triturado en conserva\",\"calorie\":7800}}"));
	*/

}

