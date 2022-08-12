package RestAPIServer.demo.mapper;

import RestAPIServer.demo.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    UserDTO test();
}
