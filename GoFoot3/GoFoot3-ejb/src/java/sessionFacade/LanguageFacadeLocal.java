/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionFacade;

import entityBean.Language;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Maxime
 */
@Local
public interface LanguageFacadeLocal {

    void create(Language language);

    void edit(Language language);

    void remove(Language language);

    Language find(Object id);

    List<Language> findAll();

    List<Language> findRange(int[] range);

    int count();
    
}
