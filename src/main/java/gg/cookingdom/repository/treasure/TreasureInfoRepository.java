package gg.cookingdom.repository.treasure;

import gg.cookingdom.enums.Rank;
import gg.cookingdom.dto.Treasure;

import java.util.List;

public interface TreasureInfoRepository {
    List<Treasure> getTreasures();
    List<Treasure> getTreasureByName(String name);
    List<Treasure> getTreasureByRank(Rank rank);
    List<Treasure> getTreasureByEffect(String effect);
}
