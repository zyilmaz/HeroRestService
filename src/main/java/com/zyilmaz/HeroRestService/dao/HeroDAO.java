package com.zyilmaz.HeroRestService.dao;

import com.zyilmaz.HeroRestService.entity.Hero;

public interface HeroDAO {

    void create(Hero hero);

    void update(Hero hero);

    Hero getHeroById(long id);

    void delete(long id);
}
