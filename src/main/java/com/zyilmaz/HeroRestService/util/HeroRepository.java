package com.zyilmaz.HeroRestService.util;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zyilmaz.HeroRestService.entity.Hero;

public interface HeroRepository extends CrudRepository<Hero, Long> {
	
	List<Hero> findByName(String name);
	
	/*@Query("select hero from Hero where hero.NAME = :name")
    Hero findHero(@Param("name") String name);
	*/
}
