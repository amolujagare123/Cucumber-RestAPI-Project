package util;

import pojo.CreateUserPOJO;
import pojo.UpdateChatUser;

import java.util.ArrayList;
import java.util.List;

public class POJOPayloads {


    public static UpdateChatUser payLoadUpdateUser() {

        UpdateChatUser updateChatUser = new UpdateChatUser();
        updateChatUser.setName("a2");
        updateChatUser.setSurname("b2");
        updateChatUser.setChat_nickname("c2");

        List<Integer> deptList = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};
        updateChatUser.setDepartments(deptList);

        List<Integer> deptRead = new ArrayList<Integer>() {{
            add(2);
        }};
        updateChatUser.setDepartments_read(deptRead);

        List<Integer> deptGrp = new ArrayList<Integer>() {{
            add(1);
        }};

        updateChatUser.setDepartment_groups(deptGrp);
        updateChatUser.setUser_groups(deptGrp);

        return updateChatUser;
    }

    public static CreateUserPOJO payLoadUpdateCreateUser(
            String user,String pass,String email, String name,
            String surname ,String nickName
    ) {

        CreateUserPOJO createUserPOJO = new CreateUserPOJO();


        createUserPOJO.setUsername(user);
        createUserPOJO.setPassword(pass);
        createUserPOJO.setEmail(email);

        createUserPOJO.setName(name);
        createUserPOJO.setSurname(surname);
        createUserPOJO.setChat_nickname(nickName);

        List<Integer> deptList = new ArrayList<Integer>() {{
            add(1);
            add(2);
        }};
        createUserPOJO.setDepartments(deptList);

        List<Integer> deptRead = new ArrayList<Integer>() {{
            add(2);
        }};
        createUserPOJO.setDepartments_read(deptRead);

        List<Integer> deptGrp = new ArrayList<Integer>() {{
            add(1);
        }};

        createUserPOJO.setDepartment_groups(deptGrp);
        createUserPOJO.setUser_groups(deptGrp);

        return createUserPOJO;
    }

}
