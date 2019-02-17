//package pack.service;
//
//
//import java.util.Random;
//
//public interface UserService {
//
//    UserDto createUser(final UserDto userDto);
//
//    boolean login(String username, String password);
//
//    boolean isUserIdExists(String userId);
//
//    UserEntity fetchUserDetails(String userId) throws Exception;
//
//    default String generateId() {
//        Random random = new Random();
//        Integer id = random.nextInt();
//        return id.toString();
//    }
//}
