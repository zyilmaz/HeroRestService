package com.zyilmaz.HeroRestService.repository;

import com.zyilmaz.HeroRestService.entity.Hero;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HeroRepository extends CrudRepository<Hero, Long> {

    List<Hero> findByName(String name);
	
	/*@Query("select hero from Hero where hero.NAME = :name")
    Hero findHero(@Param("name") String name);
	*/
}
