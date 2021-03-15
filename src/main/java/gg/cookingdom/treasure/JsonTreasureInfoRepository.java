package gg.cookingdom.treasure;

import com.fasterxml.jackson.databind.ObjectMapper;
import gg.cookingdom.cookie.Rank;
import lombok.SneakyThrows;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JsonTreasureInfoRepository implements TreasureInfoRepository{

    private final List<Treasure> treasures;

    @SneakyThrows
    public JsonTreasureInfoRepository() {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(
                getClass().getResource("static/treasureinfo.json").getPath()));

        JSONObject jsonObject = (JSONObject) obj;
        ObjectMapper mapper = new ObjectMapper();
        this.treasures = mapper.readValue(jsonObject.toJSONString(), List.class);
    }

    @Override
    public List<Treasure> getTreasureByName(String name) {
        return treasures.stream()
                .filter(treasure -> treasure.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Treasure> getTreasureByRank(Rank rank) {
        return null;
    }

    @Override
    public List<Treasure> getTreasureBy(String effect) {
        return null;
    }
}
