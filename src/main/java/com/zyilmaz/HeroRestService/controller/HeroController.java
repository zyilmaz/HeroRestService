package com.zyilmaz.HeroRestService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zyilmaz.HeroRestService.entity.Hero;
import com.zyilmaz.HeroRestService.service.HeroService;
import com.zyilmaz.HeroRestService.util.HeroRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "api")
public class HeroController {

	@Autowired
	HeroService heroService;

	@Autowired
	HeroRepository heroRepo;

	@ApiOperation(value = "Get all heroes")
	@RequestMapping(value = "/hero", method = RequestMethod.GET)
	public Iterable<Hero> getHeroesList() {
		return heroRepo.findAll();
	}

	@ApiOperation(value = "Get Hero by Id")
	@RequestMapping(value = "/hero", method = RequestMethod.GET, params = "id")
	@Cacheable(cacheNames = "heroes", key = "#id")
	public Hero getHeroById(@RequestParam(value = "id") int id) {
		return heroService.get((long) id);
	}

	@ApiOperation(value = "Get Hero by Name")
	@RequestMapping(value = "/hero", method = RequestMethod.GET, params = "name")
	@Cacheable(cacheNames = "heroes", key = "#name")
	public Hero getHeroByName(@RequestParam(value = "name") String name) {
		return heroRepo.findByName(name).get(0);
	}

	@ApiOperation(value = "Add Hero")
	@RequestMapping(value = "/hero", method = RequestMethod.POST)
	// @Cacheable(cacheNames = "heroes", key = "#id")
	public Hero addHero(@RequestBody Hero hero) {
		heroRepo.save(hero);
		return hero;
	}

	@ApiOperation(value = "Add Hero")
	@RequestMapping(value = "/hero", method = RequestMethod.POST, params = "name")
	// @Cacheable(cacheNames = "heroes", key = "#id")
	public Hero addHeroWithName(@RequestParam String name) {
		Hero hero = new Hero();
		hero.setName(name);

		heroRepo.save(hero);
		return hero;
	}

	@ApiOperation(value = "Update Hero")
	@RequestMapping(value = "/hero", method = RequestMethod.PUT)
	public Hero updateHero(@RequestBody Hero hero) {
		heroRepo.save(hero);
		return hero;

	}

	@ApiOperation(value = "Delete Hero")
	@RequestMapping(value = "/hero", method = RequestMethod.DELETE)
	public void deleteHero(@RequestParam(value = "id") long id) {
		heroRepo.deleteById(id);
	}

	/*@ApiOperation(value = "Search for an Item")
	@RequestMapping("/addHeroWithRepo")
	// @Cacheable(cacheNames = "heroes", key = "#id")
	public String addHeroWithRepo(@RequestParam(value = "name") String name) {

		Hero her = new Hero();
		her.setName(name);

		heroRepo.save(her);

		return "Success";
	}*/
}
