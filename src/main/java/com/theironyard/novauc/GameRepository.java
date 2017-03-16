package com.theironyard.novauc;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by psubedi2020 on 3/15/17.
 */
public interface GameRepository extends CrudRepository<Game, Integer> {

    List<Game> findByUser(User user);
    List<Game> findByGenre(String genre);
    List<Game> findByReleaseYear(int year);
    List<Game> findByGenreAndReleaseYear(String genre, int releaseYear);
    List<Game> findByReleaseYearIsGreaterThanEqual(int minReleaseYear);

    Game findFirstByGenre(String genre);
    int countByGenre(String genre);
    List<Game> findByGenreOrderByNameAsc(String genre);

   @Query("SELECT mygame FROM Game mygame  WHERE mygame.platform LIKE ?1% ")
   List<Game> findByPlatformStartsWith(String platform);

    @Query("SELECT g FROM Game g WHERE g.name LIKE ?1%")
    List<Game> findByNameStartsWith(String name);

}
