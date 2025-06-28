package study.memorydb.db;

import study.memorydb.entity.Entity;

import java.io.Serializable;
import java.util.*;

abstract public class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID>{
    private List<T> dataList = new ArrayList<T>();

    private static long index = 0;

    // comparator
    private final Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return o1.getId().compareTo(o2.getId());
        }
    };

    @Override
    public T save(T data) {
//        빈 데이터
        if (Objects.isNull(data)) {
            throw new RuntimeException("data is null");
        }

        //이미 데이터가 있는가
        Optional<T> prevData;
        prevData = dataList.stream()
                .filter(e -> e.getId().equals(data.getId()))
                        .findFirst();
        if (prevData.isPresent()) {
            dataList.remove(prevData.get());
            dataList.add(data);
            return data;
        }

        //unique_id
        data.setId(index++);
        dataList.add(data);
        return data;
    }

    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream()
                .sorted(sort)
                .toList();
    }

    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream().filter(e -> e.getId().equals(id)).findFirst();
        deleteEntity.ifPresent(t -> dataList.remove(t));
    }
}
