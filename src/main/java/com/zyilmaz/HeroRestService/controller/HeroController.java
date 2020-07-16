package com.zyilmaz.HeroRestService.controller;

import com.zyilmaz.HeroRestService.entity.Hero;
import com.zyilmaz.HeroRestService.service.HeroService;
import com.zyilmaz.HeroRestService.repository.HeroRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api")
public class HeroController {

    private final HeroService heroService;

    private final HeroRepository heroRepo;

    public HeroController(HeroService heroService, HeroRepository heroRepo) {
        this.heroService = heroService;
        this.heroRepo = heroRepo;
    }

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
    public Hero addHero(@RequestBody Hero hero) {
        heroRepo.save(hero);
        return hero;
    }

    @ApiOperation(value = "Add Hero")
    @RequestMapping(value = "/hero", method = RequestMethod.POST, params = "name")
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

	@ApiOperation(value = "Add Hero with Service")
	@RequestMapping("/addHeroWithService")
	public String addHeroWithService(@RequestParam(value = "name") String name) {
		Hero hero = new Hero();
        hero.setName(name);

		heroService.create(hero);
		return "Success";
	}
}
