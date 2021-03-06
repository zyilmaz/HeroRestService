package com.zyilmaz.HeroRestService.service;

import com.zyilmaz.HeroRestService.dao.HeroDAO;
import com.zyilmaz.HeroRestService.entity.Hero;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HeroServiceImpl implements HeroService {

    private final HeroDAO heroDao;

    public HeroServiceImpl(HeroDAO heroDao) {
        this.heroDao = heroDao;
    }

    @Override
    public void create(Hero hero) {
        heroDao.create(hero);
    }

    @Override
    public Hero get(Long id) {
        return heroDao.getHeroById(id);
    }

}
