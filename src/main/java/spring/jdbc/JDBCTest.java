package spring.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JDBCTest {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    CityDao cityDao =  ctx.getBean(CityDao.class);
    NamedParameterJdbcTemplate namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean(NamedParameterJdbcTemplate.class);

    @Test
    public void testNamedParameterJdbcTemplate() {
        String sql = "INSERT INTO city  (NAME,CountryCode,District,Population) VALUES (:name,:countryCode,:district,:population)";

        City city = new City();
        city.setName("test5");
        city.setCountryCode("ABW");
        city.setDistrict("test");
        city.setPopulation(100);

        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(city);
        namedParameterJdbcTemplate.update(sql, parameterSource);
    }

    @Test
    public void testCityDao() {
        System.out.println(cityDao.get(1));
    }


    /*
    获取单个列的值，或作统计查询
     */
    @Test
    public void testQueryForObject2() {
        String sql = "SELECT count(*) FROM `City` ";
        long count = jdbcTemplate.queryForObject(sql, Long.class);

        System.out.println(count);
    }

    /*
    查找实体类的集合
     */
    @Test
    public void testQueryForeList() {
        String sql = "SELECT * FROM `City` where id > ? ";
        RowMapper<City> rowMapper = new BeanPropertyRowMapper<>(City.class);
        List<City> list = jdbcTemplate.query(sql, rowMapper, 3);

        System.out.println(list);
    }

    /*
    jdbcTemplate.queryForObject（）
    从数据库获取记录，实际得到一个对象
     */
    @Test
    public void testQueryForObject() {
        String sql = "SELECT * FROM `City` where id = ? ";
        RowMapper<City> rowMapper = new BeanPropertyRowMapper<>(City.class);
        City city = jdbcTemplate.queryForObject(sql, rowMapper,1);

        System.out.println(city);
    }

    @Test
    public void testBatchUpdate() {
        String sql = "INSERT INTO city  (NAME,CountryCode,District,Population) VALUES (?,?,?,?);";
        List<Object[]> list = new ArrayList();
        list.add(new Object[]{"test","ABW","test",10000});
        list.add(new Object[]{"test2","ABW","test",20000});
        list.add(new Object[]{"test3","ABW","test",30000});
        list.add(new Object[]{"test4","ABW","test",40000});
        jdbcTemplate.batchUpdate(sql,list);

    }
    @Test
    public void testUpdate() {
        String sql = "update city set name = ? where name = ?;";
        jdbcTemplate.update(sql,"Kb","Kabul");
    }

    @Test
    public void testDataSource() {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource);
    }
}
