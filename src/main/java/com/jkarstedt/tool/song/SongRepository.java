package com.jkarstedt.tool.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
class SongRepositoy implements com.jkarstedt.tool.song.Repository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Song> findAll() {
        return this.entityManager.createQuery("SELECT n FROM Note n", Song.class)
                .getResultList();
    }

}
