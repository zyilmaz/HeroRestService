package com.zyilmaz.HeroRestService.service;

import com.zyilmaz.HeroRestService.entity.Hero;

public interface HeroService {

    void create(Hero hero);

    Hero get(Long id);

}
