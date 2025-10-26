package ru.yandex.practicum;

import org.postgresql.ds.PGConnectionPoolDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.yandex.practicum.catsgram.model.Film;
import ru.yandex.practicum.catsgram.rowmapper.FilmRowMapper;

import javax.sql.PooledConnection;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/filmsdb";
        String user = "dbuser";
        String password = "12345";

        PGConnectionPoolDataSource ds = new PGConnectionPoolDataSource();
        ds.setURL(url);
        ds.setUser(user);
        ds.setPassword(password);
        PooledConnection pooledConnection = null;
        try {
            pooledConnection = ds.getPooledConnection();
            String sql = "SELECT * FROM films WHERE kind = ? AND len_min = ?";
            PreparedStatement preparedStatement = pooledConnection.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, "Sci-Fi");
            preparedStatement.setInt(2, 110);

            //jdbcTemplate.update(
            //        "INSERT INTO films VALUES (?, ?, ?, ?, ?, ?)",
            //        4, "Movie4", 2024,
            //        LocalDate.parse("2024-05-05"),
            //        "Mystery", 120);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("title"));
            }
            String query = "SELECT * FROM films WHERE ID = ?";
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
            dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            dataSource.setUrl("jdbc:postgresql://localhost:5432/catsgram");
            dataSource.setUsername("dbuser");
            dataSource.setPassword("12345");
            Film film = jdbcTemplate.queryForObject(query, new FilmRowMapper(), 1);
            System.out.println("AAAA: " + film);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
