package gene.recombine.stuhubsys.mapper;

import java.util.Map;

public interface AuthMapper {
    Map<String, String> login(String ID, String password);
}
