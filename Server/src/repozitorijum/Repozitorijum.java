package repozitorijum;

import java.util.List;

/**
 *
 * @author LENOVO
 * @param <T>
 */
public interface Repozitorijum<T> {
    List<T> vratiSve(T param) throws Exception;
    void dodaj(T param) throws Exception;
    void izmeni(T param) throws Exception;
    void obrisi(T param)throws Exception;
    List<T> vratiSve();
}
