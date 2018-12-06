package org.upgrad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.upgrad.models.Category;
import org.upgrad.models.Item;
import org.upgrad.models.Restaurant;

import java.util.Set;

@Repository
public interface ItemRepository  extends CrudRepository<Item, Integer> {

    @Query(nativeQuery = true,value="SELECT * from ITEM INNER JOIN CATEGORY_ITEM on ITEM.id=CATEGORY_ITEM.ITEM_ID WHERE CATEGORY_ITEM.CATEGORY_ID=?2 AND ITEM.id IN(SELECT ITEM.ID from ITEM INNER JOIN RESTAURANT_ITEM on ITEM.id=RESTAURANT_ITEM.ITEM_ID  AND RESTAURANT_ITEM.RESTAURANT_ID=?1)")
    Set<Item> getItemsByCategoryAndRestaurant(Integer RestaurantId, Integer categoryId);
}
