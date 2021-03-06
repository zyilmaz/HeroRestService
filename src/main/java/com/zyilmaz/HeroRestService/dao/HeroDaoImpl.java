package com.zyilmaz.HeroRestService.dao;

import com.zyilmaz.HeroRestService.entity.Hero;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class HeroDaoImpl implements HeroDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Hero hero) {
        entityManager.persist(hero);
    }

    @Override
    public void update(Hero hero) {
        entityManager.merge(hero);
    }

    @Override
    public Hero getHeroById(long id) {
        return entityManager.find(Hero.class, id);
    }

    @Override
    public void delete(long id) {
        Hero hero = getHeroById(id);
        if (hero != null) {
            entityManager.remove(hero);
        }
    }
}
