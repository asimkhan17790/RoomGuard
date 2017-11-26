(function() {

    angular
        .module("RoomGuardWebApp")
        .controller("UserController",UserController);

    function UserController ($location,$routeParams ,$timeout ) {
        var vm = this;

        function init() {

            console.log("User Controller init called...");

        }
        init();
    }
})();