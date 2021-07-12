package util;

public enum APIResources {

    getUsersAPI("/index.php/site_admin/restapi/getusers/"),
    createUserAPI("/index.php/site_admin/restapi/user/"),
    getUserAPI("/index.php/site_admin/restapi/user/"),
    deleteUserAPI("/index.php/site_admin/restapi/user/"),
    updateUserAPI("/index.php/site_admin/restapi/user/");

    String resource;

    APIResources(String resource) {

        this.resource = resource;
    }

    public String getResource()
    {
        return resource;
    }
}
