package study.memorydb.db;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID extends Serializable> extends Repository<T, ID> {
    //create
    T save(T data);

    //read
    Optional<T> findById(ID id); // ID를 가지고 데이터 찾기
    List<T> findAll();

    //update
    // 여기서는 save에서 처리 -> 있으면 업데이트, 없으면 저장

    // delete
    void delete(ID id);

}
