package three.seminar.deeping.repository;

import three.seminar.deeping.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private static final Map<Integer, User> handong = new HashMap<>();

    public User save(User user){
        handong.put(user.getStuNum(),user);
        return user;
    }
    public User findById(Integer stuNumber){
        return handong.get(stuNumber);
    }
    //여러개 가져올 것인데 종류가 User다
    //ArryaList를 생성하기 위해서는 new를 사용해야 한다
    public List<User> findAll(){
        return new ArrayList<>(handong.values());
    }
    public void update(Integer id, User updateParams){
        User findUser = findById(id);
        findUser.setStuNum(updateParams.getStuNum());
        findUser.setStuNum(updateParams.getStuNum());
    }
    public void delete(Integer itemId){
        handong.remove(itemId);
    }
}
