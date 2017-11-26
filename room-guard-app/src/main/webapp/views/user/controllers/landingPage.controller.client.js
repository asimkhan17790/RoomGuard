(function() {

    angular
        .module("RoomGuardWebApp")
        .controller("LandingPageController",LandingPageController);

    function LandingPageController ($location, $routeParams, $timeout, UserService) {
        var vm = this;
        vm.user = {};
        vm.createUser = createUser;
        vm.loginPage = function() {
         }

        function createUser () {
            UserService.createUser(vm.user);
        }
    }
})();