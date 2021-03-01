package net.eduard.curso;

import java.util.Collection;
import java.util.Map;

public interface Armazenamento<T, M> {

    M getBy(String key);

    Map<String , T> cache();

    void save(T dado);

    T load(String key);

    T loadOrGet(String key);

    Collection<T> loadAll();

    void reload(T dado);


}
