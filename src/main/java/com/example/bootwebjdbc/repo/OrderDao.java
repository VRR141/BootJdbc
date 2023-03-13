package com.example.bootwebjdbc.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderDao {

    @Autowired
    private NamedParameterJdbcTemplate template;

    private static final String SQL_SCRIPT_NAME = "find_product.sql";

    public List<String> getProductName(String name){
        String sqlScript = read(SQL_SCRIPT_NAME);
        MapSqlParameterSource parameterSource = new MapSqlParameterSource("name", name);
        return template.query(sqlScript, parameterSource,
                (rs, rowNum) -> rs.getString("product_name"));
    }


    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
