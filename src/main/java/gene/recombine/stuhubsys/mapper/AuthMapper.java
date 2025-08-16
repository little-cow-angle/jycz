package gene.recombine.stuhubsys.mapper;

import org.apache.ibatis.annotations.MapKey;

import java.util.Map;

public interface AuthMapper {

    @MapKey("id")
    Map<String, String> login(String ID, String password);
}
