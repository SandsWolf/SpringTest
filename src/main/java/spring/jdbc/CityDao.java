package spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class CityDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public City get(Integer id) {
        String sql = "SELECT * FROM `City` where id = ?";
        RowMapper<City> rowMapper = new BeanPropertyRowMapper<>(City.class);
        City city = jdbcTemplate.queryForObject(sql, rowMapper, id);

        return city;
    }

}
