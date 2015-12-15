/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Promotioncategory;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.PromotionModel;

/**
 *
 * @author Maxime
 */
@Stateless
public class PromotioncategoryFacade extends AbstractFacade<Promotioncategory> implements PromotioncategoryFacadeLocal {
    @PersistenceContext(unitName = "GoFoot3-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromotioncategoryFacade() {
        super(Promotioncategory.class);
    }

    @Override
    public List<PromotionModel> getPromoByWeekNumber(int weekNumber) {
        List<PromotionModel> promos = new ArrayList<>();
        
        Query query = em.createNamedQuery("Promotioncategory.findByWeekNumber");
        query.setParameter("weeknumber", weekNumber);
        List<Promotioncategory> promosDB = query.getResultList();
        
        for (Promotioncategory promo : promosDB) {
            PromotionModel p = new PromotionModel();
            p.setId(promo.getIdpromcat());
            p.setIdCategory(promo.getIdcategory().getIdcategory());
            p.setPercentage(promo.getPercentage().doubleValue());
            p.setWeeknumber(weekNumber);
            promos.add(p);
        }
        
        return promos;
    }

    @Override
    public PromotionModel getPromoByWeekNumberAndCatId(int weekNumber, int catId) {
        PromotionModel promo = new PromotionModel();
        
        Query query = em.createNamedQuery("Promotioncategory.findByWeekNumberAndCatId");
        query.setParameter("weeknumber", weekNumber);
        query.setParameter("idcategory", catId);
        Promotioncategory promoDB;
        try {
            promoDB = (Promotioncategory)query.getSingleResult();
            promo.setId(promoDB.getIdpromcat());
            promo.setIdCategory(promoDB.getIdcategory().getIdcategory());
            promo.setPercentage(promoDB.getPercentage().doubleValue());
            promo.setWeeknumber(weekNumber);
        } catch (NoResultException e) {
            promo = null;
        }
        
        return promo;
    }
    
}
