/**
 * Created by sumitbhanwala on 2/14/17.
 */
// creating a user service which will be invoked when a user hits on the login page with the valid
// credentials and if the username and password are correct than lets the user go to the profile
// page of his and all the fields of the profile populated with his credentials
(function () {
    angular
        .module("RoomGuardWebApp")
        .factory("UserService" ,userService)

    function userService($http) {
        var api = {
            "createUser": createUser,
            "getUserByEmail": getUserByEmail,
            "findUserByCredentials": findUserByCredentials
        };
        return api;

        function createUser(user) {
            return $http.post("/roomGuardWebApp/rest/user", user);
        }

        // adding trailing slash as spring is truncating the part after.
        function getUserByEmail(email) {
            return $http.get("/roomGuardWebApp/rest/user/"+ email + "/");
        }

        function findUserByCredentials(emailAddress , password) {
            var user ={
                emailAddress: emailAddress,
                password: password
            };
            return $http.post("/roomGuardWebApp/rest/user/login",user);
        }
    }
})();
