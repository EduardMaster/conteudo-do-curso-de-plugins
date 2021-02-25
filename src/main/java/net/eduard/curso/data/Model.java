package net.eduard.curso.data;

import java.util.Collection;
import java.util.Map;

public interface Model<Data, Primary, Handler> {

    Map<Primary, Data> getCache();

    Map<Primary, Handler> getHandlersCache();

    Handler getMainHandler();

    Handler getHandlerBy(Primary primary);

    boolean has(Primary primary);

    void save(Data data);

    void reload(Data data);

    Data load(Primary primary);


    Collection<Data> loadAll();

    default Data getOrLoad(Primary primary){
        if (has(primary)){
            return getCache(primary);
        }else return load(primary);
    }

    default boolean hasCache(Primary primary) {
        return getCache().containsKey(primary);
    }

    default Data getCache(Primary primary) {
       return getCache().get(primary);
    }

    default void removeCache(Primary primary) {
        getCache().remove(primary);
    }

    void delete(Primary primary);


}
