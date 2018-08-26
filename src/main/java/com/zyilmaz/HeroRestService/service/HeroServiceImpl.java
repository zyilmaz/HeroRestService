package com.zyilmaz.HeroRestService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zyilmaz.HeroRestService.dao.HeroDAO;
import com.zyilmaz.HeroRestService.entity.Hero;

@Service
@Transactional
public class HeroServiceImpl implements HeroService {

	@Autowired
	private HeroDAO heroDao;

	@Override
	public void create(Hero hero) {
		heroDao.create(hero);

	}

	@Override
	public Hero get(Long id) {
		return heroDao.getHeroById(id);
	}

}
