package org.judy.silentkiosk.store.repository;

import org.judy.silentkiosk.store.entity.Store;
import org.judy.silentkiosk.store.entity.StoreMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store,Long> {

    @Query("select s from Store s where s.sno = :sno")
    public Store getStoreBySno(Long sno);

    @Query("select sm from StoreMenu sm where sm.store.sno = :sno")
    public List<StoreMenu> getStoreMenuBySno(Long sno);

}
