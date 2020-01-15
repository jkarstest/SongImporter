package com.jkarstedt.tool.song;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MyRepository extends CrudRepository<Song, Long> {


}