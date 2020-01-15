/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jkarstedt.tool.song;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class JpaApplication {
	private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}


	@Bean
	@Order(0)
	public CommandLineRunner demo(MyRepository repository) {
		return (args) -> {
			jdbcTemplate.execute("delete from notes.transfer_songs");
			ExcelToDatabase.runExporter("songs.xlsx",repository);


			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Song customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");


		};
	}
	@Bean
	@Order(1)
	public CommandLineRunner executeSql() {
		return (args) -> {
		log.info("done with "+	jdbcTemplate.queryForObject("select count(*) from notes.transfer_songs", new Object[] {}, Integer.class)+" rows.");
			jdbcTemplate.execute("select count(*) from notes.transfer_songs");
		};
	}

	@Bean
	@Order(2)
	public CommandLineRunner associateSongs() {
		return (args) -> {
			log.info("erasing all songs in notes.app_song");
			jdbcTemplate.execute("delete from notes.app_song");
			log.info("writing  to songs");
			jdbcTemplate.execute("INSERT INTO notes.app_song (id,name,inception)\n" +
					"select UUID(),title,inception from notes.transfer_songs");

			log.info("done with "+	jdbcTemplate.queryForObject("select count(*) from notes.transfer_songs", new Object[] {}, Integer.class)+" rows.");
		};
	}
}
